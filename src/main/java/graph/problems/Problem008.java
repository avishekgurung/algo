package graph.problems;

import java.util.HashSet;
import java.util.Set;

import graph.utils.Graph;

public class Problem008 {

  /**
   * We check if the adjacent vertex is visited and is not a parent then there is a cycle.
   * @param graph
   * @param parent
   * @param vertex
   * @return
   * Complexity = Ve = E
   */
  private static boolean detectCycleInNonDG(Graph graph, char parent, char vertex) {
    int srcIndex = graph.indexMap.get(vertex);
    graph.visited[srcIndex] = 1;

    for(int i=0 ; i < graph.vertices.length; i++) {
      if(graph.adjMatrix[srcIndex][i] != 0 && graph.visited[i] == 1 && graph.vertices[i] != parent){
        return true;
      }
      if(graph.adjMatrix[srcIndex][i] != 0 && graph.visited[i] != 1) {
        boolean result = detectCycleInNonDG(graph, vertex, graph.vertices[i]);
        if(result) return result;
      }
    }
    return false;
  }

  private static boolean detectCycleInDG(Graph graph, char vertex, Set<Character> backEdges) {
    if(backEdges.contains(vertex)) return true;
    backEdges.add(vertex);

    int vertexIndex = graph.indexMap.get(vertex);
    for(int i=0; i < graph.vertices.length; i++) {
      if(graph.adjMatrix[vertexIndex][i] != 0) {
        boolean result = detectCycleInDG(graph, graph.vertices[i], backEdges);
        if(result) return result;
      }
    }
    backEdges.remove(vertex);
    return false;
  }

  /**
   * Another simple solution using adjacency list.
   *
   *     private boolean cycleInDag(Graph graph, Set<Character> visited, char vertex) {
   *         if(visited.contains(vertex)) return true;
   *         visited.add(vertex);
   *         boolean result = false;
   *         for(HeapNode neighbour : graph.adjList.get(vertex)) {
   *             result = cycleInDag(graph, visited, neighbour.label) || result;
   *         }
   *         visited.remove(vertex);
   *         return result;
   *     }
   *
   *     private boolean cycleInNonDG(Graph graph, Set<Character> visited, char vertex, char previous) {
   *         if(visited.contains(vertex)) return false;
   *         visited.add(vertex);
   *         boolean result = false;
   *         for(HeapNode neighbour: graph.adjList.get(vertex)) {
   *             if(visited.contains(neighbour.label) && neighbour.label != previous) {
   *                 return true;
   *             }
   *             result = cycleInNonDG(graph, visited, neighbour.label, vertex) || result;
   *         }
   *         return result;
   *     }
   *
   */

  public static void main(String[] args) {
    char vertices[] = new char[]{'A', 'B', 'C', 'D'};
    Graph graph = new Graph(vertices, true);
    graph.setEdge('A', 'B' );
    graph.setEdge('A', 'C' );
    graph.setEdge('B', 'C' );
    graph.setEdge('C', 'D' );
    System.out.println("Has cycle: " + detectCycleInNonDG(graph, 'A', 'A'));

    System.out.println("-------------------------------");
    vertices = new char[]{'A', 'B', 'C', 'D'};
    graph = new Graph(vertices, false);
    graph.setEdge('A', 'B' );
    //graph.setEdge('A', 'C' );
    graph.setEdge('C', 'A' );
    graph.setEdge('B', 'C' );
    graph.setEdge('C', 'D' );

    System.out.println("Has cycle: " + detectCycleInDG(graph, 'A', new HashSet<Character>()));

  }

}
