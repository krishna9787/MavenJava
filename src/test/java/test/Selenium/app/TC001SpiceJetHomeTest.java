package test.Selenium.app;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.KrishnaComp.app.DriverInitializationChrome;
import com.KrishnaComp.app.ListnerDataProvider;

import ExtentReports.ExtentTestManager;

@Listeners(ListnerDataProvider.class)
public class TC001SpiceJetHomeTest extends DriverInitializationChrome{
	@Test
	public void TC001SpiceJet() {
		ExtentTestManager.getTest().setDescription("Open SpiceJet HomePage");
		System.out.println("Hello");
	}
}
