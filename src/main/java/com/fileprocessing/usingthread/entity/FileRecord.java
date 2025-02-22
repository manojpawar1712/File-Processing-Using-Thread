package com.fileprocessing.usingthread.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mail_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String email;

	private String fileName;

	private boolean send;

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSend() {
		return send;
	}

	public void setSend(boolean send) {
		this.send = send;
	}

}
