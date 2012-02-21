package com.sakserv;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StudentTest {

	@Test
	public void testCreate() {
		final String firstStudentName = "Jane Doe";
		Student firstStudent = new Student(firstStudentName);
		assertEquals("Jane Doe", firstStudent.getName());
		
		final String secondStudentName = "Joe Blow";
		Student secondStudent = new Student(secondStudentName);
		assertEquals("Joe Blow", secondStudent.getName());
		
		assertEquals("Jane Doe", firstStudent.getName());
	}
}