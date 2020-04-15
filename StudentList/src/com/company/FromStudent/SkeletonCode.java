package com.company.FromStudent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SkeletonCode {

    private File csvDatabase;
    private Scanner filescanner;

    public boolean openFile(File file) throws FileNotFoundException {
        return true;
    }

    public Student searchStudentByName(String studentName) {
        return new Student();
    }

    public Student searchStudentByID(String studentID){
        return new Student();
    }

    public Student searchStudentByEmail(String studentEmail){
        return new Student();
    }

    public Event searchEventByName(String eventName){
        return new Event();
    }

    public Event searchEventByDate(String eventDate){
        return new Event();
    }

    public StudentList readFile(){
        // it would read from this.csvDatabase and return a new StudentList with the data
        return new StudentList();
    }

    public boolean createFile(String name){
        return false;
    }

    public boolean writeToFile(StudentList sl){
        //write to this.csvDatabase
        return false;
    }


}
