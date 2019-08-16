package com.example.demo;

import java.io.Serializable;

public class EmailModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1404185636399251685L;

	private String email;
	private String subject;
	private String content;
	private String attachFilePath;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAttachFilePath() {
		return attachFilePath;
	}
	public void setAttachFilePath(String attachFilePath) {
		this.attachFilePath = attachFilePath;
	}
	
}
