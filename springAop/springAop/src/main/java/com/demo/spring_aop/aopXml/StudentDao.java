package com.demo.spring_aop.aopXml;

public class StudentDao {

	public void saveStudent(){
		System.out.println("==========增加学生========");
		System.out.println("save方法结束");
	}
	public void updateStudent(String name){
		System.out.println("=========更新学生" + name + "=========");
		System.out.println("update方法结束");
	}
	public void deleteStudent(){
		System.out.println("=======删除学生========");
		System.out.println("delete方法结束");
	}
	public String findStudent(){
		System.out.println("=======查找学生========");
		System.out.println("find方法结束");
		return "张小明";
	}
}
