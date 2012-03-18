package com.sakserv.sis.studentinfo;

import java.util.ArrayList;

public class Student {
	
	private static final int MIN_FULL_TIME_CREDITS = 12;
	public static final String IN_STATE = "CO";
	
	private String name;
	private int creditHoursEnrolled;
	private String residentState = "";
	private ArrayList<String> grades = new ArrayList<String>();
	
	public static final String GRADE_A = "A";
	public static final String GRADE_B = "B";
	public static final String GRADE_C = "C";
	public static final String GRADE_D = "D";
	public static final String GRADE_F = "F";

	
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
	
	public void addGrade(String grade) {
		grades.add(grade);
	}
	
	public double getGpa() {
		double total = 0.0;
		if (grades.isEmpty()) {
			return total;
		}
		
		for (String grade: grades) {
			total += getGradePointsForLetterGrade(grade);
		}
		
		return total / grades.size();
		
	}
	
	private int getGradePointsForLetterGrade(String grade) {
		if (grade.equals(Student.GRADE_A))	return 4;
		if (grade.equals(Student.GRADE_B)) 	return 3;
		if (grade.equals(Student.GRADE_C))  return 2;
		if (grade.equals(Student.GRADE_D))  return 1;
		return 0;
	}

}