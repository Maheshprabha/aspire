package com.atmecs.automationAspireportal.utils;

import java.util.Set;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.atmecs.automationAspireportal.constant.ProjectBaseConstantPaths;
import com.atmecs.automationAspireportal.testscript.SampleTestScript;
import com.atmecs.falcon.automation.ui.selenium.Browser;
import com.atmecs.falcon.automation.util.reporter.ReportLogService;
import com.atmecs.falcon.automation.util.reporter.ReportLogServiceImpl;

public class Pageactions {
	//RandomNumber random = new RandomNumber();
	ReadLocators read = new ReadLocators();
	Browser browser = null;
	ReadDataFromExcel reader = getsheet(ProjectBaseConstantPaths.EXCEL_FILE);
	private ReportLogService report = new ReportLogServiceImpl(SampleTestScript.class);
	public Pageactions(Browser browser) {
		this.browser = browser;
	}

	
	  public ReadDataFromExcel getsheet(String sheetname) 
	  { 
		  ReadDataFromExcel read= new ReadDataFromExcel(); 
		  try 
		  { 
			  read.setPath(sheetname); 
			  } 
		  catch (Exception e) 
		  { 
			  e.printStackTrace(); 
			  } 
		  return read; 
		  }
	 

	
	  public String getdata_fromExcel(String sheetname, String columnname, String rowname) 
	  { 
		  String datavalue = reader.getCellDataByColumnName(sheetname,columnname, rowname); 
		  return datavalue; 
		  }
	 

	
	  public String writedata_toExcel(String sheetname, String columnname, int rownumber, String value) 
	  { 
		  String datavalue = reader.setCellData(sheetname,columnname, rownumber, value); 
		  return datavalue; 
		  }
	 

	
	  public String getdatabycellvalue(String sheetName, int colNum, int i) 
	  {
	  
		  String datavalue = reader.getCellData(sheetName, colNum, i); 
		  return datavalue; 
		  }
	 

	public WebElement getLocator(String locatorType) {
		String[] locator = locatorType.split(":");

		/*
		 * System.out.println("In Select locators::***************");
		 * System.out.println("Key::"+locator[0]);
		 * System.out.println("value::"+locator[1]);
		 */

		WebElement webElement = null;

		switch (locator[0]) {
		case "id":
			webElement = browser.getFindFromBrowser().findElementById(locator[1]);
			break;
		case "name":
			webElement = browser.getFindFromBrowser().findElementByName(locator[1]);
			break;
		case "className":
			webElement = browser.getFindFromBrowser().findElementByClassName(locator[1]);
			break;
		case "linkText":
			webElement = browser.getFindFromBrowser().findElementByLinkText(locator[1]);
			break;
		case "partialLinkText":
			webElement = browser.getFindFromBrowser().findElementByPartialLinkText(locator[1]);
			break;
		case "tagName":
			webElement = browser.getFindFromBrowser().findElementByTagName(locator[1]);
			break;
		case "cssSelector":
			webElement = browser.getFindFromBrowser().findElementByCssSelector(locator[1]);
			break;
		case "xpath":
			webElement = browser.getFindFromBrowser().findElementByXpath(locator[1]);
			break;
		}
		return webElement;
	}

	public void clickOnElement(String element) {
		try {
			WebElement webElement = getLocator(element);
			webElement.click();
		} catch (Exception exception) {
			 exception.printStackTrace();
		}
	}
	
	public void clear(String element) {
		WebElement webElement=getLocator(element);
		webElement.clear();
	}
	
	public void sendKeys(String element,String value) {

		WebElement webelement= getLocator(element);
		webelement.sendKeys(value);
	}

	public String getText(String element) {
			WebElement webElement = getLocator(element);
			return webElement.getText();
	}

	public String getCssValue(String element, String value) {
			WebElement webElement = getLocator(element);
			return webElement.getCssValue(value);
	}

	public void mouseOver(String element) {
		try {
			Actions action = new Actions(browser.getDriver());
			WebElement webElement = getLocator(element);
			action.moveToElement(webElement).perform();
		}catch (Exception exception) {
			report.info("element is not displayed and enable to mouse hover");
		}
	}
	
	public String mouseOvering(String element) {
		try {
			Actions action = new Actions(browser.getDriver());
			WebElement webElement = getLocator(element);
			action.moveToElement(webElement).perform();
		}catch (Exception exception) {
			report.info("element is not displayed and enable to mouse hover");
		}
		return element;
	}
	

	/*
	 * public String randomnumber(String locator) throws Exception { int
	 * randomnumber = random.generateRandomNumber(); String number =
	 * Integer.toString(randomnumber); String locatorvalue =
	 * ReadLocators.getPropertyvalue(locator,
	 * ProjectBaseConstantPaths.LOCATORS_FILE); String Locator =
	 * locatorvalue.replace("*", number); return Locator; }
	 */

	public void windowHandle() {
		Set<String> allWindowHandles = browser.getDriver().getWindowHandles();

		for (String handle : allWindowHandles) {
			browser.getDriver().switchTo().window(handle);
		}
	}
}