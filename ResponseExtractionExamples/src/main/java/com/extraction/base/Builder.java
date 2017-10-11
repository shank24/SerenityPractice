package com.extraction.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.hamcrest.Matcher;
import org.junit.BeforeClass;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.builder.ResponseSpecBuilder;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.specification.ResponseSpecification;

public class Builder {

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
		RestAssured.rootPath = "query.results.rate";

		/*
		 * Building Request Specifications
		 */

		builder = new RequestSpecBuilder();

		builder.addParameter("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
				+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")");
		builder.addParameter("format", "json");
		builder.addParameter("env", "store://datatables.org/alltableswithkeys");

		rspec = builder.build();

		/*
		 * Building Response Specifications
		 */

		headers.put("Content-Type", "application/json");

		responsebuilder = new ResponseSpecBuilder();

		// responsebuilder.expectBody("query.count", equalTo(6));

		responsebuilder.expectStatusCode(200);

		// responsebuilder.expectHeaders();

	}

}
