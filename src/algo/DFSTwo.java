package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class GraphTwo{
	List<List<Integer>> graph;
	boolean[] visited; // this helps to track if a node is visited
	
	// to create a graph use constructor that takes total number of nodes
	GraphTwo(int numberOfNodes){
		graph = new ArrayList<>(); // creates empty arraylist to represent the graph
		visited = new boolean[numberOfNodes]; // declares the size of the visited array
		
		// create adjacency list using total number of nodes
		for(int i = 0; i < numberOfNodes; i++) {
			graph.add(i, new ArrayList<>()); // at each index in graph, create an empty arraylist to hold list of neighbors
		}
	}
	
	// have a adjacency list, now create a method to add edges
	public void addEdge(int nodeOne, int nodeTwo) {
		// to create an edge, get a list of neighboring nodes for nodeOne and add nodeTwo to that list
		graph.get(nodeOne).add(nodeTwo);
		graph.get(nodeTwo).add(nodeOne);
	}
	
	
	// dfs method
	public void dfs(int sourceNodeIndex) {
		// create a stack to hold visited nodes
		Stack<Integer> stack = new Stack<>(); // Integer is for node index, ex node 1, node 2 etc
		visited[sourceNodeIndex] = true; // mark visited node as true
		stack.push(sourceNodeIndex);
		
		while(!stack.isEmpty()) {
			// pop out topmost element and check if its neighbors are all visited. If not visited, mark visited 
			Integer node = stack.pop();

			//print this to a file
			System.out.print(node + " ");
			
			// for this node, grab all its neighbors
			List<Integer> neighborsList = graph.get(node);
			
			//for each neighbor, if it is not in visited array, push to stack and mark it as visited
			for(Integer neighbor : neighborsList) {
				if(!visited[neighbor]) { 
					stack.push(neighbor);
					visited[neighbor] = true;
				}
				
			}
			
		}
	}
	
}


public class DFSTwo {
	public static void main(String[] args) {
		//1. declare number of nodes
		//2. create edges
		//3. invoke dfs method
		
		int numberOfNodes = 4;
		
		GraphTwo g = new GraphTwo(numberOfNodes);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		
		
		g.dfs(0);
	}
}
