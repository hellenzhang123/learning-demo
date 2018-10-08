package com.demo.spring_aop.aopXml;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring的AOP的注解开发
 * @author jt
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class DemoTest {
	@SuppressWarnings("restriction")
    @Resource(name="studentDao1")
	private StudentDao studentDao;

	@Test
	public void demo1(){
//	    studentDao.saveStudent();
	    studentDao.updateStudent("小花");
//	    studentDao.deleteStudent();
//	    studentDao.findStudent();
	}
}
