package com.java.streams;

@FunctionalInterface
interface Cab2
{
	public String  bookCab(String source, String destination);
}

/*
class Ola implements Cab2
{
	@Override
	public String bookCab(String source, String destination) {
		System.out.println("Ola source and destination is...."+ source+ "    "+ destination);
		return "Source price......"+source;
	}
}

*/

public class LamdaExpressions2 
{
	public static void main(String[] args) 
	{
		Cab2 cab = (source, destination) -> {  
																		System.out.println("Ola source and destination is...."+ source+ "    "+ destination);
																		return "Hello"+ source;
																	};
		cab.bookCab("Hyd","Mumbai");
	}
}
