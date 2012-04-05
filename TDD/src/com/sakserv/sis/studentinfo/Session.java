package com.sakserv.sis.studentinfo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public abstract class Session extends Course implements Comparable<Session>, 
	Iterable<Student> {

	// Instance
	private Course course;
	private Date startDate;
	private List<Student> students = new Vector<Student>();
	private int numberOfCredits;
	private URL url;
	
	public Session(Course course, Date startDate) {
		this.course = course;
		this.startDate = startDate;
	}
	
	public int compareTo(Session session) {
		int compare = this.getDepartment().compareTo(
				session.getDepartment());
		
		// Dept code matches, check course number
		if (compare == 0) {
			compare = this.getNumber().compareTo(
					session.getNumber());
		}
		return compare;
	}
	
	void setNumberOfCredits(int numberOfCredits) {
		this.numberOfCredits = numberOfCredits;
	}
	
	public String getDepartment(){
		return course.department;
	}
	
	public String getNumber(){
		return course.number;
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
	
	public double averageGpaForPartTimeStudents() {
		double total = 0.0;
		int count = 0;
		
		for (Student student: students) {
			if (student.isFullTime()) {
				continue;
			}
			count++;
			total += student.getGpa();
		}
		return count == 0 ? 0.0 : total / count;
	}
	
	public Iterator<Student> iterator() {
		return students.iterator();
	}
	
	public void setUrl(String urlString) throws SessionException {
		try {
			this.url = new URL(urlString);
		}
		catch (MalformedURLException e) {
			log(e);
			throw new SessionException(e);
		}
	}
	
	public void log(Exception e) {
		e.printStackTrace();
	}
	
	public URL getUrl() {
		return url;
	}

}
