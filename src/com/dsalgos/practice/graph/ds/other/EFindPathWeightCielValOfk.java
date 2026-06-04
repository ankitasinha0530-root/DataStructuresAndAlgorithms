package com.dsalgos.practice.graph.ds.other;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class EFindPathWeightCielValOfk {
	
	static String cPath;
	static int cPathwt = Integer.MAX_VALUE;

	static PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

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
		ceilingOfWt(graph, 0, 5, visited, 0 + "", 0, 42);
		System.out.println(cPathwt);

	}

	private static void ceilingOfWt(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf, int wsf,
			int val) {

		if(src == dest) {
//			if(wsf > val && wsf < cPathwt) {
//				cPathwt = wsf;
			if(wsf > val) {
				cPathwt = Math.min(cPathwt, wsf);
				cPath = psf;
			}
			return;
		}
		visited[src] = true;
		for(Edge edge : graph[src]) {
			if(visited[edge.nbr] == false) {
				ceilingOfWt(graph, edge.nbr, dest, visited, psf + edge.nbr, wsf + edge.wt, val);
			}
		}
		visited[src] = false;
	}

}
