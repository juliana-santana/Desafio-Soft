package restriction;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.BeforeClass;
import org.junit.Test;
import spec.EndpointSpecification;

import static io.restassured.RestAssured.given;

public class SearchCpf implements EndpointSpecification {

    @BeforeClass
    public static void setUpSuite() {
        RequestSpecification requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setPort(PORT)
                .setBasePath(RESTRICTION)
                .build();

        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.requestSpecification = requestSpecification;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void testReturn200Cpf1withRestriction() {
        given()
           .when()
                .pathParam("cpf",   "97093236014")
                .get()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testReturn200Cpf2withRestriction() {
        given()
           .when()
                .pathParam("cpf",   "60094146012")
                .get()
           .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testReturn200Cpf3withRestriction() {
        given()
            .when()
                .pathParam("cpf",   "84809766080")
                .get()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testReturn200Cpf4withRestriction() {
        given()
            .when()
                .pathParam("cpf",   "62648716050")
                .get()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testReturn200Cpf5withRestriction() {
        given()
            .when()
                .pathParam("cpf",   "26276298085")
                .get()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testReturn200Cpf6withRestriction() {
        given()
            .when()
                .pathParam("cpf",   "01317496094")
                .get()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testReturn200Cpf7withRestriction() {
        given()
            .when()
                .pathParam("cpf",   "55856777050")
                .get()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testReturn200Cpf8withRestriction() {
        given()
            .when()
                .pathParam("cpf",   "19626829001")
                .get()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testReturn200Cpf9withRestriction() {
        given()
            .when()
                .pathParam("cpf",   "24094592008")
                .get()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test
    public void testReturn200Cpf10withRestriction() {
        given()
            .when()
                .pathParam("cpf",   "58063164083")
                .get()
            .then()
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void testReturn204CpfwithoutRestriction() {
        given()
            .when()
                .pathParam("cpf",   "1234567890")
                .get()
            .then()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }
}
