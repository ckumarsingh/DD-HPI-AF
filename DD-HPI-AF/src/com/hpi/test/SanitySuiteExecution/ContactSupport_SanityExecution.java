package com.hpi.test.SanitySuiteExecution;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.hpi.test.ContactSupport.ContactSupport_IdentifyLanding;
import com.hpi.test.ParentBase.TestBase;
import com.hpi.test.ContactSupport.ContactSupport_IdentifyProduct;
public class ContactSupport_SanityExecution extends TestBase {
	
	ContactSupport_IdentifyLanding ContactSupport_IdentifyLanding;
	ContactSupport_IdentifyProduct ContactSupport_IdentifyProduct;
	public ContactSupport_SanityExecution() {
		super();
	}
@BeforeMethod
public void setup() {
	initialization();
	ContactSupport_IdentifyLanding = new ContactSupport_IdentifyLanding();
	ContactSupport_IdentifyProduct = new ContactSupport_IdentifyProduct();
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
	Assert.assertEquals(SDLink1, "https://uat.support.hp.com/in-en/document/c05061199");
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


@AfterMethod
public void AllWebclose() {
	driver.quit();
}
}

