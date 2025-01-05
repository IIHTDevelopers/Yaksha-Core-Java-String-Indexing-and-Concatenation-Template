package testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.expr.MethodCallExpr;

public class AutoGrader {

	// Test for string indexing and string concatenation methods
	public boolean testStringIndexingAndConcatenation(String filePath) throws IOException {
		System.out.println("Starting testStringIndexingAndConcatenation with file: " + filePath);

		// Load participant's file
		File participantFile = new File(filePath); // Path to participant's file
		if (!participantFile.exists()) {
			System.out.println("File does not exist at path: " + filePath);
			return false;
		}

		// Parse the file using JavaParser
		FileInputStream fileInputStream = new FileInputStream(participantFile);
		JavaParser javaParser = new JavaParser();
		CompilationUnit cu;
		try {
			cu = javaParser.parse(fileInputStream).getResult()
					.orElseThrow(() -> new IOException("Failed to parse the Java file"));
		} catch (IOException e) {
			System.out.println("Error parsing the file: " + e.getMessage());
			throw e;
		}

		System.out.println("Parsed the Java file successfully.");

		// Flags to check for string indexing and concatenation methods
		boolean hasIndexingMethods = false;
		boolean hasConcatenationMethods = false;

		// 1. Checking String Indexing Methods (charAt, indexOf, lastIndexOf, substring)
		System.out.println("------ Checking String Indexing Methods ------");
		for (MethodCallExpr method : cu.findAll(MethodCallExpr.class)) {
			String methodName = method.getNameAsString();
			if (methodName.equals("charAt") || methodName.equals("indexOf") || methodName.equals("lastIndexOf")
					|| methodName.equals("substring")) {
				hasIndexingMethods = true;
				System.out.println("✓ Found string indexing method: " + methodName);
			}
		}

		// Output the result for string indexing methods
		if (hasIndexingMethods) {
			System.out.println("✓ String indexing methods are present.");
		} else {
			System.out.println("✘ Missing string indexing methods.");
		}

		// 2. Checking String Concatenation Methods (concat, append)
		System.out.println("------ Checking String Concatenation Methods ------");
		for (MethodCallExpr method : cu.findAll(MethodCallExpr.class)) {
			String methodName = method.getNameAsString();
			if (methodName.equals("concat") || methodName.equals("append")) {
				hasConcatenationMethods = true;
				System.out.println("✓ Found string concatenation method: " + methodName);
			}
		}

		// Output the result for string concatenation methods
		if (hasConcatenationMethods) {
			System.out.println("✓ String concatenation methods are present.");
		} else {
			System.out.println("✘ Missing string concatenation methods.");
		}

		// Test result
		boolean result = hasIndexingMethods && hasConcatenationMethods;
		System.out.println("Test result: " + result);

		return result;
	}
}
