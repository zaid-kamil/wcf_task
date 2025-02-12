package com.mile1.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mile1.bean.Student;
import com.mile1.exception.NullMarksArrayException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullStudentException;
import com.mile1.service.StudentReport;
import com.mile1.service.StudentService;

public class StudentTest {

	StudentReport studentReport = new StudentReport();
	StudentService studentService = new StudentService();

	// TC1: Test A grade computation
	@Test
	public void testGradeA() throws NullMarksArrayException, NullNameException, NullStudentException {
		Student student = new Student("John", new int[] { 80, 75, 87 });
		assertEquals("A", studentReport.findGrades(student));
	}

	// TC2: Test D grade computation
	@Test
	public void testGradeD() throws NullMarksArrayException, NullNameException, NullStudentException {
		Student student = new Student("Smith", new int[] { 40, 40, 40 });
		assertEquals("D", studentReport.findGrades(student));
	}

	// TC3: Test F grade computation
	@Test
	public void testGradeF() throws NullMarksArrayException, NullNameException, NullStudentException {
		Student student = new Student("Jane", new int[] { 30, 30, 12 });
		assertEquals("F", studentReport.findGrades(student));
	}

	// TC4: Test null student object
	@Test(expected = NullStudentException.class)
	public void testNullStudent() throws NullStudentException, NullMarksArrayException, NullNameException {
		studentReport.validate(null);
	}

	// TC5: Test null name
	@Test(expected = NullNameException.class)
	public void testNullName() throws NullMarksArrayException, NullNameException, NullStudentException {
		Student student = new Student(null, new int[] { 85, 85, 85 });
		studentReport.validate(student);
	}

	// TC6: Test null marks array
	@Test(expected = NullMarksArrayException.class)
	public void testNullMarksArray() throws NullMarksArrayException, NullNameException, NullStudentException {
		Student student = new Student("John", null);
		studentReport.validate(student);
	}

	// TC7: Test counting null names
	@Test
	public void testNullNameCount() {
		Student[] students = new Student[] { new Student("John", new int[] { 85, 85, 85 }),
				new Student(null, new int[] { 85, 85, 85 }), new Student(null, new int[] { 85, 85, 85 }) };
		assertEquals(2, studentService.findNumberOfNullName(students));
	}

	// TC8: Test counting null objects
	@Test
	public void testNullObjectCount() {
		Student[] students = new Student[] { new Student("John", new int[] { 85, 85, 85 }), null, null };
		assertEquals(2, studentService.findNumberOfNullObjects(students));
	}

	// TC9: Test counting null marks arrays
	@Test
	public void testNullMarksCount() {
		Student[] students = new Student[] { new Student("John", new int[] { 85, 85, 85 }), new Student("Smith", null),
				new Student("Jane", null) };
		assertEquals(2, studentService.findNumberOfNullMarksArray(students));
	}
}