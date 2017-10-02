package com.studentapp.junit.studentsinfo;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.studentapp.testbase.TestBase;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;

@RunWith(SerenityRunner.class)
public class TagsTest extends TestBase {

	@WithTag("studentfeature:NEGATIVE")
	@Title("Provide a 405 status code when incorrect HTTP method is used to access")
	@Test
	public void inValidMethod() {

		SerenityRest.rest().given().when().get("/list").then().statusCode(405).log().all();
	}

	@WithTags({ @WithTag("studentfeature:SMOKE"), @WithTag("studentfeature:POSITIVE") })

	@Title("This test will verify if a status code of 200 is returned")
	@Test
	public void verifyStatusCodeIs200() {

		SerenityRest.rest().given().when().get("/list").then().statusCode(200);
	}

	@WithTags({ @WithTag("studentfeature:SMOKE"), @WithTag("studentfeature:NEGATIVE") })

	@Title("This test will provide an error code of 400 when user tries to access an invalid resource")
	@Test
	public void inCorrectResource() {

		SerenityRest.rest().given().when().get("/listabcd").then().statusCode(400).log().all();
	}

}
