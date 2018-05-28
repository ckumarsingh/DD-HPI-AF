package com.hpi.test.ContactSupport;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hpi.test.ParentBase.TestBase;

public class ContactSupport_EntitlementPage extends TestBase {
	public ContactSupport_EntitlementPage( ) {
		PageFactory.initElements(driver, this);
	}
@FindBy(id="hpProductContextPageTitle")	
	WebElement GetEntitlementPageTitle;
@FindBy(id="entitlementHeadingForSerial")
	WebElement GetTitle4ProdctNo;
@FindBy(id="entitlementHeadingForProduct")
	WebElement GetTitle4Serial;
@FindBy(id="wFormSerialNumber")
	WebElement GetSerialNo;
@FindBy(id="wFormProductLocation_dd_headerValue")
	WebElement GetLocation;
@FindBy(id="wFormLanguage_dd_headerValue")
	WebElement GetlanguageSupport;
@FindBy(id="btnWShowOptions")
	WebElement GetShowOptions;


public String EntitlementPageTitle() {
	String P1=GetEntitlementPageTitle.getText();
	return P1;
}
public String GetSerialTitle() {
	String T1=GetTitle4ProdctNo.getAttribute("textContent");
	return T1;
}
public String GetTitle4Product() {
	String T2=GetTitle4Serial.getText();
	return T2;
}
public boolean SrnoDs() {
	boolean B1=GetSerialNo.isDisplayed();
	return B1;
}
}
