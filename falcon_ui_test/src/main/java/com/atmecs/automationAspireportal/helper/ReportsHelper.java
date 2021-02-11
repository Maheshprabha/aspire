package com.atmecs.automationAspireportal.helper;

import com.atmecs.automationAspireportal.testscript.SampleTestScript;
import com.atmecs.automationAspireportal.utils.LoadProperties;
import com.atmecs.automationAspireportal.utils.Pageactions;
import com.atmecs.automationAspireportal.utils.ReadLocators;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class ReportsHelper {
	Browser browser=null;
	Pageactions page;
	ReadLocators read = new ReadLocators();
	LoadProperties load = new LoadProperties();
	public ReportsHelper(Browser browser) {
		this.browser = browser;
		page=new Pageactions(browser);
	}
	
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);


}
