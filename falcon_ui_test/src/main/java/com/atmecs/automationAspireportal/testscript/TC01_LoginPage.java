package com.atmecs.automationAspireportal.testscript;

import org.testng.annotations.Test;


import com.atmecs.aspireportalAutomation.utils.ReadLocators;
import com.atmecs.automationAspireportal.constant.ProjectBaseConstantPaths;
import com.atmecs.automationAspireportal.testsuite.TestSuiteBase;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;
import com.atmecs.aspireportalAutomation.utils.LoadProperties;
import com.atmecs.aspireportalAutomation.utils.LogReport;
import com.atmecs.aspireportalAutomation.utils.Pageactions;

public class TC01_LoginPage extends TestSuiteBase{
	ReadLocators read = new ReadLocators();
	LoadProperties load = new LoadProperties();
	LogReport log = new LogReport();
	
	
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
	@Test
	public void LoginPage() throws Exception {
		Pageactions page=new Pageactions(browser);
	log.info("STEP#1: Entering the Email");
		String email=page.getdata_fromExcel("Login Page", "Employee Username", "Employee");
		page.sendKeys(ReadLocators.getPropertyvalue("loc.email.input", ProjectBaseConstantPaths.LOCATORS_FILE), email);
		report.info("Successfully entered Email");
	log.info("STEP#2: Entering the Password");
	    page.clickOnElement("loc.password.input");
		String password=page.getdata_fromExcel("Login Page", "Employee Password", "Employee");
		page.sendKeys(ReadLocators.getPropertyvalue("loc.password.input", ProjectBaseConstantPaths.LOCATORS_FILE), password);
		report.info("Successfully entered Password");
		Thread.sleep(3000);
	log.info("STEP#3: Click on Login button");  
	    page.clickOnElement("loc.login.btn");
	    report.info("Successfully clicked on login button");
	    Thread.sleep(3000);
	log.info("STEP#4: Validating the login text");
	    page.clickOnElement("loc.password.input");
		String logotext=page.getdata_fromExcel("Dashboard", "Validation Value", "Logo");
		page.sendKeys(ReadLocators.getPropertyvalue("loc.logo.txt", ProjectBaseConstantPaths.LOCATORS_FILE), logotext);
		report.info("Successfully validated the text");
	}
}
