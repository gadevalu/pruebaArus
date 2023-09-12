package com.testApi;


import static io.restassured.RestAssured.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


public class Test_POST {
	
	 @BeforeAll
	    public static void setup() {
	        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";
	    }

	    @Test
	    public void testPostEmployee() {
	        String requestBody = "{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}";

	        Response response = given()
	            .contentType(ContentType.JSON)
	            .body(requestBody)
	            .when()
	                .post("/create");

	        int statusCode = response.getStatusCode();
	        String responseBody = response.getBody().asString();
	        

	        System.out.println("Estado de la respuesta: " + statusCode);
	        System.out.println("Datos de la respuesta: \n" + responseBody);
	    }



}
