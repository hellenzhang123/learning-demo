package com.example.demo.entity;


public class ExportData {
	private String name;
	private Integer age;
	private Integer gender;
	private String address;
	private String idCard;
	private String remarks;
	
	public ExportData(String name, Integer age, Integer gender, String address, String idCard, String remarks) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.idCard = idCard;
		this.remarks = remarks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
