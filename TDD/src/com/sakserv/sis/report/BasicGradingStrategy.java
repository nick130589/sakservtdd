package com.sakserv.sis.report;

import com.sakserv.sis.studentinfo.Student;

public class BasicGradingStrategy implements GradingStrategy {
	
	public int getGradePointsFor(Student.Grade grade) {
		return grade.getPoints();
	}
}
