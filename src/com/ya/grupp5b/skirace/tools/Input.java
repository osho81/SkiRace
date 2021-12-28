package com.ya.grupp5b.skirace.tools;

import java.util.Scanner;

public class Input {

	public static Scanner scan = new Scanner(System.in);
	
	public static String readString() {
		while (!scan.hasNextLine()) { // Försök fixa så man inte kan skriva in siffror
//			scan.nextLine();
			System.out.println("Felaktig inmatning \nProva igen: ");
		}
		return scan.nextLine();
		
	}
	
	//Skapa en metod som kan läsa klockslag
	
	public static int readInt() {		
		while (!scan.hasNextInt()) {
			scan.nextLine();
			System.out.print("Felaktig inmatning \nProva igen: ");
		}
		int chosenInt = scan.nextInt();
		scan.nextLine();
		return chosenInt;
	}
	
}
