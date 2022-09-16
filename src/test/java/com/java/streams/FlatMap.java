package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class FlatMap {

	@Test
	public void Flatmap() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

		list.stream().map(n -> n + 5).collect(Collectors.toList()).forEach(n -> System.out.println("Number is..." + n));

		// flatMap

		List<Integer> list1 = Arrays.asList(1, 2);
		List<Integer> list2 = Arrays.asList(3, 4);
		List<Integer> list3 = Arrays.asList(5, 6);

		List<List<Integer>> finalList = Arrays.asList(list1, list2, list3);

		List<Integer> finalResults = finalList.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
		System.out.println("Final list is..." + finalResults);

		List<Integer> finalResults2 = finalList.stream().flatMap(x -> x.stream().map(n -> n * 10))
				.collect(Collectors.toList());
		System.out.println("Final list is..." + finalResults2);

	}

	@Test
	public void FlatMap2() {
		List<String> teamA = Arrays.asList("Scott", "Alex", "David", "John", "Jermy");
		List<String> teamB = Arrays.asList("Gil", "Johny", "John", "Kitty", "Tom");
		List<String> teamC = Arrays.asList("Ken", "Jony", "Rob", "Brigs", "Johnson");

		List<List<String>> players = new ArrayList<List<String>>();
		players.add(teamA);
		players.add(teamB);
		players.add(teamC);

		for (List<String> team : players) {
			for (String name : team) {
				System.out.println("Player name is..." + name);

			}

		}

		List<String> names = players.stream().flatMap(p -> p.stream()).collect(Collectors.toList());
		System.out.println("Names is...." + names);

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
	public void FlatMap4()
	{
		
		List<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(101, "Smith", 10000));
		emp.add(new Employee(102, "John", 20000));
		emp.add(new Employee(103, "Kennedy", 30000));
		
		List<Employee> emp2 = new ArrayList<Employee>();
		emp2.add(new Employee(101, "Smith", 10000));
		emp2.add(new Employee(102, "John", 20000));
		emp2.add(new Employee(103, "Kennedy", 30000));
		
		
		List<List<Employee>> empList = Arrays.asList(emp,emp2);
		
		for(List<Employee> s: empList)
		{
			for(Employee e : s)
			{
				System.out.println("Employee....."+ e);
				
			}
			
		}
		
	List<String > employeeList=	empList.stream().flatMap(e -> e.stream()).map(n -> n.name).collect(Collectors.toList());
	System.out.println("Name list is........."+ employeeList);
		
		
		
		
		
	}

}
