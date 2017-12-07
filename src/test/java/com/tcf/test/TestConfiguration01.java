package com.tcf.test;

import org.junit.Assert;
import org.junit.Test;

import com.tcf.util.Configuration1;
import com.tcf.util.Configuration2;
import com.tcf.util.Configuration3;

public class TestConfiguration01 {

	/*@Test
	public void Test1(){
		String val = Configuration1.getConfiguration().getValue("username");
		String val2 = Configuration1.getConfiguration().getValue("url");
		String val3 = Configuration1.getConfiguration().getValue("driver");
		System.out.println(val3);
		Assert.assertEquals("root", val);
	}*/
	/*@Test
	public void Test2(){
		String val = Configuration2.getConfiguration().getValue("username");
		String val2 = Configuration2.getConfiguration().getValue("url");
		String val3 = Configuration2.getConfiguration().getValue("driver");
		System.out.println(val3);
		Assert.assertEquals("root", val);
	}*/
	@Test
	public void Test3(){
		String val = Configuration3.getConfiguration().getValue("username");
		String val2 = Configuration3.getConfiguration().getValue("url");
		String val3 = Configuration3.getConfiguration().getValue("driver");
		System.out.println(val3);
		Assert.assertEquals("root", val);
	}
}
