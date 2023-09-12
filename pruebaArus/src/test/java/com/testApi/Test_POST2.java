package com.testApi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Test_POST2 {
	
	@BeforeAll
    public static void setup() {
        // Configura la URL base de la API
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
    }

    @Test
    public void testPostRequest() {
        // Cuerpo de la solicitud POST en formato JSON
        String requestBody = "{\"name\":\"John\",\"salary\":\"5000\",\"age\":\"30\"}";

        given()
            .contentType(ContentType.JSON) // Especifica el tipo de contenido JSON
            .body(requestBody) // Establece el cuerpo de la solicitud
        .when()
            .post("/create") // Especifica la ruta del endpoint POST
        .then()
            .statusCode(200) // Verifica el código de estado 200
            .body("name", equalTo("John")) // Verifica el valor del campo "name"
            .body("salary", equalTo("5000")) // Verifica el valor del campo "salary"
            .body("age", equalTo("30")); // Verifica el valor del campo "age"
    }
	

}
