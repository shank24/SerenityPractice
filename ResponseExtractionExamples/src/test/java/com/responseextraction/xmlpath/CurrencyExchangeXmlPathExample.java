package com.responseextraction.xmlpath;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.path.xml.XmlPath.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.extraction.base.TestBase;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.internal.path.xml.NodeChildrenImpl;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;

public class CurrencyExchangeXmlPathExample extends TestBase{



	// It is retrieving the whole data set
	@Test
	public void test001() {
		// ValidatableResponse response = given().param("q",
		// "SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
		// + "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
		// .param("format", "xml").param("env",
		// "store://datatables.org/alltableswithkeys")
		// .param("diagnostics",
		// "true").when().log().all().get("/yql").then().statusCode(200);
		//
		// System.out.println("The Whole Data Set : " + response);

	}

	/*
	 * It is retrieving the count of data members
	 */

	@Test
	public void test002() {

		String count = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
								+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
				.param("format", "xml").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.@yahoo:count");

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
				.param("format", "xml").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.@yahoo:lang");

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
				.param("format", "xml").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.results.rate[1].Name");

		System.out.println("The Name is : " + name);

	}

	/*
	 * Get the values under rate as String
	 */

	@Test
	public void test005() {

		String name = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\",\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
				.param("format", "xml").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").andReturn().asString();

		String valuesUnderRate = with(name).get("query.results.rate").toString();

		System.out.println("The Values under rate is : " + valuesUnderRate);

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
				.param("format", "xml").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.results.rate.size()");

		System.out.println("The Size of Rate Values is : " + size);

	}

	/*
	 * It is retrieving the Size Of Collection
	 */

	@Test
	public void test007() {

		NodeChildrenImpl sizeOfCollection = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\","
								+ "\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
				.param("format", "xml").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").then().extract().path("query.results.rate");

		System.out.println("The Size of Collection via Node Class is : " + sizeOfCollection.size());

	}

	/*
	 * Get all the Names from the Response as String
	 */

	@Test
	public void test008() {

		String name = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\",\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
				.param("format", "xml").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").andReturn().asString();

		String valuesUnderName = with(name).get("query.results.rate.findAll{it.Name}.Name").toString();

		String valuesUnderName1 = with(name).get("query.results.rate.Name").toString();

		System.out.println("The Values under Name is : " + valuesUnderName);
		System.out.println("The Values under Name is 1 : " + valuesUnderName1);

	}

	/*
	 * Get all the Info aboutUSD/AUD
	 */

	@Test
	public void test009() {

		String name = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\",\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
				.param("format", "xml").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").andReturn().asString();

		String infoAboutUSDAUD = with(name).get("query.results.rate.findAll{it.Name=='USD/AUD'}").toString();

		System.out.println("The Info about USD/AUD is : " + infoAboutUSDAUD);

	}

	/*
	 * Extracting Using attr id = "INR=X" and getting the rate .. using **
	 */

	@Test
	public void test010() {

		String name = given()
				.param("q",
						"SELECT * FROM yahoo.finance.xchange WHERE pair in (\"USDTHB\",\"USDINR\",\"USDCAD\",\"USDAUD\",\"USDEUR\",\"USDBRL\")")
				.param("format", "xml").param("env", "store://datatables.org/alltableswithkeys")
				.param("diagnostics", "true").when().get("/yql").andReturn().asString();

		// query.results.rate = **
		String valuesAboutINR = with(name).get("**.findAll{it.@id=='USDINR'}.Rate").toString();

		System.out.println("The Info about USD/INR is : " + valuesAboutINR);

	}
}
