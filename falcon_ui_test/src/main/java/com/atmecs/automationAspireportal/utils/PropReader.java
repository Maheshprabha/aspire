package com.atmecs.automationAspireportal.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropReader {
	
	private Properties properties;

	public PropReader(String path) {
		properties = new Properties();
		try {
			FileInputStream input = new FileInputStream(path);
			properties.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public String getValue(String key) {
		return properties.getProperty(key);
	}


}
