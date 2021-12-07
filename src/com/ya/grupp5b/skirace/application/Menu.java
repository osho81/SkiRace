package com.ya.grupp5b.skirace.application;

import java.util.Scanner;



public class Menu {

	void runMenu() {

		int menuChoice = 0;

		while (menuChoice != 5) {
			Scanner scan = new Scanner(System.in);
			System.out.println("1. L�gg till deltagare");
			System.out.println("2. Kolla mellantid & placering ");
			System.out.println("3. Tidtagning m�lg�ng");
			System.out.println("4. Visa resultat ");
			System.out.println("5. Avsluta");
			System.out.print("Val: ");
			menuChoice = scan.nextInt();

			switch (menuChoice) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			default:
				System.out.println("Felaktigt val");
				break;
			}
		}

	}

//	int readInt(Scanner scan) {
//		while (!scan.hasNextInt()) {
//			scan.nextLine();
//			System.out.print("Felaktigt val \nProva igen: ");
//		}
//		return scan.nextInt();
//	}
}
