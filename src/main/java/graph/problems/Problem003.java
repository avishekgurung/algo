package graph.problems;

import java.util.LinkedList;
import java.util.Queue;

import graph.utils.Graph;

public class Problem003 {

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
        char neighbour = graph.vertices[i];
        int newDistance = distance[vertexIndex] + 1;
        if(graph.adjMatrix[vertexIndex][i] == 1) {
          if (distance[i] == -1) {
            distance[i] = newDistance;
            path[i] = path[vertexIndex] + " -> " + neighbour;
            queue.add(neighbour);
          } else if (newDistance < distance[i]) {
            distance[i] = newDistance;
            path[i] = path[vertexIndex] + " -> " + neighbour;
          }
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
