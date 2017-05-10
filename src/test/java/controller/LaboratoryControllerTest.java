package controller;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.LaboratoryController;
import model.Laboratory;
import model.Student;
import repository.LaboratoryRepository;
import repository.RepositoryException;
import repository.StudentRepository;

public class LaboratoryControllerTest {

    private LaboratoryController labController;
    String file1="studTest1";
    String file2="labTest";
    
    @Before
    public void setUp() {
    	 labController = new LaboratoryController(file1,file2);
    }
    
    @After
    public void clean() throws FileNotFoundException {
    	PrintWriter writer = new PrintWriter(file1);
	    writer.print("");
	    writer.close();
	    PrintWriter writer2 = new PrintWriter(file2);
	    writer2.print("");
	    writer2.close();
    }
	
	@Test
	public void testSaveStudent() throws FileNotFoundException {   
	    String studentRegNumber = "zzzz2188";
		String name = "Pop Oana";
		int group = 234;
		Student student = new Student(studentRegNumber,name,group);
	    labController.saveStudent(student);
	    clean();
	}
	
	@Test
	public void test1SaveLaboratory() throws Exception {
	    String studentRegNumber = "posh2134";
		String name = "Pop Oana";
		int group = 234;
		Student student = new Student(studentRegNumber,name,group);
	    labController.saveStudent(student);
		
		int laboratoryNumber = 111111;
		String dateString = "30/6/2017";
		int problemNumber = 8;
		Float grade = (float) 8;
		studentRegNumber = "posh2134";		
		Laboratory lab = new Laboratory(laboratoryNumber,dateString,problemNumber,grade,studentRegNumber);
	    labController.saveLaboratory(lab);
	    clean();
	}

	/*
	@Test
	public void test2SaveLaboratory() throws Exception{	    
		
		
		int laboratoryNumber = 777;
		String dateString = "30/6/2017";
		int problemNumber = 8;
		Float grade = (float) 8;
		String studentRegNumber = "posh2134";		
		Laboratory lab = new Laboratory(laboratoryNumber,dateString,problemNumber,grade,studentRegNumber);
	    labController.saveLaboratory(lab);
	    clean();
	}
	*/
	
}
