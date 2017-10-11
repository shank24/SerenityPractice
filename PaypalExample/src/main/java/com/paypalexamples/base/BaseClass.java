package com.paypalexamples.base;

import static com.jayway.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

public class BaseClass {

	protected static String accessToken;

	public static final String client_Id = "AU_1Wit_OktHHfycrckyTW1CyPbhbp0FtxbFoYWiQj1U7o4LAqwks4PAd2MXsJNIq8kefbkpvCLsLDmh";
	public static final String secret_Id = "EGpdmfZ8otUw17aeQvvnClct7yHgfRC5oVSowaX3mQo2E48FxBAXjknS9sgZjjAiFBfsOH51S1rBKs1S";

	@BeforeClass
	public static void getToken() {

		RestAssured.baseURI = "https://api.sandbox.paypal.com";
		RestAssured.basePath = "/v1";

		accessToken = given().parameters("grant_type", "client_credentials").auth().preemptive()
				.basic(client_Id, secret_Id).when().post("/oauth2/token").then().log().all().extract()
				.path("access_token");

		System.out.println("The Access Token Is : " + accessToken);
	}

}
