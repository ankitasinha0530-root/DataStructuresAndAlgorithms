package com.dsalgos.practice.graph.ds.other;

import java.util.ArrayList;

public class CFindLargestPathByWeight {

	static String lPath;
	static int lPathwt = Integer.MIN_VALUE;

	public static void main(String[] args) {

		ArrayList<Edge>[] graph = new ArrayList[11]; // graph also called as adjacency list

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		graph[0].add(new Edge(0, 1, 10));

		graph[1].add(new Edge(1, 0, 10));
		graph[1].add(new Edge(1, 3, 15));

		graph[2].add(new Edge(2, 3, 20));
		graph[2].add(new Edge(2, 4, 30));
		graph[2].add(new Edge(2, 4, 30));

		graph[3].add(new Edge(3, 2, 20));
		graph[3].add(new Edge(3, 1, 15));
		graph[3].add(new Edge(3, 5, 15));

		graph[4].add(new Edge(4, 2, 30));
		graph[4].add(new Edge(4, 5, 10));

		graph[5].add(new Edge(5, 3, 15));
		graph[5].add(new Edge(5, 4, 10));

		boolean[] visited = new boolean[graph.length];
		largestWightedPath(graph, 0, 5, visited, 0 + "", 0);
		System.out.println("sPath = " + lPath + ", sPathwt = " + lPathwt);

	}

	private static void largestWightedPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf,
			int wsf) {

		if (src == dest) {
			lPathwt = Math.max(lPathwt, wsf);
			lPath = psf;
			return;
		}
		
		visited[src] = true;

		for (Edge edge : graph[src]) {

			if (visited[edge.nbr] == false) {

				largestWightedPath(graph, edge.nbr, dest, visited, psf + edge.nbr, wsf + edge.wt);
			}
		}
		visited[src] = false;
	}

}
