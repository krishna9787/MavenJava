package test.API.automation;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class TC001GetMethodTest {
	
  @Test
  public void tc_001_getMethod_validation() {
	  Response response = get("http://www.omdbapi.com/?t=Spiderman&y=&plot=short&r=json");
	  System.out.println("Response received: "+ response.getContentType());
	  System.out.println("Response Body: "+ response.getBody().asString());
	  System.out.println("Response Header: "+ response.getHeader("headerName"));
	  if (response.getContentType().contains("json")) System.out.println("Success");
	  else System.out.println("Failure");
	  
  }
}
