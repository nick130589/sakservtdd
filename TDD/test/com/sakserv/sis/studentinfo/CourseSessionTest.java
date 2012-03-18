package com.sakserv.sis.studentinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.sakserv.sis.DateUtil;

public class CourseSessionTest {
	
	private CourseSession session;
	
	private static final String DEPARTMENT_CODE = "ENGL";
	private static final String COURSE_NUMBER = "101";
	private static final Date START_DATE = DateUtil.createDate(2003, 1, 6); // year, month, day
	private static final int COURSE_CREDITS = 3; 
	
	@Before
	public void setUp(){
		session = createCourseSession();
	}

	@Test
	public void createTest() {
		
		assertEquals(DEPARTMENT_CODE, session.getDepartmentCode());
		assertEquals(COURSE_NUMBER, session.getCourseNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(START_DATE, session.getStartDate());
	}
	
	@Test
	public void enrollStudentTest() {

		Student student1 = new Student("Cain DiVoe");
		session.enroll(student1);
		assertEquals(1, session.getNumberOfStudents());
		assertEquals(student1, session.getStudentByIndex(0));
		
		Student student2 = new Student("Coralee DeVaughn");
		session.enroll(student2);
		assertEquals(2, session.getNumberOfStudents());
		
		assertEquals(student1, session.getStudentByIndex(0));
		assertEquals(student2, session.getStudentByIndex(1));
		
	}
	
	@Test
	public void testCourseDate() {
		Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}
	
	@Test
	public void testCount() {
		CourseSession.resetCount();
		assertEquals(0, CourseSession.getCount());
		
		createCourseSession();
		assertEquals(1, CourseSession.getCount());
		createCourseSession();
		assertEquals(2, CourseSession.getCount());
	}
	
	@Test
	public void testCourseSessionComparable() {
		final Date date = new Date();
		CourseSession firstSession = CourseSession.create("CMSC", "101", date);
		CourseSession secondSession = CourseSession.create("ENGL", "101", date);
		
		assertTrue(firstSession.compareTo(secondSession) < 0);
		assertTrue(secondSession.compareTo(firstSession) > 0);
		
		CourseSession thirdSession = CourseSession.create("CMSC", "101", date);
		assertEquals(0, firstSession.compareTo(thirdSession));
		
		CourseSession fourthSession = CourseSession.create("CMSC", "210", date);
		assertTrue(thirdSession.compareTo(fourthSession) < 0);
		assertTrue(fourthSession.compareTo(thirdSession) > 0);
		
	}
	
	private CourseSession createCourseSession() {
		CourseSession session = CourseSession.create(DEPARTMENT_CODE, COURSE_NUMBER, START_DATE);
		session.setNumberOfCredits(COURSE_CREDITS);
		return session;
	}
}