package com.tcf.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration1 {
	private static Configuration1 conf;
	private Properties props;
	private Configuration1() {
		props = new Properties();
		InputStream inStream = Configuration1.class.getClassLoader().getResourceAsStream("database.properties");
		try {
			props.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aaaaaaaaaaaaaaaaaaaaa");
	}
	
	public static Configuration1 getConfiguration(){
		if(conf == null){
			conf = new Configuration1();
		}
		return conf;
	}
	
	public String getValue(String key){
		return conf.props.getProperty(key);
	}
}
