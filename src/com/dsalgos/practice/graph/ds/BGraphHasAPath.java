package com.dsalgos.practice.graph.ds;

import java.util.ArrayList;

class Edge{
	int src;
	int nbr;
	int wt;
	
	public Edge(int src, int nbr, int wt) {
		this.src = src;
		this.nbr = nbr;
		this.wt = wt;
	}
}

public class BGraphHasAPath {

	public static void main(String[] args) {

		int src = 0;
		int dest = 6;
		int vertices = 6;
		
	//	int[] graph = new int[vertices];
		
		@SuppressWarnings("unchecked")
		ArrayList<Edge>[] graph = new ArrayList[vertices]; 
		
	//	initilize the graph
		for (int i = 0; i < vertices; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		boolean[] visited  = new boolean[5]; // number of vertices
		boolean path = hasPath(graph, src, dest, visited);
		System.out.println(path);
	}

	private static boolean hasPath(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited) {
		if(src == dest) {
			return true;
		}
		
		visited[src] = true;
		for(Edge edge : graph[src]) {
			if(visited[edge.nbr] == false) {
				boolean hasNbrPath = hasPath(graph, edge.nbr, dest, visited);
				if(hasNbrPath == true) {
					return true;
				}
			}
		}
		
		return false;
	}

}
