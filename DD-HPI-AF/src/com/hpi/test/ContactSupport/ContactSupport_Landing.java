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
@FindBy(id="hpProductContextPageTitle")
WebElement GetPageTitleH1;
@FindBy(xpath="//*[@id=\"masterDiv\"]/div/h2")
WebElement GetHelpProductTitleH2;
@FindBy(id="productImgDisabledprinter")
WebElement GetPrinterIcon;
@FindBy(id="productImgDisabledlaptop")
WebElement GetLaptopIcon;
@FindBy(id="productImgDisableddesktop")
WebElement GetDesktopIcon;
@FindBy(id="productImgDisabledother")
WebElement GetOtherIcon;
//Actions//


public String ValidatePageTitleH1() {
	String PageTitleH1=GetPageTitleH1.getText();
	return PageTitleH1;
}
public String ValidateHelpProductTitleH2() {
	String HelpProductTitleH2=GetHelpProductTitleH2.getText();
	return HelpProductTitleH2;
}
public boolean VerifySignBtnDsplyd() {
	return GetSignIn.isDisplayed();
}
public boolean VerifyPrinterBtnDsplyd() {
	return GetPrinterIcon.isDisplayed();
}
public void ClickPrinterIcon() {
	GetPrinterIcon.click();
}
public boolean VerifyLaptopBtnDsplyd() {
	return GetLaptopIcon.isDisplayed();
}
public void ClickLaptopIcon() {
	GetLaptopIcon.click();
}
public boolean VerifyDesktopBtnDsplyd() {
	return GetDesktopIcon.isDisplayed();
}
public void ClickDesktopIcon() {
	GetDesktopIcon.click();
}
public boolean VerifyOtherBtnDsplyd() {
	return GetOtherIcon.isDisplayed();
}
public void ClicOtherIcon() {
	GetOtherIcon.click();
}
}