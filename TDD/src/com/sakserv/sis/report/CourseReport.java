package com.sakserv.sis.report;

import static com.sakserv.sis.report.ReportConstant.NEWLINE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sakserv.sis.studentinfo.CourseSession;

public class CourseReport {
	
	private List<CourseSession> sessions = new ArrayList<CourseSession>();
	
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
