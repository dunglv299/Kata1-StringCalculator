package com.qsoft.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void returnZeroWhenInputIsNull() {
		assertEquals(0, Calculator.add(null));
	}

	@Test
	public void returnZeroWhenInputIsEmpty() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void returnSingleNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void returnSumOfMultipleNumberWithCommaDelimiter() {
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void unknownAmountOfNumber() {
		assertEquals(28, Calculator.add("1,2,3,4,5,6,7"));
	}

	@Test
	public void returnSumOfMultipleNumberWithOtherDelimiter() {
		assertEquals(10, Calculator.add("1\\2.3\n4"));
	}

	@Test
	public void newLineBetweenNumber() {
		assertEquals(10, Calculator.add("1\n2,3\n4"));
	}

	@Test
	public void differentDelimiter() {
		assertEquals(3, Calculator.add("//;\n1;2"));
	}

	@Test
	public void thrownExceptionWithNegativeNumber() {
		try {
			Calculator.add("-1,2,-3");
			fail("Exception");
		} catch (RuntimeException e) {
			assertEquals("-1 -3 negatives not allowed", e.getMessage());
			// TODO: handle exception
		}
	}

	@Test
	public void ignoreNumberGreaterThousand() {
		assertEquals(5, Calculator.add("//1234***2***3"));
	}

	@Test
	public void longDelimiter() {
		assertEquals(6, Calculator.add("//[***1][2342342]\n1***2***3"));
	}

	@Test
	public void otherDifferentDelimiter() {
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}

	@Test
	public void longDifferentDelimiter() {
		assertEquals(
				4,
				Calculator
						.add("//1234[*((&(*&&(*][%95868688456945689&]\n1*[3132132132132]#3"));
	}
}
