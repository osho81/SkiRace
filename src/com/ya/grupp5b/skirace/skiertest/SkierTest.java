package com.ya.grupp5b.skirace.skiertest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ya.grupp5b.skirace.skier.Skier;

class SkierTest {

	
	@Test
	void testSkierStringString() {
		
		Skier skier1 = new Skier("Kalle", "Anka");
		skier1.setSkierNumber(2);
		
		String testFirstName = "Kalle";
		String testLastName = "Anka";
		
		assertEquals(testFirstName, skier1.getFirstName());
		assertEquals(testLastName, skier1.getLastName());
		assertEquals(2, skier1.getSkierNumber());
	}

}
