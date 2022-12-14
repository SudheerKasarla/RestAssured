package com.java.defaultfunctionalinterfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {

	public static void main(String[] args) {

		Consumer<String> consumer = new Consumer<String>() {

			@Override
			public void accept(String name) {
				System.out.println("Anonymous class is......." + name);

			}
		};
		consumer.accept("Consumer");

	//===========================================================
		
		Consumer<String> con = (name) -> {     System.out.println("Name is...." + name);   };
		con.accept("Anonymous");
		
	//===========================================================

		List<String> names = new ArrayList<>();
		names.add("Java");
		names.add("Selenium");
		names.add("Testing");
		
		
		names.forEach((name) -> System.out.println("Names in list is..........."+ name));
		
		//==========================================================
		
		names.forEach((name) ->
		{
			String str = name.toUpperCase();
			System.out.println("Uppercase is....."+ str);
			
		});
		 
		
		
		//==============================AndThen===========================
		
		Consumer<String> consumer1 = (name) -> System.out.println("Update is...."+name);
		Consumer<String> consumer2 = (name) -> System.out.println("Update2 is...."+name);
		
		consumer1.andThen(consumer2).accept("Reddy");   // Accept  --> To accept the input
		
		System.out.println("===================================");
		List<String> names2 = new ArrayList<>();
		names2.add("Java");
		names2.add("Selenium");
		names2.add("Testing");
		
		names2.forEach(consumer1.andThen(consumer2));
		
		
		
		//==================================================
		
		
		Consumer<String> cons1 = (name) -> {System.out.println(name);};
		cons1.accept("Consumer preference is.....");
		
		cons1.andThen(cons1).accept("Consumer....");
		
		
		//===================================================
		
		System.out.println("-----------------------------------------------------------------------------");
		
		Consumer<String> con1 = (element) -> System.out.println("Consumer element is....."+ element);
		Consumer<String> con2 = (element) -> System.out.println("Consumer element is....."+ element);
		
		List<String> elements = new ArrayList<>();
		elements.add("ABC");
		elements.add("CDE");
		elements.add("EFG");
		elements.add("HIJ");
		elements.add("KLM");
		elements.add("MNO");
		
		elements.forEach(con1.andThen(con2));
		
		System.out.println("=================ABC=====================");
		
		
		elements.forEach((ele) -> 
		{
			String str =ele.toLowerCase();
			System.out.println("Lower is....."+str);
			
		});
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
