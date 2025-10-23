package Assignment17;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class FakeRestBaseUrl {
    protected RequestSpecification spec;

    public FakeRestBaseUrl() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://fakerestapi.azurewebsites.net/api/v1")
                .build();
    }
}

