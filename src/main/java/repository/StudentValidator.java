package main.java.repository;

import main.java.model.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StudentValidator implements Validator<Student> {
	
	@Override
    public void validate(Student student) throws ValidationException {
			StringBuffer errorMsg=new StringBuffer();		
			// patterns and constrains
	        if (!student.getRegNumber().matches("[a-zA-Z]{4}[\\d]{4}")) {
	            errorMsg.append("The student registration number is invalid!");
	        }
	        if (!student.getName().matches("[a-zA-Z]+[\\s]?[a-zA-Z]+[\\s]?[a-zA-Z]+") || !student.getName().contains(" ")) {
	            errorMsg.append("\nThe student name is invalid!");
	        }
	        if (student.getGroup() >= 1000 || student.getGroup() <= 0) {
	            errorMsg.append("\nThe student group is invalid!");
	        }
	        
	        if (errorMsg.length()>0) {
	            throw new ValidationException(errorMsg.toString());
	        }
    }
} 