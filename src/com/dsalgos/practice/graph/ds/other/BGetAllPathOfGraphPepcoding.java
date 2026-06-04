package com.dsalgos.practice.graph.ds.other;

import java.util.ArrayList;
import java.util.List;

public class BGetAllPathOfGraphPepcoding {

	public static void main(String[] args) {
			
		ArrayList<Edge>[] graph = new ArrayList[11]; // graph also called as adjacency list

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		graph[0].add(new Edge(0, 1, 10));
		graph[1].add(new Edge(1, 0, 10));
		graph[2].add(new Edge(2, 3, 20));
		graph[3].add(new Edge(3, 2, 20));
		graph[2].add(new Edge(2, 4, 30));
		graph[4].add(new Edge(4, 2, 30));
		graph[3].add(new Edge(3, 1, 15));
		graph[1].add(new Edge(1, 3, 15));
		graph[4].add(new Edge(4, 5, 10));
		graph[5].add(new Edge(5, 4, 10));
		
		boolean[] visited = new boolean[graph.length];
		printAllValidPath(graph, 0, 5, visited, 0+"");
	}

	private static void printAllValidPath(ArrayList<Edge>[] graph, int source, int dest, boolean[] visited, String ans) {

		if(source == dest) {
			System.out.println(ans);
			return;
		}
		visited[source] = true;
		List<Edge> childNode = graph[source];
		for(Edge edge : childNode) {
			if(!visited[edge.nbr]) {
				printAllValidPath(graph, edge.nbr, dest, visited, ans + edge.nbr);
			}
		}
		visited[source] = false;
	}
}
