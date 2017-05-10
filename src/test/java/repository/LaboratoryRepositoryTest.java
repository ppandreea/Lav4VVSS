package test.java.repository;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.java.model.Laboratory;
import main.java.model.Student;
import main.java.repository.LaboratoryRepository;
import main.java.repository.RepositoryException;
import main.java.repository.StudentRepository;

public class LaboratoryRepositoryTest {
	
	private LaboratoryRepository labRepo;
	String file1="labTest";
	
	@Before
	public void setUp() {
		labRepo = new LaboratoryRepository(file1);
	}
	
	@After
    public void clean() throws FileNotFoundException {
    	PrintWriter writer = new PrintWriter(file1);
	    writer.print("");
	    writer.close();
    }

	@Test
	public void getLaboratoryRepository() {
		String file = "labTest";
		LaboratoryRepository labRepo = new LaboratoryRepository(file);
		assertEquals(file,labRepo.getFile());
	}
	
	@Test
	public void setLaboratoryRepository() {
		LaboratoryRepository labRepo = new LaboratoryRepository();
		String file = "labTest";
		labRepo.setFile(file);
		assertEquals(file,labRepo.getFile());
	}
		
	@Test
	public void test1SaveLaboratory() throws ParseException, FileNotFoundException {
		int laboratoryNumber = 28;
		String dateString = "30/6/2017";
		int problemNumber = 8;
		Float grade = (float) 8;
		String studentRegNumber = "paig0027";		
		Laboratory laboratory = new Laboratory(laboratoryNumber,dateString,problemNumber,grade,studentRegNumber);
		labRepo.saveLaboratory(laboratory);
		clean();
	}

	@Test
	public void test2SaveLaboratory() throws ParseException, FileNotFoundException {
		int laboratoryNumber = 28;
		String dateString = "30/6/2017";
		int problemNumber = 8;
		Float grade = (float) 8;
		String studentRegNumber = "paig0027";		
		Laboratory laboratory = new Laboratory(laboratoryNumber,dateString,problemNumber,grade,studentRegNumber);
		labRepo.saveLaboratory(laboratory);
		clean();
	}

	@Test
	public void test1FindOneLaboratory() throws ParseException, FileNotFoundException {		
		int laboratoryNumber = 10;
		String dateString = "30/6/2017";
		int problemNumber = 8;
		Float grade = (float) 9;
		String studentRegNumber = "paig0027";		
		Laboratory laboratory = new Laboratory(laboratoryNumber,dateString,problemNumber,grade,studentRegNumber);
		labRepo.saveLaboratory(laboratory);
		
		laboratoryNumber = 10;
		studentRegNumber = "paig0027";
	//	assertTrue(labRepo.findOne(laboratoryNumber,studentRegNumber));
		clean();
	}
	
	@Test
	public void test2FindOneLaboratory() {
		int laboratoryNumber = 34;
		String studentRegNumber = "paig0027";
		assertFalse(labRepo.findOne(laboratoryNumber,studentRegNumber));
	}
/*	
	@Test
	public void test1AddGrade() throws NumberFormatException, IOException, ParseException {		
		int laboratoryNumber = 11;
		String studentRegNumber = "paig0027";
		Float grade = (float) 10;
		labRepo.addGrade(studentRegNumber, laboratoryNumber, grade);
		
	}
	
	@Test(expected=RepositoryException.class)
	public void test2AddGrade() throws NumberFormatException, IOException, ParseException {
		int laboratoryNumber = 111;
		String studentRegNumber = "paig0027";
		Float grade = (float) 10;
		labRepo.addGrade(studentRegNumber, laboratoryNumber, grade);
		
	}
	*/
}
