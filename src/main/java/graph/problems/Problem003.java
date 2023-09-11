package graph.problems;

import java.util.*;


/**
 * The algorithm for shortest path for non weighted graph is as follows:
 *
 * 0. Create a distance and path table, with distance table holding the largest value for all the other vertices, except
 * the initial vertex.
 * 1. Add the initial start vertex into the queue.
 * 2. Pop out the vertex from the queue. And for every popped vertex.
 * 3. If its not visited
 *      4. Process it (mark it as visited).
 *      5. If the adjacent vertices are not visited then add them into the queue and calculate their distance and path.
 *
 * This is just a BFS traversal with very minimal modification. Whenever, when we see the node first time then it is usually
 * considered that it has a shortest distance.
 *
 * The time and space complexity is same as that of BFS.
 * E+V for adj list and V^2 for adj matrix.
 *
 */
public class Problem003 {

  private class Graph {
    char[] vertices;
    int[][] adjMatrix;
    Map<Character, Integer> indexMap = new HashMap<>();
    Map<Character, LinkedList<Character>> adjList = new HashMap<>();

    Graph(char[] vertices) {
      this.vertices = vertices;
      this.adjMatrix = new int[vertices.length][vertices.length];
      for(int i=0; i < vertices.length; i++) {
        indexMap.put(vertices[i], i);
        adjList.put(vertices[i], new LinkedList<>());
      }
    }

    void addEdge(char a, char b) {
      adjMatrix[indexMap.get(a)][indexMap.get(b)] = 1;
      adjMatrix[indexMap.get(b)][indexMap.get(a)] = 1;
      adjList.get(a).add(b);
      adjList.get(b).add(a);
    }

    void showMatrix() {
      System.out.println("\t" + Arrays.toString(vertices) + "\n");
      for(int i=0; i < vertices.length; i++) {
        System.out.println(vertices[i] + "\t" + Arrays.toString(adjMatrix[i]));
      }
    }

    void showList() {
      System.out.println();
      for(int i=0; i < vertices.length; i++) {
        System.out.println(vertices[i] + "\t" + adjList.get(vertices[i]));
      }
    }
  }


  private void shortestPathNonWeightedWithAdjMat(Graph graph, char vertex) {
    int distance[] = new int[graph.vertices.length];
    String path[] = new String[graph.vertices.length];
    Queue<Character> queue = new LinkedList<>();
    queue.add(vertex);

    for(int i=0; i < graph.vertices.length; i++) {
      distance[i] = Integer.MAX_VALUE;
    }
    distance[graph.indexMap.get(vertex)] = 0;
    path[graph.indexMap.get(vertex)] = vertex+"";
    Set<Character> visited = new HashSet<>();


    while(!queue.isEmpty()) {
      vertex = queue.remove();
      if(!visited.contains(vertex)) {
        visited.add(vertex);
        int vertexIndex = graph.indexMap.get(vertex);
        for(int i=0; i < graph.vertices.length; i++) {
          if(graph.adjMatrix[vertexIndex][i] == 1 && !visited.contains(graph.vertices[i])) {
            queue.add(graph.vertices[i]);
            distance[i] = distance[vertexIndex] + 1;
            path[i] = path[vertexIndex] + " -> " + graph.vertices[i];
          }
        }
      }
    }

    for(int i=0; i < graph.vertices.length; i++) {
      System.out.println(distance[i] + " : " + path[i]);
    }
  }

  private void shortestPathNonWeightedWithAdjList(Graph graph, char vertex) {
    int distance[] = new int[graph.vertices.length];
    String path[] = new String[graph.vertices.length];
    for(int i=0; i < graph.vertices.length; i++) {
      distance[i] = Integer.MAX_VALUE;
    }
    distance[graph.indexMap.get(vertex)] = 0;
    path[graph.indexMap.get(vertex)] = vertex + "";
    Queue<Character> queue = new LinkedList<>();
    queue.add(vertex);

    Set<Character> visited = new HashSet<>();

    while(!queue.isEmpty()) {
      vertex = queue.remove();
      if(!visited.contains(vertex)) {
        visited.add(vertex);
        int vertexIndex = graph.indexMap.get(vertex);
        for(Character adjVertex : graph.adjList.get(vertex)) {
          if(!visited.contains(adjVertex)) {
            int adjVertexIndex = graph.indexMap.get(adjVertex);
            distance[adjVertexIndex] = distance[vertexIndex] + 1;
            path[adjVertexIndex] = path[vertexIndex] + " -> " + adjVertex;
            queue.add(adjVertex);
          }
        }
      }
    }

    for(int i=0; i < graph.vertices.length; i++) {
      System.out.println(distance[i] + " : " + path[i]);
    }
  }

  private void run() {
    char vertices[] = {'A', 'B', 'C', 'D', 'E', 'F'};
    Graph graph = new Graph(vertices);
    graph.addEdge('A', 'B');
    graph.addEdge('B', 'C');
    graph.addEdge('A', 'D');
    graph.addEdge('B', 'F');
    graph.addEdge('F', 'E');

    shortestPathNonWeightedWithAdjMat(graph, 'A');
    System.out.println("\n\n");
    shortestPathNonWeightedWithAdjList(graph, 'A');

  }

  public static void main(String[] args) {
    new Problem003().run();
  }

}
