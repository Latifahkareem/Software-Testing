package Assignment19.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UserManagementTest {

    private String token = null; // سيتم حفظ التوكن هنا بعد تسجيل الدخول

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://your-api-url.com";

        String payload = "{ \"username\": \"testuser\", \"password\": \"123456\" }";
        Response response = given()
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                .contentType(ContentType.JSON)
                .body(payload)
                .redirects().follow(true)
                .when()
                .post("/endpoint")  // endpoint الخاص بتسجيل الدخول
                .then()
                .log().all()
                .extract().response();

        String contentType = response.getContentType();

        if (contentType != null && contentType.contains("application/json")) {
            try {
                token = response.jsonPath().getString("token");
                System.out.println("Token: " + token);
            } catch (Exception e) {
                System.out.println("JSON موجود لكن لا يحتوي على token: " + e.getMessage());
            }
        } else {
            System.out.println("Response is not JSON. Possibly HTML or Redirect.");
            System.out.println("Response preview: ");
            System.out.println(response.asString().substring(0, Math.min(500, response.asString().length())) + "...");
        }
    }

    @Test
    public void sampleGetTest() {
        // اختبار GET يستخدم التوكن إذا كان موجود
        if (token != null) {
            given()
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                    .header("Authorization", "Bearer " + token)
                    .redirects().follow(true)
                    .when()
                    .get("/endpoint") // المسار المطلوب اختباره
                    .then()
                    .statusCode(200)
                    .log().all();
        } else {
            System.out.println("Skipping GET test because token is not available.");
        }
    }

    @Test
    public void samplePostTest() {
        // مثال POST آخر يستخدم التوكن
        if (token != null) {
            String newPayload = "{ \"data\": \"example\" }";

            given()
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64)")
                    .header("Authorization", "Bearer " + token)
                    .contentType(ContentType.JSON)
                    .body(newPayload)
                    .redirects().follow(true)
                    .when()
                    .post("/another-endpoint")
                    .then()
                    .statusCode(200)
                    .log().all();
        } else {
            System.out.println("Skipping POST test because token is not available.");
        }
    }
}
