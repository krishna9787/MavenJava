package test.API.automation;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.KrishnaComp.app.GetSetFunction;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Validatable;
import com.jayway.restassured.response.ValidatableResponse;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import static com.jayway.restassured.RestAssured.*;
public class TC009E2EAutomationTest {
	@Test
	public void testCase009() {
		ExtentReports extentReport = new ExtentReports("./Report/report.html",true);
		extentReport.addSystemInfo("Author Name", "Testing World");
		ExtentTest extentTest = extentReport.startTest("TC009E2EAutomationTest");
		extentTest.log(LogStatus.PASS, "TC Started");
		GetSetFunction inst = new GetSetFunction();
		inst.setId(15);
		inst.setAuthor("Enid Blyton");
		inst.setTitle("Famous Five");
		
		ValidatableResponse response = given()
		.contentType(ContentType.JSON)
		.body(inst)
		.when()
		.post("http://localhost:3000/posts/")
		.then()
		.contentType(ContentType.JSON);
		
		int respID = response.extract().path("id");
		int respCode = response.extract().response().getStatusCode();
		Assert.assertEquals(respCode, 201);
		
		ValidatableResponse response1 = when()
		.get("http://localhost:3000/posts/"+respID)
		.then()
		.contentType(ContentType.JSON);
		
		System.out.println(response1.extract().path("Author"));
		System.out.println(response1.extract().path("Title"));
		
		GetSetFunction inst1 = new GetSetFunction();
		inst1.setId(respID);
		inst1.setTitle("Spiderman");
		inst1.setAuthor("XYZ");
		
		ValidatableResponse response2 = given()
				.contentType(ContentType.JSON)
				.body(inst1)
				.when()
				.put("http://localhost:3000/posts/"+respID)
				.then()
				.contentType(ContentType.JSON);
		
			System.out.println(response2.extract().asString());	
		
			when()
			.delete("http://localhost:3000/posts/"+respID)
			.then()
			.contentType(ContentType.JSON);
			
			extentReport.endTest(extentTest);
			
	}
}

