package ExtentReports;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class ExtentManager {
  private static ExtentReports extent;
  
  @BeforeTest
  public synchronized static ExtentReports getReporter() {
	  if (extent==null) {
		  extent = new ExtentReports("./Report/report.html",true);
	  }
	return extent;  
  }

}
