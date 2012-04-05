package com.sakserv.sis.studentinfo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sakserv.sis.report.HonorsGradingStrategy;

public class StudentTest {
	
	private final String FIRST_STUDENT_NAME = "Jane Doe";
	private final int FIRST_STUDENT_HOURS = 3;
	
	private final String SECOND_STUDENT_NAME = "Joe Blow";
	private final int SECOND_STUDENT_HOURS = 5;
	
	private Student firstStudent, secondStudent;
	
	private static final double GRADE_TOLERANCE = 0.05;
	
	@Before
	public void setUp() {
		firstStudent = new Student(FIRST_STUDENT_NAME);
		secondStudent = new Student(SECOND_STUDENT_NAME);
	}
	
	@Test
	public void testCreate() {
		assertEquals("Jane Doe", firstStudent.getName());
		assertEquals("Joe Blow", secondStudent.getName());
		assertEquals("Jane Doe", firstStudent.getName());
	}
	
	@Test
	public void testAddCreditHours() {
		assertEquals(0, firstStudent.getCreditHours());
	
		firstStudent.addCreditHours(FIRST_STUDENT_HOURS);
		assertEquals(3, firstStudent.getCreditHours());
		
		firstStudent.addCreditHours(FIRST_STUDENT_HOURS + FIRST_STUDENT_HOURS);
		assertEquals(9, firstStudent.getCreditHours());
		
		firstStudent.addCreditHours(FIRST_STUDENT_HOURS);
		assertEquals(12, firstStudent.getCreditHours());
		
		assertEquals(0, secondStudent.getCreditHours());
		secondStudent.addCreditHours(SECOND_STUDENT_HOURS);
		assertEquals(5, secondStudent.getCreditHours());
		
		assertTrue(firstStudent.isFullTime());
		assertFalse(secondStudent.isFullTime());
	}
	
	@Test
	public void testInState() {
		assertFalse(firstStudent.isInState());
		firstStudent.setResidentState(Student.IN_STATE);
		assertTrue(firstStudent.isInState());
		firstStudent.setResidentState("MD");
		assertFalse(firstStudent.isInState());
		
		firstStudent.setResidentState("co");
		assertTrue(firstStudent.isInState());
	}
	
	@Test
	public void testCalculateGpa() {
		assertGpa(firstStudent, 0.0);
		
		firstStudent.addGrade(Student.Grade.A);		
		assertGpa(firstStudent, 4.0);
		
		firstStudent.addGrade(Student.Grade.B);
		assertGpa(firstStudent, 3.5);
		
		firstStudent.addGrade(Student.Grade.C);
		assertGpa(firstStudent, 3.0);
		
		firstStudent.addGrade(Student.Grade.D);
		assertGpa(firstStudent, 2.5);
		
		firstStudent.addGrade(Student.Grade.F);
		assertGpa(firstStudent, 2.0);
	}
	
	@Test
	public void testCalculateHonorsStudentGpa() {
		assertGpa(createHonorsStudent(), 0.0);
		assertGpa(createHonorsStudent(Student.Grade.A), 5.0);
		assertGpa(createHonorsStudent(Student.Grade.B), 4.0);
		assertGpa(createHonorsStudent(Student.Grade.C), 3.0);
		assertGpa(createHonorsStudent(Student.Grade.D), 2.0);
		assertGpa(createHonorsStudent(Student.Grade.F), 0.0);
	}
	
	@Test
	@SuppressWarnings("all")
	public void testCasting() {
		List students = new ArrayList();
		students.add(new Student("a"));
		students.add(new Student("b"));
		
		List names = new ArrayList();
		Iterator it = students.iterator();
		while (it.hasNext()) {
			Student student = (Student)it.next();
			names.add(student.getLastName());
		}
		
		assertEquals("a", names.get(0));
		assertEquals("b", names.get(1));
	}
	
	@Test
	public void testCharges() {
		Student student = new Student("a");
		student.addCharge(500);
		student.addCharge(200);
		student.addCharge(399);
		assertEquals(1099, student.totalCharges());
	}
	
	@Test
	public void testBadlyFormattedName() {
		final String studentName = "a b c d";
		try {
			new Student(studentName);
			fail("Expected StudentNameFormatException on 4 part name");
		}
		catch (StudentNameFormatException expectedException) {
			assertEquals(String.format(Student.TOO_MANY_NAME_PARTS_MSG,
					studentName, Student.MAX_NAME_PARTS), 
					expectedException.getMessage());
		}
	}
	
	private Student createHonorsStudent(Student.Grade grade) {
		Student student = createHonorsStudent();
		student.addGrade(grade);
		return student;
	}
	
	private Student createHonorsStudent() {
		Student student = new Student("a");
		student.setGradingStrategy(new HonorsGradingStrategy());
		return student;
	}
	
	private void assertGpa(Student student, double expectedGpa) {
		assertEquals(expectedGpa, student.getGpa(), 
				StudentTest.GRADE_TOLERANCE);
	}
}