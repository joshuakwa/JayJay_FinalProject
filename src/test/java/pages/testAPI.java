package pages;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class testAPI {

    @Test
    public void getUserTest() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2/";
        given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer fc4dbd86085d7695b329e7227885ac295f3295987db617a14aad7403be6b073b")
                .get("users")
                .then()
                .assertThat().statusCode(200);
    }
}
