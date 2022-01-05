package com.ya.grupp5b.skirace.skier;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Comparator;

public class CompareGoalTime implements Comparator<Skier> {

	@Override
	public int compare(Skier skier1, Skier skier2) {

		LocalTime testTime = LocalTime.of(0, 0, 0, 0);	
		
		if (skier1.getGoalTime() == null) {
			return -1;
		} else if (skier2.getGoalTime() == null) {
			return 1;
		} else if (skier1.getGoalTime() == null && skier2.getGoalTime() == null) {
			return 0;
		} else {
			Duration duration1 = Duration.between(testTime, skier1.getGoalTime());
			int durationInSec1 = (int) duration1.toSeconds();
			Duration duration2 = Duration.between(testTime, skier2.getGoalTime());
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
