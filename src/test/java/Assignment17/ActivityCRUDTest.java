package Assignment17;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class ActivityCRUDTest extends FakeRestBaseUrl {

    @Test
    public void activityCRUDTest() {
        // 1️⃣ CREATE - POST
        Activity newActivity = new Activity(1001, "Learn Java", "2025-10-23T00:00:00", 0);
        Response postResponse = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(newActivity)
                .when()
                .post("/Activities");
        postResponse.prettyPrint();
        assertEquals(postResponse.getStatusCode(), 200);

        // 2️⃣ READ - GET
        Response getResponse = given()
                .spec(spec)
                .when()
                .get("/Activities/1001");
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
                .put("/Activities/1001");
        putResponse.prettyPrint();
        assertEquals(putResponse.getStatusCode(), 200);

        // 4️⃣ DELETE - DELETE
        Response deleteResponse = given()
                .spec(spec)
                .when()
                .delete("/Activities/1001");
        deleteResponse.prettyPrint();
        assertEquals(deleteResponse.getStatusCode(), 200);

        // تأكيد الحذف
        Response getAfterDelete = given()
                .spec(spec)
                .when()
                .get("/Activities/1001");
        assertEquals(getAfterDelete.getStatusCode(), 404); // غير موجود بعد الحذف
    }
}

