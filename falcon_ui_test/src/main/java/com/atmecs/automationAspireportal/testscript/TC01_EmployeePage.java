package com.atmecs.automationAspireportal.testscript;


import org.testng.annotations.Test;

import com.atmecs.automationAspireportal.constant.ProjectBaseConstantPaths;
import com.atmecs.automationAspireportal.helper.EmployeeloginHelper;
import com.atmecs.automationAspireportal.testsuite.TestSuiteBase;
import com.atmecs.automationAspireportal.utils.LoadProperties;
import com.atmecs.automationAspireportal.utils.LogReport;
import com.atmecs.automationAspireportal.utils.Pageactions;
import com.atmecs.automationAspireportal.utils.ReadLocators;
import com.atmecs.automationAspireportal.utils.Waits;
import com.atmecs.automationAspireportal.validationresult.EmployeePageValidation;
import com.atmecs.falcon.automation.ui.selenium.Verify;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class TC01_EmployeePage extends TestSuiteBase{
	ReadLocators read = new ReadLocators();
	LoadProperties load = new LoadProperties();
	LogReport log = new LogReport();
	String actualtooltipmessage;
	String expectedtooltipmessage;
	String sheetname="Employee";
	String columnname="Validation Text";
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
	@Test
	public void EmployeePage() throws Exception {
		Waits waits=new Waits(browser);
		EmployeePageValidation validate=new EmployeePageValidation(browser);
		Pageactions page=new Pageactions(browser);
	    EmployeeloginHelper emphelper=new EmployeeloginHelper(browser);
	    emphelper.loginPage();
	 log.info("STEP#5: Validating the Breadcrum");
		validate.validateEmployeeBreadcrum();
		report.info("Successfully validated breadcrum");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.copy.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	log.info("STEP#6: Selecting the activity");	
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.activityvalue.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully selected on Select Activity");
	log.info("STEP#7: Entering hours to the days");	
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.monvalue.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
	    String monvalue=page.getdata_fromExcel("Employee", "Validation Text", "Monday value");
	    page.sendKeys(ReadLocators.getPropertyvalue("loc.monvalue.txt", ProjectBaseConstantPaths.LOCATORS_FILE), monvalue);
	    report.info("Successfully Entered mon value");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.tuevalue.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
	    String tuevalue=page.getdata_fromExcel("Employee", "Validation Text", "Tuesday value");
	    page.sendKeys(ReadLocators.getPropertyvalue("loc.tuevalue.txt", ProjectBaseConstantPaths.LOCATORS_FILE), tuevalue);
	    report.info("Successfully Entered tue value");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.wedvalue.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
	    String wedvalue=page.getdata_fromExcel("Employee", "Validation Text", "Wednesday value");
	    page.sendKeys(ReadLocators.getPropertyvalue("loc.wedvalue.txt", ProjectBaseConstantPaths.LOCATORS_FILE), wedvalue);
	    report.info("Successfully Entered wed value");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.tuevalue.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
	    String thuvalue=page.getdata_fromExcel("Employee", "Validation Text", "Thursday value");
	    page.sendKeys(ReadLocators.getPropertyvalue("loc.thuvalue.txt", ProjectBaseConstantPaths.LOCATORS_FILE), thuvalue);
	    report.info("Successfully Entered thu value");
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.frivalue.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
	    String frivalue=page.getdata_fromExcel("Employee", "Validation Text", "Friday value");
	    page.sendKeys(ReadLocators.getPropertyvalue("loc.frivalue.txt", ProjectBaseConstantPaths.LOCATORS_FILE), frivalue);
	    report.info("Successfully Entered fri value");
	 log.info("STEP#8: Add Notes");	
	    page.mouseOver(ReadLocators.getPropertyvalue("loc.notestooltip.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
	    waits.implicitWait();
	    actualtooltipmessage=page.getText(ReadLocators.getPropertyvalue("validate.tooltip.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
        page.writedata_toExcel(sheetname, columnname, 9, actualtooltipmessage);
        expectedtooltipmessage=page.getdata_fromExcel(sheetname, columnname, "Notes value");
        Verify.verifyString(actualtooltipmessage, expectedtooltipmessage, "Validating the tooltip message is same as expected or not");
		report.info("Successfully validated notes");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.notestooltip.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
		String notes=page.getdata_fromExcel("Employee", "Validation Text", "Notes text");
		page.sendKeys(ReadLocators.getPropertyvalue("loc.notestooltip.txt", ProjectBaseConstantPaths.LOCATORS_FILE), notes);
		report.info("Successfully Entered notes value");
     log.info("STEP#9: Add Activity");	
        page.mouseOver(ReadLocators.getPropertyvalue("loc.addactvity.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
        waits.implicitWait();
        actualtooltipmessage=page.getText(ReadLocators.getPropertyvalue("validate.tooltip.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
        page.writedata_toExcel(sheetname, columnname, 10, actualtooltipmessage);
        expectedtooltipmessage=page.getdata_fromExcel(sheetname, columnname, "Add activity value");
        Verify.verifyString(actualtooltipmessage, expectedtooltipmessage, "Validating the tooltip message is same as expected or not");
		report.info("Successfully validated add activity");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.addactvity.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on add activity");
	log.info("STEP#10: Selecting the second activity");	
	    page.clickOnElement(ReadLocators.getPropertyvalue("loc.secondactvity.ddn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    report.info("Successfully selected Activity");
	log.info("STEP#11: Delete Activity");	
	    page.mouseOver(ReadLocators.getPropertyvalue("loc.deleteactivity.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
	    waits.implicitWait();
	    actualtooltipmessage=page.getText(ReadLocators.getPropertyvalue("validate.tooltip.txt", ProjectBaseConstantPaths.LOCATORS_FILE));
        page.writedata_toExcel(sheetname, columnname, 11, actualtooltipmessage);
        expectedtooltipmessage=page.getdata_fromExcel(sheetname, columnname, "Delete activity value");
        Verify.verifyString(actualtooltipmessage, expectedtooltipmessage, "Validating the tooltip message is same as expected or not");
		report.info("Successfully validated delete activity");
		page.clickOnElement(ReadLocators.getPropertyvalue("loc.deleteactivity.btn", ProjectBaseConstantPaths.LOCATORS_FILE));
		report.info("Successfully clicked on delete activity");
	}
}
