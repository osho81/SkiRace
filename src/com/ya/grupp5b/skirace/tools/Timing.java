package com.ya.grupp5b.skirace.tools;

import java.time.DateTimeException;
import java.time.Duration;
import java.time.LocalTime;

/**
 * Klass som hanterar klassmetod för tidsberäkning
 */

public class Timing {

	// METOD: Tidsberäknarmetod, beräknar löpt tid utifrån nuvarande tid
	public static LocalTime calcDuration(LocalTime chosenStartTime) {

		LocalTime currentTime = LocalTime.now();

		Duration duration = Duration.between(chosenStartTime, currentTime);

		// Dra ur en "normal" tidsangivelse ur duration; hh:mm:ss:ns
		int durationH = (int) duration.toHours();
		int durationM = (int) duration.toMinutesPart();
		int durationS = (int) duration.toSecondsPart();
		int durationNs = (int) duration.toNanosPart();

		// Felhantering för starttid
		try {
			return LocalTime.of(durationH, durationM, durationS, durationNs);
		} catch (DateTimeException e) {
			System.out.println("OBS! Vald åkare har inte startat.");
		}

		return null;
	}

}
