package com.ya.grupp5b.skirace.tools;

import java.time.LocalTime;
import java.util.Scanner;
import com.ya.grupp5b.skirace.race.Race;


public class Input {

	private Scanner scan = new Scanner(System.in);

	// METOD: Användaren får välja starttid för tävlingen
	public LocalTime selectStartTime() {
		System.out.println("Vilken tid startar tävlingen?");
		System.out.println("Starttid timme: ");
		int h = readInt();
		System.out.println("Starttid minut: ");
		int m = readInt();

		LocalTime timeNow = LocalTime.now();
		int hNow = timeNow.getHour();
		int mNow = timeNow.getMinute();

		while (h >= 24 || m >= 60 || (h < hNow || (h == hNow && m < mNow))) { // Felhantering starttid
			if (h >= 24 || m >= 60) {
				System.out.println("Fel format! Försök igen\nTimme: 1-23\nMinut: 1-59");
				System.out.println("Starttid timme: ");
				h = readInt();
				System.out.println("Starttid minut: ");
				m = readInt();

			} else if (h < hNow || (h == hNow && m < mNow)) {
				System.out.println("Starttiden kan inte ha passerat, försök igen");
				System.out.println("Starttid timme: ");
				h = readInt();
				System.out.println("Starttid minut: ");
				m = readInt();
			}
		}
		LocalTime raceStart = LocalTime.of(h, m, 0, 0);
		return raceStart;
	}

	public String readString() {
		while (!scan.hasNextLine()) { // Försök fixa så man inte kan skriva in siffror
			System.out.println("Felaktig inmatning \nProva igen: ");
		}
		return scan.nextLine();

	}

	// Skapa en metod som kan läsa klockslag
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

		System.out.println("\nVilken tävlande vill du registrera målgångstid för? ");
		int chosenStartNum = readInt();
		int currentIndex = 0;

		// Hitta <index> för den önskade tävlande, via det valda start nr
		for (var skier : race.getSkierList()) {
			if (skier.getSkierNumber() == chosenStartNum) {
				currentIndex = race.getSkierList().indexOf(skier);
			}
		}

		race.getSkierList().get(currentIndex)
				.setGoalTime(Timing.calcDuration(race.getSkierList().get(currentIndex).getIndivStartTime()));
		
		return currentIndex;
	}
	
	// METOD: val 2 i menyn - dvs. registrera mellantid för vald åkare
	public int regTempTime(Race race, Output output) {

		System.out.println("\nVilken tävlande vill du registrera mellantid för? ");
		int chosenStartNum = readInt();
		int currentIndex = 0;

		// Hitta <index> för den önskade tävlande, via det valda start nr
		for (var skier : race.getSkierList()) {
			if (skier.getSkierNumber() == chosenStartNum) {
				currentIndex = race.getSkierList().indexOf(skier);
			}
		}

		race.getSkierList().get(currentIndex)
				.setTempTime(Timing.calcDuration(race.getSkierList().get(currentIndex).getIndivStartTime()));

		return currentIndex;
	}
}
