package test.java.repository;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.model.Student;
import main.java.repository.LaboratoryValidator;
import main.java.repository.RepositoryException;
import main.java.repository.StudentRepository;
import main.java.repository.ValidationException;

public class StudentRepositoryTest {
	
	private StudentRepository studentRepoTest;
	String file1="studTest1";
	
	@Before
	public void setUpTest1() {
		studentRepoTest = new StudentRepository(file1);
	}
	
	@After
    public void clean() throws FileNotFoundException {
    	PrintWriter writer = new PrintWriter(file1);
	    writer.print("");
	    writer.close();
    }
	
	@Test
	public void testGetStudentRepository() {
		String file = "studTest1";
		StudentRepository studentRepo = new StudentRepository(file);
		assertEquals(file,studentRepo.getFile());
		
	}
	
	@Test
	public void testSetStudentRepository() {
		StudentRepository studentRepo = new StudentRepository();
		String file = "src/main/resources/students.txt";
		studentRepo.setFile(file);
		assertEquals(file,studentRepo.getFile());
	}
	
	@Test
	public void test1SaveStudent() throws FileNotFoundException {
		String studentRegNumber = "poss2555";
		String name = "Pop Oana";
		int group = 234;
		Student student = new Student(studentRegNumber,name,group);
		studentRepoTest.saveStudent(student);
		clean();
	}

	@Test(expected=RepositoryException.class)
	public void test2SaveStudent() throws FileNotFoundException {	
		String studentRegNumber = "posh2134";
		String name = "Pop Oana";
		int group = 234;
		Student student = new Student(studentRegNumber,name,group);
		studentRepoTest.saveStudent(student);
		studentRepoTest.saveStudent(student);
		clean();
	}

	@Test
	public void test1FindOneStudent() throws FileNotFoundException {
		String studentRegNumber = "posh2134";
		String name = "Pop Oana";
		int group = 234;
		Student student = new Student(studentRegNumber,name,group);
		studentRepoTest.saveStudent(student);
		
		assertTrue(studentRepoTest.findOne(studentRegNumber));
		clean();
	}
	
	@Test
	public void test2FindOneStudent() {
		String studentRegNumber = "posh0000";
		assertFalse(studentRepoTest.findOne(studentRegNumber));
	}
/*	
	@Test
	public void test1GetAllStudents() throws NumberFormatException, IOException {	
		List<Student> students = new ArrayList<Student>();
		
		String studentRegNumber1 = "posh2134";
		String name1 = "Pop Oana";
		int group1 = 234;
		Student student1 = new Student(studentRegNumber1,name1,group1);
		students.add(student1);
		studentRepoTest.saveStudent(student1);
		
		String studentRegNumber2 = "posh2135";
		String name2 = "Popa Ioana";
		int group2 = 23;
		Student student2 = new Student(studentRegNumber2,name2,group2);
		students.add(student2);
		studentRepoTest.saveStudent(student2);
		
		String studentRegNumber3 = "posh2136";
		String name3 = "Popa Oana";
		int group3 = 734;
		Student student3 = new Student(studentRegNumber3,name3,group3);
		students.add(student3);
		studentRepoTest.saveStudent(student3);
		
		assertEquals(students,studentRepoTest.getStudentsList());
		clean();
		
	}
	*/
	@Test(expected=Exception.class)
	public void test2GetAllStudents() throws NumberFormatException, IOException {
		studentRepoTest.setFile("testDummy");
		studentRepoTest.getStudentsList();
		
		}
	
}
