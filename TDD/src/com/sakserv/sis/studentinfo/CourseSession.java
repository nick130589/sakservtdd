package com.sakserv.sis.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Provides a representation of a single-semester
 * session of a specific university course.
 * @author Shane Kumpf
 *
 */
public class CourseSession {
	
	// Class
	private static int count = 0;
	
	// Instance
	private String departmentCode;
	private String courseNumber;
	private Date startDate;
	private ArrayList<Student> students = new ArrayList<Student>();
	private int numberOfCredits;
	
	
	private CourseSession(String departmentCode, String courseNumber, Date startDate) {
		this.departmentCode = departmentCode;
		this.courseNumber = courseNumber;
		this.startDate = startDate;
	}
	
	// Factory
	public static CourseSession create(String departmentCode, String courseNumber, Date startDate) {
		CourseSession.incrementCount();
		return new CourseSession(departmentCode, courseNumber, startDate);
	}
	
	// Public
	public ArrayList<Student> getAllStudents() {
		return students;
	}
	
	public void enroll(Student student){
		student.addCreditHours(numberOfCredits);
		students.add(student);
	}
	
	// Package class methods
	static int getCount() {
		return count;
	}
	
	static void resetCount() {
		count = 0;
	}
	
	static void incrementCount() {
		count++;
	}
	
	// Package instance methods
	String getDepartmentCode(){
		return departmentCode;
	}
	
	String getCourseNumber(){
		return courseNumber;
	}
	
	int getNumberOfStudents(){
		return students.size();
	}
	
	Student getStudentByIndex(int index){
		return students.get(index);
	}
	
	Date getStartDate() {
		return startDate;
	}
	
	Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		int numberOfDays = 16 * 7 - 3; // weeks * days per week - 3
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}
	
	void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	
}