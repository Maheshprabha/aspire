package com.atmecs.automationAspireportal.testscript;

import org.testng.annotations.Test;

import com.atmecs.automationAspireportal.helper.DateHelper;
import com.atmecs.automationAspireportal.helper.ManagerloginHelper;
import com.atmecs.automationAspireportal.helper.ValidationHelper;
import com.atmecs.automationAspireportal.testsuite.TestSuiteBase;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class TC05_ShiftsPage extends TestSuiteBase{
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	@Test
	public void Shifts() throws Exception {
		ValidationHelper helper=new ValidationHelper(browser);
		DateHelper date=new DateHelper(browser);
		ManagerloginHelper manahelper=new ManagerloginHelper(browser);
		manahelper.LoginPage();
	report.info("Clicking on the Shifts button");
		helper.clickonelement("loc.shiftsbutton.btn");
	report.info("Successfully clicked on the shifts button");
	report.info("Clicking on the project dropdown in shifts page");
		helper.selectproject("Project", "loc.shifts.ddn", "loc.projecttext.txt", "loc.projectvalue.txt");
	report.info("Successfully selected the project");
	report.info("Clicking on click here to update shifts");
	    helper.clickonelement("loc.clickHereToUpdateShift.btn");
	report.info("Successfully clicked on click here to update shifts"); 
	report.info("Selecting Employee");
	    helper.selectemployee("loc.selectEmployee.input", "loc.projectvalue.txt");
	report.info("Successfully selected employee");
	report.info("Selecting start date and end date");
	    date.selectdates("loc.startDate.input","loc.endDate.input");
	report.info("Successfully selected dates");    
	report.info("Selecting Shift");
	    helper.clickonelement("loc.selectshift.ddn");
	report.info("Successfully selected shift");
	report.info("Clicking on save button");
	   helper.clickonelement("loc.save.btn");
	   helper.getDataofRow("Shifts", "validate.alertmsg.txt", 9);   
	    
	}
}
