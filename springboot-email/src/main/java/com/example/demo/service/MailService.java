package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface MailService {

	public boolean sendSimpleMail(String to, String subject, String content);
	
	public boolean sendHtmlMail(String to, String subject, String content);
	
	public boolean sendAttachmentMail(String to, String subject, String content, String filePath);
	public boolean sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
