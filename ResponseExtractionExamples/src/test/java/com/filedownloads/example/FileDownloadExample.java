package com.filedownloads.example;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;

import org.junit.Test;

/**
 * @author shanky
 *
 */
public class FileDownloadExample {

	/*
	 * Download a file & compare it with an Expected File Check the size of a
	 * file
	 */

	@Test
	public void verifyDownloadFile() {

		// Read the File
		File inputFile = new File(
				System.getProperty("user.dir") + File.separator + "geckodriver-v0.18.0-arm7hf.tar.gz");

		String name = inputFile.getPath();
		System.out.println("Name of the file is : " +name );
		
		
		
		// Length of input File
		int expectedSize = (int)inputFile.length();

		System.out.println("Size Of the file : " + expectedSize + " bytes");
		

		
		byte[] actualValue = given()
		.when()
		.get("https://github.com/mozilla/geckodriver/releases/download/v0.18.0/geckodriver-v0.18.0-arm7hf.tar.gz")
		.then()
		.extract()
		.asByteArray();
		
		
		System.out.println("Size Of the actual file is : " + actualValue.length + " bytes");
		
		
		assertThat(expectedSize, equalTo(actualValue.length));
	}

}
