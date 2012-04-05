package com.sakserv.sis.studentinfo;

import java.util.Date;


/**
 * Provides a representation of a single-semester
 * session of a specific university course.
 * @author Shane Kumpf
 *
 */
public class CourseSession extends Session {
	
	// Class
	private static int count = 0;
	
	// Factory
	public static CourseSession create(Course course, Date startDate) {
		incrementCount();
		return new CourseSession(course, startDate);
	}
	
	protected CourseSession(Course course, Date startDate) {
		super(course, startDate);
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
	
	protected int getSessionLength() {
		return 16;
	}	
}