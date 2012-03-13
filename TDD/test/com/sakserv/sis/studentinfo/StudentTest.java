package com.sakserv.sis.studentinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	
	private final String FIRST_STUDENT_NAME = "Jane Doe";
	private final int FIRST_STUDENT_HOURS = 3;
	
	private final String SECOND_STUDENT_NAME = "Joe Blow";
	private final int SECOND_STUDENT_HOURS = 5;
	
	private Student firstStudent, secondStudent;
	
	@Before
	public void setUp() {
		firstStudent = new Student(FIRST_STUDENT_NAME);
		secondStudent = new Student(SECOND_STUDENT_NAME);
	}
	
	@Test
	public void testCreate() {
		assertEquals("Jane Doe", firstStudent.getName());
		assertEquals("Joe Blow", secondStudent.getName());
		assertEquals("Jane Doe", firstStudent.getName());
	}
	
	@Test
	public void testAddCreditHours() {
		assertEquals(0, firstStudent.getCreditHours());
		firstStudent.addCreditHours(FIRST_STUDENT_HOURS);
		assertEquals(3, firstStudent.getCreditHours());
		firstStudent.addCreditHours(FIRST_STUDENT_HOURS + FIRST_STUDENT_HOURS);
		assertEquals(9, firstStudent.getCreditHours());
		firstStudent.addCreditHours(FIRST_STUDENT_HOURS);
		assertEquals(12, firstStudent.getCreditHours());
		
		assertEquals(0, secondStudent.getCreditHours());
		secondStudent.addCreditHours(SECOND_STUDENT_HOURS);
		assertEquals(5, secondStudent.getCreditHours());
		
		assertTrue(firstStudent.isFullTime());
		assertFalse(secondStudent.isFullTime());
	}
	
}