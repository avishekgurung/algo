package graph.problems;

import java.util.LinkedList;
import java.util.Queue;

import graph.utils.Graph;

public class Problem001 {

  public static void breadFirstTraversal(Graph graph, char vertex) {

    Queue<Character> queue = new LinkedList<Character>();
    queue.add(vertex);

    while(!queue.isEmpty()) {
      vertex = queue.remove();
      int vertexIndex = graph.indexMap.get(vertex);
      if(graph.visited[vertexIndex] == 0) {
        System.out.print(vertex + "\t");
        graph.visited[vertexIndex] = 1;

        for (int i = 0; i < graph.vertices.length; i++) {
          if (graph.adjMatrix[vertexIndex][i] == 1 && graph.visited[i] == 0) {
            queue.add(graph.vertices[i]);
          }
        }
      }
    }
    System.out.println();
  }

  public static void depthFirstTraversal(Graph graph, char vertex) {

    System.out.print(vertex + "\t");
    int vertexIndex = graph.indexMap.get(vertex);
    graph.visited[vertexIndex] = 1;

    for(int i=0; i < graph.vertices.length; i++) {
      if(graph.adjMatrix[vertexIndex][i] == 1 && graph.visited[i] == 0) {
        depthFirstTraversal(graph, graph.vertices[i]);
      }
    }
  }

  public static void main(String[] args) {

    Graph graph = Graph.getPredefinedGraph();
    breadFirstTraversal(graph, 'A');

    System.out.println();

    graph = Graph.getPredefinedGraph();
    depthFirstTraversal(graph,'A' );
  }

}
