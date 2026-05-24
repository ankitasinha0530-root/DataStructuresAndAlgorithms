package com.dsalgos.practice.graph.ds;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class EPrimsAlgorithmGraph {
	
	// Read me = https://www.geeksforgeeks.org/difference-between-prims-and-kruskals-algorithm-for-mst/?ref=lbp
	
	// Find path with minimum weight of the edges
	// Generate shortest path tree
	// we will use priorityQueue here
	// in Priority Queue elements are sorted in ascending order by default, hence the head of the queue is the element whose priority is lowest.
	public static class Edge{
		
		 int src;
		 int neibr;
		 int wt;
		 
		 public Edge(int src, int neibr, int wt) {
			 this.src = src;
			 this.neibr = neibr;
			 this.wt = wt;
		 }
	}
	
	public static class Pair implements Comparable<Pair>{
		 int v;			// current vertex
		 int PrevVertx;  //  acquiring Vertex, previous vertex
		 int wt;		// wt/distance between previous and current vertex
		 
		 public Pair(int v, int PrevVertx, int wt) {
			 this.v = v;
			 this.PrevVertx = PrevVertx;
			 this.wt = wt;
		 }

		@Override
		public int compareTo(Pair o) {
			return this.wt - o.wt;
		}
	}
	
	public static class Graph{
		int vtce;
		ArrayList<Edge>[] adjacency;
		
		Graph(int vtce) {
		    this.vtce = vtce;
		    
		    // Initilize graph
		    adjacency = new ArrayList[vtce];
		    for (int i = 0; i < vtce; i++) {
		    	adjacency[i] = new ArrayList<>();
		    }
		}
		
		// create graph by creating adjacency Matrix
		void addEdge(int u, int v, int w) {
			adjacency[u].add(new Edge(u, v, w));
			adjacency[v].add(new Edge(v, u, w));
		}
	}
	
	public static void main(String[] args) {
		// Initialize graph
		 int v = 9;
		Graph g = new Graph(v);
		 
		 g.addEdge(0, 1, 4);
         g.addEdge(0, 7, 8);
         
         g.addEdge(1, 2, 8);
         g.addEdge(1, 7, 11);
         
         g.addEdge(2, 3, 7);
         g.addEdge(2, 8, 2);
         g.addEdge(2, 5, 4);
         g.addEdge(3, 4, 9);
         g.addEdge(3, 5, 14);
         g.addEdge(4, 5, 10);
         g.addEdge(5, 6, 2);
         g.addEdge(6, 7, 1);
         g.addEdge(6, 8, 6);
         g.addEdge(7, 8, 7);
         
         int src = 0;
//       Step 1 : create a min priorityQueue which will always have min element at the top
//       step 2 : create vertices boolean array to mark it true when visited
//       step 3 : initialize the min priority Queue
//       step 4 : while min priorityQueue is not empty extract the top element from the min Priority queue
//       step 5 : if the pair.vertex is marked as true skip this iteration and start the next iteration
//       step 6 : if the pair.vertex is not marked true then mark it true and print it element
//       step 7 : for each neighbour of the vertex if not marked true 
//       step 8 : add it to the minpq previous neighbour of the vertex and weight between previous vertex and current vertex to the queue
         
		
		//Define PriorityQueue
		PriorityQueue<Pair> minPq = new PriorityQueue<Pair>((n1, n2) -> n1.wt - n2.wt);
		minPq.add(new Pair(src, -1, 0));
		boolean[] vertices  = new boolean[v];
		primsAlgorithm(minPq, vertices, g);
		
	}

	private static void primsAlgorithm(PriorityQueue<Pair> minPq, boolean[] vertices, Graph graph) {
		
		while(!minPq.isEmpty()) {
			Pair rem = minPq.poll();
		
			if(vertices[rem.v] == true) {
				continue;
			}
			
			vertices[rem.v] = true;
			if(rem.PrevVertx != -1) {
				System.out.println(rem.v + ", " + rem.PrevVertx + ", " + rem.wt);
			}
			
			for(Edge e : graph.adjacency[rem.v]) {
				if(vertices[e.neibr] == true) {
					minPq.add(new Pair(e.neibr, rem.v, e.wt ));
				}
			}
		}
	}

}
