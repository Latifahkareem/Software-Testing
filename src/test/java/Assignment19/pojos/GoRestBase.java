package Assignment19.pojos;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class GoRestBase {
    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
    }
}

