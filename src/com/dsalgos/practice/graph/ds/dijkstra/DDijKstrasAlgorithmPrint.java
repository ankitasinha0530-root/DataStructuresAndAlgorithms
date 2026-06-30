package com.dsalgos.practice.graph.ds.dijkstra;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class DDijKstrasAlgorithmPrint {

    // Find path with minimum weight of the edges
    // Generate shortest path tree
    // we will use priorityQueue here
    // In Priority Queue elements are sorted in ascending order by default,
    // hence the head of the queue is the element whose priority is lowest. - minHEap
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

    public static class Graph{
        int vtce;
        ArrayList<Edge>[] adjacency;

        @SuppressWarnings("unchecked")
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
//       step 8 : add it to the path so far and weight so far and add it to the queue

        //Define PriorityQueue
        PriorityQueue<Pair> minpq = new PriorityQueue<>((w1, w2) -> w1.wsf - w2.wsf);
        minpq.offer(new Pair(src, src+"", 0));

        boolean[] visited = new boolean[v];
        printAllShortestPath(minpq, visited, g);
    }

    private static void printAllShortestPath(PriorityQueue<Pair> minpq, boolean[] visited, Graph graph) {

        while(!minpq.isEmpty()) {
            Pair pair = minpq.poll();

            if(visited[pair.v]) {
                continue; 				// if the vertex is visited skip the iteration
            }
            visited[pair.v] = true;
            System.out.println(pair.v + " via " + pair.psf + " @ " + pair.wsf);
            for(Edge e : graph.adjacency[pair.v]) {
                if(!visited[e.neibr]) {
                    minpq.add(new Pair(e.neibr, pair.psf + "->" + e.neibr, pair.wsf + e.wt));
                }
            }
        }
    }

    private static class Pair implements Comparable<Pair>{
        int v;
        String psf;
        int wsf;

        public Pair(int v, String psf, int wsf) {
            this.v = v;
            this.psf = psf;
            this.wsf = wsf;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }
}

