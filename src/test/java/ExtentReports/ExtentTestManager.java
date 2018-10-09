package ExtentReports;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterTest;

public class ExtentTestManager {
	
	static ExtentReports extentReport = ExtentManager.getReporter();
	static ExtentTest test;
	public static Map extentMap = new HashMap();
	static Thread thread;

  public static synchronized ExtentTest getTest() {
	  long i = thread.currentThread().getId();
	  test = (ExtentTest)extentMap.get((int)i);
	  return test;
  }

  public static synchronized ExtentTest startTest(String testname, String desc) {
	  test = extentReport.startTest(testname, desc);
	  long i = thread.currentThread().getId();
	  extentMap.put((int)i,test);
	  return test;
  }
  
  @AfterTest
  public static synchronized void endTest() {
	  long i = thread.currentThread().getId();
	  extentReport.endTest((ExtentTest)extentMap.get((int)i));
  }

}
