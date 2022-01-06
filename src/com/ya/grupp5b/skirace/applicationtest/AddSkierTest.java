package com.ya.grupp5b.skirace.applicationtest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Collections;

import org.junit.jupiter.api.Test;

import com.ya.grupp5b.skirace.application.AddSkier;
import com.ya.grupp5b.skirace.race.Race;
import com.ya.grupp5b.skirace.tools.Input;

class AddSkierTest {

	@Test
	void testAddSkier() {
		//Arrange
		Input input=new Input();
		Race race=new Race();
		LocalTime start1=LocalTime.of(13, 0, 0, 0);
		race.setRaceStart(start1);
		
		//Act
		AddSkier.addSkier(race, input);
		Collections.sort(race.getSkierList());
		
		
		//Assert
		assertEquals(4,race.getSkierList().size());
		assertEquals(start1,race.getSkierList().get(0).getIndivStartTime());
		assertEquals(start1.plus(15,ChronoUnit.SECONDS),race.getSkierList().get(1).getIndivStartTime());
		
	}

}
