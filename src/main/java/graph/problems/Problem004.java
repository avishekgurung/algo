package graph.problems;

import java.util.LinkedList;
import java.util.Queue;

import graph.utils.Graph;

public class Problem004 {

  //Dijkstra's algorithm
  public static void shortestPath(Graph graph, char vertex) {

    int[] distance = new int[graph.vertices.length];
    String[] path = new String[graph.vertices.length];

    for(int i=0; i < distance.length; i++) {
      distance[i] = Integer.MAX_VALUE;
    }

    distance[graph.indexMap.get(vertex)] = 0;
    path[graph.indexMap.get(vertex)] = vertex + "";

    Queue<Character> queue = new LinkedList<Character>();
    queue.add(vertex);

    while(!queue.isEmpty()) {
      vertex = queue.remove();
      int vertexIndex = graph.indexMap.get(vertex);

      for(int i=0 ; i < graph.vertices.length; i++) {
        if(graph.adjMatrix[vertexIndex][i] != 0) {
          int newDistance = distance[vertexIndex] + graph.adjMatrix[vertexIndex][i];
          char neighbour = graph.vertices[i];
          if(distance[i] == Integer.MAX_VALUE) {
            distance[i] = newDistance;
            path[i] = path[vertexIndex] + " -> " + neighbour;
            queue.add(neighbour);
          }
          else if(newDistance < distance[i]){
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
    char[] vertices = new char[]{'A','B','C','D','E'};
    Graph graph = new Graph(vertices, false);

    graph.setEdge('A', 'B', 4);
    graph.setEdge('A', 'C', 1);
    graph.setEdge('C', 'B', 2);
    graph.setEdge('B', 'E', 4);
    graph.setEdge('C', 'D', 4);
    graph.setEdge('D', 'E', 2);

    shortestPath(graph, 'A');
  }

}
