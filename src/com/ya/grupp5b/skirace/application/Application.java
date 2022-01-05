package com.ya.grupp5b.skirace.application;

import java.util.Collections;

import com.ya.grupp5b.skirace.race.Race;
import com.ya.grupp5b.skirace.tools.*;

public class Application {

	// Nödvändiga objekt
	private Race race = new Race();
	private MenuOutput menu = new MenuOutput();
	private Output output = new Output(); 
	private Input input = new Input(); 

	// METOD: Kör hela applikationen
	public void runSkiRace() {
		runMenu();
	}

	// METOD: Yttre menyn
	private void runMenu() {

		int menuChoice = 0;
		while (menuChoice != 2) {

			menu.printMenu();
			menuChoice = input.readInt();

			switch (menuChoice) {
			case 1:
				race.setRaceStart(input.selectStartTime());
				AddSkier.addSkier(race, input);
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
		while (menuChoice != 6) {

			menu.printInnerMenu();
			menuChoice = input.readInt();
			int currentIndex;

			switch (menuChoice) {
			case 1:
				output.printSkierList(race);
				break;
			case 2:
				currentIndex = input.regTempTime(race, output); // Registrera mellantid för vald åkare
				output.printChosenTempTime(currentIndex, race);
				break;
			case 3:
				currentIndex = input.regGoalTime(race, output); // Registrera måltid för vald åkare
				output.printChosenGoalTime(currentIndex, race);
				break;
			case 4:			
				output.printSkierTempTime(race);
				break;
			case 5:
				output.printSkierGoalTime(race);
				break;
			case 6:
				System.out.println("Stänger ned...");
				System.exit(0);
				break;
			default:
				System.out.println("Felaktigt val");
				break;
			}
		}
	}

}
