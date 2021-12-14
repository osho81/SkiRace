package com.ya.grupp5b.skirace.tools;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;

import com.ya.grupp5b.skirace.skier.Skier;

public class SkierReg {

	public static int totalSkiers() { // Tar in antalet tävlande

		Scanner scan = new Scanner(System.in);
		System.out.println("Hur många ska tävla? ");
		int totalSkiers = scan.nextInt();
		scan.nextLine();

		return totalSkiers;

	}

	public static List<Skier> addSkier() { // Tar in tävlandens namn och delar ut startnummer

		Scanner scan = new Scanner(System.in);
		int totalSkiers = totalSkiers();

		List<Integer> numbersList = new Vector<Integer>();
		List<Skier> skiersList = new ArrayList<Skier>();

		// Fyll i numbersList med nummer; fyll i skiersList med nya tävlande
		for (int i = 1; i <= totalSkiers; i++) {
			numbersList.add(i);

			System.out.println("Förnamn: ");
			String firstName = scan.nextLine();
			System.out.println("Efternamn: ");
			String lastName = scan.nextLine();

			// Skapa objekt (tävlande) av Skier-klass; constructor 1
			Skier newSkier = new Skier(firstName, lastName);

			// Lägg till skapat objektet (tävlande) i listan
			skiersList.add(newSkier);

		}

		// Tilldela startnummer till varje tävlande
		for (int j = totalSkiers; j > 0; j--) {
			int randomValue = (int) (Math.random() * (1 * j)); // exempel random: 2
			Skier newSkier = skiersList.get(j - 1); // exempel tävlande nr 4: Pelle Oskarsson

			// Gällande tävlande (exempel: Pelle Oskarsson, nr 4) i skiersList
			// Tilldelas ett startnummer med hjälp av setSkierNumber i klassen SKier
			// Exempel: numbersList = 1,2,3,4,5; numbersList(2) = 3
			newSkier.setSkierNumber(numbersList.get(randomValue));

			// Ta bort redan tilldelat nummer ur numbersList
			numbersList.remove(randomValue);

		}

		// Hämta starttid
		LocalTime raceStart = Timing.startingTime(totalSkiers);

		// Tilldela starttid och öka (15 sekunder * startnummer) för varje tävlande
		for (int j = totalSkiers; j > 0; j--) { // Ex:

			// Exempel: första loopen bakifrån är tävlande nr 3 på index 4
			// Öka raceStart med (15 sekunder * startnummer)
			LocalTime givenStartTime = raceStart.plus(15 * skiersList.get(j - 1).getSkierNumber(), ChronoUnit.SECONDS);

			// Tilldela denna starttid
			skiersList.get(j - 1).setIndivStartTime(givenStartTime);
		}

		// Sorterar efter skier (se Skiers compareTo)
//		Collections.sort(skiersList);
		for (Skier newSkier : skiersList) {
			System.out.println(newSkier);
		}
		return skiersList;

	}

}
