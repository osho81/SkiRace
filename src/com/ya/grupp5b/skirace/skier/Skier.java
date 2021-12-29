package com.ya.grupp5b.skirace.skier;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



public class Skier extends Person implements Comparable<Skier> {

	private int skierNumber;
	private LocalTime indivStartTime;
	private LocalTime goalTime;

	// Constructor 1
	public Skier(String firstName, String lastName) {
		super(firstName, lastName);

	}

	// Constructor 2
	public Skier(int skierNumber) {
		super();
		this.skierNumber = skierNumber;
	}

	public LocalTime getIndivStartTime() {
		return indivStartTime;
	}

	public void setIndivStartTime(LocalTime indivStartTime) {
		this.indivStartTime = indivStartTime;
	}
	
	public int getSkierNumber() {
		return skierNumber;
	}

	public void setSkierNumber(int skierNumber) {
		this.skierNumber = skierNumber;
	}	

	public LocalTime getGoalTime() {
		return goalTime;
	}

	public void setGoalTime(LocalTime goalTime) {
		this.goalTime = goalTime;
	}

	@Override
	public String toString() {	
		DateTimeFormatter formatPattern = DateTimeFormatter.ofPattern("HH:mm:ss"); // formatting options
        String formattedIndivStartTime = indivStartTime.format(formatPattern); // apply pattern on our date obj
        
        return String.format("Starttid: " + formattedIndivStartTime + "  Startnummer: #"+ skierNumber + " Namn: " + firstName + " " + lastName);
	}
	
	@Override
    public int compareTo(Skier otherSkier) {

        if (this.skierNumber < otherSkier.skierNumber) {
            return -1;
        } else if (this.skierNumber > otherSkier.skierNumber) {
            return 1;
        } else {
            return 0;
        }
	}

}
