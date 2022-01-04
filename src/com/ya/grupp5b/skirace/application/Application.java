package com.ya.grupp5b.skirace.application;

import java.util.Collections;

import com.ya.grupp5b.skirace.race.Race;
import com.ya.grupp5b.skirace.tools.*;

public class Application {

	// Nödvändiga objekt
	private Race race = new Race();
	private MenuOutput menu = new MenuOutput();

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
		while (menuChoice != 6) {

			menu.printInnerMenu();
			menuChoice = Input.readInt();

			switch (menuChoice) {
			case 1:
				Output.printSkierList(race);
				break;
			case 2:
				Input.regTempTime(race); // Registrera mellantid för vald åkare
				break;
			case 3:
				Input.regGoalTime(race); // Registrera måltid för vald åkare
				break;
			case 4:			
				Output.printSkierTempTime(race);
				break;
			case 5:
				Output.printSkierGoalTime(race);
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
