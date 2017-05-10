package repository;

import model.Laboratory;
import model.Student;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class LaboratoryValidator implements Validator<Laboratory> {

	@Override
	public void validate(Laboratory laboratory) throws ValidationException {
		StringBuffer errorMsg=new StringBuffer();	
		// patterns and constrains
		if(laboratory.getLaboratoryNumber() < 1) {
            errorMsg.append("The laboratory number has to be greater than zero!");
        }
		if(laboratory.getProblemNumber() > 10 || laboratory.getProblemNumber() < 1) {
            errorMsg.append("\nInvalid problem number!");
        }
        Date date = new Date();
        if(date.after(laboratory.getAssignmentDate())) {
            errorMsg.append("\nInvalid date!");
        }
               
        if (errorMsg.length()>0) {
            throw new ValidationException(errorMsg.toString());
        }	
	}
	
	public void validateAddGrade(float grade, int labNumber)  throws ValidationException{
		StringBuffer errorMsg=new StringBuffer();
        if(grade < 0 || grade > 10) {
        	errorMsg.append("The grade must be >0 and <=10!");
        }
        if(labNumber < 1) {
            errorMsg.append("The laboratory number has to be greater than zero!");
        }
        
        if (errorMsg.length()>0) {
            throw new ValidationException(errorMsg.toString());
        }
    }
} 