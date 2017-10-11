package com.studentapp.cucumber.steps;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.studentapp.cucumber.serenity.StudentSerenitySteps;
import com.studentapp.utils.TestUtils;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class StudentSteps {

	static String email = null;

	@Steps
	StudentSerenitySteps steps;

	@When("^User sends a GET request to the list endpoint, they must get back a valid status code 200$")
	public void verify_Status_Code_200_For_List_Endpoint() {

		SerenityRest.rest().given().when().get("/list").then().statusCode(200);
	}

	@When("^I create a new student by providing the information firstName (.*) lastName (.*) email (.*) programme (.*) courses (.*)$")
	public void createStudent(String firstName, String lastName, String _email, String programme, String course) {

		List<String> courses = new ArrayList<String>();
		courses.add(course);

		email = TestUtils.getRandomValue() + _email;

		steps.createStudent(firstName, lastName, email, programme, courses).assertThat().statusCode(201);
	}

	@Then("^I verify that the student with (.*) is created$")
	public void verifyStudentByEmailID(String emailID) {

		HashMap<String, Object> actualValue = steps.getStudentInfoByEmailID(email);

		assertThat(actualValue, hasValue(email));

	}

}
