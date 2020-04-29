package com.company.FromStudent;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;

public class skeletonCodeVerificationTest {

    private SkeletonCode sc;
    private Scanner fileScanner;

    @Before
    public void setUp() throws Exception {
       this.sc = new SkeletonCode();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void openFile() throws FileNotFoundException {

        File f = null;
        boolean result =  sc.openFile(f); // the method should handle a NullPointerException here

        assertFalse(result); // the method should return false as the file could not be opened
    }

    @Test
    public void openFile2() throws FileNotFoundException {

        File f = new File("WrongFileThatProbablyShouldNotExist19204846.txt"); // this file does not exist
        boolean result =  sc.openFile(f); // the method should handle a NullPointerException here

        assertFalse(result); // the method should return false as the file could not be opened
    }

    @Test
    public void openFile3() throws FileNotFoundException {

        File f = new File("CorrectFile.csb"); // wrong file format
        boolean result =  sc.openFile(f); // the method should handle a FileNotFoundException here

        assertFalse(result); // the method should return false as the file could not be opened
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void searchStudentByName() {

        String studentName = null; // student name to pass
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the input was null
        Student result = sc.searchStudentByName(studentName);

        assertEquals(expected, result);
    }

    @Test
    public void searchStudentByName2() {

        String studentName = "Ch@#$rles"; // student name to pass
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the name was invalid
        Student result = sc.searchStudentByName(studentName);

        assertEquals(expected, result);
    }

    @Test
    public void searchStudentByName3() {

        String studentName = "Idon'texist Murphy"; // student name to pass
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the student was not found
        Student result = sc.searchStudentByName(studentName);

        assertEquals(expected, result);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void searchStudentByID() {

        String studentID = null; // student ID to pass
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the input was null
        Student result = sc.searchStudentByID(studentID);

        assertEquals(expected, result);
    }

    @Test
    public void searchStudentByID2() {

        String studentID = "0000123456"; // student ID to pass (too long in this case. Should be 9 numbers)
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the ID was not a 9-digit number
        Student result = sc.searchStudentByID(studentID);

        assertEquals(expected, result);
    }

    @Test
    public void searchStudentByID3() {

        String studentID = "0116"; // student ID to pass (too short in this case. Should be 9 numbers)
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the ID was not a 9-digit number
        Student result = sc.searchStudentByID(studentID);

        assertEquals(expected, result);
    }

    @Test
    public void searchStudentByID4() {

        String studentID = "999888888"; // student ID to pass (Invalid format. Should begin with "000")
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the ID must start with "000"
        Student result = sc.searchStudentByID(studentID);

        assertEquals(expected, result);
    }

    @Test
    public void searchStudentByID5() {

        String studentID = "000987185"; // student ID to pass (valid format but ID does not exist)
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the ID does not belong to a student
        Student result = sc.searchStudentByID(studentID);

        assertEquals(expected, result);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void searchStudentByEmail() {

        String studentEmail = null; // student name to pass
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the input was null
        Student result = sc.searchStudentByEmail(studentEmail);

        assertEquals(expected, result);
    }

    @Test
    public void searchStudentByEmail2() {

        String studentEmail = "nicholasmurphy@professors.kennesaw.edu"; // student email to pass (invalid format)
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the email did not have a valid format
        Student result = sc.searchStudentByEmail(studentEmail);

        assertEquals(expected, result);
    }

    @Test
    public void searchStudentByEmail3() {

        String studentEmail = "nichola^&*smurphy@students.kennesaw.edu"; // student email to pass (invalid format)
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the email did not have a valid format
        Student result = sc.searchStudentByEmail(studentEmail);

        assertEquals(expected, result);
    }

    @Test
    public void searchStudentByEmail4() {

        String studentEmail = "astudent@students.kennesaw.edu"; // student email to pass (email does not exist)
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the email does not belong to a student
        Student result = sc.searchStudentByEmail(studentEmail);

        assertEquals(expected, result);
    }

    @Test
    public void searchStudentByEmail5() {

        String studentEmail = ""; // student email to pass
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the input was empty
        Student result = sc.searchStudentByEmail(studentEmail);

        assertEquals(expected, result);
    }

    @Test
    public void searchStudentByEmail6() {

        String studentEmail = "a@students.kennesaw.edu"; // student email to pass (Too short. No KSU email could be just one
                                                         // character long)
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the email was too short
        Student result = sc.searchStudentByEmail(studentEmail);

        assertEquals(expected, result);
    }

    @Test
    public void searchStudentByEmail7() {

        String studentEmail = "ThisNameIsWayTooLongForAStudentEmail@students.kennesaw.edu";
        // student email to pass (Too long. KSU shortens long last names on emails)
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the email was too short
        Student result = sc.searchStudentByEmail(studentEmail);

        assertEquals(expected, result);
    }

    @Test
    public void searchStudentByEmail8() {

        String studentEmail = "aname1@students.kennesaw.edu";
        // student email to pass (valid format but does not exist)
        Student expected = null; // the method should return null as it could not find the student

        // the method should print a message saying that the email does not belong to a student
        Student result = sc.searchStudentByEmail(studentEmail);

        assertEquals(expected, result);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void searchEventByName() {

        String eventName = null; // event name to pass
        Event expected = null; // the method should return null as it could not find the event

        // the method should print a message saying that the input was null
        Event result = sc.searchEventByName(eventName);

        assertEquals(expected, result);
    }

    @Test
    public void searchEventByName2() {

        String eventName = "This Event Did Not Happen"; // event name to pass (event does not exist).
        Event expected = null; // the method should return null as it could not find the event

        // the method should print a message saying that the event was not found
        Event result = sc.searchEventByName(eventName);

        assertEquals(expected, result);
    }

    @Test
    public void searchEventByName3() {

        String eventName = ""; // event name to pass
        Event expected = null; // the method should return null as it could not find the event

        // the method should print a message saying that the input was empty
        Event result = sc.searchEventByName(eventName);

        assertEquals(expected, result);
    }

    @Test
    public void searchEventByName4() {

        String eventName = "A"; // event name to pass (No event could have a name this short).
        Event expected = null; // the method should return null as it could not find the event

        // the method should print a message saying that the event name was too short
        Event result = sc.searchEventByName(eventName);

        assertEquals(expected, result);
    }

    @Test
    public void searchEventByName5() {

        String eventName = "Having an event name of this length would really just be a joke, since it could not fit in any" +
                "kind of banner or flyer and would be hard to track and create on OwlLife";
        // event name to pass (No event could have a name this long).
        Event expected = null; // the method should return null as it could not find the event

        // the method should print a message saying that the event name was too long
        Event result = sc.searchEventByName(eventName);

        assertEquals(expected, result);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void searchEventByDate() {

        String eventDate = null; // event date to pass
        Event expected = null; // the method should return null as it could not find the event

        // the method should print a message saying that the input was null
        Event result = sc.searchEventByName(eventDate);

        assertEquals(expected, result);
    }

    @Test
    public void searchEventByDate2() {

        String eventDate = "003/04.2019"; // event date to pass (invalid format)
        Event expected = null; // the method should return null as it could not find the event

        // the method should print a message saying that the format was invalid and show the user that it should be
        // MM/DD/YYYY
        Event result = sc.searchEventByName(eventDate);

        assertEquals(expected, result);
    }

    @Test
    public void searchEventByDate3() {

        String eventDate = "15/33/2019"; // event date to pass (invalid format)
        Event expected = null; // the method should return null as it could not find the event

        // the method should print a message saying that the date was not valid
        Event result = sc.searchEventByName(eventDate);

        assertEquals(expected, result);
    }

    @Test
    public void searchEventByDate4() {

        String eventDate = "10/12/2019"; // event date to pass (valid format but there no were no events on that date)
        Event expected = null; // the method should return null as it could not find the event

        // the method should print a message saying that the event was not found
        Event result = sc.searchEventByName(eventDate);

        assertEquals(expected, result);
    }

    @Test
    public void searchEventByDate5() {

        // Here we would need an event to be in the file in order to test that a slightly different but still valid
        // date format returns the correct result

        String eventDate = "1/12/2019"; // event date to pass (valid format)
        Event expected = new Event();
        expected.setName("Test Event");

        // the method should print a message saying that the event was not found
        Event result = sc.searchEventByName(eventDate);

        assertEquals(expected.getName(), result.getName());
    }

    @Test
    public void searchEventByDate6() {

        String eventDate = "1022/1222/201944"; // event date to pass (invalid format)
        Event expected = null; // the method should return null as it could not find the event

        // the method should print a message saying that the date had an invalid format
        Event result = sc.searchEventByName(eventDate);

        assertEquals(expected, result);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void readFile() {

        //In order to test this, the database file in the skeleton class should be null, as this would
        // cause a NullPointerException. This tests that even if there is no file available to read, the
        // program does not break.

        StudentList expected = null;

        StudentList result = sc.readFile(); // this could throw an error, which should be handled

        assertEquals(expected, result);
    }

    @Test
    public void readFile2() {

        //In order to test this, the database file in the skeleton class should be empty, as this would
        // return an empty StudentList. This tests that that case is handled properly

        StudentList expected = new StudentList();

        StudentList result = sc.readFile(); // returns an empty StudentList

        assertEquals(result.getStudentList().size(), expected.getStudentList().size());
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void createFile() throws FileNotFoundException {

        File f = null;
        boolean result =  sc.openFile(f); // the method should handle a NullPointerException here

        assertFalse(result); // the method should return false as the file could not be created
    }

    @Test
    public void createFile2() throws FileNotFoundException {

        File f = new File("filealreadyxists.csv"); // this file already exists
        boolean result =  sc.openFile(f); // the method should handle an error here

        assertFalse(result); // the method should return false as the file could not be created
    }

    @Test
    public void createFile3() throws FileNotFoundException {

        File f = new File("CorrectFile.csb"); // wrong file format
        boolean result =  sc.openFile(f); // the method should handle a FileNotFoundException here

        assertFalse(result); // the method should return false as the file could not be opened
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void writeToFile() throws IOException {

        StudentList ls = null;
        boolean result = sc.writeToFile(ls); // should return false as StudentList is null

        assertFalse(result);
    }

    @Test
    public void writeToFile2() throws IOException {

        StudentList infoOnFile1 = sc.readFile(); // returns info on the file to compare later

        StudentList sl = new StudentList();

        boolean result = sc.writeToFile(sl); // should return false as StudentList is empty

        assertFalse(result);


        StudentList infoOnFile2 = sc.readFile(); // returns info on the file after trying to write info from an empty list

        //asserts that nothing new was written to the file.
        assertEquals(infoOnFile1.getStudentList().size(), infoOnFile2.getStudentList().size());
    }
}