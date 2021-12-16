package com.ya.grupp5b.skirace.application;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.ya.grupp5b.skirace.skier.Skier;
import com.ya.grupp5b.skirace.tools.*;

public class Menu {

	static void runMenu() {

		// Gör skiersList tillgänglig i denna klass
		List<Skier> skiersList = SkierReg.addSkier();

		int menuChoice = 0;

		while (menuChoice != 5) {
			Scanner scan = new Scanner(System.in);

			System.out.println("1. Lägg till deltagare");
			System.out.println("2. Kolla mellantid & placering");
			System.out.println("3. Tidtagning målgång");
			System.out.println("4. Visa resultat ");
			System.out.println("5. Avsluta");
			System.out.print("Val: ");
			menuChoice = scan.nextInt();

			switch (menuChoice) {
			case 1:
				// Tillfälligt uppflyttad
				// (inga andraval går att göra innan val 1 är gjort)
				break;
			case 2:
				checkDuration(skiersList);
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				System.out.println("Felaktigt val");
				break;
			}
		}

	}

	// Metod för att köra val 2 - dvs. checka specific tävlandes löpta tid
	private static void checkDuration(List<Skier> skiersList) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Vilken tävlande vill du checka id för?");
		int chosenStartNum = scan.nextInt();
		int currentIndex = 0;

		// Hitta <index> för den önskade tävlande, via det valda start nr
		// (Detta sätt skulle fungera även om man inte har sorterad lista)
		for (var skier : skiersList) {
			if (skier.getSkierNumber() == chosenStartNum) {
				currentIndex = skiersList.indexOf(skier);
				
				// Tillfälliga kontrollutskrifter
				System.out.println(skier);
				System.out.println(currentIndex);
				System.out.println(skier.getSkierNumber());
			}
		}

		// Kom åt starttid för objektet på det funna indexet
		LocalTime startingTimeToPass = skiersList.get(currentIndex).getIndivStartTime();

		// Anropa tidsberäkningsmetoden med den utdragna starttiden
		Timing.lapsedTime(startingTimeToPass);
	}

//	int readInt(Scanner scan) {
//		while (!scan.hasNextInt()) {
//			scan.nextLine();
//			System.out.print("Felaktigt val \nProva igen: ");
//		}
//		return scan.nextInt();
//	}
}
