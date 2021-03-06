package com.pattern.tutor.syntax.action.newfeature.java8.chap6;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toList;

import java.util.stream.IntStream;

import com.pattern.tutor.syntax.action.newfeature.java8.entity.Dish;

public class PartitionByExample {

	public static void main(String[] args) {
//		getVegetarianList();
		
		getPrimeList(100);
	}

	public static void getVegetarianList() {
		Dish.menu.stream().filter(Dish::isVegetarian).collect(toList()).forEach(System.out::println);
		System.out.println("-----------------------------------------");

		Dish.menu.stream().collect(partitioningBy(Dish::isVegetarian, groupingBy(Dish::getType)))
				.forEach((key, value) -> {
					System.out.println(key + " : " + value);
				});
	}

	public static void getPrimeList(int n) {
		IntStream.rangeClosed(2, n).boxed().collect(partitioningBy(candidate -> isPrime(candidate))).forEach((key, value) -> {
			System.out.println(key + " : " + value);
		});
	}

	private static boolean isPrime(int candidate) {
		return IntStream.rangeClosed(2, (int) Math.sqrt(candidate)).noneMatch(i -> candidate % i == 0);
	}
}
