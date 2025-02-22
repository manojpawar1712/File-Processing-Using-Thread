package com.fileprocessing.usingthread.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.fileprocessing.usingthread.entity.FileRecord;
import com.fileprocessing.usingthread.repo.MailRecordRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
	
	@Autowired
	private MailRecordRepository mailRecordRepository;
	
	@Autowired
	private JavaMailSender mailSender;
	
	//@Autowired
	//private ExecutorService executorService = Executors.newFixedThreadPool(5);
	
	private ScheduledExecutorService scheduledExecutorService =  Executors.newScheduledThreadPool(1);  
	
	private String FOLDER = "E:\\Self Practice\\File Processing Using THread\\Scan-Files";
	
	public void startTask() {
		//executorService.submit(this::readFileTask);
		scheduledExecutorService.scheduleAtFixedRate(this::scanFolder, 0, 3, TimeUnit.SECONDS);
	}
	
	private void scanFolder() {
		try {
			Path path = Paths.get(FOLDER);
			
			if(Files.exists(path) && Files.isDirectory(path)) {
				Stream<Path> s = Files.list(path);
				if(s.count() > 0) {
					Files.list(path).forEach(this::processFile);					
				} else {
					System.out.println("No files found! Checking after 3 Sec...");
				}
			} else {
                System.out.println("Folder does not exist: " + FOLDER );
            }
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void processFile(Path path) {
		FileRecord fileRecord = new FileRecord();
		fileRecord.setFileName(path.getFileName().toString());
		fileRecord.setEmail("sample@gmail.com");
		fileRecord.setSend(false);
		mailRecordRepository.save(fileRecord);
		try {
			Files.delete(path);
			System.out.println("File cleaned : "+ path.toString());
		} catch (IOException e) {
			System.out.println("Unable to delete file");
		}
		System.out.println("---------------------");
		System.out.println("-------Record Added--------------" + path.getFileName().toString());
		System.out.println("---------------------");
	}
	
	
	
	
	
	
	
	
	
	
}
