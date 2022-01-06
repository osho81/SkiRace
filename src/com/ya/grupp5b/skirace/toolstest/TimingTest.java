package com.ya.grupp5b.skirace.toolstest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;

class TimingTest {

	@Test
	void testCalcDuration() {
		//Arrange
		LocalTime tid1=LocalTime.of(11, 0);
		LocalTime tid2=LocalTime.of(15, 0);
		Duration duration=Duration.between(tid1, tid2);
		
		//Act
		Duration durationH=Duration.of(4, ChronoUnit.HOURS);
		Duration durationM=Duration.of(240, ChronoUnit.MINUTES);
		Duration durationS=Duration.of(14400, ChronoUnit.SECONDS);
		
		//Assert
		assertEquals(durationH, duration);
		assertEquals(durationM, duration);
		assertEquals(durationS, duration);
	}

}
