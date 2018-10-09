package test.API.automation;

import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;

import com.KrishnaComp.app.GetSetFunction;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;




public class TC003PostMethodTest {
  @Test
  public void f() {
	  given()
		.contentType(ContentType.JSON)
		.body("{\"id\":2,\"title\":\"Spiderman\",\"author\":\"XYZ\"}")
		.when()
		.post("http://localhost:3000/posts")
		.then()
		.statusCode(201);
  }
}
