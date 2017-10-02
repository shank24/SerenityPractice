package com.studentapp.junit.studentsinfo;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.model.StudentClass;
import com.studentapp.testbase.TestBase;
import com.studentapp.utils.ReuseableSpecifications;
import com.studentapp.utils.TestUtils;

import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

@RunWith(SerenityRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class StudentsCRUDTest extends TestBase {

	static String firstName = "Kylie";
	static String lastName = "Meaders";
	static String email = TestUtils.getRandomValue() + "abc@gmail.com";
	static String programme = "Ansible";
	static int studentID;

	@Steps
	StudentSerenitySteps steps;

	@Title("This will hit the POST Request and create the student")
	@Test
	public void test001() {

		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("Springs");

		steps.createStudent(firstName, lastName, email, programme, courses).statusCode(201).specification(ReuseableSpecifications.getGenericResponseSpec());

	}

	@Title("Verify If the student was added in the app")
	@Test
	public void test002() {

		HashMap<String, Object> value = steps.getStudentInfoByFirstName(firstName);

		assertThat(value, hasValue(firstName));

		studentID = (int) value.get("id");
	}

	@Title("Update The User and verify the updated information")
	@Test
	public void test003() {
		ArrayList<String> courses = new ArrayList<String>();
		courses.add("JAVA");
		courses.add("Springs");

		firstName = firstName + "_Updated1234";
		steps.updateStudentInfo(firstName, lastName, email, programme, studentID, courses);

		HashMap<String, Object> value = steps.getStudentInfoByFirstName(firstName);
		assertThat(value, hasValue(firstName));

	}

	@Title("Delete The student and verify the deletion occurs")
	@Test
	public void test004() {

		steps.deleteStudentByID(studentID);
		steps.getStudentByID(studentID).statusCode(404);

	}

}
