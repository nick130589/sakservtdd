package com.sakserv.sis.studentinfo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.sakserv.sis.DateUtil;

public class CourseSessionTest extends SessionTest {
	
	private static final String DEPARTMENT_CODE = "ENGL";
	private static final String COURSE_NUMBER = "101";
	private static final Date START_DATE = DateUtil.createDate(2003, 1, 6); // year, month, day 
	
	@Test
	public void testCourseDate() {
		Session session = createSession(createCourse(), START_DATE);
		Date sixteenWeeksOut = DateUtil.createDate(2003, 4, 25);
		assertEquals(sixteenWeeksOut, session.getEndDate());
	}
	
	@Test
	public void testCount() {
		CourseSession.resetCount();
		assertEquals(0, CourseSession.getCount());
		
		createSession(createCourse(), START_DATE);
		assertEquals(1, CourseSession.getCount());
		createSession(createCourse(), START_DATE);
		assertEquals(2, CourseSession.getCount());
	}
	
	protected Session createSession(Course course, Date startDate) {
		return CourseSession.create(course, startDate);
	}
	
	private Course createCourse() {
		return new Course(DEPARTMENT_CODE, COURSE_NUMBER);
	}
}