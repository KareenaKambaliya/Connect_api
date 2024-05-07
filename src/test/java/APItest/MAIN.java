package APItest;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class MAIN {

        @BeforeClass
        public void setup() {
            // Set the base URI for all requests
            RestAssured.baseURI = "https://connectdev.pluto-men.com";
        }

    @Test
    public void testGetRequest() {
        given()
                .when()
                .get("/login")
                .then()
                .statusCode(200)
                .body(containsString("Login"));
    }


    @Test
    public void testPostRequest() {

        given()
                .body("{ \"key\": \"value\" }")
                .when()
                .post("/endpoint")
                .then()
                .statusCode(201);
    }

}
