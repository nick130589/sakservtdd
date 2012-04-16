package com.sakserv.sis.report;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.io.Writer;

import org.junit.Before;
import org.junit.Test;

import com.sakserv.sis.DateUtil;
import com.sakserv.sis.studentinfo.Course;
import com.sakserv.sis.studentinfo.CourseSession;
import com.sakserv.sis.studentinfo.Session;
import com.sakserv.sis.studentinfo.Student;
import com.sakserv.sis.ui.StudentUI;

public class RosterReporterTest {

	private Session session;
	
	@Before
	public void setUp() {
		session = CourseSession.create(new Course("ENGL", "101"), 
				DateUtil.createDate(2003, 1, 6));
		
		session.enroll(new Student("A"));
		session.enroll(new Student("B"));
	}
	
	
	@Test
	public void testRosterReport() throws IOException {
		
		Writer writer = new StringWriter();
		new RosterReporter(session).writeReport(writer);
		assertReportContents(writer.toString());
	}
	
	@Test
	public void testFiledReport() throws IOException {
		final String filename = "testFileReport.txt";
		try {
			new RosterReporter(session).writeReport(filename);
		
			StringBuffer buffer = new StringBuffer();
			String line;
		
			BufferedReader reader = new BufferedReader(
					new FileReader(filename));
			while ((line = reader.readLine()) != null) {
				buffer.append(String.format(line + "%n"));
			}
			assertReportContents(buffer.toString());
		}
		finally {
			delete(filename);
		}	
	}
	
	public void assertReportContents(String rosterReport) {
		assertEquals(String.format(RosterReporter.ROSTER_REPORT_HEADER +
				"A%n" + "B%n" + RosterReporter.ROSTER_REPORT_FOOTER +
				session.getNumberOfStudents() + "%n"), rosterReport);
	}
	
	public void delete(String filename) {
		File file = new File(filename);
		if (file.exists()) {
			file.deleteOnExit();
		}
	}
	
}
