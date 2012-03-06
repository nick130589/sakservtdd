package com.sakserv;

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

	private String departmentCode;
	private String courseNumber;
	private Date startDate;
	private ArrayList<Student> students = new ArrayList<Student>();
	
	public final static String NEWLINE = System.getProperty("line.seperator");
	public final static String ROSTER_REPORT_HEADER = "Student" + NEWLINE + "-" + NEWLINE;
	public final static String ROSTER_REPORT_FOOTER = NEWLINE + "# students = ";
	
	public CourseSession(String departmentCode, String courseNumber, Date startDate) {
		this.departmentCode = departmentCode;
		this.courseNumber = courseNumber;
		this.startDate = startDate;
	}
	
	public String getDepartmentCode(){
		return departmentCode;
	}
	
	public String getCourseNumber(){
		return courseNumber;
	}
	
	public int getNumberOfStudents(){
		return students.size();
	}
	
	public void enroll(Student student){
		students.add(student);
	}
	
	public Student getStudentByIndex(int index){
		return students.get(index);
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public Date getEndDate() {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(startDate);
		int numberOfDays = 16 * 7 - 3; // weeks * days per week - 3
		calendar.add(Calendar.DAY_OF_YEAR, numberOfDays);
		return calendar.getTime();
	}
	
	public String getRosterReport() {
		StringBuilder buffer = new StringBuilder();
		
		buffer.append(ROSTER_REPORT_HEADER);
		
		for (Student student: students) {
			buffer.append(student.getName() + NEWLINE);
		}
		
		buffer.append(ROSTER_REPORT_FOOTER + students.size() + NEWLINE);
		System.out.println(buffer.toString());
		return buffer.toString();
		
	}
}