package test.API.automation;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.*;

public class TC007DeleteTest {
  @Test
  public void TC007DelTest() {
	  given()
	  .contentType(ContentType.JSON)
	  .when()
	  .delete("http://localhost:3000/posts/3")
	  .then()
	  .statusCode(200);
  }
}
