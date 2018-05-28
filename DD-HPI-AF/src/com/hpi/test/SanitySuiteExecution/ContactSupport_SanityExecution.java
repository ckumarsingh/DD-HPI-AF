package com.hpi.test.SanitySuiteExecution;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hpi.test.ContactSupport.ContactSupport_EntitlementPage;
import com.hpi.test.ContactSupport.ContactSupport_IdentifyLanding;
import com.hpi.test.ContactSupport.ContactSupport_IdentifyProduct;
import com.hpi.test.ParentBase.TestBase;
import com.hpi.test.util.TestUtil;


public class ContactSupport_SanityExecution extends TestBase {

	
	ContactSupport_IdentifyLanding ContactSupport_IdentifyLanding;
	ContactSupport_IdentifyProduct ContactSupport_IdentifyProduct;
	ContactSupport_EntitlementPage ContactSupport_EntitlementPage;
	

@BeforeMethod
public void setup() {
	initialization();
	ContactSupport_IdentifyLanding = new ContactSupport_IdentifyLanding();
	ContactSupport_IdentifyProduct = new ContactSupport_IdentifyProduct();
	ContactSupport_EntitlementPage = new ContactSupport_EntitlementPage();
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
public void TC04_ClickSDDLinkTest() {
	ContactSupport_IdentifyLanding.ClickOnGuest();
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
public void TC06_PFindDsbled() {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	boolean PFindFlag1=ContactSupport_IdentifyProduct.ValidatePfindBtnEn();
	Assert.assertFalse(PFindFlag1);
}
@Test(priority=6)
public void TC07_PFindEnbled() {
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
public void TC_EP_PNameTest() throws InterruptedException {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind("HP ENVY Recline 23-k001hk TouchSmart All-in-One Desktop PC (ENERGY STAR)");
	ContactSupport_IdentifyProduct.ClickFind();
	Thread.sleep(5000);
	String P2=ContactSupport_EntitlementPage.EntitlementPageTitle();
	Assert.assertEquals(P2, "HP Customer Support - Verify entitlement");
}
@Test(priority=9)
public void TC_EP_SNOTest() throws InterruptedException {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind("4CS34503K1");
	ContactSupport_IdentifyProduct.ClickFind();
	Thread.sleep(5000);
	String P2=ContactSupport_EntitlementPage.EntitlementPageTitle();
	Assert.assertEquals(P2, "HP Customer Support - Verify entitlement");
}
@Test(priority=10)
public void TC_EP_PNTest() throws InterruptedException {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind("H6N52AA");
	ContactSupport_IdentifyProduct.ClickFind();
	Thread.sleep(5000);
	String P2=ContactSupport_EntitlementPage.EntitlementPageTitle();
	Assert.assertEquals(P2, "HP Customer Support - Verify entitlement");
}


@Test(priority=11,dataProvider="getTestdata")
	public void TC_PN_SNTest(String ProductNo) {
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
	public void TC_SNTest(String SerialNo) {
	ContactSupport_IdentifyLanding.ClickOnGuest();
	ContactSupport_IdentifyProduct.EnterProductPfind(SerialNo);
	ContactSupport_IdentifyProduct.ClickFind();
	String T1= ContactSupport_EntitlementPage.GetTitle4Product();
	Assert.assertEquals(T1, "");
	//Assert.assertTrue(T1);
	System.out.println(T1);
	boolean B3=ContactSupport_EntitlementPage.SrnoDs();
	Assert.assertFalse(B3);
}

@AfterMethod
public void AllWebclose() {
	driver.quit();
}



	
	
	
}



