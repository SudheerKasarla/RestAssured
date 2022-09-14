package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo3 {
	public static void main(String[] args) {
		
		
		
		List<String> words = Arrays.asList("cup",null,"forest");
		
		List<String> result = new ArrayList<>();
		
		result=words.stream().filter(str -> str!=null).collect(Collectors.toList());
		System.out.println("Result is..."+ result);
	}

}
