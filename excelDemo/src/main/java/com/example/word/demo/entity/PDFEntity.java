package com.example.word.demo.entity;


import java.util.Date;

import com.deepoove.poi.data.DocxRenderData;

public class PDFEntity {

	private String buyer;
	private String orderBy;
	private Date orderDate;
	private double remitTotal;
	private String bank;
	private String account;
	private String remitcode;
	private Date remitDate;
	private String companyName;
	private Date printDate;
	private DocxRenderData order;
	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public double getRemitTotal() {
		return remitTotal;
	}
	public void setRemitTotal(double remitTotal) {
		this.remitTotal = remitTotal;
	}
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getRemitcode() {
		return remitcode;
	}
	public void setRemitcode(String remitcode) {
		this.remitcode = remitcode;
	}
	public Date getRemitDate() {
		return remitDate;
	}
	public void setRemitDate(Date remitDate) {
		this.remitDate = remitDate;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Date getPrintDate() {
		return printDate;
	}
	public void setPrintDate(Date printDate) {
		this.printDate = printDate;
	}
	public DocxRenderData getOrder() {
		return order;
	}
	public void setOrder(DocxRenderData order) {
		this.order = order;
	}
	
	
	
//	private String  
}
