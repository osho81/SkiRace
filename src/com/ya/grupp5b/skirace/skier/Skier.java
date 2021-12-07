package com.ya.grupp5b.skirace.skier;

public class Skier extends Person {

	private int skierNumber;
	

	public Skier(String firstName, String lastName) {
		super(firstName, lastName);

	}

	public Skier(int skierNumber) {
		super();
		this.skierNumber = skierNumber;
	}

	public int getSkierNumber() {
		return skierNumber;
	}

	public void setSkierNumber(int skierNumber) {
		this.skierNumber = skierNumber;
	}

	@Override
	public String toString() {
		return "Åkare " + firstName + ", " + lastName + ", #" + skierNumber;
	}
	
}
