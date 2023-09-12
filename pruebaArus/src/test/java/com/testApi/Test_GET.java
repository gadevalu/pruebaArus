package com.testApi;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Test_GET {
	

	 @BeforeAll
	    public static void setup() {
	          RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	    }

	    @Test
	    public void testGetEmployeeData() {
	    	Response response = given()
	                .when()
	                    .get("/employees");

	            int statusCode = response.getStatusCode();
	            String responseBody = response.getBody().asString();

	            System.out.println("Estado de la respuesta: " + statusCode);
         
	            System.out.println("Datos de la respuesta: \n" + responseBody);
	    }

}
