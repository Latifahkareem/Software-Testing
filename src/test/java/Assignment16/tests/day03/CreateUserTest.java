package Assignment16.tests.day03;

import Assignment16.base_urls.PetStoreBaseUrl;
import Assignment16.pojos.User;
import Assignment16.pojos.SuccesfullUserCreationPojo;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTest extends PetStoreBaseUrl {

    @Test
    public void createUserTest() {

        int id = 101;
        User payload = new User(
                id,
                "TomHanks",
                "Tom",
                "Hanks",
                "tomhanks@example.com",
                "Tom@123",
                "500123456",
                1
        );

        SuccesfullUserCreationPojo expected =
                new SuccesfullUserCreationPojo(200, "unknown", String.valueOf(id));

        Response response = given(spec)
                .body(payload)
                .when()
                .post("/user");

        response.prettyPrint();

        SuccesfullUserCreationPojo actual = response.as(SuccesfullUserCreationPojo.class);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(actual.getCode(), expected.getCode());
        Assert.assertEquals(actual.getType(), expected.getType());
        Assert.assertEquals(actual.getMessage(), expected.getMessage());
    }
}
