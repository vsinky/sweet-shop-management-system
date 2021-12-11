package com.workshop.demo;

import java.util.Scanner;

public class Application {
final static int Exit_Value = 5;
	
	SweetStore sweetstore = new SweetStore();
	UserInterface userInterface = new UserInterface();

	public static void main(String[] args) {
		System.out.println("Welcome to Sweet Shop.");

		UserInterface userInterface = new UserInterface();
		Application application = new Application();
		while (true) {
			int input = userInterface.showUserMenu();
			application.handleUserSelection(input);
			if (input == Exit_Value) {
				break;
			}

		}
		System.out.println("The END");
	}

	private void handleUserSelection(int input) {
		UserInterface userInterface = new UserInterface();
		switch (input) {
		case 1:
			Laddu laddu = new Laddu();
			laddu.price = 25;
			
			GulabJamun gulabJamun = new GulabJamun();
			gulabJamun.price = 65;
			
			Modak modak = new Modak();
			modak.price = 80;
			
			KajuBarfi kajuBarfi = new KajuBarfi();
			kajuBarfi.price = 65;

			sweetstore.add(gulabJamun);
			sweetstore.add(laddu);
			sweetstore.add(kajuBarfi);
			sweetstore.add(modak);
			break;
		case 2:
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the Sweet name : ");
			String sweetName = scanner.nextLine();
			Sweet name = sweetstore.getSweet(sweetName);
			sweetstore.removeSweet(name);
			break;
		case 4:
			UserInterface userInterface1 = new UserInterface();
			userInterface1.printAllSweet(sweetstore.getList());
			break;
		case Exit_Value:
			System.out.println("Thank You");
			break;
			}
		}
	}