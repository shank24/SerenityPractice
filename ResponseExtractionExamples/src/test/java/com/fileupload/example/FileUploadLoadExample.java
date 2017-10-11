package com.fileupload.example;

import static com.jayway.restassured.RestAssured.given;
import static io.restassured.path.xml.XmlPath.*;

import static org.hamcrest.MatcherAssert.assertThat;

import java.io.File;
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

public class FileUploadLoadExample {

	/*
	 * Upload a file to zamzar.com and convert it into other format
	 */
	@Test
	public void uploadFileExample() {

		String apiKey = "6e1236c3dc74565b56f57d81a2bb28b0ce4aca0a";
		String endpoint = "https://sandbox.zamzar.com/v1/jobs";
		//String sourceFile = "/tmp/portrait.gif";
		//String targetFormat = "png";

		File file = new File(System.getProperty("user.dir") + File.separator + "MountainsBook.jpg");
		System.out.println(file.getAbsolutePath());

		given()
		.auth()
		.basic(apiKey,"")
		.multiPart("source_file", file)
		.multiPart("target_format", "png")
		.when()
		.post(endpoint)
		.then().log().all();
	}
}
