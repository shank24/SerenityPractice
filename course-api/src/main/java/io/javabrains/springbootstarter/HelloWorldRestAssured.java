package io.javabrains.springbootstarter;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class HelloWorldRestAssured {

	@Test
	public void makeSureThatGoogleIsUp() {
		given().when().get("http://www.google.com").then().statusCode(200);
	}
}
