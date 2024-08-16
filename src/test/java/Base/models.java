package Base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.cucumber.java.*;

public class models {
    private static RequestSpecification request;
//    @Before("@api")
    public static void setupHeaders() {
//        RestAssured.baseURI = "https://gorest.co.in/public/v2";

        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 8a80f0b0b8c1719f06e3e93c47729d6c3b1c64c99df0594a09653dc3ad55f9ab");

//        RestAssured.requestSpecification = requestSpec;
    }

    public static Response getListUsers(String endpoint){
        setupHeaders();
        return request.when().get(endpoint);
    }
}
