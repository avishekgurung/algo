package graph.problems;

import java.util.*;

public class Problem005 {

  /**
   * OLD
   * Quick Walkthrough:
   * Bellman-Ford works as follows:
   * For a given vertex, it looks into all its neighbours. If the neighbour is
   *  1. NOT visited
   *    It will calculate the distance and assign it.
   *    It will add this neighbour to the queue.
   *
   *  2. Visited
   *    It will calculated the distance. If this distance is less than already calculated
   *    distance of neighbour then it assigns this new distance.
   *
   * This is a Bellman-Ford algo that is a combination of Dijktra and non-weighted graph algo
   * and works for negative edges as well but its complexity is slightly higher than that of
   * Dijktra's algo.
   *
   * Its complexity using Adj List is O(EV).
   *
   * while(!queue.isEmpty()) loop takes V
   * Using, adj list, for every neighbour it takes e.
   * Now q.add takes V
   * So complexity = V * (eV) = VE
   *
   * @param graph
   * @param vertex
   */


  /**
   * NEW (Bellman Ford)
   * The algorithm for shortest path for negative weighted graph is as follows:
   *
   * 0. Create a distance and path table, with distance table holding the largest value for all the other vertices, except
   * the initial vertex.
   * 1. Add the initial start vertex into the queue.
   * 2. Pop out the vertex from the queue. And for every popped vertex.
   * 3. If its not visited
   *      4. Process it (mark it as visited).
   *      5. If the adjacent vertices are not visited then calculate their distance. If the new distance is less than
   *      their already existing distance, then add them into the queue and calculate their path.
   *
   * For Adj Mat, O(n) =
   * For Adj List, O(n) = EV
   *
   * COMPARISON
   * In the non weighted graph, we are using BFS and calculating the path by just adding 1 for every edge.
   * In Dijkstra, we are doing the same but we are replacing heap by queue and we are adding the vertices into the
   * heap only if the new distance is lesser than the old distance.
   * In Bellman ford, we are doing the same as Dijkstra, but we are using heap by queue.
   *
   */

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
          if(distance[i] == Integer.MAX_VALUE) { //if not visited.
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

  private class Graph {
    char[] vertices;
    int[][] adjMatrix;
    Map<Character, Integer> indexMap = new HashMap<>();
    Map<Character, LinkedList<HeapNode>> adjList = new HashMap<>();

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
      adjList.get(a).add(new HeapNode(b, 1));
      adjList.get(b).add(new HeapNode(a, 1));
    }

    void addEdge(char a, char b, int weight) {
      adjMatrix[indexMap.get(a)][indexMap.get(b)] = weight;
      adjMatrix[indexMap.get(b)][indexMap.get(a)] = weight;
      adjList.get(a).add(new HeapNode(b, weight));
      adjList.get(b).add(new HeapNode(a, weight));
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

  private class HeapNode {
    char label;
    int weight;

    HeapNode(char label, int weight) {
      this.label = label;
      this.weight = weight;
    }

    public int getWeight() {
      return weight;
    }

    @Override
    public String toString() {
      return "(" + label + "," + weight + ")";
    }
  }

  private static void shortestPathWeightedNegativeWithAdjList(Graph graph, char vertex) {
    int size = graph.vertices.length;
    int distance[] = new int[size];
    String path[] = new String[size];
    for(int i=0; i < size; i++) distance[i] = Integer.MAX_VALUE;
    int vertexIndex = graph.indexMap.get(vertex);
    distance[vertexIndex] = 0;
    path[vertexIndex] = vertex + "";
    Queue<Character> queue = new LinkedList<>();
    Set<Character> visited = new HashSet<>();
    queue.add(vertex);

    while(!queue.isEmpty()) {
      vertex = queue.remove();
      if(!visited.contains(vertex)) {
        visited.add(vertex);
        vertexIndex = graph.indexMap.get(vertex);
        for(HeapNode node : graph.adjList.get(vertex)) {
          if(!visited.contains(node.label)) {
            int newDistance = distance[vertexIndex] + node.weight;
            int adjVertexIndex = graph.indexMap.get(node.label);
            if(newDistance < distance[adjVertexIndex]) {
              distance[adjVertexIndex] = newDistance;
              path[adjVertexIndex] = path[vertexIndex] + " -> " + node.label;
              queue.add(node.label);
            }
          }
        }
      }
    }


/*    while(!queue.isEmpty()) {
      vertex = queue.remove();
      if(!visited.contains(vertex)) {
        visited.add(vertex);
        vertexIndex = graph.indexMap.get(vertex);
        for(HeapNode node : graph.adjList.get(vertex)) {
          if(!visited.contains(node.label)) {
            int newDistance = distance[vertexIndex] + node.weight;
            int adjVertexIndex = graph.indexMap.get(node.label);
            distance[adjVertexIndex] = newDistance;
            path[adjVertexIndex] = path[vertexIndex] + " -> " + node.label;
            queue.add(node.label);

          }

          if(visited.contains(node.label)) {
            int newDistance = distance[vertexIndex] + node.weight;
            int adjVertexIndex = graph.indexMap.get(node.label);
            if(newDistance < distance[adjVertexIndex]) {
              distance[adjVertexIndex] = newDistance;
              path[adjVertexIndex] = path[vertexIndex] + " -> " + node.label;
              queue.add(node.label);
            }
          }
        }
      }
    }*/

    for(int i=0; i < graph.vertices.length; i++) {
      System.out.println(distance[i] + " : " + path[i]);
    }

  }


  private void run() {
    char vertices[] = new char[]{'A','B','C','D','E'};
    Graph graph = new Graph(vertices);
    graph.addEdge('A', 'B', 4);
    graph.addEdge('A', 'C', 1);
    graph.addEdge('C', 'B', 2);
    graph.addEdge('B', 'E', 4);
    graph.addEdge('C', 'D', 4);
    graph.addEdge('D', 'E', 2);

    shortestPathWeightedNegativeWithAdjList(graph, 'A');

    System.out.println("-------------------------------");
    vertices = new char[]{'A','B','C','D'};
    graph = new Graph(vertices);
    graph.addEdge('A', 'B', 2);
    graph.addEdge('A', 'C', 3);
    graph.addEdge('C', 'D', -10);
    graph.addEdge('B', 'D', 0);
    shortestPathWeightedNegativeWithAdjList(graph, 'A');
    System.out.println("Dijktra's algo is corrected here");
  }

  public static void main(String[] args) {
    new Problem005().run();
    /*char[] vertices = new char[]{'A','B','C','D','E'};
    Graph graph = new Graph(vertices, false);

    graph.setEdge('A', 'B', 4);
    graph.setEdge('A', 'C', 1);
    graph.setEdge('C', 'B', 2);
    graph.setEdge('B', 'E', 4);
    graph.setEdge('C', 'D', 4);
    graph.setEdge('D', 'E', 2);

    shortestPath(graph, 'A');

    System.out.println("----------------");
    vertices = new char[]{'A','B','C','D'};
    graph = new Graph(vertices, false);

    graph.setEdge('A', 'B', 2);
    graph.setEdge('A', 'C', 3);
    graph.setEdge('C', 'D', 1);
    graph.setEdge('B', 'D', 3);
    shortestPath(graph,'A');

    System.out.println("----------------");
    vertices = new char[]{'A','B','C','D'};
    graph = new Graph(vertices, false);
    graph.setEdge('A', 'B', 2);
    graph.setEdge('A', 'C', 3);
    graph.setEdge('C', 'D', -10);
    graph.setEdge('B', 'D', 0);
    shortestPath(graph,'A');*/

  }
}
