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
@FindBy(id="wFormSerialNumber")
	WebElement GetSerialEditBox;
@FindBy(id="status-key")
	WebElement GetwarrantyTag;
@FindBy(xpath="//span[@class='key serialProdNumBld'][text()='Serial number:']")
	WebElement GetSerialNoTag;
@FindBy(xpath="//span[@class='key serialProdNumBld'][text()='Product number:']")
	WebElement GetProductNoTag;
@FindBy(id="btnWShowOptions")
	WebElement GetShowButton;
@FindBy(id="getPhoneSupport")
	WebElement GetPhoneSupport;
@FindBy(id="getEmailForm")
	WebElement GetEmailForm;
@FindBy(id="Forum")
	WebElement GetForum;
@FindBy(id="ServiceCenter")
	WebElement GetServiceCenter;



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
public boolean WarrantyTagDs( ) {
	boolean W1=GetwarrantyTag.isDisplayed();
	return W1;
}
public boolean SerialTagDs() {
	boolean S1=GetSerialNoTag.isDisplayed();
	return S1;
}
public boolean ProductTag() {
	boolean P1=GetProductNoTag.isDisplayed();
	return P1;
}
public boolean ShowbtnEnld() {
	boolean S3=GetShowButton.isEnabled();
	return S3;
}

public void ShowButtonClick() {
	GetShowButton.click();
}
public void EnterSrNo(String SN) {
	GetSerialNo.sendKeys(SN);
}
public boolean PhoneSupportBtnDs () {
	boolean PS1=GetPhoneSupport.isDisplayed();
	return PS1;
}
public boolean EmailFormBtnDs () {
	boolean EF1=GetEmailForm.isDisplayed();
	return EF1;
}
public boolean ForumBtnDs () {
	boolean F1=GetForum.isDisplayed();
	return F1;
}
public boolean ServiceCenterBtnDs () {
	boolean SC1=GetServiceCenter.isDisplayed();
	return SC1;
}

}

