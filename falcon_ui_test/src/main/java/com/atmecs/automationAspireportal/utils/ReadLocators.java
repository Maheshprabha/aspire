package com.atmecs.automationAspireportal.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ReadLocators {
	static Properties properties;
	static FileReader reader;
	static File file;
	WebDriver driver;



	public static String getPropertyvalue(String key, String path) throws IOException {
		Properties prop = new Properties();
		FileInputStream input = new FileInputStream(path);
		try {
			prop.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String data = prop.getProperty(key);
		return data;
	}
	
}

