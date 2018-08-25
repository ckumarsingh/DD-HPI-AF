package com.hpi.test.ContactSupport;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hpi.test.ParentBase.TestBase;

public class ContactSupport_SupportOptions extends TestBase {
	public ContactSupport_SupportOptions() {
		PageFactory.initElements(driver, this);
	}
//PageFactory--WebElements
@FindBy(xpath="//h1[text()='How can we help you?']")
WebElement GetSupportHelpTitle;	
@FindBy(xpath="//img[contains(@alt,'product information')]")
WebElement GetProductImage;	
@FindBy(id="prodInfoTitle")
WebElement GetProductInfoTitle;	
@FindBy(id="changeProductTrigger")
WebElement GetChangeProductLink;	
@FindBy(id="status-key")
WebElement GetWarrantyStatusText;	
@FindBy(id="warrantyTypeModal")
WebElement GetTooltipIcon;	
@FindBy(id="lnkOWResult")
WebElement GetSeeDetailsLink;	
@FindBy(xpath="//span[text()='Serial number:']")
WebElement GetSerialNumText;	
@FindBy(id="piSerialNum")
WebElement GetSerialNum;	
@FindBy(xpath="//span[text()='Product number:']")
WebElement GetProductNumText;	
@FindBy(id="piProdNum")
WebElement GetProdNum;	
@FindBy(xpath="//img[@class='addIcon']")
WebElement GetAddIcon;	
@FindBy(xpath="//img[@class='addBtnTxt']")
WebElement GetAddProdText;
	
//Actions
public String VerifySupportHelpTitle() {
	  return GetSupportHelpTitle.getText();
	}
public boolean VerifyProductImage() {
	  return GetProductImage.isDisplayed();
	}
public String VerifyProductInfoTitle() {
	  return GetProductInfoTitle.getText();
	}
public boolean VerifyChangeProductLink() {
	  return GetChangeProductLink.isDisplayed();
	}
public boolean VerifyWarrantyStatusText() {
	  return GetWarrantyStatusText.isDisplayed();
	}
public boolean VerifyTooltipIcon() {
	  return GetTooltipIcon.isDisplayed();
	}
public boolean VerifySeeDetailsLink() {
	  return GetSeeDetailsLink.isDisplayed();
	}
public boolean VerifySerialNumText() {
	  return GetSerialNumText.isDisplayed();
	}
public boolean VerifyProductNumText() {
	  return GetProductNumText.isDisplayed();
	}
public String VerifyProdNum() {
	  return GetProdNum.getText();
	}
public String VerifySerialNum() {
	  return GetSerialNum.getText();
	}
public boolean VerifyAddIcon() {
	  return GetAddIcon.isDisplayed();
	}
public boolean VerifyAddProdText() {
	  return GetAddProdText.isDisplayed();
	}

}
