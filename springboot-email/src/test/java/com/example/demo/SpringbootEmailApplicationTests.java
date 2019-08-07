package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.service.impl.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootEmailApplicationTests {

	@Autowired
	MailService mailService;
//	@Test
//	public void contextLoads() {
//		mailService.sendSimpleMail("15735170558@163.com", "test", "我是一封测试邮件");
//	}
//	
//	@Test
//	public void sendInlineResourceMailTest() {
//		mailService.sendInlineResourceMail("15735170558@163.com", "测试图片", "测试携带图片呀呀呀呀呀", "‪C:/Users/emp/Desktop/1676201090.jpg", "1");
////		sendSimpleMail("15735170558@163.com", "test", "我是一封测试邮件");
//	}
//	
//	@Test
//	public void sendHtmlMailTest() {
//		mailService.sendHtmlMail("15735170558@163.com", "测试HTML", "<html><body><h1>测试一下</h1></body></html>");
//	}
	
//	@Test
//	public void sendAttachmentMailTest() {
//		mailService.sendAttachmentMail("15735170558@163.com", "测试发送附件邮件", "", "C\:‪/Users/emp/Desktop/1676201090.jpg");
//	}


}
