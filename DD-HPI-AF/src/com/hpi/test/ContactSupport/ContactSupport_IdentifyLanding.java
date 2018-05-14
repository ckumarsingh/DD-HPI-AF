package com.hpi.test.ContactSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hpi.test.ParentBase.TestBase;

public class ContactSupport_IdentifyLanding extends TestBase {
		public ContactSupport_IdentifyLanding () {
			PageFactory.initElements(driver, this);
				}
//Page factory---WebElements
@FindBy(id="continueAsGuest")
WebElement GetContinueAsGuest;
@FindBy(xpath="//input[@value='Sign in']")
WebElement GetSignIn;

//Actions
public boolean VerifyGuestBtnDsplyd() {
	return GetContinueAsGuest.isDisplayed();
}
public boolean VerifySignInBtnDsplyd() {
	return GetSignIn.isDisplayed();
}
public void ClickOnGuest() {
	GetContinueAsGuest.click();
}
}