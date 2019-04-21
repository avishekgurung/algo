package graph.problems;

import java.util.LinkedList;
import java.util.Queue;

import graph.utils.Graph;


/**
 * Algo: See if the neighbours are not visited, then calculate its distance.
 */
public class Problem003 {

  /**
   * Complexity is same as that of BFS
   * @param graph
   * @param vertex
   */
  public static void shortestPath(Graph graph, char vertex) {
    int distance[] = new int[graph.vertices.length];
    String path[] = new String[graph.vertices.length];

    for(int i=0; i < distance.length; i++) {
      distance[i] = -1;
    }

    //keeping the distance to itself as 0.
    distance[graph.indexMap.get(vertex)] = 0;
    path[graph.indexMap.get(vertex)] = vertex + "";

    Queue<Character> queue = new LinkedList<Character>();
    queue.add(vertex);

    while(!queue.isEmpty()) {
      vertex = queue.remove();
      int vertexIndex = graph.indexMap.get(vertex);

      for(int i=0; i < graph.vertices.length; i++) {
        if(graph.adjMatrix[vertexIndex][i] == 1 && distance[i] == -1) {
            distance[i] = distance[vertexIndex] + 1;
            path[i] = path[vertexIndex] + " -> " + graph.vertices[i];
            queue.add(graph.vertices[i]);
        }
      }
    }

    for(int i=0; i < graph.vertices.length; i++) {
      System.out.println(distance[i] + " : " + path[i]);
    }

  }

  public static void main(String[] args) {

    char[] vertices = new char[]{'A','B','C','D','E','F','G'};
    Graph graph = new Graph(vertices, false);
    graph.setEdge('C', 'A');
    graph.setEdge('C', 'F');
    graph.setEdge('A', 'D');
    graph.setEdge('D', 'F');
    graph.setEdge('A', 'B');
    graph.setEdge('B', 'D');
    graph.setEdge('B', 'E');
    graph.setEdge('E', 'G');
    graph.setEdge('G', 'F');
    graph.setEdge('D', 'G');

    shortestPath(graph, 'C');

  }

}
