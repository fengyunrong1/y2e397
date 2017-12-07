package com.tcf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration3 {
	private static class Singleton {
		private static Configuration3 conf = new Configuration3();
	}
	private Properties props;
	private Configuration3() {
		props = new Properties();
		InputStream inStream = Configuration3.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			props.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aaaaaaaaaaaaaaaaaaaaa");
	}
	
	public static Configuration3 getConfiguration(){
		return Singleton.conf;
	}
	
	public String getValue(String key){
		return Singleton.conf.props.getProperty(key);
	}
}
