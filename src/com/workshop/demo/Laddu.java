package com.workshop.demo;

import java.util.ArrayList;

public class Laddu extends Sweet{
	public Laddu() {
		name="Laddu";
		shape = shape.ROUND;
		colour = colour.YELLOW;
		price = 10;
		ingredient = new ArrayList();
		ingredient.add("Sugar");
		ingredient.add("Floar");
		name = "Laddu";	
	}
}