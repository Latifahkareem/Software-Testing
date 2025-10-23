package Assignment16;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class PetstoreBaseUrl {
    private static final String JSON = null;
    protected RequestSpecification spec;

    public PetstoreBaseUrl() {
        new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                .setContentType(JSON);
    }

    @BeforeClass
    public void setSpec() {
    }
}
