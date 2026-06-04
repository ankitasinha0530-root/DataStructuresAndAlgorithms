package com.dsalgos.practice.graph.ds.other;

import java.util.ArrayList;

public class CFindSmallestPathByWeight {
	
	static String sPath;
	static int sPathwt = Integer.MAX_VALUE;

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
		graph[3].add(new Edge(3, 5, 15));
		graph[5].add(new Edge(5, 3, 15));
		graph[4].add(new Edge(4, 5, 10));
		graph[5].add(new Edge(5, 4, 10));

		boolean[] visited = new boolean[graph.length];
		shortestWightedPath(graph, 0, 5, visited, 0 + "", 0);

		System.out.println("sPath = " + sPath + ", sPathwt = " + sPathwt);

	}

	private static void shortestWightedPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf,
			int wt) {
		if(src == dest) {
			sPathwt = Math.min(sPathwt, wt);
			sPath = psf;
			return;
		}
		
		visited[src] = true;
		for(Edge e : graph[src]) {
			if(visited[e.nbr] == false) {
				shortestWightedPath(graph, e.nbr, dest, visited, psf + e.nbr, wt + e.wt);
			}
		}
		visited[src] = false;
		
	}

}
