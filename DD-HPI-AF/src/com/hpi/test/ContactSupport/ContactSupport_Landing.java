package com.hpi.test.ContactSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hpi.test.ParentBase.TestBase;

public class ContactSupport_Landing extends TestBase {
		public ContactSupport_Landing () {
			PageFactory.initElements(driver, this);
				}
//Page factory---WebElements

@FindBy(id="contactSignIn")
WebElement GetSignIn;
@FindBy(id="productImgDisabledprinter")
WebElement GetPrinterIcon;

//Actions//

public boolean VerifySignBtnDsplyd() {
	return GetSignIn.isDisplayed();
}
public boolean VerifyPrinterBtnDsplyd() {
	return GetPrinterIcon.isDisplayed();
}
public void ClickPrinterIcon() {
	GetPrinterIcon.click();
}
}