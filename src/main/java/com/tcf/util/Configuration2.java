package com.tcf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration2 {
	private static Configuration2 conf = new Configuration2();
	private Properties props;
	private Configuration2() {
		props = new Properties();
		InputStream inStream = Configuration2.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			props.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aaaaaaaaaaaaaaaaaaaaa");
	}
	
	public static Configuration2 getConfiguration(){
		return conf;
	}
	
	public String getValue(String key){
		return conf.props.getProperty(key);
	}
}
