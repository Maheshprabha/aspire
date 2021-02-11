package com.atmecs.automationAspireportal.testscript;

import org.testng.annotations.Test;

import com.atmecs.automationAspireportal.helper.EmployeeHelper;
import com.atmecs.automationAspireportal.helper.ManagerloginHelper;
import com.atmecs.automationAspireportal.helper.ValidationHelper;
import com.atmecs.automationAspireportal.testsuite.TestSuiteBase;
import com.atmecs.automationAspireportal.validationresult.ManagerPageValidation;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class TC04_Manager_Reject extends TestSuiteBase{
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);

	
	@Test
	public void Manager_Action_Reject() throws Exception {
		ManagerPageValidation validation=new ManagerPageValidation(browser);
		ManagerloginHelper manahelper=new ManagerloginHelper(browser);
	    ValidationHelper helper=new ValidationHelper(browser);
	    
	    EmployeeHelper employeeHelper=new EmployeeHelper(browser);
	  
	    employeeHelper.employeeHelper();
	    manahelper.LoginPage();	report.info("STEP#14: Validating the Breadcrum");
		validation.validateManagerBreadcrum();
		report.info("Successfully validated breadcrum");
	report.info("STEP#15: Selecting the project");
	    helper.selectproject("Project", "loc.project.ddn", "loc.projecttext.txt", "loc.projectvalue.txt");
	report.info("STEP#16: Selecting the employee name");
	    helper.clickonelement("loc.empnamedown.ddn");
	report.info("Successfully selected employee dropdown");
	report.info("STEP#17: Clicking reject button under action column");
	    helper.clickonelement("loc.checkbox.btn");
	    helper.reject("loc.reject.btn", "loc.rejecttextarea.txt");
	    helper.approve_rejectbutton("Rejected message", "loc.rejectbutton.txt", "validate.rejectmessage.txt");
}
}
