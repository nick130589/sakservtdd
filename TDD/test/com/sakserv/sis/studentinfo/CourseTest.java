package com.sakserv.sis.studentinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class CourseTest {

	@Test
	public void testCreate() {
		Course course = new Course("CMSC", "120");
		assertEquals("CMSC", course.getDepartment());
		assertEquals("120", course.getNumber());
	}
	
	@Test
	public void testEquality() {
		Course courseA = new Course("CMSC", "120");
		Course courseAPrime = new Course("CMSC", "120");
		Course courseAPrime2 = new Course("CMSC", "120");
		
		assertEquals(courseA, courseAPrime);
		
		Course courseB = new Course("ARTH", "330");
		assertFalse(courseA.equals(courseB));
		
		//Reflexivity
		assertEquals(courseA, courseA);
		
		//transitivity
		assertEquals(courseA, courseAPrime);
		assertEquals(courseAPrime, courseAPrime2);
		assertEquals(courseA, courseAPrime2);
		
		//Symmetry
		assertEquals(courseAPrime, courseA);
		assertEquals(courseA, courseAPrime);
		
		//Consistency
		assertEquals(courseA, courseAPrime);
		
		//Compare to null
		assertFalse(courseA.equals(null));
		
		// Containment
		List<Course> list = new ArrayList<Course>();
		list.add(courseA);
		assertTrue(list.contains(courseAPrime));
	}
	
	@Test
	public void testHashCodes() {
		Course courseA = new Course("CMSC", "120");
		Course courseAPrime = new Course("CMSC", "120");
		
		assertEquals(courseA.hashCode(), courseAPrime.hashCode());
		
		// Consistency
		assertEquals(courseA.hashCode(), courseA.hashCode());
	}
	
	@Test
	public void testApplesAndOranges() {
		Course courseA = new Course("CMSC", "120");
		assertFalse(courseA.equals("CMSC-120"));
	}
	
	@Test
	public void testHashCodePerformance() {
		final int count = 10000;
		long start = System.currentTimeMillis();
		
		Map<Course,String> map = new HashMap<Course,String>();
		
		for (int i = 0; i<count; i++) {
			Course course = new Course("C" + i, "" + i);
			map.put(course, "");
		}
		
		long stop = System.currentTimeMillis();
		long elapsed = stop - start;
		final long arbitraryThreshold = 200;	
		assertTrue("elapsed time = " + elapsed, elapsed < arbitraryThreshold);
		
	}
	
	@Test
	public void testToString() {
		Course course = new Course("ENGL", "301");
		assertEquals("ENGL 301", course.toString());
		assertEquals("SPAN 420", "" + new Course("SPAN", "420"));
	}

}
