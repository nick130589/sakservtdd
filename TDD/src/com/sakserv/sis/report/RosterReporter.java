package com.sakserv.sis.report;

import static com.sakserv.sis.report.ReportConstant.NEWLINE;

import java.io.IOException;
import java.io.Writer;

import com.sakserv.sis.studentinfo.Session;
import com.sakserv.sis.studentinfo.Student;

public class RosterReporter {

	public final static String ROSTER_REPORT_HEADER = "Student" +
			NEWLINE + "-" + NEWLINE;
	public final static String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";
	
	private Session session;
	private Writer writer;
	
	public RosterReporter(Session session) {
		this.session = session;
	}
	
	public void writeReport(Writer writer) throws IOException {
		this.writer = writer;
		writeHeader();
		writeBody();
		writeFooter();
	}
	
	public void writeHeader() throws IOException {
		writer.write(ROSTER_REPORT_HEADER);
	}
	
	public void writeBody() throws IOException {
		for (Student student: session.getAllStudents()) {
			writer.write(student.getName() + NEWLINE);
		}
	}
	
	public void writeFooter() throws IOException {
		writer.write(ROSTER_REPORT_FOOTER + 
				session.getAllStudents().size() + NEWLINE);
	}
	
}
