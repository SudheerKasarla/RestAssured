package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo2 {

	public static void main(String[] args) {

		List<String> names = Arrays.asList("Hyderbad", "Nagar", "Puram", "chennai");

		List<String> namesLength = new ArrayList<>();

		namesLength = names.stream().filter(str -> str.length() > 6 && str.length() < 8).collect(Collectors.toList());
		System.out.println("Names length is...."+ namesLength);
		
		names.stream().filter(str -> str.length() > 6 && str.length() < 8).forEach(str -> System.out.println(str));
	}

}
