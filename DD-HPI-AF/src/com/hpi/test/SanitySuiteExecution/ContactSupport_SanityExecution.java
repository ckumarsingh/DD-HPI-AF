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

@Test
public void TC01AllBtnsDsplyd_Test () {
	boolean S1= ContactSupport_Landing.VerifySignBtnDsplyd();
	Assert.assertTrue(S1);
	boolean S2= ContactSupport_Landing.VerifyPrinterBtnDsplyd();
	Assert.assertTrue(S2);
}
@Test
public void TC_PrinterLanding_Test () {
	ContactSupport_Landing.ClickPrinterIcon();
	boolean S1=ContactSupport_ProductsLanding.VerfyDMDdsplyd();
	Assert.assertTrue(S1);
	boolean S2=ContactSupport_ProductsLanding.VerfyDMDEnbld();
	Assert.assertTrue(S2);
	boolean S3=ContactSupport_ProductsLanding.VerfyFindOutMoreLinkdsplyd();
	Assert.assertTrue(S3);
	boolean S4=ContactSupport_ProductsLanding.VerfySNTag();
	Assert.assertTrue(S4);
	boolean S5=ContactSupport_ProductsLanding.VerfySNBox();
	Assert.assertTrue(S5);
}
@Test
public void TC_ClickFndOutMoreLink_Test ( ) {
	ContactSupport_Landing.ClickPrinterIcon();
	String SDLink1=ContactSupport_ProductsLanding.ValidateSDPageURL();
	Assert.assertEquals(SDLink1, "https://uat.support.hp.com/us-en/document/c05061199");
	ContactSupport_ProductsLanding.ClickFindlink();
	driver.get(SDLink1);
	String SS= driver.getWindowHandle();
	driver.switchTo().window(SS);
	WebElement SD=driver.findElement(By.xpath("//h2[text()='Solution and Diagnostic Data Collection']"));
	String SD1=SD.getText();
	Assert.assertEquals(SD1, "Solution and Diagnostic Data Collection");
}
@Test
public void TC_VerifyPrinterSubmitBtn_Test () {
	ContactSupport_Landing.ClickPrinterIcon();
	boolean S1=ContactSupport_ProductsLanding.VerfySbmtBtnDspld();
	boolean S2=ContactSupport_ProductsLanding.VerfySbmtBtnEnbld1();
	boolean S3=ContactSupport_ProductsLanding.VerfySbmtBtnEnbld2();
	boolean S4=ContactSupport_ProductsLanding.VerfySbmtBtnEnbld3();
	Assert.assertTrue(S1);
	Assert.assertFalse(S2);
	Assert.assertTrue(S3);
	Assert.assertFalse(S4);
}
@Test
public void TC_LaptopLanding_Test () {
	ContactSupport_Landing.ClickPrinterIcon();
	boolean S1=ContactSupport_ProductsLanding.VerfyDMDdsplyd();
	Assert.assertTrue(S1);
	boolean S2=ContactSupport_ProductsLanding.VerfyDMDEnbld();
	Assert.assertTrue(S2);
	boolean S3=ContactSupport_ProductsLanding.VerfyFindOutMoreLinkdsplyd();
	Assert.assertTrue(S3);
	boolean S4=ContactSupport_ProductsLanding.VerfySNTag();
	Assert.assertTrue(S4);
	boolean S5=ContactSupport_ProductsLanding.VerfySNBox();
	Assert.assertTrue(S5);
}
@Test
public void TC_DesktopLanding_Test () {
	ContactSupport_Landing.ClickPrinterIcon();
	boolean S1=ContactSupport_ProductsLanding.VerfyDMDdsplyd();
	Assert.assertTrue(S1);
	boolean S2=ContactSupport_ProductsLanding.VerfyDMDEnbld();
	Assert.assertTrue(S2);
	boolean S3=ContactSupport_ProductsLanding.VerfyFindOutMoreLinkdsplyd();
	Assert.assertTrue(S3);
	boolean S4=ContactSupport_ProductsLanding.VerfySNTag();
	Assert.assertTrue(S4);
	boolean S5=ContactSupport_ProductsLanding.VerfySNBox();
	Assert.assertTrue(S5);
}
@Test
public void TC_VerifyLaptopSubmitBtn_Test () {
	ContactSupport_Landing.ClickPrinterIcon();
	boolean S1=ContactSupport_ProductsLanding.VerfySbmtBtnDspld();
	boolean S2=ContactSupport_ProductsLanding.VerfySbmtBtnEnbld1();
	boolean S3=ContactSupport_ProductsLanding.VerfySbmtBtnEnbld2();
	boolean S4=ContactSupport_ProductsLanding.VerfySbmtBtnEnbld3();
	Assert.assertTrue(S1);
	Assert.assertFalse(S2);
	Assert.assertTrue(S3);
	Assert.assertFalse(S4);
}
@Test
public void TC_VerifyDesktopSubmitBtn_Test () {
	ContactSupport_Landing.ClickPrinterIcon();
	boolean S1=ContactSupport_ProductsLanding.VerfySbmtBtnDspld();
	boolean S2=ContactSupport_ProductsLanding.VerfySbmtBtnEnbld1();
	boolean S3=ContactSupport_ProductsLanding.VerfySbmtBtnEnbld2();
	boolean S4=ContactSupport_ProductsLanding.VerfySbmtBtnEnbld3();
	Assert.assertTrue(S1);
	Assert.assertFalse(S2);
	Assert.assertTrue(S3);
	Assert.assertFalse(S4);
}

@Test
public void TC_VerifyPrinterProductLabel_Test() throws InterruptedException {
	ContactSupport_Landing.ClickPrinterIcon();
	String S1=ContactSupport_ProductsLanding.VerfyProductLabel();
	Assert.assertEquals(S1, "Locate your product's information label");
	ContactSupport_ProductsLanding.ClickProductLabel();
	Thread.sleep(2000);
	String S2=ContactSupport_ProductsLanding.VrfyLcateTitle();
	Assert.assertEquals(S2, "Find your serial number by locating the product label");
	ContactSupport_ProductsLanding.ClickCancelProductlabel();
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



