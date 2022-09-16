package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class MapDemo {

	@Test
	public void Map() {
		List<String> vehicles = Arrays.asList("car", "bus", "flight", "ship");
		List<String> vehicles2 = new ArrayList<>();

		for (String name : vehicles) {
			vehicles2.add(name.toUpperCase());
		}

		// Stream -> Map
		List<String> vehiclesInUpperCase = vehicles.stream().map(name -> name.toUpperCase())
				.collect(Collectors.toList());
		System.out.println("Vehicles list is..." + vehiclesInUpperCase);
	}

	@Test /// Length of element
	public void Map2() {
		List<String> vehicles = Arrays.asList("car", "bus", "flight", "ship");
		// List<String> vehicles2 = new ArrayList<>();

		// Using streams

		vehicles.stream().map(v -> v.length()).forEach(len -> System.out.println(len));

	}

	@Test
	public void Map3() {
		List<Integer> numberList = Arrays.asList(2, 3, 4, 5);

		List<Integer> number2 = numberList.stream().map(n -> n * 3).collect(Collectors.toList());
		
		System.out.println("Number is...."+ number2);

	}
	
	class Employee
	{
		int id;
		String name;
		int salary;
		Employee(int id, String name, int salary) 
		{
			this.id =id;
			this.name = name;
			this.salary = salary;
			
		}
	}
	
	
	@Test
	public void Map4()
	{
		
		List<Employee> empList = Arrays.asList(
														new Employee(102, "Alex", 2000),
														new Employee(103, "Bob", 10000),
														new Employee(104, "Charles", 2000000),
														new Employee(105, "Edward", 20000));
		// Collection -> Stream -> Filter -> map -> Collect
	List<Integer> empSalList=		empList.stream()
						 .filter(s -> s.salary > 20000)
						 .map(s -> s.salary)
						 .collect(Collectors.toList());
	System.out.println("Salary is...."+ empSalList);
		
	}

}
