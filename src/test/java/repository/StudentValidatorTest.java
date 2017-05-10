package test.java.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import main.java.model.Student;
import main.java.repository.LaboratoryValidator;
import main.java.repository.RepositoryException;
import main.java.repository.StudentValidator;
import main.java.repository.ValidationException;


public class StudentValidatorTest {
	private StudentValidator validator;
	
	@Before
	public void setUp() {
		 validator = new StudentValidator();
	}
	
	
	@Test(expected=ValidationException.class)
	public void test1StudentValidateMethodRegNumber() {
		Student student = new Student("3paig1111","Ion Pop",223);
		validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test2StudentValidateMethodRegNumber() {
		Student student = new Student("67+i","Ion Pop",223);
		validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test3StudentValidateMethodRegNumber() {
		StudentValidator validator = new StudentValidator();
		Student student = new Student("67+i d","Ion Pop",223);
			validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test4StudentValidateMethodRegNumber() {
		Student student = new Student("67+i d","Ion Pop",223);
		validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test5StudentValidateMethodRegNumber() {
		Student student = new Student("","Ion Pop",223);
		validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test1StudentValidateMethodName() {
		Student student = new Student("paig1111","Ion",223);
		validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test2StudentValidateMethodName() {
		StudentValidator validator = new StudentValidator();
		Student student = new Student("paig1111","Io+n",223);
		validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test3StudentValidateMethodName() {
		Student student = new Student("paig1111","Ion +0 l",223);
		validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test4StudentValidateMethodName() {
		Student student = new Student("paig1111","",223);
		validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test1StudentValidateMethodGroup() {
		Student student = new Student("paig1111","Ion",2233);
		validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test2StudentValidateMethodGroup() {
		Student student = new Student("paig1111","Ion",-9);
			validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test3StudentValidateMethodGroup() {
		Student student = new Student("paig1111","Ion",0);
			validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test1StudentValidateMethod() {
		Student student = new Student("4paig1111 r","Ion",-9);
			validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test2StudentValidateMethod() {;
		Student student = new Student("","",100);
			validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test3StudentValidateMethod() {
		Student student = new Student("","Ion",-9);
			validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test4StudentValidateMethod() {
		Student student = new Student("","Ion Ana",9);
			validator.validate(student);		
	}
	
	@Test(expected=ValidationException.class)
	public void test5StudentValidateMethod() {
		Student student = new Student("","Ion Ana",7890);
			validator.validate(student);		
	
	}
	
	@Test
	public void test6StudentValidateMethod() {
		Student student = new Student("paig0027","Ion Ana",123);
			validator.validate(student);		
	}
	
	@Test
	public void test7StudentValidateMethod() {
		Student student = new Student("sdie0234","Mihai Anton Jr",6);
			validator.validate(student);		
	}	
}
