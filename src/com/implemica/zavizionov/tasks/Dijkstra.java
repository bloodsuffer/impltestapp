package com.implemica.zavizionov.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Describes an object with nodes and paths between them. Can be used to find
 * the shortest ways between some nodes.
 * 
 * @author Zavizionov A.
 *
 */
public class Dijkstra {

	private int nodesCount = 0;
	private List<String> nodes;
	private int[][] routeDistances;
	private int[][] pathsToFind;

	/**
	 * 
	 * @param paths
	 *            - array with paths between nodes, which length have to be
	 *            founded
	 */
	public void addPaths(String paths[][]) {
		pathsToFind = new int[paths.length][2];
		for (int i = 0; i < paths.length; i++) {
			// searching the indexes of given city names
			pathsToFind[i][0] = nodes.indexOf(paths[i][0]);
			pathsToFind[i][1] = nodes.indexOf(paths[i][1]);
		}
	}

	/**
	 * Constructor.
	 * 
	 * @param nodesCount
	 */
	public Dijkstra(int nodesCount) {
		this.nodesCount = nodesCount;
		nodes = new ArrayList<>(nodesCount);
		routeDistances = new int[nodesCount][nodesCount];
		for (int i = 0; i < nodesCount; i++) {
			// filling the distances array with 'infinities'
			Arrays.fill(routeDistances[i], Integer.MAX_VALUE);
		}

	}

	/**
	 * Adds the node to the list.
	 * 
	 * @param name
	 *            - string name of the node.
	 */
	public void addNode(String name) {
		nodes.add(name);
	}

	/**
	 * Creates the route between to nodes and sets its length.
	 * 
	 * @param from
	 *            - index of one node
	 * @param to
	 *            - index of another node
	 * @param distance
	 *            - distance between this nodes
	 */
	public void addRouteDistance(int from, int to, int distance) {
		if (from < 0 || to < 0 || distance < 0) {
			throw new IllegalArgumentException();
		}
		routeDistances[from][to] = distance;
	}

	/**
	 * Calculates the shortest distance to all other nodes from the given node.
	 * 
	 * @param nodeIndex
	 *            - given node
	 * @return array with the distances to other nodes.
	 */
	public int[] calculate(int nodeIndex) {
		// vector of distances to other nodes
		int[] distance = new int[nodesCount];
		// shows if some node is already visited
		boolean[] visited = new boolean[nodesCount];
		// fillst an array with 'infinities'
		Arrays.fill(distance, Integer.MAX_VALUE);
		// distance from our node to itself is '0'
		distance[nodeIndex] = 0;

		while (true) {
			int current = -1;
			// looking for nearest unvisited node
			for (int i = 0; i < nodesCount; i++) {
				if (!visited[i] && distance[i] < Integer.MAX_VALUE
						&& (current == -1 || distance[current] > distance[i])) {
					current = i;
				}
			}
			// break if it was not founded
			if (current == -1) {
				break;
			}
			// mark the founded node as visited
			visited[current] = true;
			// calculating the shortest path to current node
			for (int i = 0; i < nodesCount; i++) {
				if (!visited[i]
						&& routeDistances[current][i] < Integer.MAX_VALUE) {
					distance[i] = Math.min(distance[i], distance[current]
							+ routeDistances[current][i]);
				}
			}

		}
		return distance;
	}

	/**
	 * Return an array with result for paths, given during parsing.
	 * 
	 * @return array with the shortest distances
	 */
	public int[] getResult() {
		int[] result = new int[pathsToFind.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = calculate(pathsToFind[i][0])[pathsToFind[i][1]];
		}
		return result;
	}
}
