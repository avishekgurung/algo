package graph.problems;

import java.util.LinkedList;
import java.util.Queue;

import graph.utils.Graph;

public class Problem001 {

  /**
   * Time Complexity calculation.
   *
   * Let V be the number of vertices in a graph. Let e be the number of edges for each vertices.
   *
   * BFS using AdjMatrix
   *
   * queue.add(firstVertex)
   *
   * while queue is not empty
   *  v = queue.remove()
   *  mark v as visited
   *  for (all vertices u in graph)
   *    if u is visited
   *      queue.add(u)
   *
   * The outer while loop will run for V times. The inner for loop runs for V times. So
   * Time Complexity = V * ( O(V) + V * (O(1)) ). Considering removing take V and Add takes 1 in q.
   * Time Complexity = V^2. Lets ignore the queue operation and assume that removing and adding
   * takes constant time.
   *
   * BFS using AdjList
   *
   * queue.add(firstVertex)
   *  while queue is not empty
   *  v = queue.remove()
   *  mark v as visited
   *  for (all neighbours u of v)
   *    if u is visited
   *      queue.add(u)
   *
   * The outer while loop runs for V times. The inner for loop runs for e times.
   * Time Complexity = V ( O(1) + e) = V + Ve. Since E represents the total number of edges in
   * the whole graph so Ve = E. Hence time complexity = V + E.
   *
   * @param graph
   * @param vertex
   */
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

  /**
   * The complexity and explanation is same as that of BFS.
   * @param graph
   * @param vertex
   */
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
