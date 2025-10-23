package Assignment18.tests;

import Assignment18.pojos.Category;
import Assignment18.pojos.Pet;
import Assignment18.pojos.Tag;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreatePetTest {

    @Test
    public void createPetTest() {
        // 1- تحضير بيانات Pet
        Category category = new Category(1, "Dogs");
        Tag tag1 = new Tag(101, "friendly");
        Pet pet = new Pet(
                123456L,
                "Buddy",
                category,
                List.of("https://example.com/photo1.jpg"), // استخدم List.of
                List.of(tag1),
                "available"
        );

        // 2- إرسال POST request
        Response response = given()
                .baseUri("https://petstore.swagger.io/v2")
                .contentType(ContentType.JSON)
                .body(pet)
                .when()
                .post("/pet");

        // 3- عرض الاستجابة
        response.prettyPrint();

        // 4- التحقق من نجاح الطلب
        assertEquals(response.getStatusCode(), 200); // Petstore تعيد 200 عند النجاح
        assertTrue(response.asString().contains("Buddy"));
        assertTrue(response.asString().contains("Dogs"));
        assertTrue(response.asString().contains("friendly"));
        assertTrue(response.asString().contains("available"));
    }
}
