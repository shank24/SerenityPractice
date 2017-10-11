package com.responseextraction.rootpath;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.path.xml.XmlPath.*;

import java.util.HashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert.*;

import com.extraction.base.TestBase;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.internal.path.xml.NodeChildrenImpl;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.*;

/**
 * @author shanky
 *
 */
public class RootPathExamples extends TestBase {
	
	@Test
	public void test001 () {

		given()
		.parameters(parameters)
		.when()
		.get("/yql")
		.then()
		.root("query.results.rate")
		.body("Name", hasItem("USD/INR"))
		.body("Name", hasItems("USD/INR","USD/CAD"))
		.body("id", hasItem("USDCAD"))
		.root("query")
		.body("count", equalTo(6))
		.body("count", greaterThan(4));
	}
		

}
