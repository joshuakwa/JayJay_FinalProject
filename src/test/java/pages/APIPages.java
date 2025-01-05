package pages;

import Base.*;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.UUID;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;


public class APIPages extends models {
    private static RequestSpecification request;
    private static Response res;
    String setURL;

    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 38cebe5affdc6038017ae850b112f50d15613c3f40d9d2a5d7bfd75f6218fcc2");
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
        String name = "joshuasda";
        String email = "user" + UUID.randomUUID() + "@example.com";
        String gender = "male";
        String status = "active";

        JSONObject bodyObj = new JSONObject();

        bodyObj.put("name", name);
        bodyObj.put("email", email);
        bodyObj.put("gender", gender);
        bodyObj.put("status", status);

        setupHeaders();
        res = request.body(bodyObj.toString()).when().post(setURL);
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

    public void assertStatusCode(int statusCode) {
        assertThat(res.statusCode()).isEqualTo(statusCode);
    }
}
