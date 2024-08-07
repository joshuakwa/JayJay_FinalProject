package pages;

import Base.baseTest;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.UUID;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;


public class APIPages extends baseTest {

    private static Response res;

    public static void assertStatusCode(int statusCode) {
        res.then().statusCode(statusCode);
    }

    @Test
    public void getUsers() {
        given().log().all()
                .get("/users")
                .then()
                .assertThat().statusCode(200);
    }

    @Test
    public void getUserDetail() {
        given().log().all()
                .get("/users/6940578")
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("id", equalTo(6940578))
                .assertThat().body("name", equalTo("Buddhana Bharadwaj IV"))
                .assertThat().body("email", equalTo("bharadwaj_buddhana_iv@kirlin.example"))
                .assertThat().body("gender", equalTo("female"));
    }

    @Test
    public void createNewUser() {
        String randomEmail = "user" + UUID.randomUUID().toString() + "@example.com";
        String randomName = "name" + UUID.randomUUID().toString().substring(0, 5);

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("name", randomName);
        bodyObj.put("email", randomEmail);
        bodyObj.put("gender", "male");
        bodyObj.put("status", "active");

        given().log().all()
                .body(bodyObj.toString())
                .post("/users")
                .then()
                .assertThat().statusCode(201)
                .assertThat().body("name", equalTo(randomName))
                .assertThat().body("email", equalTo(randomEmail))
                .assertThat().body("status", equalTo("active"))
                .assertThat().body("gender", equalTo("male"));
    }
}
