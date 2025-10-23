package Assignment20;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BookstoreAPITests {

    private String token;
    private String userId;
    public final String BASE_URL = "https://bookstore.demoqa.com";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;

        // 1️⃣ توليد التوكن
        Map<String, String> loginBody = new HashMap<>();
        loginBody.put("userName", "latifahUser123"); // استبدل باليوزر الخاص بك
        loginBody.put("password", "Pass@123");       // استبدل بالباسورد الخاص بك

        token = given()
                .contentType("application/json")
                .body(loginBody)
                .when()
                .post("/Account/v1/GenerateToken")
                .then()
                .statusCode(200)
                .extract()
                .path("token");

        System.out.println("Generated Token: " + token);
    }

    @Test(priority = 1)
    public void createUserTest() {
        Map<String, String> userBody = new HashMap<>();
        userBody.put("userName", "latifahUser123"); // يجب أن يكون فريدًا
        userBody.put("password", "Pass@123");

        userId = given()
                .contentType("application/json")
                .body(userBody)
                .when()
                .post("/Account/v1/User")
                .then()
                .statusCode(201)
                .extract()
                .path("userID");

        System.out.println("Created User ID: " + userId);
    }

    @Test(priority = 2)
    public void assignBooksToUserTest() {
        String bookId = "9781449325862"; // مثال على ISBN كتاب

        Map<String, Object> body = new HashMap<>();
        body.put("userId", userId);
        body.put("collectionOfIsbns", List.of(Map.of("isbn", bookId)));

        given()
                .header("Authorization", "Bearer " + token)
                .contentType("application/json")
                .body(body)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .statusCode(201)
                .log().body();
    }

    @Test(priority = 3)
    public void getUserInfoTest() {
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/Account/v1/User/" + userId)
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test(priority = 4)
    public void getAllBooksTest() {
        given()
                .header("Authorization", "Bearer " + token)
                .when()
                .get("/BookStore/v1/Books")
                .then()
                .statusCode(200)
                .log().body();
    }
}
