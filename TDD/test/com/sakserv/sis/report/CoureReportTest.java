package com.sakserv.sis.report;

import static com.sakserv.sis.report.ReportConstant.NEWLINE;
import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;

import com.sakserv.sis.studentinfo.Course;
import com.sakserv.sis.studentinfo.CourseSession;


public class CoureReportTest {

	@Test
	public void testReport() {
		final Date date = new Date();
		CourseReport report = new CourseReport();
		report.add(CourseSession.create(new Course("ENGL", "101"), date));
		report.add(CourseSession.create(new Course("CZEC", "200"), date));
		report.add(CourseSession.create(new Course("ITAL", "410"), date));
		report.add(CourseSession.create(new Course("CZEC", "220"), date));
		report.add(CourseSession.create(new Course("ITAL", "330"), date));
		
		assertEquals("CZEC 200" + NEWLINE +
					 "CZEC 220" + NEWLINE +
					 "ENGL 101" + NEWLINE +
					 "ITAL 330" + NEWLINE +
					 "ITAL 410" + NEWLINE,
				report.text());
	}

}
