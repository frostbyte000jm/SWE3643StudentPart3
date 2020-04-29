package com.company.FromStudent;

import java.util.ArrayList;
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

    public boolean containsStudentFullName(String fn){
       Student foundStudent = null;
        for (Student ob: studentList.keySet()) {
            if (ob.getFullName().equals(fn)){
                foundStudent = ob;
                break;
            }
        }

        return foundStudent != null;
    }

    public Student getStudentByFullName(String fn){
        Student foundStudent = null;
        for (Student ob: studentList.keySet()) {
            if (ob.getFullName().equals(fn)){
                foundStudent = ob;
                break;
            }
        }

        return foundStudent;
    }

    public boolean containsStudentIDNum(String IDNum){
        Student foundStudent = null;
        for (Student ob: studentList.keySet()) {
            if (ob.getID().equals(IDNum)){
                foundStudent = ob;
                break;
            }
        }

        return foundStudent != null;
    }

    public Student getStudentByIDNum(String IDNum){
        Student foundStudent = null;
        for (Student ob: studentList.keySet()) {
            if (ob.getID().equals(IDNum)){
                foundStudent = ob;
                break;
            }
        }

        return foundStudent;
    }

    public boolean containsStudentEmail(String email){
        Student foundStudent = null;
        for (Student ob: studentList.keySet()) {
            if (ob.getEmail().equals(email)){
                foundStudent = ob;
                break;
            }
        }

        return foundStudent != null;
    }

    public Student getStudentByEmail(String email){
        Student foundStudent = null;
        for (Student ob: studentList.keySet()) {
            if (ob.getEmail().equals(email)){
                foundStudent = ob;
                break;
            }
        }

        return foundStudent;
    }

    public ArrayList<String> writeToCSV(){
        ArrayList<String> csvList = new ArrayList<>();
        for (Student ob: studentList.keySet()) {
            String s = ob.getCSVStudent();
            csvList.add(s);
            }
        return csvList;
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
