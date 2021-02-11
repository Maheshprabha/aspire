package com.atmecs.automationAspireportal.constant;

import java.io.IOException;
import java.util.Properties;

import com.atmecs.falcon.automation.util.parser.PropertyParser;

public class AspireportalLocators {
	
	PropertyParser propertyParser=new PropertyParser();
	String filepath=ProjectBaseConstantPaths.LOCATORS_FILE;
	Properties properties;
	
	public AspireportalLocators() {
		try {
			properties=propertyParser.loadProperty(filepath);
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public String getUrl() {
		return properties.getProperty(AspireportalKeys.URL);	
	}
	
	public String getEmailInput() {
		return properties.getProperty(AspireportalKeys.USERNAME);	
	}
	
	public String getPasswordInput() {
		return properties.getProperty(AspireportalKeys.PASSWORD);	
	}
	
	public String getLoginbutton() {
		return properties.getProperty(AspireportalKeys.LOGIN);	
	}

}
