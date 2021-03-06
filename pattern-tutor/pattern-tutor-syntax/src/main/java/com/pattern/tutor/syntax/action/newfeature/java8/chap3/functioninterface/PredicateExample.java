package com.pattern.tutor.syntax.action.newfeature.java8.chap3.functioninterface;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.pattern.tutor.syntax.action.newfeature.java8.util.factory.StringFactory;

public class PredicateExample {

	public static void main(String[] args) {
		filter(StringFactory.generateStringList(), (String s) -> !s.isEmpty()).stream().forEach(System.out::println);
	}

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		return list.stream().filter(p).collect(Collectors.toList());
	}
}
