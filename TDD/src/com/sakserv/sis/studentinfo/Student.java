package com.sakserv.sis.studentinfo;

import java.util.ArrayList;
import java.util.List;

import com.sakserv.sis.report.BasicGradingStrategy;
import com.sakserv.sis.report.GradingStrategy;

public class Student {
	
	public static final int MIN_FULL_TIME_CREDITS = 12;
	public static final String IN_STATE = "CO";
	public static final int MAX_NAME_PARTS = 3;
	public static final String TOO_MANY_NAME_PARTS_MSG = "Student name '%s'" +
			"contains more than %d parts";
	
	private String name;
	private int creditHoursEnrolled;
	private String residentState = "";
	
	private String firstName = "";
	private String middleName = "";
	private String lastName = "";
	
	private String studentId = "";
	
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
	
	public enum Flag {
		ON_CAMPUS(1),
		TAX_EXEMPT(2),
		MINOR(4),
		TROUBLEMAKER(8);
		
		private int mask;
		
		Flag(int mask) {
			this.mask = mask;
		}
	}
	private int settings = 0x0;
	
	public void set(Flag... flags) {
		for (Flag flag: flags) {
			settings |= flag.mask;
		}
	}
	
	public void unset(Flag...flags) {
		for (Flag flag: flags) {
			settings &= ~flag.mask;
		}
	}
	
	public boolean isOn(Flag flag) {
		return (settings & flag.mask) == flag.mask; 
	}
	
	public boolean isOff(Flag flag) {
		return !isOn(flag);
	}
	
	
	private List<Grade> grades = new ArrayList<Grade>();
	
	private GradingStrategy gradingStrategy = new BasicGradingStrategy();
	
	public Student(String fullName){
		name = fullName;
		creditHoursEnrolled = 0;
		List<String> nameParts = split(fullName);
		if (nameParts.size() > MAX_NAME_PARTS) {
			String message = String.format(TOO_MANY_NAME_PARTS_MSG,
					fullName, MAX_NAME_PARTS);
			throw new StudentNameFormatException(message);
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
	
	public void setId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getId() {
		return studentId;
	}

}