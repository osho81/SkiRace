package com.ya.grupp5b.skirace.tools;

import java.time.LocalTime;
import java.util.Scanner;
import com.ya.grupp5b.skirace.race.Race;

/**
 * Klass som hanterar metoder för all inmatning
 */

public class Input {

	private Scanner scan = new Scanner(System.in);

	// METOD: Användaren får mata in starttid för tävlingen
	public LocalTime selectStartTime() {
		System.out.println("Välj starttid");
		System.out.println("Timme: ");
		int h = readInt();
		System.out.println("Minut: ");
		int m = readInt();

		LocalTime timeNow = LocalTime.now();
		int hNow = timeNow.getHour();
		int mNow = timeNow.getMinute();

		// Felhantering starttid
		while (h >= 24 || m >= 60 || (h < hNow || (h == hNow && m < mNow))) { 
			if (h >= 24 || m >= 60) {
				System.out.println("Fel format! Försök igen\nTimme: 1-23\nMinut: 1-59");
				System.out.println("Timme: ");
				h = readInt();
				System.out.println("Minut: ");
				m = readInt();

			} else if (h < hNow || (h == hNow && m < mNow)) {
				System.out.println("Starttiden kan inte ha passerat, försök igen");
				System.out.println("Timme: ");
				h = readInt();
				System.out.println("Minut: ");
				m = readInt();
			}
		}
		LocalTime raceStart = LocalTime.of(h, m, 0, 0);
		return raceStart;
	}

	//METOD: Läser in string och felhanterar vid null
	public String readString() {
		while (!scan.hasNextLine()) { 
			System.out.println("Felaktig inmatning \nProva igen: ");
		}
		return scan.nextLine();
	}

	//METOD: Läser in int och felhanterar om ej int 
	public int readInt() {
		while (!scan.hasNextInt()) {
			scan.nextLine();
			System.out.print("Felaktig inmatning \nProva igen: ");
		}
		int chosenInt = scan.nextInt();
		scan.nextLine();
		return chosenInt;
	}

	// METOD: val 3 i menyn - dvs. registrera målgångstid för vald åkare
	public int regGoalTime(Race race, Output output) {

		System.out.println("\nVilken åkare vill du registrera målgångstid för? ");
		int chosenStartNum = readInt();
		int currentIndex = 0;

		// Hitta <index> för den önskade tävlande, via det valda start nr
		for (var skier : race.getSkierList()) {
			if (skier.getSkierNumber() == chosenStartNum) {
				currentIndex = race.getSkierList().indexOf(skier);
			}
		}

		// Tilldelar målgångstid till vald åkare
		race.getSkierList().get(currentIndex)
				.setGoalTime(Timing.calcDuration(race.getSkierList().get(currentIndex).getIndivStartTime()));

		return currentIndex;
	}

	// METOD: val 2 i menyn - dvs. registrera mellantid för vald åkare
	public int regTempTime(Race race, Output output) {

		System.out.println("\nVilken åkare vill du registrera mellantid för? ");
		int chosenStartNum = readInt();
		int currentIndex = 0;

		// Hitta <index> för den önskade tävlande, via det valda start nr
		for (var skier : race.getSkierList()) {
			if (skier.getSkierNumber() == chosenStartNum) {
				currentIndex = race.getSkierList().indexOf(skier);
			}
		}

		// Tilldelar mellantid till vald åkare
		race.getSkierList().get(currentIndex)
				.setTempTime(Timing.calcDuration(race.getSkierList().get(currentIndex).getIndivStartTime()));

		return currentIndex;
	}
}
