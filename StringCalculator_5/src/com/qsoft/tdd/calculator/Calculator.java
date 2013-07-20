package com.qsoft.tdd.calculator;

import java.awt.font.NumericShaper;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	public static int add(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		} else {
			StringBuilder delimterBuilder = new StringBuilder();
			for (String s : getDelimiter(input)) {
				delimterBuilder.append(s + ",");
			}
			if (getDelimiter(input).size() > 0) {
				input = input.substring(input.indexOf("\n") + 1);
			}
			String[] numbers = input.split("[\\" + delimterBuilder.toString()
					+ ",\n]");
			int sum = 0;
			StringBuilder negativeNumbers = new StringBuilder();
			for (int i = 0; i < numbers.length; i++) {
				if (checkNumericString(numbers[i])
						&& toInteger(numbers[i]) <= 1000) {
					int number = toInteger(numbers[i]);
					if (number < 0) {
						negativeNumbers.append(number + " ");
					} else {
						System.out.println(number);
						sum += number;
					}
				}
			}
			if (negativeNumbers.length() > 0) {
				throw new RuntimeException(negativeNumbers.toString()
						+ "negatives not allowed");
			}
			return sum;
		}
	}

	public static int toInteger(String string) {
		return Integer.parseInt(string);
	}

	public static List<String> getDelimiter(String input) {
		List<String> delimiterList = new ArrayList<String>();
		Pattern pattern = Pattern.compile("\\[(.*?)\\]");
		Matcher matcher = pattern.matcher(input);
		while (matcher.find()) {
			delimiterList.add(matcher.group(1));
		}
		return delimiterList;
	}

	public static boolean checkNumericString(String string) {
		try {
			Integer.parseInt(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
