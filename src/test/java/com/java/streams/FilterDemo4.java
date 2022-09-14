package com.java.streams;

import java.util.ArrayList;
import java.util.List;

class Product {
	int id;
	String name;
	double price;

	public Product(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;

	}
}

public class FilterDemo4 {

	public static void main(String[] args) {

		List<Product> productList = new ArrayList<Product>();
		productList.add(new Product(1, "HP Laptop", 25000));
		productList.add(new Product(2, "HP Laptop2", 50000));
		productList.add(new Product(3, "HP Laptop3", 50000));
		productList.add(new Product(4, "HP Laptop4", 2000));
		productList.add(new Product(5, "HP Laptop5", 1000));
		
		
		productList.stream().filter(p -> p.price > 2000).forEach(p ->  System.out.println("Name is    "+p.name+"       "+p.price));
	}

}
