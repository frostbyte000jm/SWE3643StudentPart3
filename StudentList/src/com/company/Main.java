package com.company;

import com.company.FromStudent.Event;
import com.company.FromStudent.SkeletonCode;
import com.company.FromStudent.Student;
import com.company.FromStudent.StudentList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Scanner;

public class Main {
    private static SkeletonCode skeletonCode;
    private static String fileLoc = "repo/Events.csv";
    private static Scanner scanner;
    private static boolean doLoop;

    public static void main(String[] args) throws IOException {

        //Interface
        /*
        There wasn't any interface instructions, so I made it super simple and completely based on the Test.
         */
        skeletonCode = new SkeletonCode();
        scanner = new Scanner(System.in);
        doLoop = true;
        while(doLoop) {
            System.out.println("Welcome to the Student Event Database.\n" +
                    "How may we assist you?\n\n" +
                    "1) Load CSV File\n" +
                    "2) Save CSV File\n" +
                    "3) New CSV File\n" +
                    "4) Search Students\n" +
                    "5) Search Events\n" +
                    "6) Quit");

            int lineNum = scanner.nextInt();
            SwitchCases(lineNum);
        }

    }

    public static boolean SwitchCases(int lineNum) throws IOException {

        if (lineNum >= 1 && lineNum <= 6){
            switch (lineNum){
                case 1:
                    ChoiceLoadFile();
                    break;
                case 2:
                    ChoiceSaveFile();
                    break;
                case 3:
                    ChoiceCreateNewFile();
                    break;
                case 4:
                    SearchStudents();
                    break;
                case 5:
                    SearchEvents();
                    break;
                case 6:
                    doLoop = false;
                    break;
            }
        }
        else {
            System.out.println("An incorrect choice was made, please choose between 1 and 6\n\n");
            return false;
        }
        return true;
    }

    private static void SearchEvents() {
        System.out.println("Choose by which method to search:\n" +
                "1) By Name\n" +
                "2) By Date\n" +
                "Enter Choice:");

        int lnIn = scanner.nextInt();

        if (lnIn >= 1 && lnIn <= 2) {
            switch (lnIn) {
                case 1:
                    SearchEventName();
                    break;
                case 2:
                    SearchEventDate();
                    break;
            }
        }
    }

    private static void SearchEventDate() {
        System.out.println("Enter Event Date: ");
        scanner.nextLine();
        String lnIn = scanner.nextLine();
        Event event = skeletonCode.searchEventByDate(lnIn);
        event.DisplayEvent();
    }

    private static void SearchEventName() {
        System.out.println("Enter Event Name: ");
        scanner.nextLine();
        String lnIn = scanner.nextLine();
        Event event = skeletonCode.searchEventByName(lnIn);
        event.DisplayEvent();
    }

    //This option will ask for file name, and save to c:\Temp (see SkeletonCode for Why Temp)
    private static void ChoiceSaveFile() throws IOException {
        System.out.println("Name of File:\n");
        StudentList sl = skeletonCode.readFile();
        boolean doSuccess = skeletonCode.writeToFile(sl);
        if(doSuccess)
            System.out.println("Success");
        else
            System.out.println("Safe File Failed.");
    }

    //This will create a new file in C:\Temp
    private static void ChoiceCreateNewFile() throws IOException {
        System.out.println("Enter New File Name (Ex 'bob.csv'): ");
        String fileName = scanner.next();
        String filePathName = "C:\\Temp\\"+ fileName;
        System.out.println("You're file will be saved to "+filePathName + " Continue? (Y/N)");
        boolean doContinue = scanner.next().equals("Y");
        boolean isAllGood = false;

        if(doContinue){
            boolean doOverride = false;
            File csvDatabase = new File(fileName);
            //Check if exist to not accidentally overwrite
            if(csvDatabase.exists()){
                System.out.println("File already Exist, Overwrite? (Y/N)");
                Scanner scanner = new Scanner(System.in);
                doOverride = scanner.next().equals("Y");
            }
            isAllGood = skeletonCode.createFile(fileName);
        }

        if(isAllGood)
            System.out.println(fileName+" has been created.");
        else
            System.out.println(fileName + " has NOT been created.");
    }

    //THis will load a file from C:\\Temp
    private static void ChoiceLoadFile() throws FileNotFoundException {
        System.out.println("Type in File Name (ex 'test.csv'): ");
        String s = scanner.next();

        fileLoc = "C:\\Temp\\"+s;

        File f = new File(fileLoc);
        boolean isGoodFile = skeletonCode.openFile(f);

        if (isGoodFile){
            System.out.println("File Loaded ... \n\n");
        }
        else{
            System.out.println("Incorrect File Type, please choose another file ... \n\n");
        }
    }

    //This will search student by Name, ID, or email and display them.
    //There wasn't any instruction what to do for more than 1 Student.
    private static void SearchStudents(){
        System.out.println("Choose by which method to search for the student:\n" +
                "1) By Full Name\n" +
                "2) By ID Number\n" +
                "3) By Email Address\n\n" +
                "Enter Choice:");

        int lnIn = scanner.nextInt();

        if (lnIn >= 1 && lnIn <= 3) {
            switch (lnIn) {
                case 1:
                    SearchStudentsFullName();
                    break;
                case 2:
                    SearchStudentsID();
                    break;
                case 3:
                    SearchStudentsEmail();
                    break;
            }
        }
    }

    private static void SearchStudentsID() {
        System.out.println("Enter ID Number: ");
        scanner.nextLine();
        String lnIn = scanner.nextLine();
        Student student = skeletonCode.searchStudentByID(lnIn);
        student.DisplayStudent();
    }

    private static void SearchStudentsEmail() {
        System.out.println("Enter Email: ");
        scanner.nextLine();
        String lnIn = scanner.nextLine();
        Student student = skeletonCode.searchStudentByEmail(lnIn);
        student.DisplayStudent();
    }

    private static void SearchStudentsFullName(){
        System.out.println("Enter Name: ");
        scanner.nextLine();
        String lnIn = scanner.nextLine();
        Student student = skeletonCode.searchStudentByName(lnIn);
        student.DisplayStudent();
    }

}
