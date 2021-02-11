package com.atmecs.automationAspireportal.testscript;

import org.testng.annotations.Test;

import com.atmecs.automationAspireportal.helper.DateHelper;
import com.atmecs.automationAspireportal.helper.ManagerloginHelper;
import com.atmecs.automationAspireportal.helper.ValidationHelper;
import com.atmecs.automationAspireportal.testsuite.TestSuiteBase;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class TC11_MailSendToStipulated extends TestSuiteBase{
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	@Test
	public void Reports() throws Exception {
		ManagerloginHelper manahelper=new ManagerloginHelper(browser);
		ValidationHelper helper=new ValidationHelper(browser);
		DateHelper datehelper=new DateHelper(browser);
		manahelper.LoginPage();
	report.info("Clicking on the Reports button");	
	    helper.clickonelement("loc.reports.btn");
	report.info("Successfully clicked on the reports button");
	report.info("Clicking on the timesheet sent button");
    helper.clickonelement("loc.timesheetsent.btn");
    report.info("Sucessfullly selected timesheet");


	

}
}