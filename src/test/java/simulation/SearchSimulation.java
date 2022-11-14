package simulation;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import spec.EndpointSpecification;

import static io.restassured.RestAssured.given;

public class SearchSimulation implements EndpointSpecification {

    @BeforeClass
    public static void setUpSuite() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setPort(PORT)
                .setBasePath(SIMULATION_SEARCH1)
                .build();

        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testConsultASimulationByCpf() {
        given()
            .when()
                .pathParam("cpf",   "66414919004")
                .get()
            .then()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test
    public void testReturnStatus404IfTheCpfDoesNotHaveASimulationRegistered() {
        given()
            .when()
                .pathParam("cpf",   "11114919004")
                .get()
            .then()
                .statusCode(HttpStatus.SC_NOT_FOUND);

    }
}
