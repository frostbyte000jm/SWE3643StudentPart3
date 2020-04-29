package com.company.FromStudent;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SkeletonCode {
    private String filePath;
    private File csvDatabase;
    private Scanner filescanner;
    private StudentList mapStudents;
    private ArrayList<Event> arrEvents;

    public boolean openFile(File file) {
        //declarations
        filePath = file.getPath();
        csvDatabase = file;
        boolean doStartStream = true;
        String[] arrHeaders = null;
        boolean isFileGood = csvDatabase.exists();
        mapStudents = new StudentList();
        arrEvents = new ArrayList<>();

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
                String eventName = "";
                String eventDate = "";
                String line = "";
                String csvSplit = ",";
                boolean doEvent = false;

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
                            if(arrColumns.length<=i){
                                break;
                            }
                            doEvent = false;
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
                                case "lblEventName":
                                    doEvent = true;
                                    eventName = data;
                                    isFileGood = true;
                                    break;
                                case "lblEventDate":
                                    doEvent = true;
                                    eventDate = data;
                                    break;

                            }
                        }
                        //Create Event
                        if(doEvent){
                            Event event = new Event(eventName,eventDate);
                            if(!arrEvents.contains(event)){
                                arrEvents.add(event);
                            }
                        }

                        //Create Student, then add student
                        Student s = new Student(buildFirstName,buildLastName,buildIDNum,buildEmail);
                        if(doEvent){
                            Event event = new Event(eventName,eventDate);
                            s.addEvent(event);
                        }
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

        if(mapStudents.containsStudentFullName(studentName)){
            return mapStudents.getStudentByFullName(studentName);
        }

        return null;
    }

    public Student searchStudentByID(String studentID){
        if(mapStudents.containsStudentIDNum(studentID)){
            return mapStudents.getStudentByIDNum(studentID);
        }

        return null;
    }

    public Student searchStudentByEmail(String studentEmail){
        if(mapStudents.containsStudentEmail(studentEmail)){
            return mapStudents.getStudentByEmail(studentEmail);
        }

        return null;
    }

    public Event searchEventByName(String eventName){

        for (int i = 0; i < arrEvents.size(); i++){
            if(arrEvents.get(i).getName().equals(eventName)){
                return arrEvents.get(i);
            }
        }
        return null;
    }

    public Event searchEventByDate(String eventDate){
        for (int i = 0; i < arrEvents.size(); i++){
            if(arrEvents.get(i).getDate().equals(eventDate)){
                return arrEvents.get(i);
            }
        }
        return null;
    }

    public StudentList readFile(){
        // it would read from this.csvDatabase and return a new StudentList with the data


        return mapStudents;
    }

    public boolean createFile(String name, boolean doOverride) throws IOException {
        //declarations
        filePath = "C:/Temp/"+name;
        csvDatabase = new File("C:/Temp/"+name);
        boolean doFileCreated = false;

        if(doOverride)
            csvDatabase.delete();

        doFileCreated = csvDatabase.createNewFile();

        return doFileCreated;
    }

    public boolean writeToFile(StudentList sl) throws IOException {
        csvDatabase.delete();
        csvDatabase.createNewFile();
        mapStudents = sl;

        String csvHeaders = "lblFName,lblLastName,lblIDNum,lblEmail,lblEventName,lblEventDate";

        FileWriter fileWriter = new FileWriter(csvDatabase);

        //create Headers
        fileWriter.append(csvHeaders);
        fileWriter.append("\n");

        ArrayList<String> csvList = new ArrayList<>();
        csvList = mapStudents.writeToCSV();

        for (String als: csvList) {
            fileWriter.append(als);
        }

        fileWriter.close();



        //write to this.csvDatabase
        return csvDatabase.exists();
    }


}
