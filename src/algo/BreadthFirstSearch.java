package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
	
	public static void bfsMethod(List<List<Integer>> adjacenyNodesList, int sourceNode, boolean[] visitedArray) {
		//1 create a queue to hold unvisited nodes, at the beginning all nodes are unvisited
		Queue<Integer> queueOfUnvisitedNodes = new LinkedList<>();
		
		//2. 
		//visitedArray[] = new boolean[adjacenyNodesList.size()]; // not visited
		
		//3. mark the source node as visited and enqueue/add it to the queue
		visitedArray[sourceNode] = true;
		queueOfUnvisitedNodes.add(sourceNode);
		
		// iterate over the queue while queue is not empty
		while(!queueOfUnvisitedNodes.isEmpty()) {
			// dequeue or pop the node from the queue
			int currentNode = queueOfUnvisitedNodes.poll();
			System.out.print(currentNode + " ");
			
			// get all adjacency nodes of currentNode
			for(int node : adjacenyNodesList.get(currentNode)) {
				if(!visitedArray[node]) {
					visitedArray[node] = true; // mark as visited
					queueOfUnvisitedNodes.add(node);
				}
			}
		}
		
	}
	
	// function to add edges to the graph
	public static void addEdge(List<List<Integer>> adjEdge, int u, int v) {
		adjEdge.get(u).add(v);
		adjEdge.get(v).add(u); // undirected graph
	}
	
	
	// BFS for entire graph, which could be disconnected graph
	public static void bfsDisconnectedGraph(List<List<Integer>> adj){
		boolean[] visitedNodes = new boolean [adj.size()]; // not visited
		for(int i = 0; i < adj.size(); i++) {
			if(!visitedNodes[i]) {
				bfsMethod(adj, i, visitedNodes);
			}
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("Breadth First Search Algorithm implementation");
		
	
		int V = 8; // number of vertices
		List<List<Integer>> adj = new ArrayList<>();
		
		// initialize the adjacency lists
		for(int i = 0; i< V; i++) {
			adj.add(new ArrayList<>());
		}
		
		// add edges to the graph
		addEdge(adj, 0, 1);
		addEdge(adj, 0, 2);
		addEdge(adj, 3, 4);
		addEdge(adj, 4, 5);
		
//		addEdge(adj, 0, 1);
//		addEdge(adj, 0, 2);
//		addEdge(adj, 1, 8);
//		addEdge(adj, 2, 8);
//		
//		addEdge(adj, 8, 20);
//		addEdge(adj, 8, 14);
//		addEdge(adj, 14, 20);
		
		// perform BFS traversal for the entire graph
				bfsDisconnectedGraph(adj);
			
	}
}
