package com.example.demo.util;

import org.slf4j.LoggerFactory;

import com.example.demo.service.MailService;

/**
 *
 * @author zhangyuxuan 2019年7月23日
 */

public class EmailNoticeThreadPoolTask implements Runnable {

  private static final org.slf4j.Logger logger = LoggerFactory.getLogger(EmailNoticeThreadPoolTask.class);
  private MailService mailService;
  private String email;
  private String content;
  private String subject;
  private String filePath;

  /**
   * @param mailService
   * @param email
   * @param content
   * @param subject
   * @param part
   */
  public EmailNoticeThreadPoolTask(MailService mailService, String email, String subject,
      String content, String filePath) {
    this.mailService = mailService;
    this.email = email;
    this.content = content;
    this.subject = subject;
    this.filePath = filePath;
  }

  @Override
  public void run() {
	logger.info("run开始");
    mailService.sendSimpleMail(email, subject, content);
    logger.info("run结束");
//    mailService.sendAttachmentMail(email, subject, content, filePath);
  }

}
