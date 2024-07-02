package graph.problems;

import java.util.*;

import graph.utils.Graph;

/**
 * Topological sorting:
 *
 * 1. Calculate the indegree of all the vertices.
 * 2. For all the vertices, whose indegree are 0, add them into the queue.
 * 3. Pop out vertex from the queue.
 *    3.1 Reduce the indegree of all its adjacency vertex
 *    3.2 If any of the adjacency vertex's indegree reduces to 0, then put that vertex into the queue.
 *
 * Complexity
 * This is a simple BFS algorithm.
 * For Adj Matrix: V^2
 * For Adj List: V + E
 */

public class Problem002 {

  private static void topologicalSort(Graph graph) {
    Queue<Character> queue = new LinkedList<Character>();

    //calculate int degree
    int inDegree[] = new int[graph.vertices.length];
    for(int i=0; i < graph.vertices.length; i++) {
      for(int j=0; j < graph.vertices.length; j++) {
        if(graph.adjMatrix[i][j] == 1) {
          inDegree[j] = inDegree[j] + 1;
        }
      }
    }

    //store all vertices with inDegree 0 in the queue.
    for(int i=0 ; i< inDegree.length; i++) {
      if(inDegree[i] == 0) {
        queue.add(graph.vertices[i]);
      }
    }

    // Reduce adjacent vertice's indegree by 1 and if its 0 then add to queue.
    while(!queue.isEmpty()) {
      char vertex = queue.remove();
      int vertexIndex = graph.indexMap.get(vertex);
      System.out.print(vertex + " -> ");

      for(int i=0; i < graph.vertices.length; i++) {
        if(graph.adjMatrix[vertexIndex][i] == 1) {
          inDegree[i] = inDegree[i] - 1;
          if(inDegree[i] == 0) {
            queue.add(graph.vertices[i]);
          }
        }
      }
    }
    System.out.println();
  }


  public static void main(String[] args) {

    char[] vertices = new char[]{'A','B','C','D','E','F','G','H'};
    Graph graph = new Graph(vertices, false);
    graph.setEdge('A', 'D');
    graph.setEdge('B', 'D');
    graph.setEdge('C', 'E');
    graph.setEdge('C', 'H');
    graph.setEdge('D', 'F');
    graph.setEdge('D', 'G');
    graph.setEdge('E', 'G');

    topologicalSort(graph);

    new Problem002().topologicalSortWithAdjList();


  }

  private void topologicalSortWithAdjList() {
    Map<Character, List<Character>> adjList = new HashMap<>();
    adjList.put('A', Arrays.asList('D', 'E'));
    adjList.put('B', Arrays.asList('D'));
    adjList.put('C', Arrays.asList('E', 'H'));
    adjList.put('D', Arrays.asList('F', 'G'));
    adjList.put('E', Arrays.asList('G'));

    topologicalSort(adjList);

  }

  private void topologicalSort(Map<Character, List<Character>> adjList) {
    Map<Character, Integer> indegree = new HashMap<>();

    for(Character vertex : adjList.keySet()) {
      if(!indegree.containsKey(vertex)) indegree.put(vertex, 0);
      List<Character> neighbors = adjList.get(vertex);
      for(Character neighbor : neighbors) {
        if(indegree.containsKey(neighbor)) indegree.put(neighbor, indegree.get(neighbor) + 1);
        else indegree.put(neighbor, 1);
      }
    }

    Queue<Character> queue = new LinkedList<>();
    for(Character vertex : indegree.keySet()) {
      if(indegree.get(vertex) == 0) queue.add(vertex);
    }

    while(!queue.isEmpty()) {
      Character vertex = queue.remove();
      System.out.print(vertex + " -> ");
      List<Character> neighbors = adjList.get(vertex);
      if(neighbors == null) continue;
      for(Character neighbor : neighbors) {
        int degree = indegree.get(neighbor);
        degree--;
        if(degree == 0) queue.add(neighbor);
        else indegree.put(neighbor, degree);
      }
    }
  }

}

