package graph.problems;

import java.util.LinkedList;
import java.util.Queue;

import graph.utils.Graph;

/**
 * The logic is to perform BFS traversal and flag a node. Meanwhile checking that no adjacent nodes
 * should have same flag.
 */
public class Problem012 {

  public static boolean isBipartite(Graph graph, char vertex) {
    int size = graph.vertices.length;
    boolean colors[] = new boolean[size];
    boolean color = true;

    Queue<Character> queue = new LinkedList<Character>();
    queue.add(vertex);

    while(!queue.isEmpty()) {
      vertex = queue.remove();
      int vertexIndex = graph.indexMap.get(vertex);
      if(graph.visited[vertexIndex] == 0) {
        graph.visited[vertexIndex] = 1;
        colors[vertexIndex] = color;
        color = !color;

        for(int i=0; i < size; i++) {
          if(graph.adjMatrix[vertexIndex][i] == 1) {
            if(graph.visited[i] == 0) {
              colors[i] = color;
              queue.add(graph.vertices[i]);
            }
            if(graph.visited[i] == 1 && colors[i] == colors[vertexIndex]) {
              return false;
            }
          }
        }

      }
    }

    printComponents(graph.vertices, colors);
    return true;
  }

  /**
   * We can also follow a simpler approach wherein, we keep traversing the graph with BFS and keeping assigning colors.
   * Once done, we will traverse the tree again and check that the colours are placed right.
   */

  private static void printComponents(char vertices[], boolean colors[]) {
    String component1 = "";
    String component2 = "";

    for(int i=0; i < vertices.length; i++) {
      if(colors[i]) component1 = component1 + "\t" + vertices[i];
      else component2 = component2 + "\t" + vertices[i];
    }
    System.out.println("Component 1: " + component1);
    System.out.println("Component 2: " + component2);
  }

  public static void main(String[] args) {
    char vertices[] = new char[]{'A','B','C','D'};
    Graph graph = new Graph(vertices, true);
    graph.setEdge('A','B' );
    graph.setEdge('B','C' );
    graph.setEdge('C','D' );

    System.out.println("Is Bipartite: " + isBipartite(graph, 'A'));

    System.out.println();
    vertices = new char[]{'A','B','C','D'};
    graph = new Graph(vertices, true);
    graph.setEdge('A','B' );
    graph.setEdge('B','C' );
    graph.setEdge('C','D' );
    graph.setEdge('B','D' );

    System.out.println("Is Bipartite: " + isBipartite(graph, 'A'));
  }

}
