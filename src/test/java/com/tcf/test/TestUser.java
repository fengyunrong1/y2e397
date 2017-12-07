package com.tcf.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.tcf.entity.SmbmsUser;
import com.tcf.service.SmbmsUserService;

public class TestUser {
	
	@Test
	public void login(){
		/*ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext-base.xml",
				"applicationContext-dao.xml","applicationContext-service.xml");*/
		ApplicationContext app = new ClassPathXmlApplicationContext("classpath*:applicationContext*.xml");
		//ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		SmbmsUserService us = (SmbmsUserService) app.getBean("smbmsUserServiceImpl");
		SmbmsUser user = new SmbmsUser();
		user.setUserCode("admin");
		user.setUserPassword("123");
		SmbmsUser logined = us.login(user);
		System.out.println(logined);
		Assert.assertEquals("admin", logined.getUserCode());
	}
	/*@Test
	public void addSmbmsUser(){
		ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
		SmbmsUserService us = (SmbmsUserService) app.getBean("smbmsUserServiceImpl");
		SmbmsUser user = new SmbmsUser();
		user.setUserCode("abc123");
		user.setUserName("abc123");
		user.setUserPassword("123");
		int result = us.addSmbmsUser(user);
		System.out.println(result);
		Assert.assertEquals(1, result);
	}*/
}
