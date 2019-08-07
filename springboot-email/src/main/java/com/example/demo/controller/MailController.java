package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.service.impl.MailService;

@Controller
@RequestMapping(value="/mail")
public class MailController {

	@Autowired
	private MailService mailService;

	@RequestMapping(value="/simple")
	@ResponseBody
	public void sendMail() {
		mailService.sendSimpleMail("15735170558@163.com", "test", "我是一封测试邮件");
	}
}
