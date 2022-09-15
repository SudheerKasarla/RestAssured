package com.java.streams;

@FunctionalInterface
interface Cab
{
	public void bookCab(String source, String destination);
}

public class LamdaExpressions 
{
	public static void main(String[] args) 
	{
		Cab cab = (source, destination) -> System.out.println("Cab booked from...."+ source +"    "+destination);
		cab.bookCab("Hyd","Mumbai");
	}
}
