package com.sakserv.sis.studentinfo.summer;

import java.util.Date;

import com.sakserv.sis.studentinfo.Session;

public class SummerCourseSession extends Session {

	public static SummerCourseSession create(String departmentCode,
			String courseNumber, Date startDate) {
		return new SummerCourseSession(departmentCode, courseNumber,
				startDate);
	}
	
	private SummerCourseSession(String departmentCode, String courseNumber,
			Date startDate) {
		super(departmentCode, courseNumber, startDate);
	}
	
	protected int getSessionLength() {
		return 8;
	}
	
}
