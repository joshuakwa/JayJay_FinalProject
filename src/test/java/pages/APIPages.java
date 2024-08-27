package pages;

import Base.*;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.UUID;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;


public class APIPages extends models {

    private static Response res;
    String setURL;

    public static void assertStatusCode(int statusCode) {
        res.then().statusCode(statusCode);
    }

    public String prepareUrl() {
        setURL = endpoint.USER_GOREST;

        return setURL;
    }

    @Test
    public void getUsers() {
        setupHeaders();
        given().when().get(setURL)
                .then()
                .log().all();
    }

    @Test
    public void getUserDetail(int id) {
        setupHeaders();
        given().log().all()
                .get(setURL + id)
                .then()
                .assertThat().statusCode(200)
                .assertThat().body("id", equalTo(id));
    }

    @Test
    public void createNewUser() {
        String randomEmail = "user" + UUID.randomUUID() + "@example.com";
        String randomName = "name" + UUID.randomUUID().toString().substring(0, 5);
        String name = "joshuasda";
        String email = "josadhjuiaos@jaoisd.asdoij";

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("name", name);
        bodyObj.put("email", email);
        bodyObj.put("gender", "male");
        bodyObj.put("status", "active");

        setupHeaders();
        given().log().all()
                .body(bodyObj.toString())
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .assertThat().statusCode(201)
                .assertThat().body("name", equalTo(name))
                .assertThat().body("email", equalTo(email))
                .assertThat().body("status", equalTo("active"))
                .assertThat().body("gender", equalTo("male"));
    }

    @Test
    public void createNewUserWithBlankName() {
        String name = "";
        String email = "josadhjuiaos@jaoisd.asadoij";

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("name", name);
        bodyObj.put("email", email);
        bodyObj.put("gender", "male");
        bodyObj.put("status", "active");

        setupHeaders();
        given().log().all()
                .body(bodyObj.toString())
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .assertThat().statusCode(422);
    }
}
