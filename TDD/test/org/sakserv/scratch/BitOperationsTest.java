package org.sakserv.scratch;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitOperationsTest {

	@Test
	public void testBitwiseMultiplication() {
		assertEquals(0, 0 & 0);
		assertEquals(0, 0 & 1);
		assertEquals(0, 1 & 0);
		assertEquals(1, 1 & 1);
	}
	
	@Test
	public void testBitwiseAddition() {
		assertEquals(0, 0 | 0);
		assertEquals(1, 0 | 1);
		assertEquals(1, 1 | 0);
		assertEquals(1, 1 | 1);
	}
	
	@Test
	public void testBitwiseDifference() {
		assertEquals(0, 0 ^ 0);
		assertEquals(1, 0 ^ 1);
		assertEquals(1, 1 ^ 0);
		assertEquals(0, 1 ^ 1);
	}
	
	@Test
	public void testLogicalNegation() {
		int x = 0x7FFFFFF1; // 2147483633 0111_1111_1111_1111_1111_1111_1111_0001
		int y = 0x8000000E; // -2147483633 1000_0000_0000_0000_0000_0000_0000_1110
		System.out.println("" + ~x);
		System.out.println("" + y);
		assertEquals(y, ~x);
	}

}

