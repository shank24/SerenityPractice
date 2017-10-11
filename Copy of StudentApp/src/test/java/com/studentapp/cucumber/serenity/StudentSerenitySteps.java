package com.studentapp.cucumber.serenity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.studentapp.model.StudentClass;
import com.studentapp.utils.ReuseableSpecifications;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class StudentSerenitySteps {

	StudentClass ob = new StudentClass();
	String p1 = "findAll{it.firstName=='";
	String p2 = "'}.get(0)";

	@Step("Creating Student With Below Set Of Params")
	public ValidatableResponse createStudent(String firstName, String lastName, String email, String programme,
			List<String> courses) {

		ob.setFirstName(firstName);
		ob.setLastName(lastName);
		ob.setEmail(email);
		ob.setCourses(courses);
		ob.setProgramme(programme);

		return SerenityRest.rest().given().spec(ReuseableSpecifications.getGenericRequestSpec()).when().body(ob).post()
				.then();

	}

	@Step("Getting Student Info With First Name: {0} ")
	public HashMap<String, Object> getStudentInfoByFirstName(String firstName) {

		return SerenityRest.rest().given().when().get("/list").then().log().all().statusCode(200).extract()
				.path(p1 + firstName + p2);

	}

	@Step("Updates on Student First Name First Name: {0},LastName :{1}, Email: {2}, Programme: {3}, StudentID: {4}, Course: {5} ")
	public ValidatableResponse updateStudentInfo(String firstName, String lastName, String email, String programme,
			int studentID, List<String> courses) {

		ob.setFirstName(firstName);
		ob.setLastName(lastName);
		ob.setEmail(email);
		ob.setCourses(courses);
		ob.setProgramme(programme);

		return SerenityRest.rest().given().spec(ReuseableSpecifications.getGenericRequestSpec()).log().all().when()
				.body(ob).put("/" + studentID).then();

	}

	@Step("Deletion of Student by ID: {0} ")
	public void deleteStudentByID(int studentID) {

		SerenityRest.rest().given().when().delete("/" + studentID);

	}

	@Step("Get Student by ID: {0}")
	public ValidatableResponse getStudentByID(int studentID) {

		return SerenityRest.rest().given().when().get("/" + studentID).then();
	}

	@Step("Get Student by EmailID: {0}")
	public HashMap<String, Object> getStudentInfoByEmailID(String email) {

		String p1 = "findAll{it.email=='";
		String p2 = "'}.get(0)";

		return SerenityRest.rest().given().when().get("/list").then().extract().path(p1 + email + p2);
	}

}
