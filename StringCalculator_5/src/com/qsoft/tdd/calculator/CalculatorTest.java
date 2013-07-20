package com.qsoft.tdd.calculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class CalculatorTest {
	@Test
	public void returnZeroWhenStringIsEmpty() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void returnSingleNumber() {
		assertEquals(1, Calculator.add("1"));
	}

	@Test
	public void returnSumOfMultipleNumberDelimitByComma() {
		assertEquals(6, Calculator.add("1,2,3"));
	}

	@Test
	public void returnSumOfMultipleNumberDelimitByNewLine() {
		assertEquals(6, Calculator.add("1\n2,3"));
	}

	@Test
	public void changeDelimiter() {
		assertEquals(3, Calculator.add("[;]\n1;2"));
	}

	@Test
	public void throwExceptionNegativeNumber() {
		try {
			Calculator.add("-1,2,3");
			fail("Exception");
		} catch (RuntimeException e) {
			assertEquals("-1 negatives not allowed", e.getMessage());
			// TODO: handle exception
		}
	}

	@Test
	public void ignoreNumberGreaterThanOneThousand() {
		assertEquals(3, Calculator.add("1001,1\n2"));
	}

	@Test
	public void longdelimiter() {
		assertEquals(6, Calculator.add("//[***]\n1***2***3"));
	}

	@Test
	public void longDifferentDelimiter() {
		assertEquals(6, Calculator.add("//[*][%]\n1*2%3"));
	}
}
