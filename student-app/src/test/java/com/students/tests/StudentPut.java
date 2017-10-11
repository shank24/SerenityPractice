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

public class StudentPut extends TestBase {

	@Test
	public void updateStudent() {
		ArrayList<String> courses = new ArrayList<>();
		courses.add("Java");
		courses.add("C++");

		Student stud = new Student();
		stud.setFirstName("Taylor");
		stud.setLastName("Swift");
		stud.setEmail("shankkalra24@gmail.com");
		stud.setProgramme("Computer Science Programming");
		stud.setCourses(courses);

		given().contentType(ContentType.JSON).when().body(stud).put("/101").then().statusCode(200);

	}
}
