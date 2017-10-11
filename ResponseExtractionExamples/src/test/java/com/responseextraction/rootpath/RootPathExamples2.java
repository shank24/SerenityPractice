package com.responseextraction.rootpath;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItems;

import org.junit.Test;

import com.extraction.base.TestBase;

/**
 * @author shanky
 *
 */
public class RootPathExamples2 extends TestBase {
	
	/*
	 * Assert on Single Name
	 */

	@Test
	public void test001() {

		given()
		.parameters(parameters)
		.when()
		.get("/yql")
		.then()
		.body("Name", hasItem("USD/INR"));
	}
	
	
	/*
	 * Assert on Multiple Name
	 */

	@Test
	public void test002() {

		given()
		.parameters(parameters)
		.when()
		.get("/yql")
		.then()
		.body("Name", hasItems("USD/INR","USD/CAD"))
		.body("id", hasItem("USDCAD"));
	}
	


}
