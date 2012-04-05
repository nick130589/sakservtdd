package com.sakserv.sis.studentinfo;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StudentDirectoryTest {

	private StudentDirectory dir;
	
	@Before
	public void setUp() {
		dir = new StudentDirectory();
	}
	
	@Test
	public void testStoreAndRetrieve() throws IOException {
		final int numberOfStudents = 10;
		
		for (int i = 0; i < numberOfStudents; i++) {
			addStudent(dir, i);
		}
		
		for (int i = 0; i < numberOfStudents; i++) {
			verifyStudentLookup(dir, i);
		}
	}
	
	void addStudent(StudentDirectory directory, int count) {
		String id = "" + count;
		Student student = new Student(id);
		student.setId(id);
		student.addCreditHours(count);
		directory.add(student);
	}
	
	void verifyStudentLookup(StudentDirectory directory, int count) {
		String id = "" + count;
		Student student = dir.findById(id);
		assertEquals(id, student.getLastName());
		assertEquals(id, student.getId());
		assertEquals(count, student.getCreditHours());
	}

}
