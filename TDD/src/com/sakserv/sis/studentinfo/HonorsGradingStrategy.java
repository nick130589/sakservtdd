package com.sakserv.sis.studentinfo;


public class HonorsGradingStrategy implements GradingStrategy {

	@Override
	public int getGradePointsFor(Student.Grade grade) {
		if (grade == Student.Grade.A) return 5;
		if (grade == Student.Grade.B) return 4;
		if (grade == Student.Grade.C) return 3;
		if (grade == Student.Grade.D) return 2;
		return 0;
	}

}
