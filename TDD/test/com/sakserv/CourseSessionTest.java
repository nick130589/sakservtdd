package com.sakserv;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class CourseSessionTest {
	
	private CourseSession session;
	
	private final String DEPARTMENT_CODE = "ENGL";
	private final String COURSE_NUMBER = "101";
	private final Date START_DATE = createDate(2003, 1, 6); // year, month, day
	
	@Before
	public void setUp(){
		session = new CourseSession(DEPARTMENT_CODE, COURSE_NUMBER, START_DATE);
	}

	@Test
	public void createTest() {
		
		assertEquals(DEPARTMENT_CODE, session.getDepartmentCode());
		assertEquals(COURSE_NUMBER, session.getCourseNumber());
		assertEquals(DEPARTMENT_CODE, session.getDepartmentCode());
		assertEquals(COURSE_NUMBER, session.getCourseNumber());
		assertEquals(0, session.getNumberOfStudents());
		assertEquals(START_DATE, session.getStartDate());
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
		Date sixteenWeeksOut = createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}
	
	@Test
	public void testRosterReport() {
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
		
		String rosterReport = session.getRosterReport();
		assertEquals(CourseSession.ROSTER_REPORT_HEADER + 
		  "A" + CourseSession.NEWLINE +
		  "B" + CourseSession.NEWLINE + 
		  CourseSession.ROSTER_REPORT_FOOTER + 
		  "2" + CourseSession.NEWLINE, rosterReport);
	}

	private Date createDate(int year, int month, int date) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.clear();
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		calendar.set(Calendar.DAY_OF_MONTH, date);
		return calendar.getTime();
	}
}