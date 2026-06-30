package com.dsalgos.practice.graph.ds.other;

import java.util.*;

public class AGraphHasPathWithMatrixInput2 {

	public static void main(String[] args) {

		int[][]	edges1 = {{0,1},{1,2},{2,0}}; // input is in Matrix form
		System.out.println(checkValidPath(3, edges1, 0, 2));
		
		int n = 6;
		int[][]	edges = {
				{0,1},
				{1,2},
				{2,0},{2, 3}, {3, 5}, {3, 6}}; // input is in Matrix form
		System.out.println(checkValidPath(n, edges, 0, 6));
	}

	private static boolean checkValidPath(int n, int[][] edges, int source, int destination) {
		//first convert it to an adjacency List or Map
		Map<Integer, List<Integer>> graph = new HashMap<>();
		
		for(int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];

		// compute the key and value if key is not already present in the Map for the key
			graph.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
			graph.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
		}

		// create a set to mark visited
		Set<Integer> visited = new HashSet<>();
		boolean hasPath = checkIfGraphHasValidPath(graph, source, destination, visited);
		return hasPath;
	}

	private static boolean checkIfGraphHasValidPath(Map<Integer, List<Integer>> graph, int source, int destination,
																											Set<Integer> visited) {
		if(source == destination) {
			return true;
		}
		visited.add(source); // add source to visited

		for(int neighbour : graph.getOrDefault(source, new ArrayList<>())){ // for each neighbour of the source 

			if(!visited.contains(neighbour)) {  // if the neighbour is already visited skip it else cosider is valid for path calculation

				boolean nbrHasPath = checkIfGraphHasValidPath(graph, neighbour, destination, visited);

				if(nbrHasPath) {
					return true;
				}
			}
		}
		return false;
	}
}
