package model;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import model.Student;
import model.StudentCompare;

public class StudentCompareTest {
	@Test
	public void testSortByGroup() {
		List<Student> students = new ArrayList<Student>();
		List<Student> sortedStudents = new ArrayList<Student>();
		
		String studentRegNumber1 = "posh2134";
		String name1 = "Pop Oana";
		int group1 = 3;
		Student student1 = new Student(studentRegNumber1,name1,group1);
		students.add(student1);
		
		String studentRegNumber2 = "posh2135";
		String name2 = "Popa Oana";
		int group2 = 1;
		Student student2 = new Student(studentRegNumber2,name2,group2);
		students.add(student2);
		
		String studentRegNumber3 = "posh2136";
		String name3 = "Dan Oana";
		int group3 = 2;
		Student student3 = new Student(studentRegNumber3,name3,group3);
		students.add(student3);
		
		sortedStudents.add(student2);
		sortedStudents.add(student3);
		sortedStudents.add(student1);
		Collections.sort(students,new StudentCompare());
		assertEquals(sortedStudents,students);
		
	}
	
}
