package com.responseextraction.assertions;

import static com.jayway.restassured.RestAssured.given;

import org.junit.Test;

import com.extraction.base.TestBase;
import static org.hamcrest.Matchers.*;

/**
 * @author shanky
 *
 */
public class AddingAssertions extends TestBase {

	/*
	 * Assert on Count Value
	 */

	@Test
	public void test001() {

		given().parameters(parameters).when().get("/yql").then().body("query.count", equalTo(6));
	}

	/*
	 * Assert on Single Name
	 */

	@Test
	public void test002() {

		given().parameters(parameters).when().get("/yql").then().body("query.results.rate.Name", hasItem("USD/INR"));
	}

	/*
	 * Assert on Multiple Name
	 */

	@Test
	public void test003() {

		given().parameters(parameters).when().get("/yql").then().body("query.results.rate.Name",
				hasItems("USD/INR", "USD/CAD"));
	}

	/*
	 * Asserts using Logical Function
	 */

	@Test
	public void test004() {

		given().parameters(parameters).when().get("/yql").then().body("query.count", greaterThan(4));
	}

	/*
	 * Adding Multiple assertions in single test
	 */

	@Test
	public void test005() {

		given().parameters(parameters).when().get("/yql").then().body("query.results.rate.Name", hasItem("USD/INR"))
				.body("query.count", equalTo(6)).body("query.results.rate.Name", hasItems("USD/INR", "USD/CAD"))
				.body("query.count", greaterThan(4));
	}

}
