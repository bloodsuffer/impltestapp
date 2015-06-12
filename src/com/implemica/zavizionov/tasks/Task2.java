package com.implemica.zavizionov.tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * This class is designed to parse the input data and
 * use Dijkstra to find the shortest way between to nodes.
 * 
 * 
 * @see Dijkstra
 * @author Zavizionov A.
 *
 */
public class Task2 {
	
	public static int MAX_TESTS = 10;
	public static int MAX_CITIES = 10000;
	public static int MAX_ROUTES = 100;

	private int testsCount = 0;
	private List<Dijkstra> tests = new ArrayList<>();
	private int[][] result;

	public static void main(String[] args) throws IOException {
		//reading input from file
		List<String> input = Files.readAllLines(Paths.get("input.txt"));
		Task2 t = new Task2();
		t.parse(input);
		int[][] answer = t.solve();
		for(int i = 0; i< answer.length;i++){
			System.out.printf("Test %s answer is %s", i+1, Arrays.toString(answer[i]));
		}
	}

	/**
	 * Parses the input data.
	 * 
	 * @param lines - list of lines grom input
	 */
	private void parse(List<String> lines) {
		Iterator<String> it = lines.iterator();
		testsCount = getInt(it.next());
		if(testsCount>MAX_TESTS){
			throw new IllegalArgumentException();
		}
		result = new int[testsCount][];
		for (int t = 0; t < testsCount; t++) {
			int nodesCount = getInt(it.next());
			if(nodesCount>MAX_CITIES){
				throw new IllegalArgumentException();
			}
			Dijkstra d = new Dijkstra(nodesCount);
			for (int i = 0; i < nodesCount; i++) {
				d.addNode(it.next());
				int numberOfConnections = getInt(it.next());
				for (int k = 0; k < numberOfConnections; k++) {
					String str[] = it.next().split(" ");
					d.addRouteDistance(i, getInt(str[0]) - 1, getInt(str[1]));
				}
			}
			int routesCount = getInt(it.next());
			if(routesCount>MAX_ROUTES){
				throw new IllegalArgumentException();
			}
			String[][] paths = new String[routesCount][2];
			for (int i = 0; i < routesCount; i++) {
				String str[] = it.next().split(" ");
				paths[i][0] =  str[0];
				paths[i][1] =  str[1];
			}
			d.addPaths(paths);
			tests.add(d);
			it.next();
		}
	}
	
	/**
	 * Must be called after parsing the input,
	 * makes every {@link Dijkstra} object to calculate
	 * the shortest ways.
	 * 
	 * @return Array with the lengthens of shortest
	 * routes for every test.
	 */
	public int[][] solve(){
		for(int i = 0; i<testsCount;i++){
			result[i] = tests.get(i).getResult();
		}
		return result;
	}
	
	
	/**
	 * Extracts integer from string.
	 * @param str
	 * @return integer value of string.
	 */
	private Integer getInt(String str) {
		return Integer.parseInt(str);
	}

}