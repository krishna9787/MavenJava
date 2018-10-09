package test.API.automation;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class PostMtdWthRtn {
  @Test
  public void fn() {
	  
	  Response response = given()
			  .contentType(ContentType.JSON)
			  .body("{\"id\":2,\"title\":\"Spidernam\",\"author\":\"XYZ\"}")
			  .when()
			  .post("http://localhost:3000/posts");
	  
	  System.out.println("Response received: "+response);
  }
}
