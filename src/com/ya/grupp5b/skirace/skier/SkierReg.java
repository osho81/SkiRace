package com.ya.grupp5b.skirace.skier;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;



public class SkierReg {
	
	public static int totalSkiers() { // Tar in antalet tävlande

		Scanner scan = new Scanner(System.in);
		System.out.println("Hur många ska tävla? ");
		int totalSkiers = scan.nextInt();
		scan.nextLine();

		return totalSkiers;

	}
	public static void addSkier() { // Tar in tävlandens namn och delar ut startnummer

		Scanner scan = new Scanner(System.in);
		int totalSkiers = totalSkiers();
		
		
		List<Integer> numbersList = new Vector<Integer>();
		List<Skier> skiersList = new ArrayList<Skier>();

		
		for (int i = 1; i <= totalSkiers; i++) {
			numbersList.add(i);
			
			System.out.println("Förnamn: ");
			String firstName = scan.nextLine();
			System.out.println("Efternamn: ");
			String lastName = scan.nextLine();
			Skier newSkier = new Skier(firstName, lastName);
			skiersList.add(newSkier);
			
		}
		
			for (int j = totalSkiers; j > 0; j--) {
				int randomValue = (int) (Math.random() * (1 * j)) ;
				Skier newSkier = skiersList.get(j - 1);
				newSkier.setSkierNumber(numbersList.get(randomValue));
				numbersList.remove(randomValue);
			}
			
			//Collections.sort(skiersList); //**lägg till om man vill ha listan sorterad efter startnummer
			for (Skier newSkier : skiersList) {
				System.out.println(newSkier);
			}
			
		}
	
}