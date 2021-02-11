package com.atmecs.automationAspireportal.utils;

import java.util.List;
import java.util.Spliterator;
import java.util.logging.Logger;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;


/**
 * Configure the log4j file path.
 */
public class LogReport {

	Logger logger = null;

	public LogReport() {
		getlogger();
		logger = Logger.getLogger(LogReport.class.getName());
	}

	public void getlogger() {
		PropertyConfigurator
				.configure("C:\\Users\\admin\\Aspireportal-master\\src\\main\\resources\\log4j\\log4j.properties");
	}

	public void info(String message) {
		logger.info(message);
	}
	public void info(String priceArray) {
		logger.info(priceArray);
	}

	public void dateinfo(int date) {
		logger.info(date);
		
	}
	public void elementinfo(List<WebElement> element) {
		logger.info(element);
	}
	public void elementinfo(WebElement element) {
		logger.info(element);
	}
	
	public void info(List<String> sortedPrices) {
		logger.info(sortedPrices);
	}
	public void info(String[] linkText) {
		logger.info(linkText);
	}
	public void info(Spliterator<String> spliterator) {
		logger.info(spliterator);
	}

	public void exceptioninfo(ElementClickInterceptedException exception) {
		logger.info(exception);
		
	}
}
