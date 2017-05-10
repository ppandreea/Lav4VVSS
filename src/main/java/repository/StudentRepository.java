package main.java.repository;

import main.java.model.Student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository {

    private String file;

    public StudentRepository(String file) {
        this.file = file;
    }

    public StudentRepository() {}

	public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void saveStudent(Student student) {
    	StudentValidator validator = new StudentValidator();
    	try {
            validator.validate(student);
            try {
            	if (!findOne(student.getRegNumber())) {     		
            		BufferedWriter writer;
            		writer = new BufferedWriter(new FileWriter(file, true));
            		writer.write("\n"+student.toString());
            		writer.close();
            	}
            	else {
            		throw new RepositoryException("A student with this registration number already exists!");
            	}            	
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }      
        } catch(ValidationException ex){
            System.err.println(ex.getMessage());
        }	
    }
    
    public boolean findOne(String regNumber) {
    	BufferedReader reader = null;
		try {			
			reader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		}
        String line = null;
			try {
				while ((line = reader.readLine()) != null) {
				    if (line.split(" ")[0].equals(regNumber)) {
				    	return true;
				    }
				}
			} catch (IOException e) {
				System.err.println(e.getMessage());
			} 	   	
    	return false;
    }


    public List<Student> getStudentsList() throws NumberFormatException,
            IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        List<Student> allStudentsList = new ArrayList<Student>();
        String line = null;
        while ((line = reader.readLine()) != null) {
            String[] temp = line.split(" ");
            String name = "";
            for(int i=1; i<temp.length-1; i++) {
            	name+=temp[i]+" ";
            }            		
            Student student = new Student(temp[0], name, Integer.valueOf(temp[temp.length-1]));
            allStudentsList.add(student);
        }
        reader.close();
        return allStudentsList;
    }

} 