package com.java.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.annotations.Test;

public class RemoveDuplicateUsingStreams {
	@Test
	public void Streams1() {

		List<String> listWithDuplicateElements = Arrays.asList("Java", "selenium", "python", "selenium");
		/*
		 * List<String> listWithNoDuplicateElements = new ArrayList<>();
		 * 
		 * 
		 * for(String ele : listWithDuplicateElements) {
		 * if(!listWithNoDuplicateElements.contains(ele)) {
		 * listWithNoDuplicateElements.add(ele); } }
		 * 
		 * 
		 * 
		 * System.out.println( "Before Duplicates"+ listWithDuplicateElements);
		 * System.out.println("After list"+ listWithNoDuplicateElements);
		 */

		List<String> streamsDuplicate = listWithDuplicateElements.stream().distinct().collect(Collectors.toList());
		System.out.println("Duplicate  " + streamsDuplicate);
	}

	@Test
	public void Streams2() {

		List<String> list = Arrays.asList("Java", "selenium Testing", "python Testing", "selenium");

		List<String> list2 = list.stream().filter(e -> e.toLowerCase().contains("testing") || e.contains("selenium"))
				.collect(Collectors.toList());

		System.out.println("List is....." + list);
		System.out.println("List2 is...." + list2);

	}

	@Test
	public void sortOrder() {

		List<Integer> unSortOrder = Arrays.asList(1, 100, 20, 99, 999, 10);

		// By Default it will sort in asceding functionality
		List<Integer> sortOrder = unSortOrder.stream().sorted().collect(Collectors.toList());

		System.out.println("unSortOrder is...." + unSortOrder);
		System.out.println("SortOrder is...." + sortOrder);

		List<Integer> sortOrder2 = unSortOrder.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		System.out.println("unSortOrder is...." + unSortOrder);
		System.out.println("SortOrder is...." + sortOrder2);
		
		List<String> unSortOrder2 = Arrays.asList("Java","Selenium","java","ava","sele");
		List<String> sortOrder3 = unSortOrder2.stream().sorted().collect(Collectors.toList());
		
		
		
		System.out.println("unSortOrder is...." + unSortOrder2);
		System.out.println("SortOrder is...." + sortOrder3);

	}

}
