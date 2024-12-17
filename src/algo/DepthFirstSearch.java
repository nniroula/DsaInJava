package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

import ds.Array;

//class LoggerImplementation{
//	static Logger logger = Logger.getLogger(DepthFirstSearch.class.getName()); // se logger in DepthFirstSearch class
//	// method to implement logger
//	public static void createSimpleLog() {
//		logger.log(Level.WARNING, "In Logger class.....");
//		logger.info("Implement logger instead of system.out.print statement");
//	}
//	
//	// log handlers - 1. FileHandler to write a log to file and 2. consoleHanlder to write to console
//}


class Graph{
	// create a graph with Adjacency list - meaning list inside a list
	List<List<Integer>> graph; // list of list of nodes
	boolean visited[];
	
	//Graph constructor takes in nodes count
	Graph(int numberOfNodes){
		graph = new ArrayList<>(); // list interface is implemented using ArrayList
		visited = new boolean[numberOfNodes]; // size of an array
		
		// create adjacency list
		for(int i =0; i < numberOfNodes; i++) {
			graph.add(i, new ArrayList<>()); // in the graph at index i, create a list to hold neighbors
		}
	} // end of constructor
	
	// method to add edges to a node from another node
	public void addEdge(int nodeOne, int nodeTwo) {
		// in graph, find a node
		List<Integer> nodeInGraph = graph.get(nodeOne); // case 1
		nodeInGraph.add(nodeTwo); // in this list, add nodeTwo as its adjacent neighbor
		
		graph.get(nodeTwo).add(nodeOne); //case 2. For undirected graph, needs both cases
	}
	
	// create actual dfs method
	public void dfs(int startNodeIndex) {
		Stack<Integer> stack = new Stack<>();
		// add start index to stack and mark it as visited
		stack.add(startNodeIndex);
		visited[startNodeIndex] = true;
		
		// while stack is not empty, check if a node is visited. If not visited, push it on to stack and mark it as visited
		while(!stack.isEmpty()) {
			// pop/remove a topmost element from stack and print it
			Integer poppedNode = stack.pop();
			System.out.print(poppedNode + " ");
			
			// get all neighbors of a popped out node
			List<Integer> neighborsList = graph.get(poppedNode);
			
			// for each neighbor, if not visited push on to stack and mark it as visited
			for(Integer neighborNode : neighborsList) {
				if(!visited[neighborNode]) {
					stack.push(neighborNode);
					visited[neighborNode] = true;
				}
			}
			
		}
	}
	
	
}


public class DepthFirstSearch {
	public static void main(String[] args) {
		// call the logger method
		// LoggerImplementation.createSimpleLog();
		
		//step1 . declare a number of nodes
		int numberOfNodes = 7;
		
		// step 2. create a graph
		Graph graph = new Graph(numberOfNodes);
		graph.addEdge(0, 1); // add node 0 and node 1
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 4);
		graph.addEdge(3, 5);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		
		// step3. invoke dfs method
		graph.dfs(0); // start graph traversal at index 0
		
	}
}
