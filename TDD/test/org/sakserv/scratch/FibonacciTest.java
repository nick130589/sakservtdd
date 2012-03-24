package org.sakserv.scratch;

import static org.junit.Assert.*;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void test() {
		assertEquals(1, fib(1));
		assertEquals(1, fib(2));
		assertEquals(2, fib(3));
		assertEquals(3, fib(4));
		assertEquals(5, fib(5));
		assertEquals(8, fib(6));
		assertEquals(13, fib(7));
		assertEquals(21, fib(8));
		assertEquals(34, fib(9));
		assertEquals(55, fib(10));
	}
	
	public int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		
		return fib(n - 1) + fib(n - 2);
	}

}
