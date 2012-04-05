package com.sakserv.sis.studentinfo.summer;

import java.util.Date;

import com.sakserv.sis.studentinfo.Course;
import com.sakserv.sis.studentinfo.Session;

public class SummerCourseSession extends Session {

	public static SummerCourseSession create(String departmentCode,
			String courseNumber, Date startDate) {
		return new SummerCourseSession(new Course(departmentCode, courseNumber),
				startDate);
	}
	
	private SummerCourseSession(Course course, Date startDate) {
		super(course, startDate);
	}
	
	protected int getSessionLength() {
		return 8;
	}
	
}
