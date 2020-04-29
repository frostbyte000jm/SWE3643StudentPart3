package com.company.FromStudent;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.company.FromStudent.*;

import static org.junit.Assert.*;

public class skeletonCodeFunctionalTest {

    private SkeletonCode sc;
    private File file;
    private boolean fileOpenGood;

    @Before
    public void setUp() throws Exception {
        this.sc = new SkeletonCode();
        file = new File("repo/Events.csv");
        fileOpenGood =  sc.openFile(file);
    }

    @Test
    public void openFile() {
        assertTrue(fileOpenGood); // the method should return true as the file was opened successfully
    }

    @Test
    public void searchStudentByName() {
        Student expected = new Student("John", "Wayne", "000000000", "johnwayne@students.kennesaw.edu");

        Student result = sc.searchStudentByName("John Wayne");

        // the following statements assert that the student was found and has all the correct information
        assertEquals(expected.getFirstName(), result.getFirstName());
        assertEquals(expected.getLastName(), result.getLastName());
        assertEquals(expected.getID(), result.getID());
        assertEquals(expected.getEmail(), result.getEmail());

        //There is no indication on what to do when a student has the same name.
    }

    @Test
    public void searchStudentByID() {

        Student expected = new Student("John", "Wayne", "000000000", "johnwayne@students.kennesaw.edu");

        Student result = sc.searchStudentByID("000000000");

        // the following statements assert that the student was found and has all the correct information
        assertEquals(expected.getFirstName(), result.getFirstName());
        assertEquals(expected.getLastName(), result.getLastName());
        assertEquals(expected.getID(), result.getID());
        assertEquals(expected.getEmail(), result.getEmail());
    }

    @Test
    public void searchStudentByEmail() {

        Student expected = new Student("John", "Wayne", "000000000", "johnwayne@students.kennesaw.edu");

        Student result = sc.searchStudentByEmail("johnwayne@students.kennesaw.edu");

        // the following statements assert that the student was found and has all the correct information
        assertEquals(expected.getFirstName(), result.getFirstName());
        assertEquals(expected.getLastName(), result.getLastName());
        assertEquals(expected.getID(), result.getID());
        assertEquals(expected.getEmail(), result.getEmail());
    }

    @Test
    public void searchEventByName() {

        Event expected = new Event("Hackathon", "01/02/2020");

        Event result = sc.searchEventByName("Hackathon");

        // the following statements assert that the event was found and has the correct information
        assertEquals(expected.getDate(), result.getDate());
        assertEquals(expected.getName(), result.getName());
    }

    @Test
    public void searchEventByDate() {

        Event expected = new Event("Hackathon", "01/02/2020");

        Event result = sc.searchEventByDate("01/02/2020");

        // the following statements assert that the event was found and has the correct information
        assertEquals(expected.getDate(), result.getDate());
        assertEquals(expected.getName(), result.getName());
    }

    @Test
    public void readFile() {

        // Assume the file has the following information (shown as a StudentList):
        //DJM - I had to adjust the test here to allow addStudent to accept an index.

        StudentList expected = new StudentList();
        expected.addStudent(new Student("John", "Wayne", "000000000", "johnwayne@students.kennesaw.edu"));
        expected.addStudent(new Student("Papa", "John", "000000001", "papajohn@students.kennesaw.edu"));
        expected.addStudent(new Student("Donald", "Trump", "000000002", "djt@students.kennesaw.edu"));

        StudentList result = sc.readFile(); // should output a list with the same students listed above

        // assert both lists have the same size
        assertEquals(result.getStudentList().size(), expected.getStudentList().size());

        /** I was not sure how to compare the data with assert statements, but printing the info could also help **/
    }

    @Test
    public void createFile() throws IOException { //Unfortunately you never told me where to create the file.

        boolean expected = true;

        boolean result = sc.createFile("newFile.pdf");

        // asserts a new file to write information to was created successfully
        assertEquals(expected, result);
    }

    @Test
    public void writeToFile() {

        StudentList sl = new StudentList();
        sl.addStudent(new Student("Sample", "Student", "000000000", "samplestudent@students.kennesaw.edu"));

        boolean result = sc.writeToFile(sl); // returns true if info was written to the file

        // asserts that information was written to the file successfully
        assertTrue(result);

        StudentList infoOnFile = sc.readFile(); // gets info from the file

        //asserts that the info on the file matches what should have been written on it
        assertEquals(sl.getStudentList().size(), infoOnFile.getStudentList().size());
    }
}