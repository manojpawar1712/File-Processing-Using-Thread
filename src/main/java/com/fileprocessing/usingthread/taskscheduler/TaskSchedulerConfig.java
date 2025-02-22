package com.fileprocessing.usingthread.taskscheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.fileprocessing.usingthread.service.TaskService;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class TaskSchedulerConfig {
	
	@Autowired
	private TaskService taskService;
	
	@PostConstruct
	public void startTask() {
		taskService.startTask();
	}
}
