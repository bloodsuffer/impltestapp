package com.implemica.zavizionov.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

;

public class Task2 {
	// private static int MAX_TESTS = 10;
	private static int MAX_CITIES = 10000;
	// private static int MAX_PATHS = 100;

	private int nodes = 0;
	private List<String> cities;
	private int[][] routeDistances;

	public static void main(String[] args) throws IOException {
		List<String> input = Files.readAllLines(Paths.get("input.txt"));
		// TODO
		input.remove(0);
		Task2 t = new Task2();
		t.parse(input);
		System.out.println(t.cities);
		System.out.println(Arrays.deepToString(t.routeDistances));
		System.out.println(Arrays.toString(t.calculateDijkstra(0)));
		System.out.println(Arrays.toString(t.calculateDijkstra(1)));
	}

	private void parse(List<String> lines) {
		Iterator<String> it = lines.iterator();
		nodes = getInt(it.next());
		if (nodes > MAX_CITIES) {
			throw new IllegalArgumentException();
		}
		cities = new ArrayList<>(nodes);
		routeDistances = new int[nodes][nodes];
		for (int i = 0; i < nodes; i++) {
			Arrays.fill(routeDistances[i], Integer.MAX_VALUE);
		}

		for (int i = 0; i < nodes; i++) {
			cities.add(it.next());
			int numberOfConnections = getInt(it.next());
			for (int k = 0; k < numberOfConnections; k++) {
				String str[] = it.next().split(" ");
				routeDistances[i][getInt(str[0]) - 1] = getInt(str[1]);
			}
		}
		it.next();
	}

	private Integer getInt(String str) {
		return Integer.parseInt(str);

	}

	public int[] calculateDijkstra(int cityIndex) {
		int[] distance = new int[nodes];
		boolean[] visited = new boolean[nodes];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[cityIndex] = 0;

		while (true) {
			int current = -1;
			for (int i = 0; i < nodes; i++) {
				if (!visited[i] && distance[i] < Integer.MAX_VALUE
						&& (current == -1 || distance[current] > distance[i])) {
					current = i;
				}
			}
			if (current == -1) {
				break;
			}
			visited[current] = true;
			for (int i = 0; i < nodes; i++) {
				if (!visited[i]
						&& routeDistances[current][i] < Integer.MAX_VALUE) {
					distance[i] = Math.min(distance[i], distance[current]
							+ routeDistances[current][i]);
				}
			}

		}

		return distance;
	}
}