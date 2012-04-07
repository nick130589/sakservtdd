package com.sakserv.sis.studentinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

public class PerformanceTest {
	
	private static final double tolerance = 0.005;
	
	Performance performance;

	@Before
	public void setUp() {
		performance = new Performance();
	}
	
	@Test
	public void testAverage() {
		performance.setNumberOfTests(4);
		performance.set(0, 98);
		performance.set(1, 92);
		performance.set(2, 81);
		performance.set(3, 72);
		
		assertEquals(92, performance.get(1));
		assertEquals(85.75, performance.average(), tolerance);
	}
	
	@Test
	public void testArrayParm() {
		performance.setScores(75, 72, 90, 60);
		assertEquals(74.25, performance.average(), tolerance);
		
		performance.setScores(100, 90);
		assertEquals(95.0, performance.average(), tolerance);
	}
	
	@Test
	public void testAverageForNoScores() {
		Performance performance = new Performance();
		assertEquals(0.0, performance.average(), tolerance);
		assertFalse(Double.isNaN(performance.average()));
	}

}
