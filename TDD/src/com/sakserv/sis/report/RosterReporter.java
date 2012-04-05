package com.sakserv.sis.report;

import static com.sakserv.sis.report.ReportConstant.NEWLINE;

import com.sakserv.sis.studentinfo.Session;
import com.sakserv.sis.studentinfo.Student;

public class RosterReporter {

	public final static String ROSTER_REPORT_HEADER = "Student" +
			NEWLINE + "-" + NEWLINE;
	public final static String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";
	
	private Session session;
	
	public RosterReporter(Session session) {
		this.session = session;
	}
	
	public String getReport() {
		StringBuilder buffer = new StringBuilder();
		
		writeHeader(buffer);
		writeBody(buffer);
		writeFooter(buffer);

		return buffer.toString();
		
	}
	
	public void writeHeader(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_HEADER);
	}
	
	public void writeBody(StringBuilder buffer) {
		for (Student student: session.getAllStudents()) {
			buffer.append(student.getName() + NEWLINE);
		}
	}
	
	public void writeFooter(StringBuilder buffer) {
		buffer.append(ROSTER_REPORT_FOOTER + 
				session.getAllStudents().size() + NEWLINE);
	}
	
}
