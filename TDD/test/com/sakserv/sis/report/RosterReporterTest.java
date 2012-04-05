package com.sakserv.sis.report;

import static com.sakserv.sis.report.ReportConstant.NEWLINE;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.sakserv.sis.DateUtil;
import com.sakserv.sis.studentinfo.Course;
import com.sakserv.sis.studentinfo.CourseSession;
import com.sakserv.sis.studentinfo.Session;
import com.sakserv.sis.studentinfo.Student;

public class RosterReporterTest {

	@Test
	public void testRosterReport() {
		Date createDate = DateUtil.createDate(2003, 1, 6);
		Session session = CourseSession.create(new Course("ENGL", "101")
			, createDate);
		
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
		
		String rosterReport = new RosterReporter(session).getReport();
		
		assertEquals(RosterReporter.ROSTER_REPORT_HEADER + 
		  "A" + NEWLINE +
		  "B" + NEWLINE + 
		  RosterReporter.ROSTER_REPORT_FOOTER + 
		  "2" + NEWLINE, rosterReport);
	}
}
