package com.hpi.test.ContactSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hpi.test.ParentBase.TestBase;

public class ContactSupport_EntitlementPage extends TestBase {
	public ContactSupport_EntitlementPage() {
		PageFactory.initElements(driver, this);
	}


//PageFactory--WebElements
@FindBy(id="hpProductContextPageTitle")
WebElement GetEntitlementTitle;
@FindBy(xpath="//*[@id='wFormSerialNumber']")
WebElement GetESNBOX;
@FindBy(xpath="//*[@id='btnWShowOptions']")
WebElement GetSubtmBtn;

public String VrfyEntitlementTitle() {
	return GetEntitlementTitle.getText();
}
public void EntrSNEntitlement (String SerialNo) {
	GetESNBOX.sendKeys(SerialNo);
}
public void ClickSbtn() {
	GetSubtmBtn.click();
}
}