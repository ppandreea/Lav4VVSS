package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import controller.LaboratoryController;
import model.Laboratory;
import model.Student;
import repository.StudentValidator;

//import com.sun.org.apache.xpath.internal.operations.Bool;

public class LaboratoriesUI {
	
	private LaboratoryController labController;

    public LaboratoriesUI(){
    }

    public void run() throws IOException, ParseException{
        System.out.println("Starting...");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        this.labController = new LaboratoryController("C:/Users/Andreea/Desktop/Testing/Prj_2_StudentsLaboratories - Copy/Lav4VVSS/src/main/resources/students.txt","C:/Users/Andreea/Desktop/Testing/Prj_2_StudentsLaboratories - Copy/Lav4VVSS/src/main/resources/laboratories.txt");
        while(true){
            System.out.println(" 1) Add student \n 2) Add Laboratory \n 3) Add grade \n 4) Get passing students \n");

            String line = br.readLine();

            if(line.equals("1")){
                String registrationNumber, name;
                int group;
                System.out.print("Registration number: ");
                registrationNumber = br.readLine();
                System.out.print("Student Name: ");
                name = br.readLine();
                try {
                    System.out.print("Group number: ");
                    String groupString = br.readLine();
                    group = Integer.parseInt(groupString);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid group - not a number!");
                    continue;
                }
                Student student = new Student(registrationNumber, name, group);
				labController.saveStudent(student);
            }

            if(line.equals("2")){
                int labNumber, problemNumber;
                String date, studentRegNumber;

                try {
                    System.out.println("Lab number: ");
                    String labNumberString = br.readLine();
                    System.out.println("Problem number: ");
                    String labProblemNumberString = br.readLine();
                    labNumber = Integer.parseInt(labNumberString);
                    problemNumber = Integer.parseInt(labProblemNumberString);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid input");
                    continue;
                }

                System.out.println("Date (dd/mm/yyyy)");
                date = br.readLine();
                System.out.println("Student reg number");
                studentRegNumber = br.readLine();
                Laboratory lab;
                try {
                    lab = new Laboratory(labNumber, date, problemNumber, studentRegNumber);
                    labController.saveLaboratory(lab);
                } catch (ParseException e) {
                    System.err.println("Invalid date format!");
                    continue;
                }
                catch (Exception e) {
                    System.err.println(e.getMessage());
                    continue;
                }
            }

            if(line.equals("3")){
                String registrationNumber, laborNumber;
                float grade;
                System.out.println("Reg number: ");
                registrationNumber = br.readLine();
                System.out.println("Lab number: ");
                laborNumber = br.readLine();
                try {
                    System.out.println("Grade: ");
                    String gradeString = br.readLine();
                    grade = Float.parseFloat(gradeString);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid grade!");
                    continue;
                }
             try {
					labController.addGrade(registrationNumber, Integer.parseInt(laborNumber), grade);                    
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }

            if(line.equals("4")){
            	try {
                    List<Student> passingStudents = labController.passedStudents();
                    System.out.println("Passing students: ");
                    for ( Student student : passingStudents) {
                        System.out.println("\t - " + student.toString());
                    }                    
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
} 
