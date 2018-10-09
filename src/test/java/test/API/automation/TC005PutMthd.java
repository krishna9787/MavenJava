package test.API.automation;

import org.testng.annotations.Test;

import com.KrishnaComp.app.GetSetFunction;
import com.jayway.restassured.http.ContentType;

import static com.jayway.restassured.RestAssured.*;

public class TC005PutMthd {
  @Test
  public void f() {
	  GetSetFunction fn = new GetSetFunction();
	  fn.setId(1);
	  fn.setAuthor("STU");
	  fn.setTitle("Shaktimaan");
	  given()
	  .contentType(ContentType.JSON)
	  .body(fn)
	  .when()
	  .put("http://localhost:3000/posts/1")
	  .then()
	  .statusCode(200);
  }
}
