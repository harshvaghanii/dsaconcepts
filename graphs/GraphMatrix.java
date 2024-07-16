package graphs;

import java.util.*;
/*
 * This program is to practice how to represent a graph using adjacency matrix
 */

public class GraphMatrix {

  public static void main(String[] args) {
    int V = 4;
    List<List<Integer>> edges = new ArrayList<>();
    edges.add(Arrays.asList(0, 1));
    edges.add(Arrays.asList(0, 2));
    edges.add(Arrays.asList(1, 2));
    edges.add(Arrays.asList(2, 3));
    GraphMatrix obj = new GraphMatrix();
    int[][] graph = obj.createGraphMatrix(edges, V);
    List<List<Integer>> graphList = obj.createGraphList(edges, V);
    obj.printGraph(graph);
    obj.BFS(graphList);
  }

  // This method is used to print the BFS traversal of the graph

  public void BFS(List<List<Integer>> graph) {
    System.out.println("in bfs");
    int V = graph.size();
    boolean[] visited = new boolean[V];

    for (int i = 0; i < V; i++) {
      if (!visited[i]) {
        visited[i] = true;
        System.out.print(i + " ");
      }

      // Exploring Neighbors
      for (Integer neighbor : graph.get(i)) {
        if (!visited[neighbor]) {
          visited[neighbor] = true;
          System.out.print(neighbor + " ");
        }
      }

    }

    System.out.println();

  }

  public int[][] createGraphMatrix(List<List<Integer>> edges, int V) {

    int[][] graph = new int[V][V];

    for (List<Integer> edge : edges) {
      int source = edge.get(0);
      int destination = edge.get(1);

      graph[source][destination] = 1;
      graph[destination][source] = 1;

    }
    return graph;
  }

  public List<List<Integer>> createGraphList(List<List<Integer>> edges, int V) {

    List<List<Integer>> graph = new LinkedList<>();

    for (int i = 0; i < V; i++) {
      graph.add(new LinkedList<>());
    }

    for (List<Integer> edge : edges) {
      int source = edge.get(0);
      int destination = edge.get(1);

      graph.get(source).add(destination);
      graph.get(destination).add(source);

    }
    return graph;
  }

  public void printGraph(int[][] graph) {
    for (int i = 0; i < graph.length; i++) {
      for (int j = 0; j < graph[0].length; j++) {
        System.out.print(graph[i][j] + " ");
      }
      System.out.println();
    }
  }

}