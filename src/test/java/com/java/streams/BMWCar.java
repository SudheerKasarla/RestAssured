package com.java.streams;

public class BMWCar {

	public static void main(String[] args) {

		Vehicle v = () -> {
			System.out.println("Anonymous inner class");
		};
		v.color();

		Vehicle2 v2 = (name, pixel) -> {
			return "Pixel resoltion ..." + name + "   " + pixel;
		};

		String color = v2.color("Blue", "Resolution");
		System.out.println("Color is..." + color);
		
		//       () -> {}

	}

}
