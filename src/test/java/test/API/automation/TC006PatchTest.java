package test.API.automation;

import org.testng.annotations.Test;

import com.KrishnaComp.app.GetSetFunction;
import com.jayway.restassured.http.ContentType;

import static com.jayway.restassured.RestAssured.*;

public class TC006PatchTest {
  @Test
  public void fn() {
	  GetSetFunction comp = new GetSetFunction();
	  comp.setAuthor("ABC");
	  given()
	  .contentType(ContentType.JSON)
	  .body(comp)
	  .when()
	  .patch("http://localhost:3000/posts/2")
	  .then()
	  .contentType(ContentType.JSON)
	  .statusCode(200);
  }
}
