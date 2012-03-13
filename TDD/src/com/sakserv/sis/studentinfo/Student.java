package com.sakserv.sis.studentinfo;

public class Student {
	
	private static final int MIN_FULL_TIME_CREDITS = 12;
	private String name;
	private int creditHoursEnrolled;
	
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

}