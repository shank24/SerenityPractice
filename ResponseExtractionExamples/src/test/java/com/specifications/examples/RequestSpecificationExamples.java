package com.specifications.examples;

import static com.jayway.restassured.RestAssured.given;
import org.junit.Test;
import com.extraction.base.Builder;

public class RequestSpecificationExamples extends Builder {

	/*
	 * Assert on Count Value
	 */

	
	
	@Test
	public void test001() {

		given()
		.spec(rspec)
		.when()
		.log()
		.all()
		.get("/yql")
		.then()
		.log()
		.all()
		.statusCode(200);
	}

	
}
