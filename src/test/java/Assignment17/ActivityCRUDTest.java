package Assignment17;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.testng.Assert.assertEquals;

public class ActivityCRUDTest extends FakeRestBaseUrl {

    @Test
    void activityCRUDTest() {
        // 1️⃣ CREATE - POST (بدون ID)
        Activity newActivity = new Activity(null, "Learn Java", "2025-10-23T00:00:00", 0);
        Response postResponse = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(newActivity)
                .when()
                .post("/Activities");
        postResponse.prettyPrint();
        int postStatus = postResponse.getStatusCode();
        assertTrue(postStatus == 200 || postStatus == 201, "Unexpected POST status code: " + postStatus);


        // احصل على الـ ID من الاستجابة
        int activityId = postResponse.jsonPath().getInt("id");

        // 2️⃣ READ - GET
        Response getResponse = given()
                .spec(spec)
                .when()
                .get("/Activities/" + activityId);
        getResponse.prettyPrint();
        assertEquals(getResponse.getStatusCode(), 200);
        Activity fetchedActivity = getResponse.as(Activity.class);
        assertEquals(fetchedActivity.getTitle(), "Learn Java");

        // 3️⃣ UPDATE - PUT
        newActivity.setTitle("Learn Java REST API");
        Response putResponse = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(newActivity)
                .when()
                .put("/Activities/" + activityId);
        putResponse.prettyPrint();
        assertEquals(putResponse.getStatusCode(), 200);

        // 4️⃣ DELETE - DELETE
        Response deleteResponse = given()
                .spec(spec)
                .when()
                .delete("/Activities/" + activityId);
        deleteResponse.prettyPrint();
        // بعض الـ APIs ترجع 200 وبعضها 204
        Assert.assertTrue(deleteResponse.getStatusCode() == 200 || deleteResponse.getStatusCode() == 204);

        // تأكيد الحذف
        Response getAfterDelete = given()
                .spec(spec)
                .when()
                .get("/Activities/" + activityId);
        assertEquals(getAfterDelete.getStatusCode(), 404); // يجب أن يكون غير موجود بعد الحذف
    }
}
