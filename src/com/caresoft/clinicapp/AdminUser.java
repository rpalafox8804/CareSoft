package com.caresoft.clinicapp;

//... imports class definition...
import java.util.Date;
import java.util.ArrayList;


public class AdminUser extends User implements HIPAACompliantAdmin, HIPAACompliantUser {
	// Inside class:
	private String role;
	private ArrayList<String> securityIncidents = new ArrayList<String>();
	  
	//Implement a constructor that takes an ID and a role
	public AdminUser (Integer id, String role) {
	  super(id);
	  this.role = role;
	}
	// Implements HIPAACompliantUser!
	public boolean assignPin(int pin) {
		// Pin must be exactly 6 digits, returns false if not.Expected to assign the pin to the user (as a member variable)
    	int length = 0;
    	long temp = 1;
    	while (temp <= pin) {
    	    length++;
    	    temp *= 10;
    	}
    	if (length == 6){
    		this.setPin(pin);
    		return true;
    	}
    	else {
    		System.out.println ("Please enter exactly 6 numbers for Pin");
    		return false;
    	}
		
	}
	public boolean accessAuthorized(Integer confirmedAuthID) {
		// Compares the ids, and if they are not a match,creates an incident report using the authIncident method,
		//Returns true if ids match, false if not.
		if (confirmedAuthID.equals(super.getId()) ) {
    		return true;
    	}
    	else {
    		authIncident();
    		return false;
    	}
	}

	// TO DO: Implement HIPAACompliantAdmin!
	public ArrayList<String> reportSecurityIncidents() {
		// Returns a list of strings (incidents reported)
		
		return securityIncidents;
	}
	  
    public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
	
	// TO DO: Setters & Getters
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}
	  
	

}

 
  

  
  

