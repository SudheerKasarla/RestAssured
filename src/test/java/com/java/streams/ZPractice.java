package com.java.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class ZPractice {
	
	public static void main(String[] args)
	{
		
		String[] arr = {"a","b","c"};
		Stream<String>  stream= Arrays.stream(arr);
		
		stream.map(x -> x.startsWith("a")).forEach(s -> System.out.println(s));
		
		Stream<Integer> s = Stream.of(1,2,3,4,5);
		
		s.forEach(p -> System.out.println(p));
		s = Stream.of(1,2,3,4,5);
		System.out.println("Count is............"+s.distinct().count());
		
	}

}
