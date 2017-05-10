package model;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Laboratory;
import model.Student;

public class StudentTest {

	@Test
	public void getStudent() {
		String studentRegNumber = "posh2134";
		String name = "Pop Oana";
		int group = 234;
		Student student = new Student(studentRegNumber,name,group);	
		assertEquals("Error in getStudent/getRegNumber",studentRegNumber,student.getRegNumber());
		assertEquals("Error in getStudent/getName",name,student.getName());
		assertEquals("Error in getStudent/getGroup",group,student.getGroup());
	}
	
	@Test
	public void setStudent() {
		Student student = new Student();
		
		String studentRegNumber = "mara0034";
		student.setRegNumber(studentRegNumber);
		assertEquals("Error in setStudent/setRegNumber",studentRegNumber,student.getRegNumber());
		
		String name = "Gogu Oana";
		student.setName(name);
		assertEquals("Error in setStudent/setName",name,student.getName());
		
		int group = 731;
		student.setGroup(group);
		assertEquals("Error in setStudent/setGroup",group,student.getGroup());
	}
	
	@Test
	public void studentToString() {
		String studentRegNumber = "paig0027";
		String name = "Andreea Popa";
		int group = 731;
		Student student = new Student(studentRegNumber,name,group);		
		assertEquals("paig0027 Andreea Popa 731",student.toString());
	}
	
	@Test
	public void hashCode1() {
		String studentRegNumber = "paig0027";
		String name = "Andreea Popa";
		int group = 731;
		Student student = new Student(studentRegNumber,name,group);
		assertEquals(917434291,student.hashCode());
	}
	
	@Test
	public void hashCode2() {
		String studentRegNumber = "";
		String name = "Andreea Popa";
		int group = 731;
		Student student = new Student(studentRegNumber,name,group);
		assertEquals(31,student.hashCode());
	}
	
	@Test
	public void test1Equals() {
		String studentRegNumber1 = "paig0027";
		String name1 = "Andreea Popa";
		int group1 = 731;
		Student student1 = new Student(studentRegNumber1,name1,group1);
		
		String studentRegNumber2 = "paig0027";
		String name2 = "Andreea Popa";
		int group2 = 731;
		Student student2 = new Student(studentRegNumber2,name2,group2);
		
		assertTrue(student1.equals(student2));
	}
	
	@Test
	public void test2Equals() {
		String studentRegNumber1 = "paig0027";
		String name1 = "Andreea Popa";
		int group1 = 731;
		Student student1 = new Student(studentRegNumber1,name1,group1);		
		assertFalse(student1.equals(null));
	}
	
	@Test
	public void test3Equals() {
		String studentRegNumber1 = "paig0027";
		String name1 = "Andreea Popa";
		int group1 = 731;
		Student student1 = new Student(studentRegNumber1,name1,group1);	
		Laboratory lab = new Laboratory();
		assertFalse(student1.equals(lab));
	}
	
	@Test
	public void test4Equals() {
		String studentRegNumber1 = "";
		String name1 = "Andreea Popa";
		int group1 = 731;
		Student student1 = new Student(studentRegNumber1,name1,group1);
		
		String studentRegNumber2 = "paig0027";
		String name2 = "Andreea Popa";
		int group2 = 731;
		Student student2 = new Student(studentRegNumber2,name2,group2);
		assertFalse(student1.equals(student2));
	}
	
	@Test
	public void test5Equals() {
		String studentRegNumber1 = null;
		String name1 = "Andreea Popa";
		int group1 = 731;
		Student student1 = new Student(studentRegNumber1,name1,group1);
		
		String studentRegNumber2 = null;
		String name2 = "Andreea Popa";
		int group2 = 731;
		Student student2 = new Student(studentRegNumber2,name2,group2);
		assertTrue(student1.equals(student2));
	}
	
	@Test
	public void test6Equals() {
		String studentRegNumber1 = null;
		String name1 = "Andreea Popa";
		int group1 = 731;
		Student student1 = new Student(studentRegNumber1,name1,group1);
		
		String studentRegNumber2 = "paig0027";
		String name2 = "Andreea Popa";
		int group2 = 731;
		Student student2 = new Student(studentRegNumber2,name2,group2);
		assertFalse(student1.equals(student2));
	}
}
