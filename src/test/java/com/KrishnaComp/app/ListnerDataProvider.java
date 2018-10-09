package com.KrishnaComp.app;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import org.openqa.selenium.TakesScreenshot;

import ExtentReports.ExtentManager;
import ExtentReports.ExtentTestManager;

public class ListnerDataProvider extends DriverInitializationChrome implements ITestListener{

	public void onFinish(ITestContext iTestContext) {
		ExtentTestManager.endTest();
		ExtentManager.getReporter().flush();
		
	}

	public void onStart(ITestContext iTestContext) {
		iTestContext.setAttribute("WebDriver", this.driver);
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		
		}

	public void onTestFailure(ITestResult iTestResult) {
		Object testClass = iTestResult.getInstance();
		WebDriver driver = ((DriverInitializationChrome)testClass).getDriver();
		
		String screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		ExtentTestManager.getTest().log(LogStatus.FAIL,"Test Failed");
		ExtentTestManager.getTest().addBase64ScreenShot(screenshot);
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		ExtentTestManager.getTest().log(LogStatus.SKIP,"Test Skipped");
	}

	public void onTestStart(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(), "");
	}

	public void onTestSuccess(ITestResult iTestResult) {
		// TODO Auto-generated method stub
		ExtentTestManager.getTest().log(LogStatus.PASS, "Test Passed");
		Object testClass = iTestResult.getInstance();
		WebDriver driver = ((DriverInitializationChrome)testClass).getDriver();
		
		String screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		ExtentTestManager.getTest().log(LogStatus.PASS,"Test Passed");
		ExtentTestManager.getTest().addBase64ScreenShot(screenshot);
	}
	
}
