package com.example.demo.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;

/**
 * @author 张雨轩
 *
 */
public class ExportEasyData {

	@Excel(name = "姓名", orderNum = "0")
	private String name;
	@Excel(name = "年龄 ", orderNum = "1")
	private Integer age;
	@Excel(name = "性别", replace = {"男_1", "女_2"}, orderNum = "2")
	private Integer gender;
	@Excel(name = "地址 ", orderNum = "3")
	private String address;
	@Excel(name = "身份证 ", orderNum = "4")
	private String idCard;
	@Excel(name = "个人备注 ", orderNum = "5")
	private String remarks;

	
	public ExportEasyData(String name, Integer age, Integer gender, String address, String idCard, String remarks) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.idCard = idCard;
		this.remarks = remarks;
	}

	public ExportEasyData() {
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
