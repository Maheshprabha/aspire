package com.atmecs.automationAspireportal.helper;


import com.atmecs.automationAspireportal.constant.ProjectBaseConstantPaths;
import com.atmecs.automationAspireportal.testscript.SampleTestScript;
import com.atmecs.automationAspireportal.utils.Pageactions;
import com.atmecs.automationAspireportal.utils.ReadLocators;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class ValidationHelper {
	Browser browser = null;

	ReadLocators read = new ReadLocators();
	Pageactions page;
	String empsheetname = "Employee";
	String mansheetname="Manager";
	String columnname = "Validation Text";
	String actualmessage;
	String expectedmessage;
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	public ValidationHelper(Browser browser) {
		this.browser = browser;
		page = new Pageactions(browser);
	}

	public void getDataofRow(String expectedString, String validationMessage, int i) throws Exception {
		actualmessage = page.getText(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE));
		page.writedata_toExcel(empsheetname, columnname, i, actualmessage);
		expectedmessage = page.getdata_fromExcel(empsheetname, columnname, expectedString);
		Verify.verifyString(actualmessage, expectedmessage, "Successfully validated the text");

	}
	
	public void enterDatatoRow(String expectedString, String validationMessage) throws Exception {
		page.clickOnElement(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE));
	    page.clear(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE));
	    String monvalue=page.getdata_fromExcel(empsheetname, columnname, expectedString);
	    page.sendKeys(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE), monvalue);
	    report.info("Successfully Entered time value");
		
	}

	
	public void tooltipmessage(String expectedtooltipmessage, String validationMessage,String value,String textvalue,String message) throws Exception {
		page.mouseOver(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE));
		actualmessage=page.getText(ReadLocators.getPropertyvalue(message, ProjectBaseConstantPaths.LOCATORS_FILE));
        expectedmessage=page.getdata_fromExcel(empsheetname, columnname, expectedtooltipmessage);
        Verify.verifyString(actualmessage, expectedmessage, "Validating the tooltip message is same as expected or not");
		report.info("Successfully validated " + expectedtooltipmessage);
		page.clickOnElement(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE));
		String notes=page.getdata_fromExcel(empsheetname, columnname, value);
		page.sendKeys(ReadLocators.getPropertyvalue(textvalue, ProjectBaseConstantPaths.LOCATORS_FILE), notes);
		report.info("Successfully Entered notes value");
			}
	public void selectactivity(String expectedString, String validationMessage,String activitytext,String activity) throws Exception {
		page.clickOnElement(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE));
	    String activity1=page.getdata_fromExcel(empsheetname, columnname, expectedString);
	    page.sendKeys(ReadLocators.getPropertyvalue(activitytext, ProjectBaseConstantPaths.LOCATORS_FILE), activity1);
	    report.info("Successfully selected on Select Activity");
	}
	
	public void activity(String expectedtooltipmessage, String validationMessage,String message) throws Exception {
		page.mouseOver(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE));
        actualmessage=page.getText(ReadLocators.getPropertyvalue(message, ProjectBaseConstantPaths.LOCATORS_FILE));
        expectedmessage=page.getdata_fromExcel(empsheetname, columnname, expectedtooltipmessage);
        Verify.verifyString(actualmessage, expectedmessage, "Validating the tooltip message is same as expected or not");
		report.info("Successfully validated " + expectedtooltipmessage);
		page.clickOnElement(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on add activity");
	}
	
	public void selectproject(String expectedString, String validationMessage,String activitytext,String activity) throws Exception {
		page.clickOnElement(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE));
	    String activity1=page.getdata_fromExcel(mansheetname, columnname, "Project");
	    page.sendKeys(ReadLocators.getPropertyvalue(activitytext, ProjectBaseConstantPaths.LOCATORS_FILE), activity1);
	    page.clickOnElement(ReadLocators.getPropertyvalue(activity, ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully selected Project");
	}
	
	public void approve_rejectbutton(String expectedtooltipmessage, String validationMessage,String message) throws Exception {
		page.clickOnElement(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE));
	    actualmessage=page.getText(ReadLocators.getPropertyvalue(message, ProjectBaseConstantPaths.LOCATORS_FILE));
        expectedmessage=page.getdata_fromExcel(mansheetname, columnname, expectedtooltipmessage);
        Verify.verifyString(actualmessage, expectedmessage, "Validating the tooltip message is same as expected or not");
        report.info("Successfully clicked on approve button and validating "+ expectedtooltipmessage);
	}
	
	public void selectemployee(String validationMessage,String activity) throws Exception {
		page.clickOnElement(ReadLocators.getPropertyvalue(validationMessage, ProjectBaseConstantPaths.LOCATORS_FILE));
	    page.clickOnElement(ReadLocators.getPropertyvalue(activity, ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully selected Project");
	}
	
	public void previousweekpendingmessage() throws Exception {
		EmployeeHelper employeeHelper=new EmployeeHelper(browser);
		EmployeeloginHelper emplogin=new EmployeeloginHelper(browser);
		emplogin.LoginPage();
		report.info("Clicking on the Timesheet");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.timesheet.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the Timesheet");
		String pagetitle = page.getText(ReadLocators.getPropertyvalue("loc.previousweek.txt", ProjectBaseConstantPaths.LOCATORS_FILE));  
		String previous=page.getdata_fromExcel(mansheetname, columnname, "Previous Week");
	    if(pagetitle==previous) {
	    employeeHelper.employeeHelper();
	    report.info("Logout button");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.logout.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.logouttext.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    }
	    else {
	    report.info("Click on the previous button");
			page.clickOnElement(ReadLocators.getPropertyvalue("loc.previousbutton.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the previous button");	
		    employeeHelper.employeeHelper();
		report.info("Click on the next button");
			page.clickOnElement(ReadLocators.getPropertyvalue("loc.nextbutton.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on the next button");	
		    employeeHelper.employeeHelper();
		report.info("Logout button");
		    page.clickOnElement(ReadLocators.getPropertyvalue("loc.logout.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		    page.clickOnElement(ReadLocators.getPropertyvalue("loc.logouttext.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    }
	}
	public void breadcrum(String value) throws Exception {
		page.getText(ReadLocators.getPropertyvalue(value, ProjectBaseConstantPaths.LOCATORS_FILE));
	}
	
	public void clickonelement(String value) throws Exception {
		page.getText(ReadLocators.getPropertyvalue(value, ProjectBaseConstantPaths.LOCATORS_FILE));
	}
	
	public void reject(String locator,String locatorvalue) throws Exception {
		page.clickOnElement(ReadLocators.getPropertyvalue(locator, ProjectBaseConstantPaths.LOCATORS_FILE));
		String rejectpopuptext=page.getdata_fromExcel(mansheetname, columnname, "Reject message");
		page.sendKeys(ReadLocators.getPropertyvalue(locatorvalue, ProjectBaseConstantPaths.LOCATORS_FILE), rejectpopuptext);
	}
}
