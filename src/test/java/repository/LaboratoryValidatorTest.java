package test.java.repository;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Before;
import org.junit.Test;

import main.java.model.Laboratory;
import main.java.repository.LaboratoryValidator;
import main.java.repository.ValidationException;

public class LaboratoryValidatorTest {
	private LaboratoryValidator validator;
	
	@Before
	public void setUp() {
		 validator = new LaboratoryValidator();
	}
	
	@Test(expected=ValidationException.class)
	public void test1LaboratoryValidateMethod() throws ParseException {		
		int laboratoryNumber = -9;
		String dateString = "30/6/2017";
		int problemNumber = 8;
		String studentRegNumber = "paig0089";		
		Laboratory lab = new Laboratory(laboratoryNumber,dateString,problemNumber,studentRegNumber);
		validator.validate(lab);
	}
	
	@Test(expected=ValidationException.class)
	public void test2LaboratoryValidateMethod() throws ParseException {
		int laboratoryNumber = 9;
		String dateString = "20/1/2017";
		int problemNumber = 8;
		String studentRegNumber = "paig0089";		
		Laboratory lab = new Laboratory(laboratoryNumber,dateString,problemNumber,studentRegNumber);
		validator.validate(lab);
	}
	
	@Test(expected=ValidationException.class)
	public void test3LaboratoryValidateMethod() throws ParseException {		
		int laboratoryNumber = 9;
		String dateString = "30/6/2017";
		int problemNumber = 0;
		String studentRegNumber = "paig0089";		
		Laboratory lab = new Laboratory(laboratoryNumber,dateString,problemNumber,studentRegNumber);
		validator.validate(lab);
	}
	
	@Test(expected=ValidationException.class)
	public void test4LaboratoryValidateMethod() throws ParseException {
		int laboratoryNumber = 9;
		String dateString = "30/6/2017";
		int problemNumber = 24;
		String studentRegNumber = "paig0089";		
		Laboratory lab = new Laboratory(laboratoryNumber,dateString,problemNumber,studentRegNumber);
		validator.validate(lab);
	}
	
	@Test
	public void test5LaboratoryValidateMethod() throws ParseException {
		int laboratoryNumber = 11;
		String dateString = "30/6/2017";
		int problemNumber = 5;
		String studentRegNumber = "paig0089";		
		Laboratory lab = new Laboratory(laboratoryNumber,dateString,problemNumber,studentRegNumber);
		validator.validate(lab);
	}
	
	@Test(expected=ValidationException.class)
	public void test1LaboratoryValidateAddGradeMethode() {
		int labNumber = 3;
		Float grade = (float) -2;
		validator.validateAddGrade(grade, labNumber);	
	}
	
	@Test(expected=ValidationException.class)
	public void test2LaboratoryValidateAddGradeMethode() {
		int labNumber = 13;
		Float grade = (float) 13;
		validator.validateAddGrade(grade, labNumber);	
	}
	
	@Test(expected=ValidationException.class)
	public void test3LaboratoryValidateAddGradeMethode() {
		int labNumber = -3;
		Float grade = (float) 7;
		validator.validateAddGrade(grade, labNumber);	
	}
	
	@Test
	public void test4LaboratoryValidateAddGradeMethode() {
		int labNumber = 3;
		Float grade = (float) 7;
		validator.validateAddGrade(grade, labNumber);	
	}
}
