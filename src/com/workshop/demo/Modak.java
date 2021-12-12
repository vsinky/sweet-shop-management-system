package com.workshop.demo;

import java.util.ArrayList;

public class Modak extends Sweet{
	public Modak() {
		name="Modak";
		shape = shape.TRIANGLE;
		colour = colour.YELLOW;
		price = 30;
		ingredient = new ArrayList();
		ingredient.add("Sugar");
		ingredient.add("Floar");

	}
}