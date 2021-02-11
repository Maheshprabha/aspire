package com.atmecs.automationAspireportal.helper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.atmecs.automationAspireportal.constant.ProjectBaseConstantPaths;
import com.atmecs.automationAspireportal.testscript.SampleTestScript;
import com.atmecs.automationAspireportal.utils.Pageactions;
import com.atmecs.automationAspireportal.utils.ReadLocators;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;


public class DateHelper {
	Browser browser=null;
    Pageactions page;
    private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	public DateHelper(Browser browser) {
		this.browser = browser;
		page=new Pageactions(browser);
	}
	public void selectdates(String startdate,String enddate) throws IOException{
	Pageactions page=new Pageactions(browser);
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDateTime now = LocalDateTime.now();
	System.out.println(dtf.format(now));
	System.out.println(dtf.format(now.plusDays(10)));
	page.sendKeys(ReadLocators.getPropertyvalue(startdate, ProjectBaseConstantPaths.LOCATORS_FILE),dtf.format(now));
	page.sendKeys(ReadLocators.getPropertyvalue(enddate, ProjectBaseConstantPaths.LOCATORS_FILE), dtf.format(now.plusDays(13)));
}
	
	public void selectshift(String validationMessage,String activity) throws Exception {
		page.clickOnElement(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE));
	    page.clickOnElement(ReadLocators.getPropertyvalue(activity, ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully selected Project");
}
}