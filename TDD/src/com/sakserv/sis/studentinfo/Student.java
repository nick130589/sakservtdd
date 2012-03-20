package com.sakserv.sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

import com.sakserv.sis.report.BasicGradingStrategy;
import com.sakserv.sis.report.GradingStrategy;

public class Student {
	
	private static final int MIN_FULL_TIME_CREDITS = 12;
	public static final String IN_STATE = "CO";
	
	private String name;
	private int creditHoursEnrolled;
	private String residentState = "";
	
	public enum Grade {
		A(4), 
		B(3), 
		C(2),
		D(1),
		F(0);
		
		private int points;
		
		Grade(int points) {
			this.points = points;
		}
		
		public int getPoints() {
			return points;
		}
	};
	
	private List<Grade> grades = new ArrayList<Grade>();
	
	private GradingStrategy gradingStrategy = new BasicGradingStrategy();
	
	
	public Student(String name){
		this.name = name;
		this.creditHoursEnrolled = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isFullTime() {
		return creditHoursEnrolled >= MIN_FULL_TIME_CREDITS;
	}
	
	public void addCreditHours(int creditsToAdd) {
		creditHoursEnrolled += creditsToAdd;
	}
	
	public int getCreditHours() {
		return creditHoursEnrolled;
	}
	
	public void setResidentState(String stateAbbreviation) {
		this.residentState = stateAbbreviation.toUpperCase();
	}
	
	public boolean isInState() {
		return residentState.equals(Student.IN_STATE);
	}
	
	public void addGrade(Grade grade) {
		grades.add(grade);
	}
	
	public double getGpa() {
		double total = 0.0;
		if (grades.isEmpty()) {
			return total;
		}
		
		for (Grade grade: grades) {
			total += gradingStrategy.getGradePointsFor(grade);
		}
		return total / grades.size();
	}
	
	void setGradingStrategy(GradingStrategy gradingStrategy) {
		this.gradingStrategy = gradingStrategy;
	}

}