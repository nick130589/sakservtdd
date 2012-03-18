package com.sakserv.sis.report;

import java.util.ArrayList;
import java.util.Collections;

import com.sakserv.sis.studentinfo.*;
import static com.sakserv.sis.report.ReportConstant.NEWLINE;

public class CourseReport {
	
	private ArrayList<CourseSession> sessions = new ArrayList<CourseSession>();
	
	public void add(CourseSession session) {
		sessions.add(session);
	}
	
	public String text() {
		Collections.sort(sessions);
		StringBuilder builder = new StringBuilder();
		for (CourseSession session: sessions) {
			builder.append(session.getDepartmentCode() + " " +
						   session.getCourseNumber() + NEWLINE);
		}
		return builder.toString();
	}

}
