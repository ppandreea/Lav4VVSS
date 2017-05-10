package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import model.Laboratory;
import model.Student;
import model.StudentCompare;
import repository.LaboratoryRepository;
import repository.RepositoryException;
import repository.StudentRepository;
import repository.ValidationException;
import repository.LaboratoryRepository;

public class LaboratoryController {

    private StudentRepository studentRepo;
    private LaboratoryRepository labRepo;

    public LaboratoryController(String studentFile, String laboratoryFile) {
    	this.studentRepo = new StudentRepository(studentFile);
    	this.labRepo = new LaboratoryRepository(laboratoryFile);
    }
    
    public void saveStudent(Student student){
    	try {
    		this.studentRepo.saveStudent(student);
    	} catch(RepositoryException ex){
            System.err.println(ex.getMessage());
        }	
     }

    public void saveLaboratory(Laboratory laboratory) throws Exception{
    	try {
    		if(studentRepo.findOne(laboratory.getStudentRegNumber())) {
    			this.labRepo.saveLaboratory(laboratory);
    		}
    		else {
    			throw new Exception("There is no student with this registration number!");
    		}    			
    	} catch(RepositoryException ex){
            System.err.println(ex.getMessage());
        }	
    }
    
    public void addGrade(String studentRegNumber, int labNumber, float grade)
            throws Exception {
    	try {
    		if(studentRepo.findOne(studentRegNumber)) {
    			this.labRepo.addGrade(studentRegNumber, labNumber, grade);
    		}
    		else {
    			throw new Exception("There is no student with this registration number!");
    		}    			
    	} catch(IOException|RepositoryException|NumberFormatException|ParseException ex){
            System.err.println(ex.getMessage());
        }	
    }

    public List<Student> passedStudents() throws NumberFormatException,
            IOException, ParseException {
        Map<String, List<Laboratory>> laboratoryMap = this.labRepo.getLaboratoryMap();
        List<Student> studentsList = studentRepo.getStudentsList();

        List<Student> passedStudents = new ArrayList<>();
        Entry<String, List<Laboratory>> entry;
        
        Set<Entry<String, List<Laboratory>>> entrySet = laboratoryMap.entrySet();
        Iterator<Entry<String, List<Laboratory>>> iterator = entrySet.iterator();
        
        while (iterator.hasNext()) {
            entry = iterator.next();
            float midGrade = entry.getValue().get(0).getGrade();
            for (Laboratory laboratory : entry.getValue()) {
                midGrade = (midGrade + laboratory.getGrade()) / 2;
            }
            //System.out.println(midGrade);
            if (midGrade >= 5) {
                Student student = new Student();
                student.setRegNumber(entry.getKey());
                int indexOf = studentsList.indexOf(student);
                passedStudents.add(studentsList.get(indexOf));
            }
        }
        
        Collections.sort(passedStudents,new StudentCompare());
        return passedStudents;
        
    }
} 