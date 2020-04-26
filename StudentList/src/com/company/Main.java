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

    public static void main(String[] args) throws IOException {

        //Interface
        /*
        This will ask to Load, Save, Display, Search
         */
        skeletonCode = new SkeletonCode();
        Scanner scanner = new Scanner(System.in);
        boolean doLoop = true;
        while(doLoop){
            System.out.println("Welcome to the Student Event Database.\n" +
                    "How may we assist you?\n\n" +
                    "1) Load CSV File\n" +
                    "2) Save CSV File\n" +
                    "3) Display or Search Students\n" +
                    "4) Quit");

            int lineNum = scanner.nextInt();

            if (lineNum >= 1 && lineNum <= 4){
                switch (lineNum){
                    case 1:
                        ChoiceLoadFile();
                        break;
                    case 2:
                        break;
                    case 3:
                        ChoiceDisplayStudents();
                        break;
                    case 4:
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

    private static void ChoiceDisplayStudents(){
        StudentList sl = skeletonCode.readFile();
        //Student s = sl.
    }
}
