package Base;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.cucumber.java.*;

public class models {
    //    @Before("@api")
    private static RequestSpecification request;
    public static void setupHeaders() {
         request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer fc4dbd86085d7695b329e7227885ac295f3295987db617a14aad7403be6b073b");
    }
}
