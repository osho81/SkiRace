package com.ya.grupp5b.skirace.toolstest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalTime;

import org.junit.jupiter.api.Test;

import com.ya.grupp5b.skirace.tools.Input;

class InputTest {

	@Test 
	void testInputs() {
		System.out.println("Skriv in: 1");
		assertEquals(Input.readInt(), 1);
		System.out.println("Skriv in: test");
		assertEquals(Input.readString(), "test");
	}

	@Test
	void testStartTime() {
		System.out.println("Testa med nuvarande klockslag");
		LocalTime nowTime = LocalTime.now();
		nowTime = LocalTime.of(nowTime.getHour(), nowTime.getMinute());
			
		
		assertEquals(nowTime, Input.selectStartTime());
	}
}
