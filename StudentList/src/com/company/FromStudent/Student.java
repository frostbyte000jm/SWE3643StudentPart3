package com.company.FromStudent;

public class Student {

    private String firstName;
    private String lastName;
    private String fullName;
    private String ID;
    private String email;

    public Student(){}

    public Student(String fn, String ln, String id, String email){
        this.firstName = fn;
        this.lastName = ln;
        this.fullName = firstName + " " + lastName;
        this.ID = id;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
