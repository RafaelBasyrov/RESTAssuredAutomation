package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class TestsOnClassAPI {

    @Test
    public void get() {

        baseURI = "http://localhost:3000";

        given()
                .get("/posts")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void post() {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", 123555);
        jsonObject.put("title","asd");
        jsonObject.put("author","asd");

        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                .post("/posts")
                .then()
                .statusCode(201);


    }

    @Test
    public void put() {

        JSONObject jsonObject = new JSONObject();

        jsonObject.put("id", 2);
        jsonObject.put("title","rafael");
        jsonObject.put("author","ildarovich");

        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                .put("/posts/3")
                .then()
                .statusCode(200);
    }

    @Test
    public void patch() {

        JSONObject jsonObject = new JSONObject();


        jsonObject.put("title", "ARARAR");


        baseURI = "http://localhost:3000";

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(jsonObject.toJSONString())
                .when()
                .patch("/posts/3")
                .then()
                .statusCode(200);
    }

    @Test
    public void delete(){
        baseURI = "http://localhost:3000";
        when().delete("/posts/3").then().statusCode(200);
    }
}