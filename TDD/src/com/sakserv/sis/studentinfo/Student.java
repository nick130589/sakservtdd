package com.sakserv.sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

import com.sakserv.sis.report.BasicGradingStrategy;
import com.sakserv.sis.report.GradingStrategy;

public class Student {
	
	public static final int MIN_FULL_TIME_CREDITS = 12;
	public static final String IN_STATE = "CO";
	
	private String name;
	private int creditHoursEnrolled;
	private String residentState = "";
	
	private String firstName = "";
	private String middleName = "";
	private String lastName = "";
	
	private List<Integer> charges = new ArrayList<Integer>();
	
	
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
	
	public Student(String fullName){
		name = fullName;
		creditHoursEnrolled = 0;
		List<String> nameParts = split(fullName);
		
		final int maximumNumberOfNameParts = 3;
		if (nameParts.size() > maximumNumberOfNameParts) {
			throw new StudentNameFormatException();
		}
		
		setName(nameParts);
	}
	
	private void setName(List<String> nameParts) {
		this.lastName = removeLast(nameParts);
		String nextName = removeLast(nameParts);
		if (nameParts.isEmpty()) {
			this.firstName = nextName;
		} else {
			this.middleName = nextName;
			this.lastName = removeLast(nameParts);
		}
	}
	
	private String removeLast(List<String> list) {
		if (list.isEmpty()) {
			return "";
		}
		return list.remove(list.size() - 1);
	}
	
	private List<String> split(String fullName) {
		List<String> results = new ArrayList<String>();
		for (String name: fullName.split(" ")) {
			results.add(name);
		}
		return results;
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
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public String getLastName() {
		return lastName;
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
	
	public void addCharge(int charge) {
		charges.add(charge);
	}
	
	public int totalCharges() {
		int total = 0;
		for (int charge: charges) {
			total += charge;
		}
		return total;
	}

}