package com.qsoft.calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.qsoft.utils.Utils;

public class Calculator {
	public static int add(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		} else {
			StringBuilder sb = new StringBuilder();
			for (String delimiter : getDelimiter(input)) {
				sb.append(delimiter + ",");
			}
			if (getDelimiter(input).size() > 0) {
				input = input.substring(input.indexOf("\n") + 1);
			}
			String[] numbers = input.split("[\\" + sb.toString() + "\n,;]");

			int sum = 0;
			StringBuilder builder = new StringBuilder();
			for (int i = 0; i < numbers.length; i++) {
				if (Utils.isNumeric(numbers[i]) && !numbers[i].isEmpty()) {
					System.out.println(numbers[i]);
					int number = Utils.toInteger(numbers[i]);
					if (number <= 1000) {
						if (number < 0) {
							builder.append(number + " ");
						} else {
							sum += number;
						}
					}
				}
			}
			if (builder.length() > 0) {
				throw new RuntimeException(builder.toString()
						+ "negatives not allowed");
			}
			System.out.println(sum);
			return sum;
		}
	}

	public static List<String> getDelimiter(String input) {
		List<String> listDelimiter = new ArrayList<String>();
		Pattern p = Pattern.compile("\\[(.*?)\\]");
		Matcher m = p.matcher(input);
		while (m.find()) {
			// System.out.println(m.group(1));
			listDelimiter.add(m.group(1));
		}

		return listDelimiter;
	}

}
