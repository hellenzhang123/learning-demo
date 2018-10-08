package com.demo.spring_aop.aop;

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
@ContextConfiguration("classpath*:applicationContext.xml")
public class DemoTest {
	@SuppressWarnings("restriction")
    @Resource(name="studentDao")
	private StudentDao studentDao;

	@Test
	public void demo1(){
//	    studentDao.saveStudent();
	    studentDao.updateStudent("小红");
//	    studentDao.deleteStudent();
//	    studentDao.findStudent();
	}
}
