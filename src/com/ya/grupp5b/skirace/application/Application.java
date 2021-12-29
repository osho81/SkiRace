package com.ya.grupp5b.skirace.application;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import com.ya.grupp5b.skirace.race.Race;
import com.ya.grupp5b.skirace.skier.CompareGoalTime;
import com.ya.grupp5b.skirace.skier.CompareTempTime;
import com.ya.grupp5b.skirace.skier.Skier;
import com.ya.grupp5b.skirace.tools.*;

public class Application {

	private Race race = new Race();
	private Menu menu = new Menu();

	// METOD: Kör hela applikationen
	public void runSkiRace() {
		runMenu();
	}

	// METOD: Yttre menyn
	private void runMenu() {

		int menuChoice = 0;
		while (menuChoice != 2) {

			menu.printMenu();
			menuChoice = Input.readInt();

			switch (menuChoice) {
			case 1:
				race.setRaceStart(selectStartTime());
				addSkier();
				Collections.sort(race.getSkierList());// Sorterar efter startnummer
				printSkierList();
				runInnerMenu();
				break;
			case 2:
				break;
			default:
				System.out.println("Felaktigt val");
				break;
			}
		}
	}

	// METOD: Inre menyn
	private void runInnerMenu() {

		int menuChoice = 0;
		while (menuChoice != 5) {

			menu.printInnerMenu();
			menuChoice = Input.readInt();

			switch (menuChoice) {
			case 1:
				regTempTime(); // Kolla mellantid & placering för vald åkare (Ska den heta regTempTime?)
				break;
			case 2:
				regGoalTime(); // Registrera måltid för vald åkare
				break;
			case 3:
				CompareTempTime tempCheck = new CompareTempTime(); // Visa och jämför mellantid
				Collections.sort(race.getSkierList(), tempCheck);
				printSkierList();
				break;
			case 4:
				CompareGoalTime goalCheck = new CompareGoalTime(); // Visa och jämför måltid
				Collections.sort(race.getSkierList(), goalCheck);
				printSkierList();
				break;
			case 5:
				// Avsluta
				break;
			default:
				System.out.println("Felaktigt val");
				break;
			}
		}
	}

	// METOD: Användaren får välja starttid för tävlingen
	private LocalTime selectStartTime() {
		System.out.println("Vilken tid startar racet? ");
		int h = Input.readInt();
		int m = Input.readInt();
		int s = Input.readInt();

		LocalTime raceStart = LocalTime.of(h, m, s, 0);
		return raceStart;
	}

	// METOD: Användaren får lägga till antal åkare och åkare
	private void addSkier() {

		System.out.println("Hur många ska tävla? ");
		int totalSkiers = Input.readInt();

		List<Integer> numbersList = new Vector<Integer>();

		// Fyll i numbersList med nummer; fyll i skiersList med nya tävlande
		for (int i = 1; i <= totalSkiers; i++) {
			numbersList.add(i);
			System.out.println("Förnamn: ");
			String firstName = Input.readString();
			System.out.println("Efternamn: ");
			String lastName = Input.readString();
			Skier newSkier = new Skier(firstName, lastName);
			race.setSkierList(newSkier);
		}

		// Tilldela startnummer till varje tävlande
		for (int j = totalSkiers; j > 0; j--) {
			int randomValue = (int) (Math.random() * (1 * j));
			Skier newSkier = race.getSkierList().get(j - 1);
			newSkier.setSkierNumber(numbersList.get(randomValue));
			// Ta bort redan tilldelat nummer ur numbersList (så att det inte går att få
			// samma nr)
			numbersList.remove(randomValue);

		}

		// Tilldela starttid och öka (15 sekunder * startnummer) för varje tävlande
		for (int j = 0; j < race.getSkierList().size(); j++) { // Ex:
			race.getSkierList().get(j).setIndivStartTime(race.getRaceStart()
					.plus(15 * race.getSkierList().get(j).getSkierNumber() - 15, ChronoUnit.SECONDS));
		}

	}

	// METOD: Skriver ut skierList
	private void printSkierList() {
		for (Skier newSkier : race.getSkierList()) {
			System.out.println(newSkier);
		}
	}

	// METOD: val 3 i menyn - dvs. checka specific tävlandes löpta tid & placering
	private void regTempTime() {

		System.out.println("Vilken tävlande vill du kolla nuvarande mellantid & placering för?");
		int chosenStartNum = Input.readInt();
		int currentIndex = 0;

		// Hitta <index> för den önskade tävlande, via det valda start nr
		for (var skier : race.getSkierList()) {
			if (skier.getSkierNumber() == chosenStartNum) {
				currentIndex = race.getSkierList().indexOf(skier);
			}
		}

		// Kom åt starttid för objektet på det funna indexet
		LocalTime chosenIndivStartTime = race.getSkierList().get(currentIndex).getIndivStartTime();
		race.getSkierList().get(currentIndex).setTempTime(Timing.calcDuration(chosenIndivStartTime));
		System.out.println("Vald tävlande har åkt i: " + race.getSkierList().get(currentIndex).getTempTime());
	}

	// METOD: val 2 i menyn - dvs. registrera måltid för vald åkare
	private void regGoalTime() {

		System.out.println("Vilken tävlande vill du registrera måltid för?: ");
		int chosenStartNum = Input.readInt();
		int currentIndex = 0;

		// Hitta <index> för den önskade tävlande, via det valda start nr
		for (var skier : race.getSkierList()) {
			if (skier.getSkierNumber() == chosenStartNum) {
				currentIndex = race.getSkierList().indexOf(skier);
			}
		}

		// Kom åt starttid för objektet på det funna indexet
		LocalTime chosenIndivStartTime = race.getSkierList().get(currentIndex).getIndivStartTime();
		race.getSkierList().get(currentIndex).setGoalTime(Timing.calcDuration(chosenIndivStartTime));
		System.out.println("Vald tävlandes måltid: " + race.getSkierList().get(currentIndex).getGoalTime());
	}
}
