package com.java.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterDemo {

	public static void main(String[] args) {
		ArrayList<Integer> numberList = new ArrayList<>();
		numberList.add(10);
		numberList.add(12);
		numberList.add(15);
		numberList.add(111);
		numberList.add(17);

		List<Integer> numberList2 = Arrays.asList(10, 15, 7, 12, 89);

		List<Integer> evenNumberList = new ArrayList<>();

		// Without streams.

		for (int n : numberList2) {
			if (n % 2 == 0) {
				evenNumberList.add(n);
			}
			System.out.println("Even number is....." + evenNumberList);

		}

		/// With streams
		evenNumberList = numberList.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());

		numberList.stream().filter(n -> n % 2 == 0).forEach(n -> System.out.println("Even number is....."+n));
		
		
		numberList.stream().filter(n -> n*3==0).forEach(n -> System.out.println("Even numberssssss is....."+n));

	}

}
