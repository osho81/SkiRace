package com.ya.grupp5b.skirace.skier;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Comparator;

public class CompareTempTime implements Comparator<Skier> {

	public int compare(Skier skier1, Skier skier2) {
		LocalTime testTime = LocalTime.of(0, 0, 0, 0);
		Duration duration1 = Duration.between(testTime, skier1.getTempTime());
		int durationInSec1 = (int) duration1.toSeconds();
		Duration duration2 = Duration.between(testTime, skier2.getTempTime());
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
