package com.KrishnaComp.app;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DriverInitializationChrome {
 
	public WebDriver driver;
	
  @BeforeTest
  public void BaseTest() {
	  
	 
	  driver = new ChromeDriver();
	  driver.get("https://book.spicejet.com/");
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
public synchronized WebDriver getDriver() {
	return this.driver = driver;
}
}
