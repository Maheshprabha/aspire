package com.atmecs.automationAspireportal.helper;

import java.io.IOException;

import org.testng.annotations.Test;

import com.atmecs.automationAspireportal.constant.ProjectBaseConstantPaths;
import com.atmecs.automationAspireportal.testscript.SampleTestScript;
import com.atmecs.automationAspireportal.utils.LoadProperties;
import com.atmecs.automationAspireportal.utils.Pageactions;
import com.atmecs.automationAspireportal.utils.ReadLocators;
import com.atmecs.automationAspireportal.utils.Waits;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class EmployeeloginHelper {
	Browser browser=null;
	Pageactions page;
	ReadLocators read = new ReadLocators();
	LoadProperties load = new LoadProperties();
	public EmployeeloginHelper(Browser browser) {
		this.browser = browser;
		page=new Pageactions(browser);
	}
	
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
		public void LoginPage(Browser browser,String email, String password) throws Exception {
			
			Pageactions page = new Pageactions(browser);
			page.sendKeys(ReadLocators.getPropertyvalue("loc.email.input", ProjectBaseConstantPaths.LOCATORS_FILE), email);
			page.sendKeys(ReadLocators.getPropertyvalue("loc.password.input", ProjectBaseConstantPaths.LOCATORS_FILE),
					password);
			page.clickOnElement(ReadLocators.getPropertyvalue("loc.login.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
			
		}
		
		public void clickOnemployeeTimesheet(Browser browser) throws IOException
		{
			Pageactions page = new Pageactions(browser);
			Waits wait = new Waits(browser);
			wait.implicitWait();
			page.mouseOver(ReadLocators.getPropertyvalue("loc.emptimesheet.lnk", ProjectBaseConstantPaths.LOCATORS_FILE));
			page.clickOnElement(ReadLocators.getPropertyvalue("loc.emptimesheet.lnk", ProjectBaseConstantPaths.LOCATORS_FILE));
	    	
		}
}

		
		
		
		
		
		
		
			
		


