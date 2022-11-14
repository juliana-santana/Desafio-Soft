package simulation;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import spec.EndpointSpecification;

import static io.restassured.RestAssured.given;

public class SearchAllSimulation implements EndpointSpecification {

    @BeforeClass
    public static void setUpSuite() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setPort(PORT)
                .setBasePath(SIMULATION_SEARCH)
                .build();

        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testSearchAllSimulation() {
        given()
            .when()
                .get()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testReturn204IfThereAreNoSimulationsRegistered() {
        given()
            .when()
                .get()
            .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
