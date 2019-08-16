package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.EmailModel;
@Service
public interface BatchMailService {

	public void batchSendEmail(List<EmailModel> emails);
	
	public void batchSendReturnEmail(List<EmailModel> emails);
}
