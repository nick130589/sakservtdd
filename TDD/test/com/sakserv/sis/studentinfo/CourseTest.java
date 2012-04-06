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
		
		Map<Course, String> map = new HashMap<Course, String>();
		map.put(courseA, "");
		assertTrue(map.containsKey(courseAPrime));
	}
	
	@Test
	public void testApplesAndOranges() {
		Course courseA = new Course("CMSC", "120");
		assertFalse(courseA.equals("CMSC-120"));
	}

}
