package com.workshop.demo;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
	final static int Exit_Value = 6;
	Scanner sc = new Scanner(System.in);
//	UserInterface userInterface = UserInterface.getInstance();
//	SweetStore sweetstore = new SweetStore();

	public static void main(String[] args) {
		UserInterface userInterface = UserInterface.getInstance();
		System.out.println("Welcome to Sweet Shop.");
		int input = 0;
		Application app = new Application();
		while (input != Application.Exit_Value) {
			input = userInterface.showUserMenu();
			app.handleUserSelection(input);
		}
	}

	private void handleUserSelection(int input) {
		Scanner sc = new Scanner(System.in);
		SweetStore sweetStore = SweetStore.getInstance();// Singleton concept
		switch (input) {
		case 1:
			addSweet();
			break;
		case 2:
			System.out.println("Enter the name you want to delete");
			String sweetName = sc.nextLine();
			Sweet name = sweetStore.getSweet(sweetName);
			sweetStore.removeSweet(name);
			break;
		case 3:
			System.out.println("Enter a sweet name you want to update");
			sweetName = sc.nextLine();
			Sweet sweet = sweetStore.getSweet(sweetName);
			updateSweet(sweet);
			break;
		case 4:
			UserInterface userInterface = UserInterface.getInstance();
			userInterface.printAllSweet(sweetStore.getList());
			break;
		case 5:
			UserInterface userInterface1 = UserInterface.getInstance();
			userInterface1.printAllYellowSweet(sweetStore.getList());
			break;
		case Exit_Value:
			System.out.println("Thank You");
			break;
		}
	}

	private void addSweet() {
		SweetStore sweetstore = SweetStore.getInstance();
		Sweet sweet = new Sweet();
		System.out.println("Enter sweet name");
		sweet.name = sc.next();
		System.out.println("Enter color");
		setColor(sweet);
		System.out.println("Enter shape");
		setShape(sweet);
		System.out.println("Enter price");
		sweet.price = sc.nextInt();
		setIngredient(sweet);
		sweetstore.add(sweet);

	}

	public void updateSweet(Sweet sweet) {
		System.out.println("Enter \n1.Shape\n2.Colour\n3.Name\n4.Price\n5.Ingredient");
		int option = sc.nextInt();
		switch (option) {
		case 1:
			setShape(sweet);
			break;
		case 2:
			setColor(sweet);
			break;
		case 3:
			updateName(sweet);
			break;
		case 4:
			updatePrice(sweet);
			break;
		case 5:
			setIngredient(sweet);
			break;
		default:
			System.exit(0);
		}
	}

	private void setIngredient(Sweet sweet) {
		System.out.println("Enter the new Ingredients sweet\",\"");
		String newIngredients = sc.next();
		System.out.println(newIngredients);
//		sweet.ingredients.clear();
		String[] ingredientArr = newIngredients.split(",");

		sweet.ingredient = Arrays.asList(ingredientArr);
	}

	private void updatePrice(Sweet sweet) {
		System.out.println("Enter Price");
		int newPrice = sc.nextInt();
		sweet.price = newPrice;
	}

	private void updateName(Sweet sweet) {
		System.out.println("Enter Name");
		String newName = sc.nextLine();
		sweet.name = newName;
	}

	private void setColor(Sweet sweet) {
		System.out.println("Enter \n1.RED \n2.GREEN \n3.YELLOW\n4.WHITE");
		int color = sc.nextInt();

		switch (color) {

		case 1:
			sweet.colour = Sweet.Colour.RED;
			break;

		case 2:
			sweet.colour = Sweet.Colour.GREEN;
			break;

		case 3:
			sweet.colour = Sweet.Colour.YELLOW;
			break;

		case 4:
			sweet.colour = Sweet.Colour.WHITE;
			break;
		}

	}

	private void setShape(Sweet sweet) {
		System.out.println("Enter \n1.TRIANGLE \n2.SQUARE \n3.ROUND");
		int shape = sc.nextInt();

		switch (shape) {

		case 1:
			sweet.shape = Sweet.Shape.TRIANGLE;
			break;

		case 2:
			sweet.shape = Sweet.Shape.SQUARE;
			break;

		case 3:
			sweet.shape = Sweet.Shape.ROUND;
			break;
		}

	}
}
