package com.qsoft.calculator;

public class Calculator {
	public static int add(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		} else {
			int sum = 0;
			input = input.replaceAll("\\[.+\\]", ",");
			System.out.println(input);
			input = input.replaceAll("[^-0-9]", ",");
			String[] numbers = input.split(",");
			StringBuilder negativeNumber = new StringBuilder();
			for (int i = 0; i < numbers.length; i++) {
				if (!numbers[i].isEmpty()) {
					int number = Utils.toInteger(numbers[i]);
					if (number > 1000) {
						number = 0;
					}
					if (number < 0) {
						negativeNumber.append(number + " ");
					}
					sum += number;
				}
			}
			if (!negativeNumber.toString().isEmpty()) {
				throw new RuntimeException(negativeNumber.toString()
						+ "negatives not allowed");
			}
			return sum;
		}
	}

}
