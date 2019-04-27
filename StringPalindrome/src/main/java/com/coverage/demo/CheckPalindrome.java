package com.coverage.demo;

public class CheckPalindrome {

	public static void main(String[] args) {
	}

	public static boolean isPalindrome(String input) {

		if (input == null) {
			throw new NullPointerException();
		}
		if (input.equals(reverseString(input)))
			return true;
		else
			return false;
	}

	private static String reverseString(String input) {
		String rev = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			rev = rev + input.charAt(i);
		}
		return rev;
	}

}
