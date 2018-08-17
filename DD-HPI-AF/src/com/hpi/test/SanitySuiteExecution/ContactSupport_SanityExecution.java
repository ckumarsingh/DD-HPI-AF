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

@Test(priority=0)
public void TC01_BtnsDisplayedTest() {
	boolean Guestflag=ContactSupport_IdentifyLanding.VerifyGuestBtnDsplyd();
	Assert.assertTrue(Guestflag);
	boolean SignInflag=ContactSupport_IdentifyLanding.VerifySignInBtnDsplyd();
	Assert.assertTrue(SignInflag);
}
@Test(priority=1)
public void TC02_GuestLoginTest() {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	String STitle=ContactSupport_IdentifyProduct.ValidatePageTitle();
	System.out.println(STitle);
	Assert.assertEquals(STitle, "Contact Support - Start by identifying your products");	
}
@Test(priority=2)
public void TC03_ValidateIdntfyNwBtnTest() {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	boolean Ds=ContactSupport_IdentifyProduct.ValidateIdntfyNowBtnDs();
	boolean En=ContactSupport_IdentifyProduct.ValidateIdntfyNowBtnEn();
	Assert.assertTrue(Ds);
	Assert.assertTrue(En);
}
@Test(priority=3)
public void TC04_ClickSDDLinkTest()  {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	((JavascriptExecutor)driver).executeScript("scroll(0,200)");
	String SDLink1=ContactSupport_IdentifyProduct.ValidateSDPageURL();
	Assert.assertEquals(SDLink1, "https://uat.support.hp.com/us-en/document/c05061199");
	ContactSupport_IdentifyProduct.ClickWikiHowLink();
	driver.get(SDLink1);
	String SS= driver.getWindowHandle();
	driver.switchTo().window(SS);
	WebElement SD=driver.findElement(By.xpath("//h2[text()='Solution and Diagnostic Data Collection']"));
	String SD1=SD.getText();
	Assert.assertEquals(SD1, "Solution and Diagnostic Data Collection");	
}
@Test(priority=4)
public void TC05_PfinderSBEnbldTest() {
	boolean PFEn1=ContactSupport_IdentifyProduct.PfinderSBDs();
	Assert.assertTrue(PFEn1);
}
@Test(priority=5)
public void TC06_PFindDsbledTest() {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	boolean PFindFlag1=ContactSupport_IdentifyProduct.ValidatePfindBtnEn();
	Assert.assertFalse(PFindFlag1);
}
@Test(priority=6)
public void TC07_PFindEnbledTest() {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind("H6N52AA");
	boolean PFindFlag2=ContactSupport_IdentifyProduct.ValidatePfindBtnEn();
	Assert.assertTrue(PFindFlag2);		
}
@Test(priority=7)
public void TC08_PfinderTPvalidateTest() throws InterruptedException {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.ClickTPPfinder();
	Thread.sleep(2000);
	String TT1=ContactSupport_IdentifyProduct.PfinderTPT();
	Assert.assertEquals(TT1, "How do I find my product name, number or serial number?");
	System.out.println(TT1);
	Boolean Image2 =ContactSupport_IdentifyProduct.ImageDs();
	Assert.assertTrue(Image2);	
}

@Test(priority=8)
public void TC09_EP_PNameTest() throws InterruptedException {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind("HP ENVY Recline 23-k001hk TouchSmart All-in-One Desktop PC (ENERGY STAR)");
	Thread.sleep(2000);
	ContactSupport_IdentifyProduct.ClickFind();
	Thread.sleep(5000);
	String P2=ContactSupport_EntitlementPage.EntitlementPageTitle();
	Assert.assertEquals(P2, "HP Customer Support - Verify entitlement");
}
@Test(priority=9)
public void TC10_EP_SNOTest() throws InterruptedException {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind("4CS34503K1");
	ContactSupport_IdentifyProduct.ClickFind();
	Thread.sleep(5000);
	String P2=ContactSupport_EntitlementPage.EntitlementPageTitle();
	Assert.assertEquals(P2, "HP Customer Support - Verify entitlement");
}
@Test(priority=10)
public void TC11_EP_PNTest() throws InterruptedException {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind("H6N52AA");
	ContactSupport_IdentifyProduct.ClickFind();
	Thread.sleep(5000);
	String P2=ContactSupport_EntitlementPage.EntitlementPageTitle();
	Assert.assertEquals(P2, "HP Customer Support - Verify entitlement");
}

@Test(priority=11,dataProvider="getTestdata")
public void TC12_PN_SNTest(String ProductNo) {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind(ProductNo);
	ContactSupport_IdentifyProduct.ClickFind();
	String T1= ContactSupport_EntitlementPage.GetTitle4Product();
	//Assert.assertTrue(T1);
	System.out.println("The string is: " + T1);
	boolean B2=ContactSupport_EntitlementPage.SrnoDs();
	Assert.assertTrue(B2);
}
@Test(priority=12,dataProvider="getTestdata1")
public void TC13_SNTest(String SerialNo) {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind(SerialNo);
	ContactSupport_IdentifyProduct.ClickFind();
	String T1= ContactSupport_EntitlementPage.GetTitle4Product();
	//Assert.assertEquals(T1, "");
	//Assert.assertTrue(T1);
	System.out.println(T1);
	boolean B3=ContactSupport_EntitlementPage.SrnoDs();
	Assert.assertFalse(B3);
	
}
@Test(priority=13,dataProvider="getTestdata1")
public void TC14_SN_WDTest(String SerialNo) throws InterruptedException {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind(SerialNo);
	ContactSupport_IdentifyProduct.ClickFind();
	Thread.sleep(10000);
	boolean W2=ContactSupport_EntitlementPage.WarrantyTagDs();
	Assert.assertTrue(W2); //Verifying Warranty Tag
	boolean S2=ContactSupport_EntitlementPage.SerialTagDs();
	Assert.assertTrue(S2); //Verifying Serial Tag
	boolean P1=ContactSupport_EntitlementPage.ProductTag();
	Assert.assertTrue(P1); //Verifying Product Tag
}
@Test(priority=14,dataProvider="getTestdata")
public void TC15_PN_WDTest(String ProductNo) throws InterruptedException {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind(ProductNo);
	ContactSupport_IdentifyProduct.ClickFind();
	Thread.sleep(10000);
	boolean W2=ContactSupport_EntitlementPage.WarrantyTagDs();
	Assert.assertFalse(W2); //Verifying Warranty Tag
	boolean S2=ContactSupport_EntitlementPage.SerialTagDs();
	Assert.assertFalse(S2); //Verifying Serial Tag
	boolean P1=ContactSupport_EntitlementPage.ProductTag();
	Assert.assertFalse(P1); //Verifying Product Tag
}
@Test(priority=15,dataProvider="getTestdata1")
public void TC16_SN_ConOptBtnTest(String SerialNo) throws InterruptedException {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind(SerialNo);
	ContactSupport_IdentifyProduct.ClickFind();
	Thread.sleep(7000);
	((JavascriptExecutor)driver).executeScript("scroll(0,450)");
	boolean S4=ContactSupport_EntitlementPage.ShowbtnEnld();
	Assert.assertTrue(S4); //Verifying ShowButton Enabled
	
}
@Test(priority=16,dataProvider="getTestdata1")
public void TC17_SN_ConOptTest(String SerialNo) throws InterruptedException {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind(SerialNo);
	ContactSupport_IdentifyProduct.ClickFind();
	Thread.sleep(7000);
	((JavascriptExecutor)driver).executeScript("scroll(0,450)");
	ContactSupport_EntitlementPage.ShowButtonClick();
	boolean PS2=ContactSupport_EntitlementPage.PhoneSupportBtnDs();
	boolean EF1=ContactSupport_EntitlementPage.EmailFormBtnDs();
	boolean F2=ContactSupport_EntitlementPage.ForumBtnDs();
	boolean SC2=ContactSupport_EntitlementPage.ServiceCenterBtnDs();
	Assert.assertTrue(PS2); //Verifying PhoneSupport Button displayed
	Assert.assertTrue(EF1);	//Verifying Email Form Button displayed
	Assert.assertTrue(F2);	//Verifying Forum Button displayed
	Assert.assertTrue(SC2);	//Verifying service center Button displayed
	
}

@Test(priority=17,dataProvider="getTestdata3" )
public void TC18_PN_ConOptBtnTest(String ProductNo, String SerialNo) throws InterruptedException {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind(ProductNo);
	ContactSupport_IdentifyProduct.ClickFind();
	Thread.sleep(7000);
	((JavascriptExecutor)driver).executeScript("scroll(0,450)");
	boolean S4=ContactSupport_EntitlementPage.ShowbtnEnld();
	boolean S5=ContactSupport_EntitlementPage.ShowbtnEnld();
	Assert.assertFalse(S4); //Verifying ShowButton Disabled
	ContactSupport_EntitlementPage.EnterSrNo(SerialNo);
	Thread.sleep(2000);
	//Assert.assertTrue(S5); //Verifying ShowButton Enabled
}
@Test(priority=18,dataProvider="getTestdata3" )
public void TC19_PN_ConOptTest(String ProductNo, String SerialNo) throws InterruptedException {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind(ProductNo);
	ContactSupport_IdentifyProduct.ClickFind();
	Thread.sleep(7000);
	((JavascriptExecutor)driver).executeScript("scroll(0,450)");
	ContactSupport_EntitlementPage.EnterSrNo(SerialNo);
	ContactSupport_EntitlementPage.ShowButtonClick();
	boolean PS2=ContactSupport_EntitlementPage.PhoneSupportBtnDs();
	boolean EF1=ContactSupport_EntitlementPage.EmailFormBtnDs();
	boolean F2=ContactSupport_EntitlementPage.ForumBtnDs();
	boolean SC2=ContactSupport_EntitlementPage.ServiceCenterBtnDs();
	Assert.assertTrue(PS2); //Verifying PhoneSupport Button displayed
	Assert.assertTrue(EF1);	//Verifying Email Form Button displayed
	Assert.assertTrue(F2);	//Verifying Forum Button displayed
	Assert.assertTrue(SC2);	//Verifying service center Button displayed
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



