package com.atmecs.automationAspireportal.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.atmecs.falcon.automation.ui.selenium.Browser;

public class Waits {
	Browser browser=null;
	public Waits(Browser browser) {
		this.browser=browser;
	}
	public void implicitWait(){
		browser.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
	}
	
	public static boolean isElementVisible(WebDriver driver, String xpath) {

		WebDriverWait wait = new WebDriverWait(driver, 15);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} catch (Exception exception) {

			return false;
		}
		return true;
	}
}
