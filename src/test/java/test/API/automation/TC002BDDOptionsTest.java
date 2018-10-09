package test.API.automation;

import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;

public class TC002BDDOptionsTest {
  @Test
  public void f() {
	  given().params("t", "Spiderman","y","","plot","short","r","json");
	  when().get("http://www.omdbapi.com/")
	  .then().statusCode(200);
  }
}
