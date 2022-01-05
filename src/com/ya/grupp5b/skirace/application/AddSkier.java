package com.ya.grupp5b.skirace.application;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Vector;

import com.ya.grupp5b.skirace.race.Race;
import com.ya.grupp5b.skirace.skier.Skier;
import com.ya.grupp5b.skirace.tools.Input;

/**
 * Klass som hanterar klassmetod för anmälan av åkare
 */

public class AddSkier {

	// METOD: Användaren får lägga till antal åkare och åkare
	public static void addSkier(Race race, Input input) {

		System.out.println("Antal åkare:");
		int totalSkiers = input.readInt();

		List<Integer> numbersList = new Vector<Integer>();

		// Fyll i numbersList med nummer; fyll i skiersList med nya tävlande
		for (int i = 1; i <= totalSkiers; i++) {
			numbersList.add(i);
			System.out.println("Åkare " + i + ":");
			System.out.println("Förnamn: ");
			String firstName = input.readString();
			System.out.println("Efternamn: ");
			String lastName = input.readString();
			Skier newSkier = new Skier(firstName, lastName);
			race.setSkierList(newSkier);
		}

		// Tilldela startnummer till varje åkare
		for (int j = totalSkiers; j > 0; j--) {
			int randomValue = (int) (Math.random() * (1 * j));
			Skier newSkier = race.getSkierList().get(j - 1);
			newSkier.setSkierNumber(numbersList.get(randomValue));

			// Ta bort tilldelat nummer ur numbersList (så man inte kan få samma startnr)
			numbersList.remove(randomValue);
		}

		// Tilldela starttid och öka (15 sekunder * startnummer) för varje åkare
		for (int j = 0; j < race.getSkierList().size(); j++) {
			race.getSkierList().get(j).setIndivStartTime(race.getRaceStart()
					.plus(15 * race.getSkierList().get(j).getSkierNumber() - 15, ChronoUnit.SECONDS));
		}

	}

}
