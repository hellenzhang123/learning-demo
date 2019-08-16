package com.example.demo.service.impl;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import com.example.demo.EmailModel;
import com.example.demo.service.BatchMailService;
import com.example.demo.service.MailService;
import com.example.demo.util.EmailNoticeThreadPoolTask;
import com.example.demo.util.EmailThreadPoolTask;

@Service
public class BatchMailServiceImpl implements BatchMailService {

	@Autowired
	private ThreadPoolTaskExecutor executor;
	@Autowired
	private MailService mailService;
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BatchMailServiceImpl.class);

	@Override
	public void batchSendReturnEmail(List<EmailModel> emails) {
		for (EmailModel emailModel : emails) {
			logger.info("向" + emailModel.getEmail() + "发送邮件开始");
			Future<Boolean> statusFuture = executor.submit(new EmailThreadPoolTask(mailService, emailModel.getEmail(), emailModel.getSubject(), emailModel.getContent(), emailModel.getAttachFilePath()));
			// 根据返回值来进行判断下一步操作，注意，future中的get方法是一个阻塞的方法，会一直等到future返回结果才会结束
			try {
				boolean status = statusFuture.get();
				// 根据结果可以进行存入数据库等操作   这边暂时只做输出操作
				logger.info("状态：" + status);
				logger.info("向" + emailModel.getEmail() + "发送邮件结束");
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void batchSendEmail(List<EmailModel> emails) {
		
		for (EmailModel emailModel : emails) {
			logger.info("向" + emailModel.getEmail() + "发送邮件开始");
			try {
				executor.execute(new EmailNoticeThreadPoolTask(mailService, emailModel.getEmail(), emailModel.getSubject(), emailModel.getContent(), emailModel.getAttachFilePath()));
				logger.info("向" + emailModel.getEmail() + "发送邮件结束");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
