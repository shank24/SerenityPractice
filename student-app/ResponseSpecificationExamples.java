package com.specifications.examples;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.specification.RequestSpecification;

import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.specification.ResponseSpecification;

public class ResponseSpecificationExamples {

	/*
	 * Assert on Count Value
	 */

	protected static RequestSpecBuilder builder;
	protected static RequestSpecification rspec;

	protected static ResponseSpecBuilder responsebuilder;
	protected static ResponseSpecification responsespec;

	static Map<String, Object> headers = new HashMap<String, Object>();

	@BeforeClass
	public static void init() {

		RestAssured.port = 8080;
		RestAssured.baseURI = "https://query.yahooapis.com";
		RestAssured.basePath = "/v1/public";
		//RestAssured.rootPath = "query.results.rate";

		/*
		 * Building Request Specifications
		 */

		builder = new RequestSpecBuilder();

		builder.addParameter("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
				+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")");
		builder.addParameter("format", "json");
		builder.addParameter("env", "store://datatables.org/alltableswithkeys");

		// Building the Request Spec
		rspec = builder.build();

		/*
		 * Building Response Specifications
		 */

		headers.put("Content-Type", "application/json;charset=utf-8");
		headers.put("Server", "ATS");

		responsebuilder = new ResponseSpecBuilder();
		responsebuilder.expectBody("query.count", equalTo(6));
		responsebuilder.expectStatusCode(200);
		responsebuilder.expectHeaders(headers);

		// Building the Response Spec
		responsespec = responsebuilder.build();
	}

	@Test
	public void test001() {

		given()
		.spec(rspec)
		.when()
		.log()
		.all()
		.get("/yql")
		.then()
		.spec(responsespec);
	}

}
