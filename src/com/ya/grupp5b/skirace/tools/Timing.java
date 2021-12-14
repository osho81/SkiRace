package com.ya.grupp5b.skirace.tools;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class Timing {
	// Static deklarerad scanner, nåbar från hela projektet
	public static Scanner input = new Scanner(System.in);

	// Användaren väljer tid som returneras
	public static LocalTime startingTime(int totalSkiers) {
		System.out.println("Vilken tid startar racet? ");
		int h = input.nextInt();
		int m = input.nextInt();
		int s = input.nextInt();
		int ns = input.nextInt();

		// Tilldela denna starttid
		LocalTime raceStart = LocalTime.of(h, m, s, ns);

		return raceStart; // Returnera starttid
	}

	// Tidsberäknarmetod
	public static void lapsedTime(LocalTime chosenStartTime) {

		// Ta reda på nuvarande tid (tiden vid checken)
		LocalTime currentTime = LocalTime.now();

		// Beräkna skillnad mellan startTid och nuvarande tid
		Duration duration = Duration.between(chosenStartTime, currentTime);
		System.out.println("Lapsed time: " + duration);

		// Metoder för att dra ut läsbar info ur duration
		// VI TAR SEDAN MED BARA DET VI BEHÖVER
		// Dra ur hours ELLER minutes ELLER seconds ELLER nano seconds
		long durationInHour = duration.toHours();
		long durationInMin = duration.toMinutes(); // Tar ej hänsyn till andra tidsenheter
		long durationInSec = duration.toSeconds();
		long durationInNs = duration.toNanos();
		System.out.println(durationInHour + " hours or " + durationInMin + " minutes or " + durationInSec
				+ " seconds or " + durationInNs + " nano seconds.");

		// Dra ur en "normal" tidsangivelse ur duration; hh:mm:ss:ns
		long durationH = duration.toHours();
		long durationM = duration.toMinutesPart(); // Tar hänsyn till andra tidsenheter
		long durationS = duration.toSecondsPart();
		long durationNs = duration.toNanosPart();
		System.out.println("Vald tävlande har åkt i " + durationH + ":" + durationM + ":" + durationS + ":" + durationNs + ":");
	}

}
