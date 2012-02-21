package com.sakserv;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CourseSessionTest {
	
	private CourseSession session;
	
	@Before
	public void setUp(){
		final String DEPARTMENT = "ENGL";
		final String NUMBER = "101";
		session = new CourseSession(DEPARTMENT, NUMBER);
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

}