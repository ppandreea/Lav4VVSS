package model;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import model.Laboratory;

public class LaboratoryTest {
	private Laboratory lab1;
	private Laboratory lab2;
	private int laboratoryNumber;
	private String dateLab;
	private int problemNumber;
	private String studentRegNumber;
	private Float grade;
	
    @Before
    public void setUp() throws ParseException{
		laboratoryNumber = 8;
		dateLab = "30/3/2017";
		problemNumber = 5;
		studentRegNumber = "paig0027";
        lab1 = new Laboratory(laboratoryNumber,dateLab,problemNumber,studentRegNumber);
    }
    
	@Before
	public void setUpGrade() throws ParseException {
		grade = (float) 8;
		lab2 = new Laboratory(laboratoryNumber,dateLab,problemNumber,grade,studentRegNumber);
	}

	@Test
	public void getLaboratoryNumber() {		
		assertEquals("Error in getLaboratoryNumber",laboratoryNumber,lab1.getLaboratoryNumber());	
		lab1.setLaboratoryNumber(5);
		assertEquals("Error in getLaboratoryNumber",5,lab1.getLaboratoryNumber());
	}
	
	@Test
	public void getAssignmentDate() throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = format.parse(dateLab);
		assertEquals("Error in getAssignmentDate",date1,lab1.getAssignmentDate());		
		String dateString = "30/6/2017";
        Date date2 = format.parse(dateString);
		lab1.setAssignmentDate(date2);
		assertEquals("Error in getAssignmentDate",date2,lab1.getAssignmentDate());	
	}
	
	@Test
	public void getProblemNumber() {
		assertEquals("Error in getProblemNumber",problemNumber,lab1.getProblemNumber());	
		lab1.setProblemNumber(2);
		assertEquals("Error in getProblemNumber",2,lab1.getProblemNumber());
	}
	
	@Test
	public void getStudentRegNumber() {		
		assertEquals("Error in getStudentRegNumber",studentRegNumber,lab1.getStudentRegNumber());	
		lab1.setStudentRegNumber("paig0028");
		assertEquals("Error in getStudentRegNumber","paig0028",lab1.getStudentRegNumber());
	}
	
	@Test
	public void getGrade() {	
		assertEquals("Error in getGrade",grade,lab2.getGrade());
		Float testGrade = (float) 5;
		lab2.setGrade(testGrade);
		assertEquals("Error in getGrade",testGrade,lab2.getGrade());
	}
	
	@Test
	public void setLaboratoryNumber() {
		int labNumberTest = 10;
		lab1.setLaboratoryNumber(labNumberTest);
		assertEquals("Error in setLaboratoryNumber",labNumberTest,lab1.getLaboratoryNumber());
		labNumberTest = 1;
		lab1.setLaboratoryNumber(labNumberTest);
		assertEquals("Error in setLaboratoryNumber",labNumberTest,lab1.getLaboratoryNumber());			
	}
	
	@Test
	public void setProblemNumber() {
		int problemNumberTest = 10;
		lab1.setProblemNumber(problemNumberTest);
		assertEquals("Error in setProblemNumber",problemNumberTest,lab1.getProblemNumber());
		problemNumberTest = 1;
		lab1.setProblemNumber(problemNumberTest);
		assertEquals("Error in setProblemNumber",problemNumberTest,lab1.getProblemNumber());			
	}
	
	@Test
	public void setStudentRegNumber() {
		String studentRegNumberTest = "aaen0910";
		lab1.setStudentRegNumber(studentRegNumberTest);
		assertEquals("Error in setProblemNumber",studentRegNumberTest,lab1.getStudentRegNumber());
		studentRegNumberTest = "aaen4564";
		lab1.setStudentRegNumber(studentRegNumberTest);
		assertEquals("Error in setProblemNumber",studentRegNumberTest,lab1.getStudentRegNumber());			
	}
	
	
	@Test
	public void laboratoryToString() throws ParseException {
		laboratoryNumber = 4;
		dateLab = "30/6/2017";
		problemNumber = 8;
		grade = (float) 8;
		studentRegNumber = "paig0089";		
		Laboratory lab = new Laboratory(laboratoryNumber,dateLab,problemNumber,grade,studentRegNumber);
		assertEquals("4 30/6/2017 8 8.0 paig0089",lab.toString());
	}
}
