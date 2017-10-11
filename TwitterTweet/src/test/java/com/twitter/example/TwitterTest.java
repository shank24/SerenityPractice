package com.twitter.example;

import org.junit.BeforeClass;
import org.junit.Test;

import com.jayway.restassured.RestAssured;

import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.spi.TransactionalWriter;

import org.junit.Test;

import com.jayway.restassured.http.ContentType;


public class TwitterTest {

	String consumerKey= "tgTtyArLFTTROuKqdMsV6x1aZ";
	String consumerSecret = "NFojQ5muO1GM2NfpHsyMreZ7ert5wuZ7MDYCRm7ac3u16kQn1d";
	
	String accessToken = "278132503-j5H1VqWXLTlpLqgFXr9TtAoBszkHLumVUHi7Zh5b";
	String secretToken = "eDXoJZ2cfDUH7gHqnT4KGmilNEfPEx7uLLNxah6GMiw7i";
	
	
	@BeforeClass
	public static void init(){
		RestAssured.baseURI="https://api.twitter.com";
		RestAssured.basePath="/1.1/statuses"; 
	}

	
/*	@Test
	public void getList(){
		
		given()
		.auth()
		.oauth(consumerKey, consumerSecret, accessToken, secretToken)
		.when()
		.get("/list.json")
		.then()
		.log()
		.all();
	}
	*/
	
	
	@Test
	public void getUserTimeline(){
		
		given()
		.auth()
		.oauth(consumerKey, consumerSecret, accessToken, secretToken)
		.queryParam("screen_name", "shankythedude")
		.when()
		.get("/user_timeline.json")
		.then()
		.log()
		.all();
	}
}
