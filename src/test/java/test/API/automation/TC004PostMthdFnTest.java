package test.API.automation;
import org.testng.annotations.Test;

import com.KrishnaComp.app.GetSetFunction;
import com.jayway.restassured.http.ContentType;

import static com.jayway.restassured.RestAssured.*;

public class TC004PostMthdFnTest {
	@Test
	public void PostMthd() {
		GetSetFunction fn = new GetSetFunction();
		  fn.setId(5);
		  fn.setAuthor("DEF");
		  fn.setTitle("Batman");
		  given()
		  .contentType(ContentType.JSON)
		  .body(fn)
		  .when()
		  .post("http://localhost:3000/posts")
		  .then()
		  .statusCode(201);  
	}
}
