package com.company.FromStudent;

import java.util.HashMap;
import java.util.Map;

public class StudentList {

    private Map<Student, Integer> studentList; // Students are mapped to the times they have been found in the file
    private Student studentAttendedMostEvents;
    private int index;

    public StudentList(){
        this.studentList = new HashMap<Student, Integer>();
        index = 0;
    }

    public void addStudent(Student s) {
        this.studentList.putIfAbsent(s, index++);
    }

    public Map<Student, Integer> getStudentList(){
        return this.studentList;
    }

    public int getSize() {
        return this.studentList.size();
    }

    public void setStudentAttendedMostEvents(Student s) {
        this.studentAttendedMostEvents = s;
    }

    public Student getStudentAttendedMostEvents() {
        return this.studentAttendedMostEvents;
    }



}
