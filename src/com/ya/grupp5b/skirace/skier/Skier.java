package com.ya.grupp5b.skirace.skier;

import java.time.LocalTime;

public class Skier extends Person implements Comparable<Skier> {

	private int skierNumber;
	private LocalTime indivStartTime;
	private LocalTime tempTime;
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

	public LocalTime getTempTime() {
		return tempTime;
	}

	public void setTempTime(LocalTime tempTime) {
		this.tempTime = tempTime;
	}

	public LocalTime getGoalTime() {
		return goalTime;
	}

	public void setGoalTime(LocalTime goalTime) {
		this.goalTime = goalTime;
	}

	@Override
	public String toString() {
		return String.format("#" + skierNumber + ", Starttid: " + indivStartTime + ", Förnamn: " + firstName
				+ ", Efternamn: " + lastName +" " + goalTime+"");
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

	public int compareGoalTime(Skier otherSkier) {
		
        if (this.goalTime.getSecond() < otherSkier.goalTime.getSecond()) {
            return -1;
        } else if (this.goalTime.getSecond() > otherSkier.goalTime.getSecond()) {
            return 1;
        } else {
            return 0;
        }
		
	}
	
	public int compareToTemp(Skier otherSkier) {
        if (this.tempTime.getSecond() < otherSkier.tempTime.getSecond()) {
            return -1;
        } else if (this.tempTime.getSecond() > otherSkier.tempTime.getSecond()) {
            return 1;
        } else {
            return 0;
        }
	}

}
