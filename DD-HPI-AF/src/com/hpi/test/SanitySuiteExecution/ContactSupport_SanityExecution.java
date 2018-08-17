package com.hpi.test.SanitySuiteExecution;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import com.hpi.test.ContactSupport.ContactSupport_Landing;
import com.hpi.test.ContactSupport.ContactSupport_ProductsLanding;
import com.hpi.test.ContactSupport.ContactSupport_SupportOptions;
import com.hpi.test.ParentBase.TestBase;
import com.hpi.test.util.TestUtil;


public class ContactSupport_SanityExecution extends TestBase {

	
	ContactSupport_Landing ContactSupport_Landing;
	ContactSupport_ProductsLanding ContactSupport_ProductsLanding;
	ContactSupport_SupportOptions ContactSupport_SupportOptions;
	

@BeforeMethod
public void setup() {
	initialization();
	ContactSupport_Landing = new ContactSupport_Landing();
	ContactSupport_ProductsLanding = new ContactSupport_ProductsLanding();
	ContactSupport_SupportOptions = new ContactSupport_SupportOptions();
}
@DataProvider
public Object[][] getTestdata() {
	String sheetname= "ProductNo";
	Object data[][]=TestUtil.getTestData(sheetname);
	return data;
}
@DataProvider
public Object[][] getTestdata1() {
	String sheetname= "SerialNo";
	Object data[][]=TestUtil.getTestData(sheetname);
	return data;
}
@DataProvider
public Object[][] getTestdata2() {
	String sheetname= "ProductName";
	Object data[][]=TestUtil.getTestData(sheetname);
	return data;
}
@DataProvider
public Object[][] getTestdata3() {
	String sheetname= "PN_SN";
	Object data[][]=TestUtil.getTestData(sheetname);
	return data;
}



/*@AfterMethod
public void AllWebclose() {
	driver.quit();	
}*/
@AfterMethod
public void screenshot(ITestResult result) {
	if(ITestResult.FAILURE==result.getStatus())
	{
		captureScreenshot(driver, result.getName());
	}
	driver.quit();
}
	
	
}



