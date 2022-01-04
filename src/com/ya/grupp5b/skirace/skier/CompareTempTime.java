package com.ya.grupp5b.skirace.skier;

import java.time.Duration;
import java.util.Comparator;

public class CompareTempTime implements Comparator<Skier> {

	public int compare(Skier skier1, Skier skier2) {
//		LocalTime tempTime1 = skier1.getTempTime();
//		LocalTime tempTime2 = skier2.getTempTime();
//		// Kan lägga till nowTime.plus(15 * skier1.getStartNr)
//		Duration duration1 = Duration.between(tempTime1, skier1.getIndivStartTime());
//		int durationInSec1 = (int) duration1.toSeconds();
//		Duration duration2 = Duration.between(tempTime2, skier2.getIndivStartTime());
//		int durationInSec2 = (int) duration2.toSeconds();
//
//		if (durationInSec1 < durationInSec2) {
//			return -1;
//		} else if (durationInSec1 > durationInSec2) {
//			return 1;
//		} else {
//			return 0;
//		}
		////////////////////////////////////////////////
		if (skier1.getTempTime() == null) {
			return -1;
		} else if (skier2.getTempTime() == null) {
			return 1;
		} else if (skier1.getTempTime() == null && skier2.getTempTime() == null) {
			return 0;
		} else {
			Duration duration1 = Duration.between(skier1.getTempTime(), skier1.getIndivStartTime());
			int durationInSec1 = (int) duration1.toSeconds();
			Duration duration2 = Duration.between(skier2.getTempTime(), skier2.getIndivStartTime());
			int durationInSec2 = (int) duration2.toSeconds();
			if (durationInSec1 < durationInSec2) {
				return -1;
			} else if (durationInSec1 > durationInSec2) {
				return 1;
			} else {
				return 0;
			}
		}

	}

}
