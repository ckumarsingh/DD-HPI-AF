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
	WebElement GetPfinderSB;
@FindBy(xpath="(//button[@id='btnSplitSearchSubmit'])[2]")
	WebElement GetPfindBtn;
@FindBy(id="tooltipPadPfinder")
	WebElement GetTooltipPfinder;
@FindBy(xpath="//h3[@id='serial-number-modal-main-heading']")
	WebElement GetPfindrTPTitle;
@FindBy(xpath="//img[contains(@alt,'Product Number')]")
	WebElement GetImageProNo;


//Actions
public String ValidatePageTitle() {
	String ActualTitle=GetPageTitle.getText();
	return ActualTitle;
}
public void ClickWikiHowLink() {
	//scrollIntoView(waitForElement(GetProductWikiDoc.click()));
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
	boolean PFDs=GetPfinderSB.isEnabled();
	return PFDs;
}
public boolean ValidatePfindBtnEn() {
	boolean PfindFlag=GetPfindBtn.isEnabled();
	return PfindFlag;
}
public void EnterProductPfind(String Prdtdtls) {
	GetPfinderSB.sendKeys(Prdtdtls);
}
public void ClickTPPfinder() {
	GetTooltipPfinder.click();
}
public String PfinderTPT ( ) {
	String TT=GetPfindrTPTitle.getText();
	return TT;
}
public boolean ImageDs() { 
	Boolean Image1 =GetImageProNo.isDisplayed();
	return Image1;
}
public void ClickFind()  {
	GetPfindBtn.click();
}


}

