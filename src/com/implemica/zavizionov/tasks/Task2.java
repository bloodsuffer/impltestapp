package com.implemica.zavizionov.tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Task2 {
	private int cities = 0;
	private int tests = 0;
	private List<List<String>> citiesInTests;

	public static void main(String[] args) {

	}

	private void parse(List<String> lines) {

		Iterator<String> it = lines.iterator();

		tests = Integer.parseInt(it.next());
		cities = Integer.parseInt(it.next());
		citiesInTests = new ArrayList<>();
		for (int i = 0; i < tests; i++) {
			citiesInTests.set(0, new ArrayList<>());
			List<String> thisCities = citiesInTests.get(i);
			for (int j = 0; j < cities; j++) {
				thisCities.set(i, it.next());
			}
		}
	}
}
