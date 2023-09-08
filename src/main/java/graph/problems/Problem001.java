package graph.problems;

import java.util.*;

public class Problem001 {

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
      System.out.println();
    }
  }


  public static void main (String args[]) {
    new Problem001().run();
  }

  private void run() {
    char vertices[] = {'A', 'B', 'C', 'D', 'E', 'F'};
    Graph graph = new Graph(vertices);
    graph.addEdge('A', 'B');
    graph.addEdge('B', 'C');
    graph.addEdge('A', 'D');
    graph.addEdge('B', 'F');
    graph.addEdge('F', 'E');
    graph.addEdge('C', 'E');

    graph.showMatrix();
    graph.showList();


    dfsAdjMat(graph, 'A', new HashSet<>());
    System.out.println();
    dfsAdjList(graph, 'A', new HashSet<>());
    System.out.println();

    bfsAdjMat(graph, 'A');
    System.out.println();
    bfsAdjList(graph, 'A');
  }


  /**
   * The algorithm for DFS goes as follows:
   * 1. Process (print) a vertex and mark it as visited.
   * 2. Now for all the adjacent vertices that are not visited, repeat step 1.
   *
   * NOTE: We do not need to check if the adjacent
   * vertices are visited or NOT if the graph is directed
   */


  /**
   *  Adjacency matrix time complexity calculation.
   *
   *  Let V and E be the total number of vertices and edges.
   *  We see that for every vertex, we compare with all the vertices (including itself) of a graph to see if an
   *  edge exists. This simply gives us the time complexity as V^2.
   */
  private void dfsAdjMat(Graph graph, char vertex, Set<Character> visited) {
    if(visited.contains(vertex)) return;
    System.out.print(vertex + " -> ");
    visited.add(vertex);
    for(int i=0; i < graph.vertices.length; i++) {
      int vertexIndex = graph.indexMap.get(vertex);
      char adjVertex = graph.vertices[i];
      if(graph.adjMatrix[vertexIndex][i] == 1 && !visited.contains(adjVertex)) {
        dfsAdjMat(graph, adjVertex, visited);
      }
    }
  }


  /**
   * Adjacency list time complexity calculation.
   *
   * Let V and E be the total number of vertices and edges.
   * For each vertex, we scan only the list of vertices that it is connected with.
   * The time complexity is simple V + E.
   * We can take a 4 vertices graph and just calculate its runtime.
   *
   */
  private void dfsAdjList(Graph graph, char vertex, Set<Character> visited) {
    if(visited.contains(vertex)) return;
    visited.add(vertex);
    System.out.print(vertex + " -> ");
    for(Character adjVertex : graph.adjList.get(vertex)) {
      if(!visited.contains(adjVertex)) {
        dfsAdjList(graph, adjVertex, visited);
      }
    }
  }

  /**
   * The algorithm for BFS are as follows:
   * 1. Add the initial start vertex into the queue.
   * 2. Pop out the vertex from the queue. And for every popped vertex.
   * 3. If its not visited
   *      4. Process it (mark it as visited).
   *      5. If the adjacent vertices are not visited then them into the queue.
   */


  /**
   * Adjacency matrix time complexity calculation.
   * Every vertex has to go through the queue. And for every vertex, we check all the vertices for its adjacency.
   * So the complexity is V^2
   */
  private void bfsAdjMat(Graph graph, char vertex) {
    Queue<Character> queue = new LinkedList<>();
    queue.add(vertex);
    Set<Character> visited = new HashSet<>();

    while(!queue.isEmpty()) {
      vertex = queue.remove();
      if(!visited.contains(vertex)) {
        System.out.print(vertex + " -> ");
        visited.add(vertex);
        int vertexIndex = graph.indexMap.get(vertex);
        for(int i=0; i < graph.vertices.length; i++) {
          if(graph.adjMatrix[vertexIndex][i] == 1 && !visited.contains(graph.vertices[i])) {
            queue.add(graph.vertices[i]);
          }
        }
      }
    }
  }


  /**
   *  Same as DFS, its V + E which can be know by simply calculating it on small simple graph.
   */
  private void bfsAdjList(Graph graph, char vertex) {
    Queue<Character> queue = new LinkedList<>();
    queue.add(vertex);
    Set<Character> visited = new HashSet<>();

    while(!queue.isEmpty()) {
      vertex = queue.remove();
      if(!visited.contains(vertex)) {
        visited.add(vertex);
        System.out.print(vertex + " -> ");
        for(Character adjVertex : graph.adjList.get(vertex)) {
          if(!visited.contains(adjVertex)) {
            queue.add(adjVertex);
          }
        }
      }
    }
  }

}
