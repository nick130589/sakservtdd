package com.sakserv.sis.report;

import com.sakserv.sis.studentinfo.Student;


public class HonorsGradingStrategy extends BasicGradingStrategy  {

	@Override
	public int getGradePointsFor(Student.Grade grade) {
		int points = super.getGradePointsFor(grade);
		if (points > 0) {
			points += 1;
		}
		return points;
	}

}
