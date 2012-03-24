package com.sakserv.sis.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

abstract public class Session implements Comparable<Session> {

	// Instance
	private String departmentCode;
	private String courseNumber;
	private Date startDate;
	private List<Student> students = new ArrayList<Student>();
	private int numberOfCredits;
	
	
	protected Session(String departmentCode, String courseNumber, Date startDate) {
		this.departmentCode = departmentCode;
		this.courseNumber = courseNumber;
		this.startDate = startDate;
	}
	
	public int compareTo(Session session) {
		int compare = this.getDepartmentCode().compareTo(session.getDepartmentCode());
		
		// Dept code matches, check course number
		if (compare == 0) {
			compare = this.getCourseNumber().compareTo(session.getCourseNumber());
		}
		return compare;
	}
	
	void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	
	public String getDepartmentCode(){
		return departmentCode;
	}
	
	public String getCourseNumber(){
		return courseNumber;
	}
	
	int getNumberOfStudents(){
		return students.size();
	}
	
	public void enroll(Student student){
		student.addCreditHours(numberOfCredits);
		students.add(student);
	}
	
	Student getStudentByIndex(int index){
		return students.get(index);
	}
	
	protected Date getStartDate() {
		return startDate;
	}
	
	public List<Student> getAllStudents() {
		return students;
	}
	
	abstract protected int getSessionLength();
	
	public Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(getStartDate());
		int numberOfDays = getSessionLength() * 7 - 3; // weeks * days per week - 3
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}

}
