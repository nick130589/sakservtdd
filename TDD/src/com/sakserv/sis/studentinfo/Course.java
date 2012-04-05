package com.sakserv.sis.studentinfo;

public class Course {
	
	protected String department;
	protected String number;
	
	public Course() {}
	
	public Course(String department, String number) {
		this.department = department;
		this.number = number;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public String getNumber() {
		return number;
	}

}
