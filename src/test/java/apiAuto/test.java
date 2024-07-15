package apiAuto;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import org.json.JSONObject;
import java.io.File;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.head;


public class test {
    @Test
    public void getUserTest() {
//      atau bisa menggunakan ini RestAssured.given().when().get("https://reqres.in/").then().log().all()
        RestAssured.baseURI = "https://reqres.in/";
        given().when().get("api/users?page=1")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("page", Matchers.equalTo(1))
                .assertThat().body("data.id", Matchers.hasSize(6));
    }
    @Test
    public void createNewUserTest(){
        RestAssured.baseURI = "https://reqres.in/";
        String name = "Joshua";
        String job = "Student";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("job", job);

//        atau bisa gunakan RestAssured.given().header().header().body().when().post().then().log().all()
        given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(jsonObject.toString())
                .post("api/users")
                .then()
                .assertThat().statusCode(201)
                .assertThat().body("name", Matchers.equalTo(name))
                .assertThat().body("job", Matchers.equalTo(job))
                .assertThat().body("$", Matchers.hasKey("id"))
                .assertThat().body("$", Matchers.hasKey("createdAt"));
    }

    @Test
    public void testUpdateUser(){
        String name = "Update nama";
        String job = "update job";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);
        jsonObject.put("job", job);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(jsonObject.toString())
                .put("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name", Matchers.equalTo(name))
                .assertThat().body("job", Matchers.equalTo(job));
    }

    @Test
    public void testPatchUser(){
        String name = "Update nama terakhir";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", name);

        RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(jsonObject.toString())
                .patch("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .assertThat().statusCode(200)
                .assertThat().body("name", Matchers.equalTo(name));
    }


    @Test
    public void testDeleteUser(){
        RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .delete("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .assertThat().statusCode(204);
    }


    @Test
    public void testRegisterUser_negative(){
        RestAssured.baseURI = "https://reqres.in";
//        login dengan email yang tidak terdaftar
        String email = "joshua@asd.com";
        String password = "asdasdasd";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", email);
        jsonObject.put("password", password);

        given().log().all()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .body(jsonObject.toString())
                .post("/api/login")
                .then()
                .assertThat().statusCode(400);
    }
}
