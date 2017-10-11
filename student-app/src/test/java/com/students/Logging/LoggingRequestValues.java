package com.students.Logging;

import com.jayway.restassured.http.ContentType;
import com.student.base.TestBase;
import com.student.model.Student;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.junit.Test;

public class LoggingRequestValues extends TestBase {

	/*
	 * This test will print out all the request headers
	 */
	@Test
	public void test001() {

		System.out.println("--------------------------Printing Request Headers-------------------------------------");
		given().log().headers().when().get("/1").then().statusCode(200);
	}

	/*
	 * This test will print out all the request Cookies
	 */
	@Test
	public void test002() {

		System.out.println("--------------------------Printing Request Cookies-------------------------------------");
		given().log().cookies().when().get("/1").then().statusCode(200);
	}

	/*
	 * This test will print out all the request Parameters
	 */
	@Test
	public void test003() {

		System.out
				.println("--------------------------Printing Request Parameters-------------------------------------");
		given().param("programme", "Computer Science").param("limit", 1).log().parameters().when().get("/list").then()
				.statusCode(200);
	}

	/*
	 * This test will print out all the request body
	 */
	@Test
	public void test004() {

		ArrayList<String> courses = new ArrayList<>();
		System.out.println("--------------------------Printing All The Request Details-------------------------------------");
		courses.add("Java");
		courses.add("C++");

		Student stud = new Student();
		stud.setFirstName("Taranjeet12");
		stud.setLastName("Singh");
		stud.setEmail("shankkalra23@gmail.com");
		stud.setProgramme("Computer science");
		stud.setCourses(courses);

		given().contentType(ContentType.JSON).log().all().when().body(stud).post().then().statusCode(201);
	}

	
	/*
	 * This test will print out all the request details, if the validation fails
	 */
	@Test
	public void test005() {

		ArrayList<String> courses = new ArrayList<>();
		System.out.println("--------------------------Printing Request Body If Validation Fails-------------------------------------");
		courses.add("Java");
		courses.add("C++");

		Student stud = new Student();
		stud.setFirstName("Karanjeet12");
		stud.setLastName("Singh12");
		stud.setEmail("shankkalra22@gmail.com");
		stud.setProgramme("Computer science");
		stud.setCourses(courses);

		given().contentType(ContentType.JSON).log().ifValidationFails().when().body(stud).post().then().statusCode(201);
	}
	
	
}
