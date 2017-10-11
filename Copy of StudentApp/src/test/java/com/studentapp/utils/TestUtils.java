package com.studentapp.utils;

import java.util.Random;

public class TestUtils {

	public static String getRandomValue(){
		Random value =new Random();
		int randomInt= value.nextInt(100000);
		return Integer.toString(randomInt);
	}
}
