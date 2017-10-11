package com.students.tests;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.student.base.TestBase;
import com.student.model.Student;

import static com.jayway.restassured.RestAssured.*;

public class StudentDelete extends TestBase {

	@Test
	public void deleteStudentTest() {

		given().when().delete("/102").then().statusCode(204);
	}
}
