package Assignment16;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;

public class PetstoreBaseUrl {
    protected RequestSpecification spec;

    public PetstoreBaseUrl() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(ContentType.JSON)  // ✅ لا تتركه null
                .build();
    }

    @BeforeClass
    public void setSpec() {
        // يمكن تركه فارغ أو استخدامه لإعادة تهيئة spec إذا لزم
    }
}
