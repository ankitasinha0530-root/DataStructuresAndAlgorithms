package com.dsalgos.practice.graph.ds.other;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class GFindnthLargestPathWeight {

	static String fPath;
	static int fPathwt = Integer.MIN_VALUE;

	static PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a-b);
	
	static PriorityQueue<Integer> minHeap1 = new PriorityQueue<>((a, b) -> a-b);

	public static void main(String[] args) {

		ArrayList<Edge>[] graph = new ArrayList[11]; // graph also called as adjacency list

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
		graph[0].add(new Edge(0, 1, 10));
		graph[0].add(new Edge(0, 5, 80));
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
		graph[5].add(new Edge(5, 1, 10));
		graph[1].add(new Edge(1, 5, 10));
		graph[2].add(new Edge(2, 5, 5));
		graph[5].add(new Edge(5, 2, 5));

		boolean[] visited = new boolean[graph.length];
		
		nthLargestPathWt(graph, 0, 5, visited, 0 + "", 0, 3);
		
		System.out.println(minHeap);
		System.out.println();
		System.out.println(minHeap.peek());
		System.out.println();
		System.out.println(minHeap1);

	}

	private static void nthLargestPathWt(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, String psf, int wsf,
			int k) {
			
		if(src == dest) {
			System.out.println("psf = " + psf + ", weight = " + wsf);
	//		minHeap1.add(wsf);
			if(minHeap.size() < k) {
				minHeap.add(wsf);
				
			}else {
				if(!minHeap.isEmpty() && minHeap.peek() < wsf) {
					minHeap.poll();
					minHeap.add(wsf);
				}
			}
			return;
		}
		visited[src] = true;
		for(Edge e : graph[src]) {
			if(visited[e.nbr] == false) {
				nthLargestPathWt(graph, e.nbr, dest, visited, psf+e.nbr, wsf+e.wt, k);
			}
		}
		visited[src] = false;
		
	}
}
