package com.sakserv.sis.studentinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.sakserv.sis.DateUtil;

abstract public class SessionTest {

	private Session session;
	
	private static final String DEPARTMENT_CODE = "ENGL";
	private static final String COURSE_NUMBER = "101";
	private static final Date START_DATE = DateUtil.createDate(2003, 1, 6); // year, month, day
	private static final int COURSE_CREDITS = 3; 
	
	@Before
	public void setUp() {
		session = createSession(DEPARTMENT_CODE, COURSE_NUMBER, START_DATE);
		session.setNumberOfCredits(COURSE_CREDITS);
	}
	
	abstract protected Session createSession(String departmentCode, String courseNumber, Date startDate);
	
	@Test
	public void testCreate() {
		assertEquals(DEPARTMENT_CODE, session.getDepartmentCode());
		assertEquals(COURSE_NUMBER, session.getCourseNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(START_DATE, session.getStartDate());
		
		final String firstStudentName = "Jane Doe";
		Student firstStudent = new Student(firstStudentName);
		assertEquals(firstStudentName, firstStudent.getName());
		assertEquals("Jane", firstStudent.getFirstName());
		assertEquals("Doe", firstStudent.getLastName());
		assertEquals("", firstStudent.getMiddleName());
		
	}
	
	@Test
	public void testEnrollStudent() {

		Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		assertEquals(COURSE_CREDITS, student1.getCreditHours());
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.getStudentByIndex(0));
		
		Student student2 = new Student("Coralee DeVaughn");
		session.enroll(student2);
		assertEquals(COURSE_CREDITS, student1.getCreditHours());
		assertEquals(2, session.getNumberOfStudents());
		
		assertEquals(student1, session.getStudentByIndex(0));
		assertEquals(student2, session.getStudentByIndex(1));
		
	}
	
	@Test
	public void testSessionComparable() {
		final Date date = new Date();
		Session firstSession = createSession("CMSC", "101", date);
		Session secondSession = createSession("ENGL", "101", date);
		
		assertTrue(firstSession.compareTo(secondSession) < 0);
		assertTrue(secondSession.compareTo(firstSession) > 0);
		
		Session thirdSession = createSession("CMSC", "101", date);
		assertEquals(0, firstSession.compareTo(thirdSession));
		
		Session fourthSession = createSession("CMSC", "210", date);
		assertTrue(thirdSession.compareTo(fourthSession) < 0);
		assertTrue(fourthSession.compareTo(thirdSession) > 0);
		
	}
}
