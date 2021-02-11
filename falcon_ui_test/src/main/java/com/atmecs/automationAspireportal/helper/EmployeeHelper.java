package com.atmecs.automationAspireportal.helper;

import com.atmecs.automationAspireportal.constant.ProjectBaseConstantPaths;
import com.atmecs.automationAspireportal.testscript.SampleTestScript;
import com.atmecs.automationAspireportal.utils.LoadProperties;
import com.atmecs.automationAspireportal.utils.Pageactions;
import com.atmecs.automationAspireportal.utils.ReadLocators;
import com.atmecs.automationAspireportal.validationresult.EmployeePageValidation;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class EmployeeHelper {
	Browser browser=null;
	Pageactions page;
	ReadLocators read = new ReadLocators();
	LoadProperties load = new LoadProperties();
	String actualtooltipmessage;
	String expectedtooltipmessage;
	String mansheetname="Manager";
	String sheetname="Employee";
	String columnname="Validation Text";
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
		public EmployeeHelper(Browser browser) {
			this.browser = browser;
			page = new Pageactions(browser);
		}

	public void employeeHelper() throws Exception {
		EmployeePageValidation validate=new EmployeePageValidation(browser);
		Pageactions page=new Pageactions(browser);
	    ValidationHelper helper=new ValidationHelper(browser);
	 report.info("STEP#5: Validating the Breadcrum");
		validate.validateEmployeeBreadcrum();
		report.info("Successfully validated breadcrum");
		//page.clickOnElement(ReadLocators.getPropertyvalue("loc.copy.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	report.info("STEP#6: Selecting the activity");
	    helper.selectactivity("Activity 1", "loc.activity.drpdwn", "loc.actvity.ddn", "loc.activityvalue.ddn");
	report.info("STEP#7: Entering hours to the days");	
	    helper.enterDatatoRow("Monday value", "loc.monvalue.txt");
	    helper.enterDatatoRow("Tuesday value", "loc.tuevalue.txt");
	    helper.enterDatatoRow("Wednesday value", "loc.wedvalue.txt");
	    helper.enterDatatoRow("Thursday value", "loc.thuvalue.txt");
	    helper.enterDatatoRow("Friday value", "loc.frivalue.txt");
	 report.info("STEP#8: Add Notes");
	    helper.tooltipmessage("Notes value", "loc.notestooltip.txt", "Notes text", "loc.textarea.txt","validate.notestooltip.txt");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.approvenotes.btn", ProjectBaseConstantPaths.LOCATORS_FILE)); 
	report.info("STEP#9: Add Activity");	
	    helper.activity("Add activity value", "loc.addactvity.btn", "validate.addtooltip.txt");
	report.info("STEP#10: Selecting the second activity");	
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.activity2.drpdwn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    String activity2=page.getdata_fromExcel("Employee", "Validation Text", "Activity 2");
      page.sendKeys(ReadLocators.getPropertyvalue("loc.actvity.ddn", ProjectBaseConstantPaths.LOCATORS_FILE), activity2);
      page.clickOnElement(ReadLocators.getPropertyvalue("loc.activityvalue.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully selected Activity");
	report.info("STEP#11: Delete Activity");
	    helper.activity("Delete activity value", "loc.deleteactivity.btn", "validate.deletetooltip.txt");
	report.info("STEP#12: Submit button");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.submit.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    actualtooltipmessage=page.getText(ReadLocators.getPropertyvalue("validate.submitmessage.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
      expectedtooltipmessage=page.getdata_fromExcel(sheetname, columnname, "Submit message");
      Verify.verifyString(actualtooltipmessage, expectedtooltipmessage, "Validating the tooltip message is same as expected or not");
		report.info("Successfully validated submit message");
}
}