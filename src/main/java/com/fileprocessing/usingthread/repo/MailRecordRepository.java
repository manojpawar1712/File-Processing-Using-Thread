package com.fileprocessing.usingthread.repo;

import org.springframework.stereotype.Repository;

import com.fileprocessing.usingthread.entity.FileRecord;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MailRecordRepository extends JpaRepository<FileRecord, Long> {

	List<FileRecord> findBySendFalse();

	void deleteTop10ByOrderByIdAsc();
}
