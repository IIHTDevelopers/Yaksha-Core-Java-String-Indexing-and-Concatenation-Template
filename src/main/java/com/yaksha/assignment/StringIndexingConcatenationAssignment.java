package com.yaksha.assignment;

public class StringIndexingConcatenationAssignment {

	public static void main(String[] args) {

		// Declare string variable
		String str = "Hello, Java World!";

		// 1. Perform string indexing operations: charAt, indexOf, lastIndexOf,
		// substring
		char charAt = str.charAt(7); // Access character at index 7
		int indexOfJava = str.indexOf("Java"); // Find the index of 'Java'
		int lastIndexOfL = str.lastIndexOf("l"); // Find the last occurrence of 'l'
		String subStr = str.substring(7, 11); // Extract substring from index 7 to 11

		// Print the results of string indexing
		System.out.println("Character at index 7: " + charAt);
		System.out.println("Index of 'Java': " + indexOfJava);
		System.out.println("Last index of 'l': " + lastIndexOfL);
		System.out.println("Substring from index 7 to 11: " + subStr);

		// Declare string variables
		String str1 = "Hello";
		String str2 = "Java";

		// 2. Perform string concatenation operations: concat, + operator, StringBuilder
		String concatStr = str1.concat(" " + str2); // Using concat() method
		String combined = str1 + " " + str2; // Using + operator
		StringBuilder sb = new StringBuilder(); // Using StringBuilder for efficient concatenation
		sb.append(str1).append(" ").append(str2);
		String builderStr = sb.toString();

		// Print the results of string concatenation
		System.out.println("Concatenated with concat: " + concatStr);
		System.out.println("Concatenated with + operator: " + combined);
		System.out.println("Concatenated with StringBuilder: " + builderStr);
	}
}
