package com.java.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class StreamsMethod {

	@Test
	public void Distinct() {

		List<String> vehiclesList = Arrays.asList("bus", "car", "jeep", "plane", "auto", "plane");

		// Distinct
		List<String> vehicles = vehiclesList.stream().distinct().collect(Collectors.toList());
		System.out.println("Vehicles is...." + vehicles);

		vehiclesList.stream().distinct().forEach(v -> System.out.println(v));

		// Count
		long count = vehiclesList.stream().distinct().count();
		System.out.println("Count is...." + count);

		// limit

		List<String> limitVehicles = vehiclesList.stream().limit(3).collect(Collectors.toList());
		System.out.println("Limit of vehicles......" + limitVehicles);

		vehiclesList.stream().limit(3).forEach(v -> System.out.println(v));

	}

	@Test
	public void Max() {
		List<Integer> numbersList = Arrays.asList(1, 2, 3, 4, 5, 6, 23);

		long n = numbersList.stream().filter(x -> x % 2 == 0).count();
		System.out.println("Count is...." + n);

		// min

		Optional<Integer> min = numbersList.stream().min((val1, val2) -> {
			return val1.compareTo(val2);
		});

		System.out.println("Min is...." + min.get());

		// Max
		Optional<Integer> max = numbersList.stream().max((val1, val2) -> {
			return val1.compareTo(val2);
		});

		System.out.println("Max is...." + max.get());

	}

	@Test
	public void Reduce() {
		List<String> stringList = Arrays.asList("A", "1", "2", "3", "4", "B");

		Optional<String> reduced = stringList.stream().reduce((value, combinedvalue) -> {
																							return combinedvalue + value;
																								});
		System.out.println("Reduce ...." + reduced.get());

	}
	
	
	
	@Test
	public void Array2()
	{
		List<String> stringList = Arrays.asList("A", "1", "2", "3", "4", "B");
		Object arr[]=	stringList.stream().toArray();
		for(Object a : arr) 
		{
			System.out.println("Array is...."+ a);
			
		}
	}

}
