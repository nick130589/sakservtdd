package com.sakserv.sis.studentinfo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


/**
 * Provides a representation of a single-semester
 * session of a specific university course.
 * @author Shane Kumpf
 *
 */
public class CourseSession implements Comparable<CourseSession> {
	
	// Class
	private static int count = 0;
	
	// Instance
	private String departmentCode;
	private String courseNumber;
	private Date startDate;
	private List<Student> students = new ArrayList<Student>();
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
	public List<Student> getAllStudents() {
		return students;
	}
	
	public void enroll(Student student){
		student.addCreditHours(numberOfCredits);
		students.add(student);
	}
	
	public String getDepartmentCode(){
		return departmentCode;
	}
	
	public String getCourseNumber(){
		return courseNumber;
	}
	
	public int compareTo(CourseSession session) {
		int compare = this.getDepartmentCode().compareTo(session.getDepartmentCode());
		
		// Dept code matches, check course number
		if (compare == 0) {
			compare = this.getCourseNumber().compareTo(session.getCourseNumber());
		}
		return compare;
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