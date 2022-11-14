package simulation;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import spec.EndpointSpecification;

import static io.restassured.RestAssured.given;

public class RemoveSimulation implements EndpointSpecification {

    @BeforeClass
    public static void setUpSuite() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setPort(PORT)
                .setBasePath(REMOVE)
                .build();

        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testReturn204OfRemovedSimulation() {
        given()
            .when()
                .pathParam("id",   "13")
                .delete()
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test
    public void testReturn404WhenSimulationDoesNotExist() {
        given()
            .when()
                .pathParam("id",   "1")
                .delete()
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

}
