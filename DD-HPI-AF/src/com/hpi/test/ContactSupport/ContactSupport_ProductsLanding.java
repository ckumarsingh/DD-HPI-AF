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
@FindBy (xpath="(//button[@type='submit'][@id='btnSplitSearchSubmit'])[2]")
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
WebElement GetKeyBoardlabel;
@FindBy (xpath="//h4[@class='col-lg-24 carouselHeading']")
WebElement GetCarouselHeadOthers;
@FindBy (xpath="//h4[@class='col-lg-21 swdPfinderTitle swdPfinderTitle-with-DMD']")
WebElement GetSPPTag;
@FindBy (xpath="//div[@class='contactPfinderTitle']")
WebElement GetAppTag;
@FindBy (id="btnTMSDDSubmit")
WebElement GetOtherSubmitBtn;
@FindBy(id="laptop-prod-info-modal-main-heading")
WebElement GetPrdtLptopHeading;
@FindBy(xpath="(//button[@aria-label='Close'][@data-dismiss='modal'][@class='close icon'])[3]")
WebElement GetCloseModal;
@FindBy(id="printer-prod-info-modal-main-heading")
WebElement GetPrdtPrinterHeading;

//Actions

public boolean VerfyDMDdsplyd () {
	return GetDMDButton.isDisplayed();
}
public boolean VerfyDMDEnbld () {
	return GetDMDButton.isEnabled();
}
public boolean VerfyFindOutMoreLinkdsplyd () {
	return GetFindoutMoreLink.isDisplayed();
}
public void ClickFindlink () {
	GetFindoutMoreLink.click();
}
public boolean VerfySNTag () {
	return GetSNTag.isDisplayed();
}
public boolean VerfySNBox () {
	return GetSNBox.isDisplayed();
}
public String ValidateSDPageURL() {
	return GetFindoutMoreLink.getAttribute("href");
}
public boolean VerfySbmtBtnDspld () {
	return GetSubmitBtn.isDisplayed();
}
public boolean VerfySbmtBtnEnbld1 () {
	return GetSubmitBtn.isEnabled();
}
public boolean VerfySbmtBtnEnbld2 () {
	GetSNBox.sendKeys("1");
	return GetSubmitBtn.isEnabled();
}
public boolean VerfySbmtBtnEnbld3 () {
	GetSNBox.clear();
	return GetSubmitBtn.isEnabled();
}
public void ClickKeyBoard () {
	GetKeyBoardlabel.click();
}
public String VerifyKeyboardDsplyd () {
	String S1=GetKeyBoardlabel.getText();
	return S1;
}
public String VerfyProductLabel () {
	String S2=GetLabelProductInfo.getText();
	return S2;
}
public void ClickProductLabel () {
	GetLabelProductInfo.click();
}
public String VrfyLcatePrdtTitle () {
	String S1=GetPrdtPrinterHeading.getText();
	return S1;
}
public void ClickCancelProductlabel () {
	GetCloseModal.click();
}
public void ClickSubmtBtn() {
	GetSubmitBtn.click();
}
public void EnterSNNo_Data(String SerialNo) {
	GetSNBox.sendKeys(SerialNo);
}
public String VerifyProdctTitle () {
	String S1= GetProductTitle.getText();
	return S1;
}
public void EnterPNNo_Data(String ProductNo) {
	GetSNBox.sendKeys(ProductNo);
}
}
