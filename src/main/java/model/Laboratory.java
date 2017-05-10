package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Laboratory {

    private int laboratoryNumber;
    private Date assignmentDate;
    private int problemNumber;
    private Float grade = (float) 0;
    private String studentRegNumber;

    public Laboratory(int laboratoryNumber, String dateString, int problemNumber,
                      String studentRegNumber) throws ParseException {
        this.laboratoryNumber = laboratoryNumber;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.assignmentDate = format.parse(dateString);
        this.problemNumber = problemNumber;
        this.studentRegNumber = studentRegNumber;
    }

    public Laboratory(int laboratoryNumber, String dateString, int problemNumber, Float grade,
                      String studentRegNumber) throws ParseException {
        this.laboratoryNumber = laboratoryNumber;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.assignmentDate = format.parse(dateString);
        this.problemNumber = problemNumber;
        this.grade = grade;
        this.studentRegNumber = studentRegNumber;
    }

    public Laboratory() {}

	public int getLaboratoryNumber()
    {
        return laboratoryNumber;
    }

    public void setLaboratoryNumber(int laboratoryNumber)
    {
        this.laboratoryNumber = laboratoryNumber;
    }

    public Date getAssignmentDate()
    {
        return assignmentDate;
    }

    public void setAssignmentDate(Date assignmentDate)
    {
        this.assignmentDate = assignmentDate;
    }

    public int getProblemNumber()
    {
        return problemNumber;
    }

    public void setProblemNumber(int problemNumber)
    {
        this.problemNumber = problemNumber;
    }

    public Float getGrade()
    {
        return grade;
    }

    public void setGrade(Float grade)
    {
        this.grade = grade;
    }

    public String getStudentRegNumber()
    {
        return studentRegNumber;
    }

    public void setStudentRegNumber(String studentRegNumber)
    {
        this.studentRegNumber = studentRegNumber;
    }

    @Override
    public String toString() {
        int month = assignmentDate.getMonth() + 1;
        int year = assignmentDate.getYear() + 1900;
        return laboratoryNumber + " " + assignmentDate.getDate() + "/" + month + "/" + year + " "
                + problemNumber + " " + grade + " " + studentRegNumber;
    }

} 