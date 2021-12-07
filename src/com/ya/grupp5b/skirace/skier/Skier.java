package com.ya.grupp5b.skirace.skier;

import java.time.LocalTime;

public class Skier extends Person implements Comparable<Skier> {

	private int skierNumber;
	private LocalTime indivStartTime; 

	public Skier(String firstName, String lastName) {
		super(firstName, lastName);

	}

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

	@Override
	public String toString() {
		return "#" + skierNumber + ", Starttid: " + indivStartTime + ", Förnamn: " + firstName
				+ ", Efternamn: " + lastName + "";
	}
	
	@Override
    public int compareTo(Skier otherSkier) {

        if (this.skierNumber < otherSkier.skierNumber) {
            return -1;
        } else if (this.skierNumber < otherSkier.skierNumber) {
            return 1;
        } else {
            return 0;
        }
	}

}
