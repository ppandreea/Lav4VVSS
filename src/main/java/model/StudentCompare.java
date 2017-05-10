package main.java.model;

import java.util.Comparator;

public class StudentCompare implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        return String.valueOf(student1.getGroup()).compareTo(String.valueOf(student2.getGroup()));
    }
}