package graph.problems;

import graph.utils.Graph;

public class Problem010 {
  
  public static int countPaths(Graph graph, char src, char dest, int count) {
    if(src == dest) {
      count++;
      return count;
    }

    int srcIndex = graph.indexMap.get(src);
    for(int i=0; i < graph.vertices.length; i++) {
      if(graph.adjMatrix[srcIndex][i] != 0) {
        count = countPaths(graph, graph.vertices[i], dest, count);
      }
    }
    return count;
  }

  /**
   * Using adj list and for directed graph
   *
   *     private int pathCount(Graph graph, char source, char destination) {
   *         if(source == destination) return 1;
   *         int result = 0;
   *         for(HeapNode neighbour : graph.adjList.get(source)) {
   *             result = result + pathCount(graph, neighbour.label, destination);
   *         }
   *         return result;
   *     }
   */

  public static void main(String[] args) {
    char vertices[] = new char[]{'A','B','C','D','E'};
    Graph graph = new Graph(vertices, false);
    graph.setEdge('A', 'B');
    graph.setEdge('B', 'D');
    graph.setEdge('D', 'E');
    graph.setEdge('B', 'C');
    graph.setEdge('C', 'D');

    int c = countPaths(graph, 'A', 'E', 0);
    System.out.println("Path count: " + c);

  }
}

/*
The graph should not contain a cycle else it will run infinitely.
 */
