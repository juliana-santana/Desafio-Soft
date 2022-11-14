package simulation;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import spec.EndpointSpecification;

import static io.restassured.RestAssured.given;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CreateSimulation implements EndpointSpecification {

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
    public void testCreateSimulationValid() {
        given()
            .body(BODY_SUCESS)
                .contentType(ContentType.JSON)
            .when()
                .post(SIMULATION)
            .then()
                .statusCode(HttpStatus.SC_CREATED);
    }

    @Test
    public void testReturnStatus400WhenSubmittingARequestWithFieldCpfInvalid() {
        given()
            .body(BODY_CPF)
                .contentType(ContentType.JSON)
            .when()
                .post(SIMULATION)
            .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void testReturnStatus400WhenSubmittingARequestWithoutTheNameField() {
        given()
            .body(BODY_NAME)
                .contentType(ContentType.JSON)
            .when()
                .post(SIMULATION)
            .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void testReturnStatus400WhenSubmittingARequestWithEmailInvalid() {
        given()
            .body(BODY_EMAIL)
                .contentType(ContentType.JSON)
            .when()
                .post(SIMULATION)
            .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void testReturnStatus400WhenSubmittingARequestWithValueGreaterThan40() {
        given()
            .body(BODY_VALUE)
                .contentType(ContentType.JSON)
            .when()
                .post(SIMULATION)
            .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void testReturnStatus400WhenSubmittingARequestWithLowerValue1000() {
        given()
            .body(BODY_VALUE1)
                .contentType(ContentType.JSON)
            .when()
                .post(SIMULATION)
            .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void testReturnStatus400WhenSubmittingARequestWithAnInstallmentFieldGreaterThan48() {
        given()
            .body(BODY_PORTION)
                .contentType(ContentType.JSON)
            .when()
                .post(SIMULATION)
            .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void testReturnStatus400WhenSubmittingARequestWithAnInstallmentFieldLessThan2() {
        given()
            .body(BODY_PORTION1)
                .contentType(ContentType.JSON)
            .when()
                .post(SIMULATION)
            .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void testReturnStatus400WhenSubmittingARequestWithEmptyValueForSafeField() {
        given()
            .body(BODY_SAFE)
                .contentType(ContentType.JSON)
            .when()
                .post(SIMULATION)
            .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void testReturnStatus409WhenSendingARequestToAnAlreadyRegisteredCpf() {
        given()
            .body(BODY_FAIL_CPF2)
                .contentType(ContentType.JSON)
            .when()
                .post(SIMULATION)
            .then()
                .log().all()
                .statusCode(HttpStatus.SC_CONFLICT);
    }
}
