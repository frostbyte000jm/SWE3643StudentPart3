package com.company;

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

    public static void main(String[] args) throws IOException {

        //Interface
        /*
        This will ask to Load, Save, Display, Search
         */
        skeletonCode = new SkeletonCode();
        scanner = new Scanner(System.in);
        boolean doLoop = true;
        while(doLoop){
            System.out.println("Welcome to the Student Event Database.\n" +
                    "How may we assist you?\n\n" +
                    "1) Load CSV File\n" +
                    "2) Save CSV File\n" +
                    "3) New CSV File\n" +
                    "4) Search Students\n" +
                    "5) Quit");

            int lineNum = scanner.nextInt();

            if (lineNum >= 1 && lineNum <= 5){
                switch (lineNum){
                    case 1:
                        ChoiceLoadFile();
                        break;
                    case 2:
                        break;
                    case 3:
                        ChoiceCreateNewFile();
                        break;
                    case 4:
                        SearchStudents();
                        break;
                    case 5:
                        doLoop = false;
                        break;
                }


            }
            else {
                //System.out.print("\033[H\033[2J");
               // System.out.flush();
                System.out.println("An incorrect choice was made, please choose between 1 and 4\n\n");
            }

            //Runtime.getRuntime().exec("cls");
        }





        SkeletonCode skeletonCode = new SkeletonCode();
        File f = new File("repo/Events.csv");
        boolean test = skeletonCode.openFile(f);

        System.out.println(test);
        System.in.read();


    }

    private static void ChoiceCreateNewFile() throws IOException {



        System.out.println("Enter New File Name (Ex 'bob.csv': ");
        String fileName = scanner.next();
        fileName = "C:\\Temp\\"+ fileName;
        System.out.println("You're file will be saved to "+fileName + " Continue? (Y/N)");
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

            isAllGood = skeletonCode.createFile(fileName,doOverride);
        }

        if(isAllGood)
            System.out.println(fileName+" has been created.");
        else
            System.out.println(fileName + " has NOT been created.");


    }

    private static void ChoiceLoadFile() throws FileNotFoundException {

        File f = new File(fileLoc);
        boolean isGoodFile = skeletonCode.openFile(f);

        if (isGoodFile){
            System.out.println("File Loaded ... \n\n");
        }
        else{
            System.out.println("Incorrect File Type, please choose another file ... \n\n");
        }

    }

    private static void SearchStudents(){
        System.out.println("Choose by which method to search for the student:\n" +
                "1) By Full Name\n" +
                "2) By First Name\n" +
                "3) By Last Name\n" +
                "4) By ID Number\n" +
                "5) By Email Address\n\n" +
                "Enter Choice:");

        int lnIn = scanner.nextInt();

        if (lnIn >= 1 && lnIn <= 5) {
            switch (lnIn) {
                case 1:
                    SearchStudentsFullName();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }




        StudentList sl = skeletonCode.readFile();
        //Student s = sl.
    }

    private static void SearchStudentsFullName(){
        System.out.println("Enter Name: ");
        scanner.nextLine();
        String lnIn = scanner.nextLine();
        Student student = skeletonCode.searchStudentByName(lnIn);
        student.DisplayStudent();
    }

}
