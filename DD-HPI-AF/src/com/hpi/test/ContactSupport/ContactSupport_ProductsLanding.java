package com.hpi.test.ContactSupport;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hpi.test.ParentBase.TestBase;

public class ContactSupport_ProductsLanding extends TestBase {
	public ContactSupport_ProductsLanding( ) {
		PageFactory.initElements(driver, this);
	}
	
//PageFactory--WebElements
	
@FindBy(id="productImgEnabledlaptop")	
WebElement GetLaptopIcon;
@FindBy(id="productImgEnableddesktop")
WebElement GetDesktopIcon;
@FindBy(id="productImgEnabledprinter")
WebElement GetPrintersIcon;
@FindBy(id="productImgEnabledother")
WebElement GetOthersIcon;
@FindBy(id="detect-now-SWD")
WebElement GetDMDButton;
@FindBy(tagName="h2")
WebElement GetProductTitle;
@FindBy(id="find-out-more-swd")
WebElement GetFindoutMoreLink;
@FindBy (xpath="//h4[@class='col-lg-21 swdPfinderTitle swdPfinderTitle-with-DMD']")
WebElement GetSNTag;
@FindBy (id="search-input-pfinder")
WebElement GetSNBox;
@FindBy (id="btnSplitSearchSubmit")
WebElement GetSubmitBtn;
@FindBy (xpath="//h4[@class='col-lg-24 carouselHeading']")
WebElement GetCarouselHead;
@FindBy (id="contact_tooltip_labelinfo")
WebElement GetLabelProductInfo;
@FindBy (id="tooltip_video_printer")
WebElement GetVideoLinkPrinter;
@FindBy (id="tooltip_video_laptop")
WebElement GetVideoLinkLaptop;
@FindBy (id="tooltip_video_desktop")
WebElement GetVideoLinkDesktop;
@FindBy (id="tooltip_video_others")
WebElement GetVideoOthers;
@FindBy (id="contact_tooltip_keyboard_desktop")
WebElement GetKeyBoardlablel;
@FindBy (xpath="//h4[@class='col-lg-24 carouselHeading']")
WebElement GetCarouselHeadOthers;

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

