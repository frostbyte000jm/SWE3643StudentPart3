package com.company.FromStudent;

import java.util.ArrayList;

public class Student {

    private String firstName;
    private String lastName;
    private String fullName;
    private String ID;
    private String email;
    private ArrayList<Event> arrEvents;
    private int eventCount;

    public Student(){}

    public Student(String fn, String ln, String id, String email){
        this.firstName = fn;
        this.lastName = ln;
        this.fullName = firstName + " " + lastName;
        this.ID = id;
        this.email = email;
        arrEvents = new ArrayList<>();
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

    public void addEvent(Event event){
        if(!arrEvents.contains(event)){
            arrEvents.add(event);
            eventCount++;
        }

    }

    public int getEventCount(){return eventCount;}

    public void DisplayStudent(){
        System.out.println("Student Name: "+firstName+" "+lastName+"\n" +
                "Student ID: "+ID+"\n" +
                "Student Email: "+ email);
    }

    public String getCSVStudent(){
        String eventName = (arrEvents.size()>0)?arrEvents.get(0).getName():"";
        String eventDate = (arrEvents.size()>0)?arrEvents.get(0).getDate():"";
        return firstName+","+lastName+","+ID+","+email+","+eventName+","+eventDate+"\n";
    }

    @Override
    public int hashCode()
    {
        return ID.hashCode();
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Student)
            return this.ID.equals(((Student) o).getID());
        else
            return false;
    }
}
