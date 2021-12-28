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
import com.ya.grupp5b.skirace.skier.CompareSkier;
import com.ya.grupp5b.skirace.skier.Skier;
import com.ya.grupp5b.skirace.tools.*;

public class Application {

	private Race race = new Race();
	private Menu menu = new Menu();

	public void runSkiRace() {
		runMenu();
	}

	public void runMenu() {

		int menuChoice = 0;
		while (menuChoice != 2) {

			menu.printMenu();
			menuChoice = Input.readInt();

			switch (menuChoice) {
			case 1:
				race.setRaceStart(selectStartTime());
				addSkier();
//				Collections.sort(race.getSkierList());//Sorterar efter startnummer
//				printSkierList();
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

	private void runInnerMenu() {

		int menuChoice = 0;
		while (menuChoice != 4) {
			
			menu.printInnerMenu();
			menuChoice = Input.readInt();

			switch (menuChoice) {
			case 1:
				checkTempTime();
				// Kolla mellantid & placering
				break;
			case 2:
				regGoalTime();
				
				break;
			case 3:
				CompareSkier test = new CompareSkier();
				Collections.sort(race.getSkierList(), test);
				printSkierList();
				// Visa resultat
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

	private LocalTime selectStartTime() {
		System.out.println("Vilken tid startar racet? ");
		int h = Input.readInt();
		int m = Input.readInt();
		int s = Input.readInt();
//		int ns = Input.readInt();

		// Tilldela denna starttid
		LocalTime raceStart = LocalTime.of(h, m, s, 0);
		return raceStart;

	}

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

			// Skapa objekt (tävlande) av Skier-klass; constructor 1
			Skier newSkier = new Skier(firstName, lastName);

			// Lägg till skapat objektet (tävlande) i listan
			race.setSkierList(newSkier);

		}

		// Tilldela startnummer till varje tävlande
		for (int j = totalSkiers; j > 0; j--) {
			int randomValue = (int) (Math.random() * (1 * j)); // exempel random: 2
			Skier newSkier = race.getSkierList().get(j - 1); // exempel tävlande nr 4: Pelle Oskarsson

			// Gällande tävlande (exempel: Pelle Oskarsson, nr 4) i skiersList
			// Tilldelas ett startnummer med hjälp av setSkierNumber i klassen SKier
			// Exempel: numbersList = 1,2,3,4,5; numbersList(2) = 3
			newSkier.setSkierNumber(numbersList.get(randomValue));

			// Ta bort redan tilldelat nummer ur numbersList
			numbersList.remove(randomValue);

		}

		// Hämta starttid
//		LocalTime raceStart = Timing.startingTime(totalSkiers);

		// Tilldela starttid och öka (15 sekunder * startnummer) för varje tävlande
		for (int j = 0; j < race.getSkierList().size(); j++) { // Ex:

			// Exempel: första loopen bakifrån är tävlande nr 3 på index 4
			// Öka raceStart med (15 sekunder * startnummer)
			race.getSkierList().get(j).setIndivStartTime(race.getRaceStart()
					.plus(15 * race.getSkierList().get(j).getSkierNumber() - 15, ChronoUnit.SECONDS));

			// Tilldela denna starttid
//			race.getSkierList().get(j).setIndivStartTime(givenStartTime);
		}

	}

	private void printSkierList() {

		for (Skier newSkier : race.getSkierList()) {
			System.out.println(newSkier);
		}
	}

	// Metod för att köra val 2 - dvs. checka specific tävlandes löpta tid
	private void checkTempTime() {

		System.out.println("Vilken tävlande vill du checka tid för?");
		int chosenStartNum = Input.readInt();
		int currentIndex = 0;

		// Hitta <index> för den önskade tävlande, via det valda start nr
		// (Detta sätt skulle fungera även om man inte har sorterad lista)
		for (var skier : race.getSkierList()) {
			if (skier.getSkierNumber() == chosenStartNum) {
				currentIndex = race.getSkierList().indexOf(skier);
			}
		}

		// Kom åt starttid för objektet på det funna indexet
		LocalTime chosenIndivStartTime = race.getSkierList().get(currentIndex).getIndivStartTime();
		race.getSkierList().get(currentIndex).setTempTime(Timing.calcDuration(chosenIndivStartTime));
		System.out.println("Vald tävlande har åkt i: " + race.getSkierList().get(currentIndex).getTempTime());
		// Anropa tidsberäkningsmetoden med den utdragna starttiden

	}

	private void regGoalTime() {

		System.out.println("Vilken tävlande vill du registrera måltid för?: ");
		int chosenStartNum = Input.readInt();
		int currentIndex = 0;

		// Hitta <index> för den önskade tävlande, via det valda start nr
		// (Detta sätt skulle fungera även om man inte har sorterad lista)
		for (var skier : race.getSkierList()) {
			if (skier.getSkierNumber() == chosenStartNum) {
				currentIndex = race.getSkierList().indexOf(skier);
			}
	
		}

		// Kom åt starttid för objektet på det funna indexet
		LocalTime chosenIndivStartTime = race.getSkierList().get(currentIndex).getIndivStartTime();
		race.getSkierList().get(currentIndex).setGoalTime(Timing.calcDuration(chosenIndivStartTime));
		System.out.println("Vald tävlandes måltid: " + race.getSkierList().get(currentIndex).getGoalTime());
		// Anropa tidsberäkningsmetoden med den utdragna starttiden

	}

//	int readInt(Scanner scan) {
//		while (!scan.hasNextInt()) {
//			scan.nextLine();
//			System.out.print("Felaktigt val \nProva igen: ");
//		}
//		return scan.nextInt();
//	}
}
