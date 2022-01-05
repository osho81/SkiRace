package com.ya.grupp5b.skirace.skier;

import java.time.Duration;
import java.util.Comparator;

/**
 * Klass för extern jämförare, jämför mellantider mellan Skiers
 */

public class CompareTempTime implements Comparator<Skier> {

	@Override
	public int compare(Skier skier1, Skier skier2) {

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
