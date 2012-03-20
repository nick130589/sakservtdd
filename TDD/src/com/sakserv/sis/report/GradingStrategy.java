package com.sakserv.sis.report;

import com.sakserv.sis.studentinfo.Student;

public interface GradingStrategy {
	int getGradePointsFor(Student.Grade grade);
}
