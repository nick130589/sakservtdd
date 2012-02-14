package com.sakserv;

import static org.junit.Assert.*;

import org.junit.Test;

public class StudentTest {

	@Test
	public void testCreate() {
		Student student = new Student("Jane Doe");
		String studentName = student.getName();
		assertEquals("Jane Doe", studentName);
		
		Student student2 = new Student("Joe Blow");
		String student2Name = student2.getName();
		assertEquals("Joe Blow", student2Name);
		
		assertEquals("Jane Doe", student.getName());
	}
}