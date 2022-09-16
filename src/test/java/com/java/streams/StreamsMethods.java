package com.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.annotations.Test;

public class StreamsMethods
{
	
	class Student
	{
		
		String name;
		int score;
		Student( String name, int score) 
		{
			
			this.name = name;
			this.score = score;
		}
		
		public String getName()
		{
			return this.name;
		}
		
		public Integer getScore()
		{
			return this.score;
		}
	}
	@Test
	public void Sorting()
	{
		
		
		List<Integer> list1 = Arrays.asList(1,4,2,7,3);
		
		//Ascending ordr
		list1.stream().sorted().collect(Collectors.toList()).forEach(x -> System.out.println(x));
		
		//Descending order
		list1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(x -> System.out.println(x));
		
		List<String> names = Arrays.asList("Hyderbad", "Nagar", "Puram", "chennai");
		
		System.out.println("=========================================");
		
		//Ascending order Objects
		names.stream().sorted().collect(Collectors.toList()).forEach(x -> System.out.println(x));
		
		System.out.println("=========================================");
		
		//Descdening order objects.
		names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).forEach(x -> System.out.println(x));
	}
	
	
	
	@Test
	public void AnyMatch()
	{
		Set<String>  match = new HashSet<String>();
		
		match.add("One mango");
		match.add("One apple");
		match.add("One orange");
		match.add("One banana");
		match.add("Two grapes");
		
		//AnyMatch --- If anyone of it matches with the given word. It returns true
		boolean value2=	match.stream().anyMatch(value -> {return value.startsWith("One");});
		System.out.println("AnyMatch....."+value2);
		
		//AllMatch
		
		boolean value3=match.stream().allMatch(value -> {return value.startsWith("One");});
		
		System.out.println("AnyMatch....."+value3);
		
		//NoneMatch
		boolean value4=match.stream().noneMatch(value -> {return value.startsWith("One");});
		System.out.println("AnyMatch....."+value4);
			
	}
	
	
	@Test
	public void FindAny()
	{
		List<String> names = Arrays.asList("Hyderbad", "Nagar", "Puram", "chennai");
		Optional<String> elements =    names.stream().findAny();
		System.out.println("Find Any is....."+ elements.get());
		
		Optional<String> elements2=names.stream().findFirst();
		System.out.println("Find first is....."+ elements2.get());
	}
	
	@Test
	public void StreamsConcat()
	{
		List<String> animals = Arrays.asList("Tiger", "Lion","Elephant");
		List<String> birds = Arrays.asList("Parrot", "Pigeon","Peacock");
		
		Stream<String> a = animals.stream();
		Stream<String> b = birds.stream();
		
		List<String> animalsAndBirds = Stream.concat(a, b).collect(Collectors.toList());
		
		System.out.println(animalsAndBirds);
		for(String A : animalsAndBirds)
		{
			System.out.println("animalsAndBirds....."+A);
		}
		
	}
	
	
	@Test
	public void ParallelStreams()
	{
		
		List<Student> studentList = Arrays.asList(
																	new Student("Rob",10 ),
																	new Student("Alex", 20),
																	new Student("Jermy", 30),
																	new Student("Smith",40 ));
		
		//Sequencial process
		studentList.stream().filter(s -> s.getScore() >20).limit(3).forEach(s -> System.out.println(s.getName() + "     "+s.getScore()));
		
		System.out.println("============================");
		
		//Parallel streams.
		studentList.parallelStream().filter(s -> s.getScore()>= 20).limit(3).forEach(s -> System.out.println(s.getName() + "     "+s.getScore()));
		
		System.out.println("============================");
		
		//Convert Stream ----> Paralel Stream.
		studentList.stream().parallel().filter(s -> s.getScore()>= 20).limit(3).forEach(s -> System.out.println(s.getName() + "     "+s.getScore()));
		
		
		
	}

}
