package com.coverage.test;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.coverage.demo.CheckPalindrome;

public class PalindromeTest {

	String input = "noon";

	boolean expected = true;

	@Test
	public void isPalindromeTest() {
		assertEquals(expected, CheckPalindrome.isPalindrome(input));
	}

	@Test
	public void isNotPalindromeTest() {
		assertEquals(false, CheckPalindrome.isPalindrome("abc"));
	}

	@Test(expected = NullPointerException.class)
	public void isNotPalindromeExceptionTest() {
		assertEquals(false, CheckPalindrome.isPalindrome(null));
	}

}
