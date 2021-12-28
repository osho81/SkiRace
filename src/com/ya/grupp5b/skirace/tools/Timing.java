package com.ya.grupp5b.skirace.tools;

import java.time.Duration;
import java.time.LocalTime;


public class Timing {

	// Tidsberäknarmetod
	public static LocalTime calcDuration(LocalTime chosenStartTime) {

		// Ta reda på nuvarande tid (tiden vid checken)
		LocalTime currentTime = LocalTime.now();

		// Beräkna skillnad mellan startTid och nuvarande tid
		Duration duration = Duration.between(chosenStartTime, currentTime);
//		System.out.println("Lapsed time: " + duration);


		// Dra ur en "normal" tidsangivelse ur duration; hh:mm:ss:ns
		int durationH = (int)duration.toHours();
		int durationM = (int)duration.toMinutesPart(); // Tar hänsyn till andra tidsenheter
		int durationS = (int)duration.toSecondsPart();
		int durationNs = (int)duration.toNanosPart();
		int durationTest = (int) duration.toSeconds();
		return LocalTime.of(durationH, durationM, durationS, durationNs);
	}

}
