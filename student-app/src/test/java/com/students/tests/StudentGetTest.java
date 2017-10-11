package com.students.tests;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.student.base.TestBase;

import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.RestAssured.*;

public class StudentGetTest extends TestBase {


	@Test
	public void getAllStudentInformation() {

		/*
		 * given() - setting Cookies, add auth , adding param, setting header
		 * info .when() - GET,POST,PUT,DELETE..etc .then() - Validate status
		 * Code, extract response, extract headers, cookies, extract the
		 * response body
		 */

		Response response = given().when().get("/103");

		System.out.println(response.body().prettyPrint());

		// Validation on status code
		// given().when().get("/list").then().statusCode(200);

	}

	@Test
	public void getStudentInfo() {
		Response response = given().when().get("/1");

		// System.out.println(response.body().prettyPrint());
	}

	@Test
	public void getStudentsFromFA() {
		Response response = given().when().get("/list?programme=Computer Science&limit=2");
		// System.out.println(response.prettyPeek());
	}

	@Test
	public void getStudentWithParameters() {
		Response response = given().param("programme", "Financial Analysis").param("limit", 3).when().get("/list");
//
//		System.out.println("Content Type : " + response.contentType());
//		System.out.println("Session ID : " + response.getSessionId());
//		System.out.println("Output : " + response.prettyPeek());
//		System.out.println("Hashcode : " + response.hashCode());
//		System.out.println("Status Code : " + response.getStatusCode());

	}
	
	@Test
	public void getStudentsName() {
		String response = 
				given()
				.when()
				.get("/list?programme=Computer Science&limit=2")
				.then()
				.extract()
				.path("[1].firstName");
				
		System.out.println("His Name Is " + response);
	}
}
