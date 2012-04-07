package com.sakserv.sis.report;

import java.util.EnumMap;
import java.util.Map;

import com.sakserv.sis.studentinfo.Student;

public class ReportCard {

	static final String A_MESSAGE = "Excellent";
	static final String B_MESSAGE = "Very Good";
	static final String C_MESSAGE = "Hmm...";
	static final String D_MESSAGE = "You're not trying";
	static final String F_MESSAGE = "Loser";
	
	private Map<Student.Grade, String> messages = null;
	
	public String getMessage(Student.Grade grade) {
		return getMessages().get(grade);
	}
	
	public Map<Student.Grade, String> getMessages() {
		if (messages == null) {
			loadMessages();
		}
		return messages;
	}
	
	private void loadMessages() {
		messages = new EnumMap<Student.Grade, String>(Student.Grade.class);
		messages.put(Student.Grade.A, ReportCard.A_MESSAGE);
		messages.put(Student.Grade.B, ReportCard.B_MESSAGE);
		messages.put(Student.Grade.C, ReportCard.C_MESSAGE);
		messages.put(Student.Grade.D, ReportCard.D_MESSAGE);
		messages.put(Student.Grade.F, ReportCard.F_MESSAGE);
	}
}
