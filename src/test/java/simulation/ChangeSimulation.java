package simulation;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import spec.EndpointSpecification;

import static io.restassured.RestAssured.given;

public class ChangeSimulation implements EndpointSpecification {

    @BeforeClass
    public static void setUpSuite() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setPort(PORT)
                .setBasePath(PATH)
                .build();

        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testChangeExistingCpf() {
        given()
            .body(BODY_CHANGE)
                .contentType(ContentType.JSON)
            .when()
                .pathParam("cpf", "18093236000")
                .put(SIMULATION_CPF)
            .then()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void testReturnStatus404WhenSubmittingARequestWithUnregisteredCpf() {
        given()
            .body(BODY_CHANGE)
                .contentType(ContentType.JSON)
            .when()
                .pathParam("cpf", "97093236003")
                .put(SIMULATION_CPF)
            .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }
}
