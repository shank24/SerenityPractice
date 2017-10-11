package com.responseextraction.jsonpath;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.extraction.base.TestBase;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;


public class CurrencyExchangeJsonPathExample extends TestBase{



/*	
	 * It is retrieving the whole data set
	 
	@Test
	public void test001() {

		given().param("q",
				"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
						+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
				.param("format", "json").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().log().all().get("/yql").then().statusCode(200);

	}*/

	/*
	 * It is retrieving the count of data members
	 */

	@Test
	public void test002() {

		int count = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
								+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
				.param("format", "json").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.count");

		System.out.println("The Count is : " + count);

	}

	/*
	 * It is retrieving the Language of data members
	 */

	@Test
	public void test003() {

		String language = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
								+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
				.param("format", "json").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.lang");

		System.out.println("The Language is : " + language);

	}

	/*
	 * It is retrieving the Specific Value Of Name of data members
	 */

	@Test
	public void test004() {

		String name = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
								+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
				.param("format", "json").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.results.rate[1].Name");

		System.out.println("The Name is : " + name);

	}

	/*
	 * It is retrieving all the Value Of Name of data members
	 */

	@Test
	public void test005() {

		List<String> rateValues = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
								+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
				.param("format", "json").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.results.rate");

		System.out.println("The Rate Values are : " + rateValues);
		System.out.println("The Size of Rate Values are : " + rateValues.size());

	}

	/*
	 * It is retrieving the Size Of Collection
	 */

	@Test
	public void test006() {

		int size = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
								+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
				.param("format", "json").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.results.rate.size()");

		System.out.println("The Size of Rate Values is : " + size);

	}
	
	/*
	 * It is retrieving the Name Of all Collection under Rates
	 */

	@Test
	public void test007() {

		List<String> names = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
								+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
				.param("format", "json").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.results.rate.Name");

		System.out.println("The Name of Rate Values is : " + names);

	}
	
	/*
	 * It is retrieving the Name Of USD/BRL
	 */

	@Test
	public void test008() {

		List<String> names = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
								+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
				.param("format", "json").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.results.rate.findAll{it.Name=='USD/BRL'}");

		System.out.println("The Name of Rate Values is : " + names);

	}
	
	/*
	 * It is retrieving the Only "Rates" Of USD/EUR
	 */

	@Test
	public void test009() {

		List<String> names = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
								+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\",\"USDEUR\")")
				.param("format", "json").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.results.rate.findAll{it.Name=='USD/EUR'}.Rate");

		System.out.println("The Name of Rate Values is : " + names);

	}
	
	
	/*
	 * It is retrieving the  "Rates" > 10
	 */

	@Test
	public void test010() {

		Response response = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
								+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\",\"USDEUR\")")
				.param("format", "json").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql");
		
	List <String> value=	response
		.then()
		.extract()
		.path("query.results.rate.findAll{it.Rate>'30'}.Name");
		
		
		System.out.println("The Name of Rate Values > 30 is : " + value);

	}
	
	/*
	 * It is retrieving the id of USDB [Starts-With]
	 */

	@Test
	public void test011() {

		List<String> names = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
								+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\",\"USDEUR\")")
				.param("format", "json").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.results."
						+ "rate.findAll{it.id==~/US.*/}");

		System.out.println("The Value which starts with USD : " + names);

	}
	
	/*
	 * It is retrieving the id of UD [Ends-With]
	 */

	@Test
	public void test012() {

		List<String> names = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
								+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\",\"USDEUR\")")
				.param("format", "json").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.results."
						+ "rate.findAll{it.id==~/.*UD/}");

		System.out.println("The Value which Ends with UD : " + names);

	}
	
}
