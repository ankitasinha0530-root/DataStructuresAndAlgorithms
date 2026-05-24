package com.dsalgos.practice.graph.ds;

import java.util.ArrayList;

class Edges{
	int src;
	int nbr;
	int wt;
	
	public Edges(int src, int nbr, int wt) {
		this.src = src;
		this.nbr = nbr;
		this.wt = wt;
	}
}

public class CPrintAllPaths {

	public static void main(String[] args) {

		int src = 0;
		int dest = 6;
		int vertices = 6;
		
		@SuppressWarnings("unchecked")
		ArrayList<Edges>[] graph = new ArrayList[vertices]; 
		
	//	initilize the graph
		for (int i = 0; i < vertices; i++) {
			graph[i] = new ArrayList<Edges>();
		}
		
		boolean[] visited  = new boolean[5]; // number of vertices
		printAllPaths(graph, src, dest, visited, src+"");
	
	}

	private static void printAllPaths(ArrayList<Edges>[] graph, int src, int dest, boolean[] visited, String psf) {
		if(src == dest) {
			System.out.println(psf);
			return ;
		}
		
		visited[src] = true;
		for(Edges edge : graph[src]) {
			if(visited[edge.nbr] == false) {
				printAllPaths(graph, edge.nbr, dest, visited, psf);
			}
		}
		visited[src] = false;
		
		return;
	}


}
