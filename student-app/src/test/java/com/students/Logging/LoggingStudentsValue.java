package com.students.Logging;

import com.jayway.restassured.http.ContentType;
import com.student.base.TestBase;
import com.student.model.Student;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.junit.Test;

public class LoggingStudentsValue extends TestBase {

	/*
	 * This test will print all the test headers
	 * 
	 */
	@Test
	public void test001() {

		System.out.println("-------------------Printing Request Headers---------------------");
		given().log().headers().when().get("/1").then().statusCode(200);


	}

	/*
	 * This test will print all the Request Parameters
	 * 
	 */
	@Test
	public void test002() {

		System.out.println("-------------------Printing Request Parameters---------------------");
		given().param("programme", "Computer Science").param("limit", 1).log().parameters().when().get("/list").then()
				.statusCode(200);

	}

	/*
	 * This test will print all the Request Body
	 * 
	 */
	@Test
	public void test003() {

		System.out.println("-------------------Printing Request Body---------------------");

		ArrayList<String> courses = new ArrayList<>();
		courses.add("Java");
		courses.add("C++");
		courses.add("C#");

		Student stud = new Student();
		stud.setFirstName("Taranjeet");
		stud.setLastName("Singh");
		stud.setEmail("shankkalra24@gmail.com");
		stud.setProgramme("Computers");
		stud.setCourses(courses);

		given().contentType(ContentType.JSON).log().body().when().body(stud).post();

	}

	/*
	 * This test will print all the Request Details
	 * 
	 */
	@Test
	public void test004(){
	
		System.out.println("-------------------Printing All Request---------------------");
		
	ArrayList<String> courses = new ArrayList<>();
	courses.add("Java");
	courses.add("C++");
	courses.add("C#");
	
	
	Student stud = new Student();
	stud.setFirstName("Taranjeet");
	stud.setLastName("Singh");
	stud.setEmail("shankkalra24@gmail.com");
	stud.setProgramme("Computers");
	stud.setCourses(courses);

	given()
	.contentType(ContentType.JSON)
	.log()
	.all()
	.when()
	.body(stud)
	.post();
	
	
	}

	/*
	 * This test will print all the Body Details
	 * 
	 */
	@Test
	public void test005() {
	
		System.out.println("-------------------Printing All Request in case of validation fails---------------------");
		
	ArrayList<String> courses = new ArrayList<>();
	courses.add("Java");
	courses.add("C++");
	courses.add("C#");
	
	
	Student stud = new Student();
	stud.setFirstName("Taranjeet1");
	stud.setLastName("Singh1");
	stud.setEmail("shankkalra241@gmail.com");
	stud.setProgramme("Computers");
	stud.setCourses(courses);

	given()
	.contentType(ContentType.JSON)
	.log()
	.ifValidationFails()
	.when()
	.body(stud)
	.post()
	.then()
	.statusCode(201);
	
	}
}
