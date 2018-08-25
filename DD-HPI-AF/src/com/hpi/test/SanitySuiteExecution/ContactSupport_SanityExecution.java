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
import com.hpi.test.ContactSupport.ContactSupport_EntitlementPage;
import com.hpi.test.ParentBase.TestBase;
import com.hpi.test.util.TestUtil;


public class ContactSupport_SanityExecution extends TestBase {

	
	ContactSupport_Landing ContactSupport_Landing;
	ContactSupport_ProductsLanding ContactSupport_ProductsLanding;
	ContactSupport_SupportOptions ContactSupport_SupportOptions;
	ContactSupport_EntitlementPage ContactSupport_EntitlementPage;

@BeforeMethod
public void setup() {
	initialization();
	ContactSupport_Landing = new ContactSupport_Landing();
	ContactSupport_ProductsLanding = new ContactSupport_ProductsLanding();
	ContactSupport_SupportOptions = new ContactSupport_SupportOptions();
	ContactSupport_EntitlementPage= new ContactSupport_EntitlementPage();
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
	boolean B1= ContactSupport_Landing.VerifySignBtnDsplyd();
	boolean B2= ContactSupport_Landing.VerifyPrinterBtnDsplyd();
	boolean B3= ContactSupport_Landing.VerifyDesktopBtnDsplyd();
	boolean B4= ContactSupport_Landing.VerifyLaptopBtnDsplyd();
	boolean B5= ContactSupport_Landing.VerifyOtherBtnDsplyd();
	Assert.assertTrue(B1);
	Assert.assertTrue(B2);
	Assert.assertTrue(B3);
	Assert.assertTrue(B4);
	Assert.assertTrue(B5);
}
@Test
public void TC_PrinterLanding_Test () {
	ContactSupport_Landing.ClickPrinterIcon();
	boolean S1=ContactSupport_ProductsLanding.VerfyDMDdsplyd();
	boolean S2=ContactSupport_ProductsLanding.VerfyDMDEnbld();
	boolean S3=ContactSupport_ProductsLanding.VerfyFindOutMoreLinkdsplyd();
	boolean S4=ContactSupport_ProductsLanding.VerfySNTag();
	boolean S5=ContactSupport_ProductsLanding.VerfySNBox();
	Assert.assertTrue(S1);
	Assert.assertTrue(S2);
	Assert.assertTrue(S3);
	Assert.assertTrue(S4);
	Assert.assertTrue(S5);
}
@Test
public void TC_ClickFndOutMoreLink_Test ( ) {
	ContactSupport_Landing.ClickPrinterIcon();
	String SDLink1=ContactSupport_ProductsLanding.ValidateSDPageURL();
	Assert.assertEquals(SDLink1, "https://support.hp.com/us-en/document/c05061199");
	ContactSupport_ProductsLanding.ClickFindlink();
	driver.get(SDLink1);
	String SS= driver.getWindowHandle();
	driver.switchTo().window(SS);
	WebElement SD=driver.findElement(By.xpath("//h2[text()='Solution and Diagnostic Data Collection']"));
	String SD1=SD.getText();
	Assert.assertEquals(SD1, "Solution and Diagnostic Data Collection", "FindOutMoreLink");
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
public void TC_VerifyPrinterProductLabel_Test() throws InterruptedException {
	ContactSupport_Landing.ClickPrinterIcon();
	String S1=ContactSupport_ProductsLanding.VerfyProductLabel();
	Assert.assertEquals(S1, "Locate your product's information label");
	ContactSupport_ProductsLanding.ClickProductLabel();
	Thread.sleep(2000);
	String S2=ContactSupport_ProductsLanding.VrfyLcatePrdtTitle();
	Assert.assertEquals(S2, "Find your serial number by locating the product label");
	ContactSupport_ProductsLanding.ClickCancelProductlabel();
}
@Test(priority=12,dataProvider="getTestdata3")
public void TC_PrinterSN_Test(String SerialNo, String ProductNo, String ProductName) throws InterruptedException {
		ContactSupport_Landing.ClickPrinterIcon();
		ContactSupport_ProductsLanding.EnterSNNo_Data(SerialNo);
		Thread.sleep(1000);
		ContactSupport_ProductsLanding.ClickSubmtBtn();
		String T1= ContactSupport_SupportOptions.VerifySupportHelpTitle();
		Assert.assertEquals(T1, "How can we help you?");
		boolean B1= ContactSupport_SupportOptions.VerifySerialNumText();
		Assert.assertTrue(B1);
		boolean B2= ContactSupport_SupportOptions.VerifyProductNumText();
		Assert.assertTrue(B2);
		System.out.println(T1);
		String S1= ContactSupport_SupportOptions.VerifySerialNum();
		String S2= ContactSupport_SupportOptions.VerifyProdNum();
		String S3=ContactSupport_SupportOptions.VerifyProductInfoTitle();
		Assert.assertEquals(S1, SerialNo);
		Assert.assertEquals(S2, ProductNo);
		Assert.assertEquals(S3, ProductName);
		System.out.println(S1);
		System.out.println(S2);
		System.out.println(S3);
		
		//Assert.assertEquals(S2, SerialNo, "The Serial No. Matches and is");
		//boolean B3=ContactSupport_SupportOptions.SrnoDs();
		//Assert.assertFalse(B3);
}
@Test(dataProvider="getTestdata3")
public void TC_PrinterPNo_Test (String SerialNo, String ProductNo, String ProductName ) throws InterruptedException {
	ContactSupport_Landing.ClickPrinterIcon();
	ContactSupport_ProductsLanding.EnterPNNo_Data(ProductNo);
	Thread.sleep(1000);
	ContactSupport_ProductsLanding.ClickSubmtBtn();
	
	String T0= ContactSupport_EntitlementPage.VrfyEntitlementTitle();
	Assert.assertEquals(T0, "HP Customer Support - Verify entitlement");
	ContactSupport_EntitlementPage.EntrSNEntitlement(SerialNo);
	Thread.sleep(1000);
	ContactSupport_EntitlementPage.ClickSbtn();
	
	String T1= ContactSupport_SupportOptions.VerifySupportHelpTitle();
	Assert.assertEquals(T1, "How can we help you?");
	boolean B1= ContactSupport_SupportOptions.VerifySerialNumText();
	Assert.assertTrue(B1);
	boolean B2= ContactSupport_SupportOptions.VerifyProductNumText();
	Assert.assertTrue(B2);
	System.out.println(T1);
	String S1= ContactSupport_SupportOptions.VerifyProdNum();
	Assert.assertEquals(S1, ProductNo);
	String S2= ContactSupport_SupportOptions.VerifySerialNum();
	Assert.assertEquals(S2, SerialNo);
	String S3=ContactSupport_SupportOptions.VerifyProductInfoTitle();
	Assert.assertEquals(S3, ProductName);
	System.out.println(S1);
	System.out.println(S2);
	System.out.println(S3);
}
@Test(dataProvider="getTestdata3")
public void TC_PrinterPName_Test (String SerialNo, String ProductNo, String ProductName  ) throws InterruptedException {
	ContactSupport_Landing.ClickPrinterIcon();
	ContactSupport_ProductsLanding.EnterPNNo_Data(ProductName);
	Thread.sleep(1000);
	ContactSupport_ProductsLanding.ClickSubmtBtn();
	
	String T0= ContactSupport_EntitlementPage.VrfyEntitlementTitle();
	Assert.assertEquals(T0, "HP Customer Support - Verify entitlement", "Entitlement page Check");
	ContactSupport_EntitlementPage.EntrSNEntitlement(SerialNo);
	Thread.sleep(1000);
	ContactSupport_EntitlementPage.ClickSbtn();
	
	String T1= ContactSupport_SupportOptions.VerifySupportHelpTitle();
	Assert.assertEquals(T1, "How can we help you?", "Support page check");
	boolean B1= ContactSupport_SupportOptions.VerifySerialNumText();
	Assert.assertTrue(B1, "SerialNumTextCheck");
	boolean B2= ContactSupport_SupportOptions.VerifyProductNumText();
	Assert.assertTrue(B2, "ProductNumTextCheck");
	System.out.println(T1);
	String S1= ContactSupport_SupportOptions.VerifyProdNum();
	Assert.assertEquals(S1, ProductNo, "ProdNumTest");
	String S2= ContactSupport_SupportOptions.VerifySerialNum();
	Assert.assertEquals(S2, SerialNo, "SerialNumTest");
	String S3=ContactSupport_SupportOptions.VerifyProductInfoTitle();
	Assert.assertEquals(S3, ProductName, "ProductNameTest");
	System.out.println(S1);
	System.out.println(S2);
	System.out.println(S3);
}






@Test
public void TC_LaptopLanding_Test () {
	ContactSupport_Landing.ClickLaptopIcon();
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
	ContactSupport_Landing.ClickDesktopIcon();
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
	ContactSupport_Landing.ClickLaptopIcon();
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
	ContactSupport_Landing.ClickDesktopIcon();
	boolean S1=ContactSupport_ProductsLanding.VerfySbmtBtnDspld();
	boolean S2=ContactSupport_ProductsLanding.VerfySbmtBtnEnbld1();
	boolean S3=ContactSupport_ProductsLanding.VerfySbmtBtnEnbld2();
	boolean S4=ContactSupport_ProductsLanding.VerfySbmtBtnEnbld3();
	Assert.assertTrue(S1);
	Assert.assertFalse(S2);
	Assert.assertTrue(S3);
	Assert.assertFalse(S4);
}


@AfterMethod
public void AllWebclose() {
	driver.quit();	
}

/*@AfterMethod
public void screenshot(ITestResult result) {
	if(ITestResult.FAILURE==result.getStatus())
	{
		captureScreenshot(driver, result.getName());
	}
	driver.quit();
}
*/	
	
}



