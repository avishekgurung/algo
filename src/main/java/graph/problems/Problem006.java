package graph.problems;

import java.util.*;

/**
 * Prim's Algorithm for minimal spanning tree.
 *
 * Spanning Tree is a tree that is created from a graph by using all the vertices. When we use
 * minimum edges then its a Minimal Spanning Tree. By definition, a tree is a acyclic connected
 * graph so Spanning Tree should have minimum edges so that there would be no cycles in the
 * tree. If |V| is the number of vertices in Graph and |E| is the number of edges then ST will
 * have |V| number of vertices but its edges will be |V|-1. In MST, we choose these edges such
 * that they are minimum. And for a given graph, the number of spanning trees will be
 * |E|
 *    C       -  (number of cycles)
 *     |V|-1
 *  Number of Edges combination with Number of vertices -1. And then we would subtract the
 *  number of cycles present in the graph. But these cycles should be the inner cycles.
 *
 * Real time applications: Lets say that we have many houses in a locality where we have to
 * supply an electric current. The cost to connect from one house to another is given. We
 * have to form a network such that the cost is minimum.
 *
 * Algo.
 * 1. First start with an edge/vertices with minimum cost and insert into min heap
 * 2. Remove the element from min heap and mark it as visited. Search all its non-visited
 *    neighbours and add them in the min heap.
 * 3. Continue until all the elements are exhausted.
 *
 * Time Complexity = ElogV
 *
 *
 * Prim's algo is similar to that of Dijktra's in implementation. Whereas Dijktra's algo helps
 * us to find a shortest path from one vertex to all other vertices whereas Prim's algo helps
 * us to find a Spanning Tree with minimum cost. Lets take a graph for an example:
 *
 *  A ----- B ----- C
 *  |               |
 *  |               |
 *  D---------------
 *
 *  AB=5, BC=5,DC=2 and AD=9.
 *
 *  Dijktra's algo would give us
 *
 *  A ----- B ----- C
 *  |
 *  |
 *  D
 *
 *  Whereas Prim's algo would give us
 *  A ----- B ----- C
 *                  |
 *                  |
 *                  D
 * Prim's algo works on non-directed graph whereas Dijktra's work mostly on directed graph. We do not need to calculate
 * new distance in Prim's algo, we just add the nearest neighbour to heap.
 *
 */

public class Problem006 {


  private class Graph {
    char[] vertices;
    int[][] adjMatrix;
    Map<Character, Integer> indexMap = new HashMap<>();
    Map<Character, LinkedList<Node>> adjList = new HashMap<>();
    boolean isDirected = false;

    Graph(char[] vertices, boolean isDirected) {
      this(vertices);
      this.isDirected = isDirected;
    }

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
      adjList.get(a).add(new Node(b, 1));
      if(!isDirected) {
        adjMatrix[indexMap.get(b)][indexMap.get(a)] = 1;
        adjList.get(b).add(new Node(a, 1));
      }
    }

    void addEdge(char a, char b, int weight) {
      adjMatrix[indexMap.get(a)][indexMap.get(b)] = weight;
      adjList.get(a).add(new Node(b, weight));
      if(!isDirected) {
        adjMatrix[indexMap.get(b)][indexMap.get(a)] = weight;
        adjList.get(b).add(new Node(a, weight));
      }
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

  private class Node {
    char label;
    int weight;
    String extra;

    Node(char label, int weight) {
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


  private void run() {
    char[] vertices = {'A', 'B', 'C', 'D', 'E'};
    Graph graph = new Graph(vertices);
    graph.addEdge('A', 'B', 2);
    graph.addEdge('A', 'C', 15);
    graph.addEdge('C', 'D', 3);
    graph.addEdge('B', 'E', 2);
    graph.addEdge('A', 'E', 2);
    graph.addEdge('D', 'E', 2);
    minimalSpanningTree(graph, 'A');
  }

  /**
   * This algo is simpler than that of Dijktra since we do not need to calculate distance and path. We just add the
   * nearest neighbour into the heap. Since, we are interested in identifying all the edges that are needed
   * to create a tree, so we are storing all these edges into a list and displaying them finally.
   */
  private void minimalSpanningTree(Graph graph, char vertex) {
    int size = graph.vertices.length;
    Comparator<Node> comparator = Comparator.comparing(Node::getWeight);
    PriorityQueue<Node> heap = new PriorityQueue<>(comparator);
    heap.add(new Node(vertex, 0));
    Set<Character> visited = new HashSet<>();
    List<String> minTree = new LinkedList<>();


    while(!heap.isEmpty()) {
      Node node = heap.remove();
      int vertexIndex = graph.indexMap.get(node.label);
      if(!visited.contains(node.label)) {
        visited.add(node.label);
        minTree.add(node.extra);
        for(int i=0; i < size; i++) {
          if(graph.adjMatrix[vertexIndex][i] !=0 && !visited.contains(graph.vertices[i])) {
            Node adjNode = new Node(graph.vertices[i], graph.adjMatrix[vertexIndex][i]);
            adjNode.extra = node.label + " - " + graph.vertices[i];
            heap.add(adjNode);
          }
        }
      }
    }

    System.out.println("The edges to generate the minimal spanning tree are: ");
    System.out.println(minTree);
  }

  public static void main(String[] args) {
    new Problem006().run();
  }

}
