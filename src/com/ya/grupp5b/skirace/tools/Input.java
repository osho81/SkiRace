package com.ya.grupp5b.skirace.tools;

import java.time.LocalTime;
import java.util.Collections;
import java.util.Scanner;

import com.ya.grupp5b.skirace.race.Race;
import com.ya.grupp5b.skirace.skier.CompareTempTime;

public class Input {

	private static Scanner scan = new Scanner(System.in);

	// METOD: Användaren får välja starttid för tävlingen
	public static LocalTime selectStartTime() {
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

	public static String readString() {
		while (!scan.hasNextLine()) { // Försök fixa så man inte kan skriva in siffror
			System.out.println("Felaktig inmatning \nProva igen: ");
		}
		return scan.nextLine();

	}

	// Skapa en metod som kan läsa klockslag
	public static int readInt() {
		while (!scan.hasNextInt()) {
			scan.nextLine();
			System.out.print("Felaktig inmatning \nProva igen: ");
		}
		int chosenInt = scan.nextInt();
		scan.nextLine();
		return chosenInt;
	}
	
	// METOD: val 3 i menyn - dvs. checka specific tävlandes löpta tid & placering
	public static void checkTempTime(Race race) {
		CompareTempTime tempCheck = new CompareTempTime(); // Jämför mellantid
		Collections.sort(race.getSkierList(), tempCheck);

		System.out.println("\nVilken tävlande vill du kolla nuvarande mellantid & placering för?");
		int chosenStartNum = Input.readInt();
		int currentIndex = 0;

		// Hitta <index> för den önskade tävlande, via det valda start nr
		for (var skier : race.getSkierList()) {
			if (skier.getSkierNumber() == chosenStartNum) {
				currentIndex = race.getSkierList().indexOf(skier);
			}
		}

		// Kom åt starttid för objektet på det funna indexet
		LocalTime currentTempTime = Timing.calcDuration(race.getSkierList().get(currentIndex).getIndivStartTime());
		Output.printChosenTempTime(currentIndex, currentTempTime, race);
	}
	
	// METOD: val 2 i menyn - dvs. registrera måltid för vald åkare
	public static void regGoalTime(Race race) {

		System.out.println("\nVilken tävlande vill du registrera måltid för? ");
		int chosenStartNum = Input.readInt();
		int currentIndex = 0;

		// Hitta <index> för den önskade tävlande, via det valda start nr
		for (var skier : race.getSkierList()) {
			if (skier.getSkierNumber() == chosenStartNum) {
				currentIndex = race.getSkierList().indexOf(skier);
			}
		}

		race.getSkierList().get(currentIndex)
				.setGoalTime(Timing.calcDuration(race.getSkierList().get(currentIndex).getIndivStartTime()));

		Output.printChosenGoalTime(currentIndex, race);
	}

}
