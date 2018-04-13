package com.jangz.syntax.newfeature.lambda;

import java.awt.Point;

import com.jangz.syntax.newfeature.util.factory.IntegerFactory;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LongestDistance {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
//		maxDistance();
		maxDistanceUsingParallel();
		System.out.println("Cost is " + ((System.currentTimeMillis() - startTime) / 1000.0) + "S.");
	}
	
	public static void maxDistance() {
		double longest = IntegerFactory.generateIntegerList(1, 10_000_000).stream()
				.map(number -> new Point(number % 3, number / 1))
				.mapToDouble(point -> point.distance(0, 0))
				.max()
				.getAsDouble();
		log.info("longest distance is {}", longest);
	}
	
	public static void maxDistanceUsingParallel() {
		double longest = IntegerFactory.generateIntegerList(1, 10_000_000).parallelStream()
				.map(number -> new Point(number % 3, number / 1))
				.mapToDouble(point -> point.distance(0, 0))
				.max()
				.getAsDouble();
		log.info("longest distance is {}", longest);
	}
}