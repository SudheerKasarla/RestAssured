package com.java.streams;

public class MyImplementation {

	public static void main(String[] args) 
	{
		MyFunctionalInterface funct = new MyFunctionalInterface() {
			
			@Override
			public void add() {
				System.out.println("Add in functional");
				
			}
		};
		
		funct.add();
	

	}

}
