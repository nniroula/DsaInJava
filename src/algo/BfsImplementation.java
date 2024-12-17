package algo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class GraphForBfs{
	// need a queue, adjacency list, visited array
	List<List<Integer>> graph;
	boolean[] visited;
	
	//constructor
	GraphForBfs(int numbersOfNodes){
		graph = new ArrayList<>(); // graph is arraylist of lists
		visited = new boolean[numbersOfNodes];
		
		// create adjacency list
		for(int i = 0; i < numbersOfNodes; i++) {
			graph.add(i, new ArrayList<>());
		}
	}
	
	// method to add edges
	public void addEdge(int nodeOne, int nodeTwo) {
		graph.get(nodeOne).add(nodeTwo);
		graph.get(nodeTwo).add(nodeOne);
	}
	
	// create actual bfs method
	public void bfs(int sourceNodeIndex) {
		Queue<Integer> queue = new LinkedList<>(); // implement Queue interface using linkedlist class
		
		queue.add(sourceNodeIndex); // add source node to the queue
		visited[sourceNodeIndex] = true; // mark it as visited or true
		
		while(!queue.isEmpty()) {
			Integer node = queue.poll(); // remove from the queue
			System.out.print(node + " ");
			
			// grab all the neighbors of the removed node
			List<Integer> neighborsList = graph.get(node);
			
			for(Integer neighbor : neighborsList) {
				if(!visited[neighbor]) {
					queue.add(neighbor);
					visited[neighbor] = true;
				}
			}
		}
		
	}
	
}


public class BfsImplementation {
	public static void main(String[] args) {
		System.out.println("BFS traversal output...");
		
		// number of nodes in a graph
		int numberOfNodes = 4;
		
		// graph class
		GraphForBfs graph = new GraphForBfs(numberOfNodes);
		
		// method to add edges to nodes
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		
		// invoke bfs method
		int startingNodeIndex = 3;
		graph.bfs(startingNodeIndex);
	}
}
