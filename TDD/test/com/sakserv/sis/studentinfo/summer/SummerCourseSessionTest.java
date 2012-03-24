package com.sakserv.sis.studentinfo.summer;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.sakserv.sis.DateUtil;
import com.sakserv.sis.studentinfo.Session;
import com.sakserv.sis.studentinfo.SessionTest;

public class SummerCourseSessionTest extends SessionTest {
	
	protected Session createSession(String departmentCode, String courseNumber, Date startDate) {
		return SummerCourseSession.create(departmentCode, courseNumber, startDate);
	}

	@Test
	public void testEndDate() {
		Date startDate = DateUtil.createDate(2003, 6, 9);
		Session session = SummerCourseSession.create("ENGL", "200", startDate);
		Date eightWeeksOut = DateUtil.createDate(2003, 8, 1);
		assertEquals(eightWeeksOut, session.getEndDate());
	}

}
