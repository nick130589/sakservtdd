package com.sakserv.sis.studentinfo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CourseTest {

	@Test
	public void testCreate() {
		Course course = new Course("CMSC", "120");
		assertEquals("CMSC", course.getDepartment());
		assertEquals("120", course.getNumber());
	}

}
