package com.java.streams;

import org.testng.annotations.Test;

import com.java.streams.Predicate2.Employee;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;
public class Function2
{
	
	class Employee
	{
		String ename;
		int salary;
		
		
		public Employee(String name, int sal)
		{
			ename = name;
			salary =sal;
		}		
	}
	@Test
	public void Function()
	{
		Function<Integer,Integer> f = n -> n*n;
		f.apply(5);
		//String length
		//String ----> length ---> Int
		Function<String, Integer> fn = s -> s.length();
		System.out.println(fn.apply("Welcome to Streams"));
		
		ArrayList<Employee> ae= new ArrayList<Employee>();
		ae.add(new Employee("John", 10000));
		ae.add(new Employee("David", 25000));
		ae.add(new Employee("Scott", 32000));
		ae.add(new Employee("Jeremy", 42000));
		ae.add(new Employee("Smith", 87000));
		
		Function<Employee, Integer> fn2 = 
				e -> 
				{ 
					int sal = e.salary;
					if (sal >= 30000)
					{
						return (sal* 10/100);
					}else
					{
						return (sal* 40/100);
					}
				};
				
		Predicate<Integer> p = b -> b > 50000;		
		
		for(Employee ep :ae)
		{
			
			int bonus=fn2.apply(ep);
			
			if (p.test(bonus)) 
			{
				System.out.println(ep.ename+"       "+  ep.salary);
				System.out.println("Bonus is....."+ bonus);
			}
			
		}
	}
	
	
	
	@Test
	public void AndThen()
	{
		
		Function<Integer, Integer> f1 = n -> n*2;
		Function<Integer, Integer> f2 = n -> n*n*n;
		
		f1.andThen(f2).apply(2); //4 -> 64
		
		f1.compose(f2).apply(2); // 8 -> 16    Reverse order
		
	}

	
	
	
}
