package com.sakserv.sis.report;

import com.sakserv.sis.studentinfo.CourseSession;
import com.sakserv.sis.studentinfo.Student;
import static com.sakserv.sis.report.ReportConstant.NEWLINE;

public class RosterReporter {

	public final static String ROSTER_REPORT_HEADER = "Student" +
			NEWLINE + "-" + NEWLINE;
	public final static String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";
	
	private CourseSession session;
	
	public RosterReporter(CourseSession session) {
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
