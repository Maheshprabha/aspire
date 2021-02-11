package com.atmecs.automationAspireportal.testscript;

import org.testng.annotations.Test;

import com.atmecs.automationAspireportal.helper.DateHelper;
import com.atmecs.automationAspireportal.helper.ManagerloginHelper;
import com.atmecs.automationAspireportal.helper.ValidationHelper;
import com.atmecs.automationAspireportal.testsuite.TestSuiteBase;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class TC06_ReportsPage extends TestSuiteBase {
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	@Test
	public void Reports() throws Exception {
		ManagerloginHelper manahelper = new ManagerloginHelper(browser);
		ValidationHelper helper = new ValidationHelper(browser);
		DateHelper datehelper = new DateHelper(browser);
		manahelper.LoginPage();
		report.info("Clicking on the Reports button");
		helper.clickonelement("loc.reports.btn");
		report.info("Successfully clicked on the reports button");
		report.info("Validating the breadcrum Reports");
		helper.breadcrum("validate.reportbreadcrum.txt");
		report.info("Successfully validated the breadcrum");
		report.info("Selecting client from the client dropdown");
		helper.selectproject("Project", "loc.client.ddn", "loc.clientname.txt", "loc.projectvalue.txt");
		report.info("Successfully selected client");
		report.info("Selecting client from the project dropdown");
		helper.selectemployee("loc.reportproject.ddn", "loc.reportprojectname.txt");
		report.info("Successfully selected project");
		report.info("Selecting dates");
		datehelper.selectdates("loc.startDate.input", "loc.endDate.input");
		report.info("Successfully dates");
		report.info("Selecting dates");
		helper.selectemployee("loc.reportemployee.ddn", "loc.reportemployeetext.txt");
		report.info("Successfully dates");
		report.info("Clicking on the export button");
		helper.clickonelement("loc.reportexport.btn");
		report.info("Sucessfully clicked on the export button");
		report.info("Selecting client from the client dropdown");
		helper.selectproject("Project", "loc.client.ddn", "loc.clientname.txt", "loc.projectvalue.txt");
		report.info("Successfully selected client");
		report.info("Selecting client from the project dropdown");
		helper.selectemployee("loc.reportproject.ddn", "loc.reportprojectname.txt");
		report.info("Successfully selected project");
		report.info("Selecting dates");
		datehelper.selectdates("loc.startDate.input", "loc.endDate.input");
		report.info("Successfully dates");

	}

}
