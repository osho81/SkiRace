package com.ya.grupp5b.skirace.racetest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.ya.grupp5b.skirace.race.Race;

class RaceTest {

	@Test
	void testSetGetRaceStart() {
		//Arrange
		LocalTime start1=LocalTime.of(13, 0, 0, 0);
		Race race1=new Race();
		race1.setRaceStart(start1);
		//Act
		LocalTime teststart=LocalTime.of(13, 0, 0, 0);
		
		//Assert
		assertEquals(teststart, race1.getRaceStart());
	}

}
