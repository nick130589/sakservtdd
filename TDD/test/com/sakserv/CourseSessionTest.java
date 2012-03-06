package com.sakserv;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

public class CourseSessionTest {
	
	private CourseSession session;
	
	@Before
	public void setUp(){
		final String DEPARTMENT = "ENGL";
		final String NUMBER = "101";
		
		final int YEAR = 103;
		final int MONTH = 0;
		final int DATE = 6;
		Date startDate = new Date(YEAR, MONTH, DATE);
		
		session = new CourseSession(DEPARTMENT, NUMBER, startDate);
	}

	@Test
	public void createTest() {
		
		assertEquals("ENGL", session.getDepartment());
		assertEquals("101", session.getNumber());
		assertEquals(0, session.getNumberOfStudents());
	}
	
	@Test
	public void enrollStudentTest() {

		Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.get(0));
		
		Student student2 = new Student("Coralee DeVaughn");
		session.enroll(student2);
		assertEquals(2, session.getNumberOfStudents());
		
		assertEquals(student1, session.get(0));
		assertEquals(student2, session.get(1));
		
	}
	
	@Test
	public void testCourseDates() {
		int year = 103;
		int month = 0;
		int date = 6;
		Date startDate = new Date(year, month, date);
		assertEquals(startDate, session.getStartDate());
		
		year = 103;
		month = 3;
		date = 25;
		
		Date sixteenWeeksOut = new Date(year, month, date);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}

}