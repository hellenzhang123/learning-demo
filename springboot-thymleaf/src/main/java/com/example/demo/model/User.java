package com.example.demo.model;

import java.sql.Date;
import java.util.List;

public class User {

	private String name;
	private Integer age;
	private String mobile;
	private String email;
	private Sex sex;
	private Date birthday;
	private List<Address> address;
	
	public User() {
	}
	public User(String name, Integer age, String mobile, String email, List<Address> address) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.email = email;
		this.address = address;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
