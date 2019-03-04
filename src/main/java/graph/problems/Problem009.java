package graph.problems;

import graph.utils.Graph;

public class Problem009 {

  public static boolean pathExists(Graph graph, char src, char dest) {
    if(src == dest) return true;

    int srcIndex = graph.indexMap.get(src);
    graph.visited[srcIndex] = 1;

    for(int i=0; i < graph.vertices.length; i++) {
      if(graph.adjMatrix[srcIndex][i] != 0 && graph.visited[i] == 0) {
        boolean result = pathExists(graph, graph.vertices[i], dest);
        if(result) return result;
      }
    }
    return false;
  }

  public static void main(String[] args) {
    char[] vertices = new char[]{'A','B','C'};
    Graph graph = new Graph(vertices, false);
    /*graph.setEdge('A', 'C');
    graph.setEdge('A', 'B');
    graph.setEdge('B', 'C');*/

    graph.setEdge('C', 'A');
    graph.setEdge('A', 'B');
    graph.setEdge('C', 'B');

    System.out.println("Path exists? " + pathExists(graph, 'A', 'C'));
  }
}
