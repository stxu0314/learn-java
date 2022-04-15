package com.test;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class calculatorTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAdd() {
		assertEquals(7,new Calculator().add(2, 5));
		//fail("Not yet implemented");
	}


	@Test
	public void testMinus() {
		
		assertEquals(-3,new Calculator().minus(2, 5));
		//fail("Not yet implemented");
	}

	@Test
	public void testMultiply() {
		
		assertEquals(10,new Calculator().multiply(2, 5));
	}

	@Test
	public void testDivide() {
		//fail("Not yet implemented");
		assertEquals(2,new Calculator().divide(10, 2));
	}

}
