package com.qsoft.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CalculatorTest {
	@Test
	public void returnZeroWhenStringEmpty() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void returnSingleNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void returnSumOfTwoNumberDelimiterByComma() {
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void returnSumOfMultipleNumberDelimiterByComma() {
		assertEquals(10, Calculator.add("1,2,3,4"));
	}

	@Test
	public void newLineBetweenNumbers() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void changeDelimiter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void throwExceptionWithNegativeNumber() {
		try {
			Calculator.add("-1,2,-3");
			fail("Throw Exception");
		} catch (RuntimeException e) {
			assertEquals("-1 -3 negatives not allowed", e.getMessage());
			// TODO: handle exception
		}
	}

	@Test
	public void ignoreNumberGreaterThanOneThousand() {
		assertEquals(6, Calculator.add("1,2,3,1001"));
	}

	@Test
	public void longDelimiter() {
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}

	@Test
	public void differentDelimiter() {
		assertEquals(10, Calculator.add("//[**][%]\n1**2%3;4"));
	}

}
