package com.hpi.test.ParentBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;	
	public static void initialization(){
		System.setProperty("webdriver.chrome.driver", "./Browser-servers/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ckumarsingh\\Downloads\\chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://uat.support.hp.com/us-en/contact-hp");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		//WebElement html = driver.findElement(By.tagName("html"));
		//html.sendKeys(Keys.chord(Keys.COMMAND, Keys.SUBTRACT));
	}
	public void scrollIntoView(WebElement element) {
        waitForElement(element);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].scrollIntoView(true);", element);
        executor.executeScript("window.scrollBy(0, -100);");
    } 
	
	public WebElement waitForElement(Object object){
		return waitForElement(object);

}
	
}