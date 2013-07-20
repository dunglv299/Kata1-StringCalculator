package com.qsoft.utils;

public class Utils {
	public static int toInteger(String string) {
		return Integer.parseInt(string);
	}
	public static boolean isNumeric(String str) {
		try {
			int i = Integer.parseInt(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
