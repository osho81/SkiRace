package com.ya.grupp5b.skirace.toolstest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.ya.grupp5b.skirace.tools.Timing;

class TimingTest {

	@Test
	void testCalcDuration() {
		
		//Arrange
		LocalTime startTime = LocalTime.of(10, 2); 
		LocalTime returnedLapse = Timing.calcDuration(startTime);	
		Duration testLapse = Duration.between(LocalTime.of(10, 2), LocalTime.now());
		
		// Act
		long returnedH = (long) returnedLapse.getHour();
		long returnedM = (long) returnedLapse.getMinute();
		long testH = testLapse.toHoursPart();
		long testM = testLapse.toMinutesPart();
		
		//Assert
		assertEquals(testH, returnedH);
		assertEquals(testM, returnedM);

	}

}
