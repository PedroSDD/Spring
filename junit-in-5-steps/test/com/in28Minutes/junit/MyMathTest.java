package com.in28Minutes.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyMathTest {

	@Test
	public void sumWith3Numbers() {
		MyMath myMath = new MyMath();
		int result = myMath.sum(new int[]{1,2,3});
		assertEquals(6, result);
	}
	
	@Test
	public void sumWith1Number1() {
		MyMath myMath = new MyMath();
		int result = myMath.sum(new int[]{3});
		assertEquals(3, result);
	}

}
