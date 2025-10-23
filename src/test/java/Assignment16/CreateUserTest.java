package Assignment16;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateUserTest extends PetstoreBaseUrl {

    @Test
    public void createUserTest() {

        // 1- تحضير بيانات المستخدم
        User user = new User(12345L, "latifah", "Latifah", "K",
                "latifah@example.com", "12345", "1234567890", 1);

        // 2- إرسال POST request
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(user)
                .when()
                .post("/user");

        response.prettyPrint();

        assertEquals(response.getStatusCode(), 200); // Petstore تعيد 200 عند النجاح
        assertTrue(response.asString().contains("latifah")); // التحقق من اسم المستخدم
    }
}
