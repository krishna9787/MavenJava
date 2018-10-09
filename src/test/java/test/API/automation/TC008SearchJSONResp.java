package test.API.automation;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;

import static com.jayway.restassured.RestAssured.*;

public class TC008SearchJSONResp {
  @Test
  public void SearchJSONResp() {
	  ValidatableResponse response = when()
	  .get("http://localhost:3000/posts/1")
	  .then()
	  .contentType(ContentType.JSON);
	  
	  System.out.println(response.extract().asString());
	  String actualTitle = response.extract().path("author");
	  System.out.println(actualTitle);

  }
}
