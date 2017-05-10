package repository;

import model.Laboratory;
import model.Student;
import model.Laboratory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LaboratoryRepository {

    private String file;
    
    public LaboratoryRepository(String file) {
        this.file = file;
    }

    public LaboratoryRepository() {}

	public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public void saveLaboratory(Laboratory laboratory) throws RepositoryException {
    	LaboratoryValidator validator = new LaboratoryValidator();
    	try {
            validator.validate(laboratory);
            try {
            	
            	if (!findOne(laboratory.getLaboratoryNumber(),laboratory.getStudentRegNumber())) {     		
            		BufferedWriter writer;
            		writer = new BufferedWriter(new FileWriter(file, true));
            		writer.write("\n"+laboratory.toString());
            		writer.close();
            	}
            	else {
            		throw new RepositoryException("Laboratory already assigned!");
            	}            	
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }      
        } catch(ValidationException ex){
            System.err.println(ex.getMessage());
        }	
    }
    
    public boolean findOne(int labNumber, String studentRegNumber) {
    	BufferedReader reader = null;
        try {			
        	reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
        	System.err.println(e);
        }
        String line = null;
		try {
			while ((line = reader.readLine()) != null) {
			    if (Integer.parseInt(line.split(" ")[0]) == labNumber && line.split(" ")[4].equals(studentRegNumber)) {
			    	return true;
			    }
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		} 
		return false;
    }

    public void addGrade(String studentRegNumber, int labNumber, float grade)
            throws IOException, NumberFormatException, ParseException, RepositoryException {
    	LaboratoryValidator validator = new LaboratoryValidator();
    	try {
    		validator.validateAddGrade(grade,labNumber);    		
    		if (findOne(labNumber,studentRegNumber)) { 
    	        List<String> laboratories = new ArrayList<String>(Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8));
    	        for (int i = 0; i < laboratories.size(); i++) {
    	            String[] temp = laboratories.get(i).split(" ");
    	            String fileLabNumber = temp[0];
    	            String fileStudentNumber = temp[4];
    	            if (Integer.parseInt(fileLabNumber)==labNumber && fileStudentNumber.equals(studentRegNumber)) {
    	                Laboratory laboratory = new Laboratory(
    	                        Integer.valueOf(temp[0]), temp[1],
    	                        Integer.valueOf(temp[2]), temp[4]);
    	                laboratory.setGrade(grade);
    	                laboratories.set(i,laboratory.toString());
    	                break;
    	            }
    	        }
    	        Files.write(Paths.get(file), laboratories, StandardCharsets.UTF_8);
        	}
        	else {
        		throw new RepositoryException("This laboratory is not assigned!");
        	}       
        
    	} catch(ValidationException ex){
            System.err.println(ex.getMessage());
        }	
    }

    public Map<String, List<Laboratory>> getLaboratoryMap()
            throws NumberFormatException, IOException, ParseException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Map<String, List<Laboratory>> laboratoryMap = new HashMap<String, List<Laboratory>>();

        String line;

        while ((line = reader.readLine()) != null) {
            String[] temp = line.split(" ");
            Laboratory laboratory = new Laboratory(Integer.valueOf(temp[0]),
                    temp[1], Integer.valueOf(temp[2]), Float.valueOf(temp[3]),
                    temp[4]);
            if (laboratoryMap.get(laboratory.getStudentRegNumber()) == null) {
                List<Laboratory> laboratoryList = new ArrayList<Laboratory>();
                laboratoryList.add(laboratory);
                laboratoryMap.put(laboratory.getStudentRegNumber(),
                        laboratoryList);
            } else {
                laboratoryMap.get(laboratory.getStudentRegNumber()).add(
                        laboratory);
            }
        }
        return laboratoryMap;
    }
} 