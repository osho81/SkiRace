package com.ya.grupp5b.skirace.application;

import java.time.LocalTime;
import java.util.Collections;
import com.ya.grupp5b.skirace.race.Race;
import com.ya.grupp5b.skirace.skier.CompareTempTime;
import com.ya.grupp5b.skirace.tools.*;

public class Application {

	// Nödvändiga objekt
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
				race.setRaceStart(Input.selectStartTime());
				AddSkier.addSkier(race);
				Collections.sort(race.getSkierList());// Sorterar efter startnummer
				runInnerMenu();
				break;
			case 2:
				System.out.println("Stänger ned...");
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
				Output.printSkierList(race);
				break;
			case 2:
				checkTempTime(); // Kolla mellantid & placering för vald åkare
				Output.printSkierTempTime(race);
				break;
			case 3:
				regGoalTime(); // Registrera måltid för vald åkare
				break;
			case 4:
				Output.printSkierGoalTime(race);
				break;
			case 5:
				System.out.println("Stänger ned...");
				System.exit(0);
				break;
			default:
				System.out.println("Felaktigt val");
				break;
			}
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
		Output.printChosenTempTime(currentIndex, currentTempTime, race);
	}

	// METOD: val 2 i menyn - dvs. registrera måltid för vald åkare
	private void regGoalTime() {

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
