package test.API.automation;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.ValidatableResponse;

import static com.jayway.restassured.RestAssured.*;
public class TC010PostForXML {
	@Test
	public void testCase010() {
		ValidatableResponse response = given()
		.contentType(ContentType.XML)
		.when()
		.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/2")
		.then()
		.contentType(ContentType.XML);
		
		System.out.println(response.extract().asString());
		System.out.println(response.extract().xmlPath().getString("Customer.CITY"));
		System.out.println(response.extract().xmlPath().getString("Customr.STREET"));
	}
}
