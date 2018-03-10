package com.amazonAWS.utilities;

public class StringUtility {
	public static void main(String[] args) {
		extractNumberFromString("Cybertek003Tec112");

	}

	public static String extractNumberFromString(String targetString) {

		String onlyNum = "";
		for (int i = 0; i < targetString.length(); i++) {

			char eachChar = targetString.charAt(i);

			if (Character.isDigit(eachChar)) {

				onlyNum += eachChar;
			}
		}
		System.out.println(onlyNum);

		return onlyNum;
	}

	
}
