package com.caresoft.clinicapp;

//... imports class definition...
import java.sql.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	

    // TO DO: Constructor that takes an ID
    public Physician (Integer id) {
    	super(id);
    	this.setId(id);
    }
    // TO DO: Implement HIPAACompliantUser!
    
    
    public boolean assignPin(int pin) {
    	// Pin must be exactly 4 digits, returns false if not.Expected to assign the pin to the user (as a member variable)
    	int length = 0;
    	long temp = 1;
    	while (temp <= pin) {
    	    length++;
    	    temp *= 10;
    	}
    	if (length == 4){
    		this.setPin(pin);
    		return true;
    	}
    	else {
    		System.out.println ("Please enter exactly 4 numbers for Pin");
    		return false;
    	}
    }
    public boolean accessAuthorized(Integer confirmedAuthID) {
    	// Checks the physician's id against the given id;
    	//returns true if they are a match, otherwise false.
    	if (confirmedAuthID.equals(getId()) ) {
    		return true;
    	}
    	else {    		
    		return false;
    	}
    }
	
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }


	
    // TO DO: Setters & Getters
    public ArrayList<String> getPatientNotes() {
    	return patientNotes;
    }
    
    
    public void setPatientNotes(ArrayList<String> patientNotes) {
    	this.patientNotes = patientNotes;
    }

}
