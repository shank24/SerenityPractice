package com.students.tests;

import static org.hamcrest.Matchers.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.student.base.TestBase;
import com.student.model.Student;

import static com.jayway.restassured.RestAssured.*;

public class StudentPostTest extends TestBase {

	@Test
	public void createNewStudent() {
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Java");
		courses.add("C++");

		Student stud = new Student();
		stud.setFirstName("Karanjeet");
		stud.setLastName("Singh");
		stud.setEmail("shankkalra@gmail.com");
		stud.setProgramme("Computer science");
		stud.setCourses(courses);

		given()
		.contentType(ContentType.JSON)
		.when()
		.body(stud)
		.post()
		.then()
		.statusCode(201);

	}
}
