package com.hpi.test.ContactSupport;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hpi.test.ParentBase.TestBase;

public class ContactSupport_IdentifyProduct extends TestBase {
	public ContactSupport_IdentifyProduct() {
		PageFactory.initElements(driver, this);
	}
//PageFactory--WebElements
@FindBy(xpath="//h2[text()='Contact Support - Start by identifying your products']")
	WebElement GetPageTitle;
@FindBy(id="detectNow")
	WebElement GetIdentifyNow;
@FindBy(linkText="How does HP use product data collected with this service?")
	WebElement GetProductWikiDoc;
@FindBy(xpath="//input[@id='search-input-pfinder']")
	WebElement PfinderSB;
//Actions
public String ValidatePageTitle() {
	String ActualTitle=GetPageTitle.getText();
	return ActualTitle;
}
public void ClickWikiHowLink() {
	GetProductWikiDoc.click();
}
public boolean ValidateIdntfyNowBtnEn() {
	boolean IDnEn= GetIdentifyNow.isEnabled();
	return IDnEn;
}
public boolean ValidateIdntfyNowBtnDs() {
	boolean IDnDs= GetIdentifyNow.isDisplayed();
	return IDnDs;
}
public String ValidateSDPageURL() {
	String SDLink=GetProductWikiDoc.getAttribute("href");
	return SDLink;
}
public boolean PfinderSBDs() {
	boolean PFDs=PfinderSB.isEnabled();
	return PFDs;
}

}

