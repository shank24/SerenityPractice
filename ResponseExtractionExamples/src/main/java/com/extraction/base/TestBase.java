package com.extraction.base;

import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import com.jayway.restassured.RestAssured;

public class TestBase {

	protected static HashMap<String, Object> parameters = new HashMap<String, Object>();
	
	@BeforeClass
	public static void init() {

		RestAssured.port = 8080;
		RestAssured.baseURI = "https://query.yahooapis.com";
		RestAssured.basePath = "/v1/public";
		RestAssured.rootPath="query.results.rate";

		parameters.put("q", "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
				+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")");
		parameters.put("format", "json");
		parameters.put("env", "store://datatables.org/alltableswithkeys");
	}
	
	@AfterClass
	public static void tearDown(){
		RestAssured.reset();
	}
}
