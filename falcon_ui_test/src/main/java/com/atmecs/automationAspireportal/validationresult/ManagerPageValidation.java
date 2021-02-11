package com.atmecs.automationAspireportal.validationresult;

import com.atmecs.automationAspireportal.constant.ProjectBaseConstantPaths;
import com.atmecs.automationAspireportal.helper.ValidationHelper;
import com.atmecs.automationAspireportal.utils.Pageactions;
import com.atmecs.automationAspireportal.utils.PropReader;
import com.atmecs.automationAspireportal.utils.ReadDataFromExcel;
import com.atmecs.automationAspireportal.utils.ReadLocators;
import com.atmecs.falcon.automation.ui.selenium.Browser;

public class ManagerPageValidation {
	PropReader propReader=new PropReader(ProjectBaseConstantPaths.LOCATORS_FILE);
	Browser browser = null;
	ReadDataFromExcel readingData=new ReadDataFromExcel();
	ReadLocators read=new ReadLocators();
    String sheetname="Manager";
    String columnname="Validation Text";
	Pageactions page;
	ValidationHelper helper;

	public ManagerPageValidation(Browser browser) {
		this.browser = browser;
		page = new Pageactions(browser);
		helper = new ValidationHelper(browser);
		//reports=new ExtentReport(browser);
	}
	public void validateManagerBreadcrum() throws Exception {
		helper.getDataofRow("Breadcrum", "validate.breadcrum.txt",2);
}
}
