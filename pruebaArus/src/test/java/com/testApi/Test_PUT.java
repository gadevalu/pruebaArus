package com.testApi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;



public class Test_PUT {
	

	@BeforeAll
    public static void setup() {
       
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
    }

    @Test
    public void testPutRequest() {
        String requestBody = "{\"name\":\"UpdatedName\",\"salary\":\"6000\",\"age\":\"35\"}";

        Response response = given()
            .contentType(ContentType.JSON) 
            .body(requestBody)
        .when()
            .put("/update/{employee_id}", 1); 

        
        System.out.println("Respuesta de la API PUT: \n" + response.prettyPrint());

                
    }
	
}
