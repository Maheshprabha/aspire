package com.atmecs.automationAspireportal.testscript;

import org.testng.annotations.Test;

import com.atmecs.automationAspireportal.helper.EmployeeHelper;
import com.atmecs.automationAspireportal.helper.ManagerloginHelper;
import com.atmecs.automationAspireportal.helper.ValidationHelper;
import com.atmecs.automationAspireportal.testsuite.TestSuiteBase;
import com.atmecs.automationAspireportal.validationresult.ManagerPageValidation;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class TC03_Manager_Approve extends TestSuiteBase{
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	
	@Test
	public void Manager_Approve() throws Exception {
		ManagerPageValidation validation=new ManagerPageValidation(browser);
		ManagerloginHelper manahelper=new ManagerloginHelper(browser);
	    ValidationHelper helper=new ValidationHelper(browser);
	    
	    EmployeeHelper employeeHelper=new EmployeeHelper(browser);
	  
	    employeeHelper.employeeHelper();
	    manahelper.LoginPage();
	report.info("Validating the Breadcrum");
		validation.validateManagerBreadcrum();
		report.info("Successfully validated breadcrum");
	report.info("Selecting the project");
	    helper.selectproject("Project", "loc.project.ddn", "loc.projecttext.txt", "loc.projectvalue.txt");
	report.info("Selecting the employee name");
	    helper.clickonelement("loc.empnamedown.ddn");
	report.info("Successfully selected employee dropdown");
	report.info("Clicking approve button under action column");
	    helper.approve_rejectbutton("Approve message", "loc.actionapprove.btn", "validate.approvemessage.txt");
	}
}
