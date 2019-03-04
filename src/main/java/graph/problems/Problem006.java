package graph.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

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
 * Prim's algo works on non-directed graph whereas Dijktra's work mostly on directed graph.
 *
 */

public class Problem006 {
  private class Vertex {
    char label;
    int weight;

    Vertex(char label, int weight) {
      this.label = label;
      this.weight = weight;
    }
  }


  private class VertexComparator implements Comparator<Vertex> {
    public int compare(Vertex o1, Vertex o2) {
      if(o1.weight < o2.weight) return -1;
      if(o1.weight > o2.weight) return 1;
      else return -1;
    }
  }

  private class Graph {

    private char[] vertices;

    private LinkedList<Vertex>[] adjList;

    private Map<Character, Integer> indexMap = new HashMap<Character, Integer>();
    private Set<Character> visited = new HashSet<Character>();
    private int size;

    Graph(char[] vertices) {
      this.size = vertices.length;
      this.vertices = vertices;

      adjList = new LinkedList[size];

      for(int i=0; i < size; i++) {
        adjList[i] = new LinkedList<Vertex>();
      }

      for(int i=0; i < size; i++) {
        indexMap.put(this.vertices[i], i);
      }
    }


    public void setEdge(char src, char dest, int weight) {
      int srcIndex = indexMap.get(src);
      Vertex neighbour = new Vertex(dest, weight);
      LinkedList<Vertex> neighbours = adjList[srcIndex];
      neighbours.add(neighbour);
      adjList[srcIndex] = neighbours;

      //For non directed graph
      int destIndex = indexMap.get(dest);
      neighbour = new Vertex(src, weight);
      neighbours = adjList[destIndex];
      neighbours.add(neighbour);
      adjList[destIndex] = neighbours;
    }


    public void minimalSpanningTree(char source) {

      String path = "";
      int cost = 0;

      PriorityQueue<Vertex> minHeap =  new PriorityQueue<Vertex>(size,new
          VertexComparator());

      Vertex vertex = new Vertex(source, 0);
      minHeap.add(vertex);

      while(!minHeap.isEmpty()) {
        vertex = minHeap.remove();
        if(!visited.contains(vertex.label)) {
          cost = cost + vertex.weight;
          path = path + vertex.label + " -> ";
          visited.add(vertex.label);
          evaluateNeighbours(vertex, minHeap);
        }
      }

      System.out.println("Path " + path);
      System.out.println("Cost: " + cost);

    }

    private void evaluateNeighbours(Vertex vertex, PriorityQueue<Vertex> minHeap) {
      int vertexIndex = indexMap.get(vertex.label);
      LinkedList<Vertex> neighbours = adjList[vertexIndex];

      for(Vertex neighbour : neighbours) {
        if(!visited.contains(neighbour.label)) {
          minHeap.add(neighbour);
        }
      }
    }
  }

  public static void main(String[] args) {
    new Problem006().util();
  }

  public void util() {

    char[] vertices = new char[]{'A','B','C','D'};
    Graph graph = new Graph(vertices);
    graph.setEdge('A', 'B', 5);
    graph.setEdge('B', 'C', 5);
    graph.setEdge('D', 'C', 2);
    graph.setEdge('D', 'A', 9);
    graph.minimalSpanningTree('D');


    System.out.println("----------------");
    vertices = new char[]{'1','2','3','4','5','6','7'};
    graph = new Graph(vertices);
    graph.setEdge('1', '6', 10);
    graph.setEdge('6', '5', 25);
    graph.setEdge('5', '4', 22);
    graph.setEdge('5', '7', 24);
    graph.setEdge('7', '4', 18);
    graph.setEdge('1', '2', 28);
    graph.setEdge('7', '2', 14);
    graph.setEdge('4', '3', 12);
    graph.setEdge('3', '2', 16);
    graph.minimalSpanningTree('1');
  }

}
