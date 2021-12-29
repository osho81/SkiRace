package com.ya.grupp5b.skirace.application;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;
import java.util.List;
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
				AddSkier.addSkier(race);
				Collections.sort(race.getSkierList());// Sorterar efter startnummer
				printSkierList();
				runInnerMenu();
				break;
			case 2:
				// Tillfällig exit
				System.out.println("Stänger ned...");
				System.exit(0);
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
		while (menuChoice != 4) {

			menu.printInnerMenu();
			menuChoice = Input.readInt();

			switch (menuChoice) {
			case 1:
				checkTempTime(); // Kolla mellantid & placering för vald åkare
				printSkierTempTime();
				break;
			case 2:
				regGoalTime(); // Registrera måltid för vald åkare
				break;
			case 3:
				printSkierGoalTime();
				break;
			case 4:
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
		System.out.println("Vilken tid startar tävlingen? ");
		int h = Input.readInt();
		int m = Input.readInt();
		int s = Input.readInt();

		LocalTime raceStart = LocalTime.of(h, m, s, 0);
		return raceStart;
	}

	// METOD: Skriver ut skierList
	private void printSkierList() {
		for (Skier newSkier : race.getSkierList()) {
			System.out.println(newSkier);
		}
	}

	// METOD: Skriver ut listan för GoalTime utskrift "Startnr: " firstName lastName
	// "Målgång: " goalTime
	private void printSkierGoalTime() {
		CompareGoalTime goalCheck = new CompareGoalTime(); // Jämför måltid
		Collections.sort(race.getSkierList(), goalCheck);
		System.out.println("\nNamn\t\t\t#Startnr\t\tMålgång\t\t\tPlacering");
		for (int i = 0; i < race.getSkierList().size(); i++) {
			System.out.println(race.getSkierList().get(i).getFirstName() + " "
					+ race.getSkierList().get(i).getLastName() + "\t\t#" + race.getSkierList().get(i).getSkierNumber()
					+ "\t\t\t" + race.getSkierList().get(i).getGoalTime() + "\t\t" + (i + 1) + "\n");
		}
	}

	private void printSkierTempTime() {
		CompareTempTime tempCheck = new CompareTempTime(); // Jämför mellantid
		Collections.sort(race.getSkierList(), tempCheck);

		System.out.println("\nNamn\t\t\t#Startnr\t\tMellantid\t\t\tPlacering");
		for (int i = 0; i < race.getSkierList().size(); i++) {

			LocalTime currentTempTime = Timing.calcDuration(race.getSkierList().get(i).getIndivStartTime());
			System.out.println(race.getSkierList().get(i).getFirstName() + " "
					+ race.getSkierList().get(i).getLastName() + "\t\t#" + race.getSkierList().get(i).getSkierNumber()
					+ "\t\t\t" + currentTempTime + "\t\t" + (i + 1) + "\n");
		}
	}

	// METOD: val 3 i menyn - dvs. checka specific tävlandes löpta tid & placering
	private void checkTempTime() {
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
		System.out.println("Mellantiden " + currentTempTime + " är tagen för skidåkare med startnummer #"
				+ race.getSkierList().get(currentIndex).getSkierNumber() + ", "
				+ race.getSkierList().get(currentIndex).getFirstName() + " "
				+ race.getSkierList().get(currentIndex).getLastName() + ", placering: " + (currentIndex + 1));
	}

	// METOD: val 2 i menyn - dvs. registrera måltid för vald åkare
	private void regGoalTime() {

		System.out.println("\nVilken tävlande vill du registrera måltid för?: ");
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

		System.out.println("Målgångstiden " + race.getSkierList().get(currentIndex).getGoalTime()
				+ " är registrerad för skidåkare med startnummer #"
				+ race.getSkierList().get(currentIndex).getSkierNumber() + ", "
				+ race.getSkierList().get(currentIndex).getFirstName() + " "
				+ race.getSkierList().get(currentIndex).getLastName() + "\n");

	}

}
