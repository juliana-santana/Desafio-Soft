package spec;

public interface EndpointSpecification {

//    REQUESTS
    String BASE_URI = "http://localhost:8080";
    Integer PORT = 8080;
    String PATH = "/api";

//    ENDPOINTS
    String RESTRICTION = "/api/v1/restricoes/{cpf}";
    String SIMULATION = "/v1/simulacoes";
    String SIMULATION_SEARCH = "/api/v1/simulacoes";
    String SIMULATION_CPF = "/v1/simulacoes/{cpf}";
    String SIMULATION_SEARCH1 = "/api/v1/simulacoes/{cpf}";
    String REMOVE = "/api/v1/simulacoes/{id}";

//    BODY CREATE SIMULATION
    String BODY_SUCESS = "{\n" +
            "  \"nome\": \"Fulano de Tal\",\n" +
            "  \"cpf\": 18093236000,\n" +
            "  \"email\": \"email@email.com\",\n" +
            "  \"valor\": 1200,\n" +
            "  \"parcelas\": 3,\n" +
            "  \"seguro\": true\n" +
            "}";

    String BODY_CPF = "{\n" +
            "  \"nome\": \"Fulano de Tal\",\n" +
            "  \"cpf\": 999.999.999-99,\n" +
            "  \"email\": \"email@email.com\",\n" +
            "  \"valor\": 1200,\n" +
            "  \"parcelas\": 3,\n" +
            "  \"seguro\": true\n" +
            "}";

    String BODY_NAME = "{\n" +
            "  \"cpf\": 12093236000,\n" +
            "  \"email\": \"email@email.com\",\n" +
            "  \"valor\": 1200,\n" +
            "  \"parcelas\": 3,\n" +
            "  \"seguro\": true\n" +
            "}";

    String BODY_EMAIL = "{\n" +
            "  \"nome\": \"Fulano de Tal\",\n" +
            "  \"cpf\": 34093236000,\n" +
            "  \"email\": \"123\",\n" +
            "  \"valor\": 1200,\n" +
            "  \"parcelas\": 3,\n" +
            "  \"seguro\": true\n" +
            "}";

    String BODY_VALUE = "{\n" +
            "  \"nome\": \"Fulano de Tal\",\n" +
            "  \"cpf\": 50293236000,\n" +
            "  \"email\": \"email@email.com\",\n" +
            "  \"valor\": 49,\n" +
            "  \"parcelas\": 3,\n" +
            "  \"seguro\": true\n" +
            "}";

    String BODY_VALUE1 = "{\n" +
            "  \"nome\": \"Fulano de Tal\",\n" +
            "  \"cpf\": 56003236000,\n" +
            "  \"email\": \"email@email.com\",\n" +
            "  \"valor\": 999,\n" +
            "  \"parcelas\": 3,\n" +
            "  \"seguro\": true\n" +
            "}";


    String BODY_PORTION = "{\n" +
            "  \"nome\": \"Fulano de Tal\",\n" +
            "  \"cpf\": 78093236000,\n" +
            "  \"email\": \"email@email.com\",\n" +
            "  \"valor\": 1200,\n" +
            "  \"parcelas\": 49,\n" +
            "  \"seguro\": true\n" +
            "}";

    String BODY_PORTION1 = "{\n" +
            "  \"nome\": \"Fulano de Tal\",\n" +
            "  \"cpf\": 78093236000,\n" +
            "  \"email\": \"email@email.com\",\n" +
            "  \"valor\": 1200,\n" +
            "  \"parcelas\": 1,\n" +
            "  \"seguro\": true\n" +
            "}";

    String BODY_SAFE = "{\n" +
            "  \"nome\": \"Fulano de Tal\",\n" +
            "  \"cpf\": 55093236000,\n" +
            "  \"email\": \"email@email.com\",\n" +
            "  \"valor\": 1200,\n" +
            "  \"parcelas\": 3,\n" +
            "  \"seguro\": \n" +
            "}";

    String BODY_FAIL_CPF2 = "{\n" +
            "  \"nome\": \"Fulano de Tal\",\n" +
            "  \"cpf\": 18093236000,\n" +
            "  \"email\": \"email@email.com\",\n" +
            "  \"valor\": 1200,\n" +
            "  \"parcelas\": 3,\n" +
            "  \"seguro\": true\n" +
            "}";

//    BODY CHANGE SIMULATION
    String BODY_CHANGE = "{\n" +
        "  \"nome\": \"Fulano de Tal\",\n" +
        "  \"cpf\": 18093236001,\n" +
        "  \"email\": \"email@email.com\",\n" +
        "  \"valor\": 1200,\n" +
        "  \"parcelas\": 3,\n" +
        "  \"seguro\": true\n" +
        "}";
}
