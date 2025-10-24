package Assignment16;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateUserTest {

    @Test
    public void createUserTest() {
        // 1. إعداد الرابط الأساسي
        String url = "https://your-api-endpoint.com/user"; // عدل الرابط حسب API الفعلية

        Response response = RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body("{ \"name\": \"Latif\", \"job\": \"Tester\" }") // عدل البيانات حسب الحاجة
                .post(url);

        response.prettyPrint();

        Assert.assertEquals(response.getStatusCode(), 200, "HTTP status code is not 200");

        int code = response.jsonPath().getInt("code");
        String type = response.jsonPath().getString("type");
        String message = response.jsonPath().getString("message");
        Assert.assertEquals(code, 200, "Response code mismatch");
        Assert.assertEquals(type, "unknown", "Response type mismatch");
        Assert.assertEquals(message, "12345", "Response message mismatch");
    }
}
