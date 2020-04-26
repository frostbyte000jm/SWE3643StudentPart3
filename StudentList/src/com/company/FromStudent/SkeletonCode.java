package com.company.FromStudent;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class SkeletonCode {
    private File csvDatabase;
    private Scanner filescanner;
    private StudentList mapStudents;
    private ArrayList<Event> arrEvents;

    public boolean openFile(File file) throws FileNotFoundException {
        //declarations
        csvDatabase = file;
        boolean doStartStream = true;
        String[] arrHeaders = null;
        boolean isFileGood = csvDatabase.exists();
        mapStudents = new StudentList();

        /*
        This is a handy tool I made a few years ago when a csv file changes constantly.
        When building this, a CSV file was not given. To continue, I need to request the author give thier CSV file Headers
         */
        if (isFileGood) {
            isFileGood = false; //reset to false, if CSV doesn't write anything. it is clearly not a good file.
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvDatabase.getPath()))) {

                //declarations
                String buildFirstName = "";
                String buildLastName = "";
                String buildIDNum = "";
                String buildEmail = "";
                String line = "";
                String csvSplit = ",";

                while ((line = bufferedReader.readLine())!=null){

                    if(doStartStream){
                        arrHeaders = line.split(csvSplit);
                        doStartStream = false;
                    }
                    else{
                        //collect data
                        String[] arrColumns = line.split(csvSplit);

                        //sort
                        for (int i = 0; i < arrHeaders.length; i++){
                            String type = arrHeaders[i];
                            String data = arrColumns[i];

                            switch (type){

                                case "lblFName":
                                    buildFirstName = data;
                                    isFileGood = true;
                                    break;
                                case "lblLastName":
                                    buildLastName = data;
                                    isFileGood = true;
                                    break;
                                case "lblIDNum":
                                    buildIDNum = data;
                                    isFileGood = true;
                                    break;
                                case "lblEmail":
                                    buildEmail = data;
                                    isFileGood = true;
                                    break;
                            }
                        }
                        //Create Student, then add student
                        Student s = new Student(buildFirstName,buildLastName,buildIDNum,buildEmail);
                        mapStudents.addStudent(s);
                    }
                }
            }
            catch (IOException e) { //If everything goes bad.
                e.printStackTrace();
                isFileGood = false;
            }
        }

        return isFileGood;
    }

    public Student searchStudentByName(String studentName) {

        

        //Student st = arrStudents[1]
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


        return mapStudents;
    }

    public boolean createFile(String name){
        return false;
    }

    public boolean writeToFile(StudentList sl){
        //write to this.csvDatabase
        return false;
    }


}
