package com.ya.grupp5b.skirace.tools;

public class MenuOutput {

	public void printMenu() {
		System.out.println("1. Skapa tävling");
		System.out.println("2. Avsluta");
		System.out.print("Val: ");
		System.out.println();
	}

	public void printInnerMenu() {
		System.out.println();
		System.out.println("1. Visa deltagarlista");
		System.out.println("2. Tidtagning mellantid ");
		System.out.println("3. Tidtagning målgång ");
		System.out.println("4. Visa mellantid & placering");
		System.out.println("5. Visa målgångstid & placering");
		System.out.println("6. Avsluta");
		System.out.print("Val: ");
		System.out.println();
	}

}
