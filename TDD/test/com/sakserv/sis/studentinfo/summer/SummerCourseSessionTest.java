package com.sakserv.sis.studentinfo.summer;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.sakserv.sis.DateUtil;
import com.sakserv.sis.studentinfo.Course;
import com.sakserv.sis.studentinfo.Session;
import com.sakserv.sis.studentinfo.SessionTest;

public class SummerCourseSessionTest extends SessionTest {
	
	protected Session createSession(Course course,
			Date startDate) {
		return SummerCourseSession.create(course.getDepartment(),
				course.getNumber(), startDate);
	}

	@Test
	public void testEndDate() {
		Date startDate = DateUtil.createDate(2003, 6, 9);
		Session session = createSession(new Course("ENGL", "200"), startDate);
		Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
		assertEquals(eightWeeksOut, session.getEndDate());
	}

}
