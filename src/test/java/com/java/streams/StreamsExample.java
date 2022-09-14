package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamsExample {

	@Test
	public void Streams() {
		// create a list of integers
		List<Integer> number = Arrays.asList(2, 3, 4, 5);

		number.stream().map(x -> x * 3).collect(Collectors.toList()).forEach(x -> System.out.println(x));

		List<String> names = Arrays.asList("Reflection", "Collection", "Stream");
		names.stream().filter(x -> x.startsWith("S")).forEach(x -> System.out.println(x));
		
		names.stream().sorted().collect(Collectors.toList()).forEach(x -> System.out.println("Sorted list is...."+x));
		
		
		List<Integer> number1 = Arrays.asList(2,3,4,5);
		int even = number1.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
		System.out.println("Even number is..."+ even);

	}
	
	@Test
	public void StreamCreation()
	{
		
		String[] arr =  {"a","b","c","d"};
		Stream<String> stream=	Arrays.stream(arr);
		stream.map(x-> x.startsWith("d")).forEach(x -> System.out.println("Starts with..............."+x));
		
		Arrays.asList(arr).parallelStream().forEach(x -> System.out.println("Parallel with..............."+x));
	}
	
	@Test
	public void StreamIteraction()
	{
		
		List<String> list =Arrays.asList("a","b","c","d");
		boolean b=  list.stream().anyMatch(x -> list.contains("a"));
		System.out.println("Boolean b is...."+ b);
	}
	
	
	@Test
	public void Filtering()
	{
		ArrayList<String> list = new ArrayList<>();
		list.add("One");
		list.add("OneAndOnly");
		list.add("Derek");
		list.add("Change");
		list.add("factory");
		list.add("justBefore");
		list.add("Italy");
		list.add("Italy");
		list.add("Thursday");
		list.add("");
		list.add("");
		
		list.stream().filter(x -> x.contains("d")).collect(Collectors.toList()).forEach(x -> System.out.println(x));
		
		List<Integer> integers = Arrays.asList(1, 1, 1);
		Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);
		System.out.println("....................."+reduced);
	}

}
