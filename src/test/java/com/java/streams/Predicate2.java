package com.java.streams;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

import org.testng.annotations.Test;

public class Predicate2 {
	
	
	public  void predicate1()
	{
		
		Predicate<Integer> p = i -> (i > 10);
		System.out.println("Test method....."+p.test(20));
		System.out.println("Test method....."+p.test(10));
		
		
		//Check the length of given string is greater than 4 or not.
		
		Predicate<String> pr= str -> (str.length() >4);
		boolean p1=   pr.test("Test2");
		boolean p3=   pr.test("Tes");
		System.out.println("Length of string....."+p1);
		System.out.println("Length of string....."+p3);

	}
	
	@Test
	public void predicate2()
	{
		//Check the length of given string is greater than 4 or not.
		String names[] = {"David","Scot","Smith","John","Marry","Jeremy"};
		
		Predicate<String> pr= str -> (str.length() >4);
		for(String name : names)
		{
			if (pr.test(name)) {
				System.out.println(name);	
			}
			
		}
	}

	class Employee
	{
		String ename;
		int salary;
		int experience;
		
		public Employee(String name, int sal, int exp)
		{
			ename = name;
			salary =sal;
			experience = exp;
		}		
	}
	
	
	@Test
	public void Emp()
	{
		Employee emp = new Employee("John", 50000, 5);
		Predicate<Employee> pr = e -> (e.salary > 30000 && e.experience > 5);
		
		pr.test(emp);
		System.out.println("Test is......" +	pr.test(new Employee("Smith", 10000, 4)));
		
		
		
		ArrayList<Employee> ae= new ArrayList<>();
		ae.add(new Employee("John", 10000, 5));
		ae.add(new Employee("David", 25000, 4));
		ae.add(new Employee("Scott", 32000, 2));
		ae.add(new Employee("Jeremy", 42000, 3));
		ae.add(new Employee("Smith", 87000, 8));
		
		for(Employee e : ae)
		{
			if(pr.test(e))
			{
				System.out.println(e.ename +"      "+e.salary);
				
			}
		}
	}
	
	
	@Test 
	public void JoiningPredicate()
	{
		
		// Joining Predicates - and , or , not
		//p1 -- checks number is even
		//p2 -- checks greater than 50
		
		int a[] = {15,55,18,62,88,100,11};
		
		Predicate<Integer> p1 = i -> i%2==0;
		Predicate<Integer> p2 = i -> i > 50;
		
		
		//and
		System.out.println("Following are numbers EVEN and Greater than 50.......");
		for(int n : a)
		{
			//if (p1.test(n) && p2.test(n))
			if (p1.and(p2).test(n)) 
			{
				System.out.println(n);
				
			}
		}
		
		System.out.println("Following are numbers EVEN OR  Greater than 50.......");
		for(int n : a)
		{
			//if (p1.test(n) && p2.test(n))
			if (p1.or(p2).test(n)) 
			{
				System.out.println(n);
				
			}
		}
		
		
		System.out.println("Following are numbers EVEN OR  Greater than 50.......");
		for(int n : a)
		{
			if (p1.negate().test(n)) 
			{
				System.out.println(n);
				
			}
		}
	}
	
}
