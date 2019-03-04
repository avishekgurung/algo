package graph.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;


public class Problem019 {


  public void util(int cost[][]) {
    Graph graph = createGraph(cost);
    int minVertex = 0, minCost = Integer.MAX_VALUE;

    //selecting edge with min cost to start with MST
    for(int i=0; i < cost.length; i++) {
      for(int j=0; j < cost[i].length; j++) {
        if(cost[i][j] != 0 && cost[i][j] < minCost) {
          minCost = cost[i][j];
          minVertex = i;
        }
      }
    }

    minimalSpanningByPrims(graph, minVertex);

  }
  private void minimalSpanningByPrims(Graph graph, int src) {
    int cost = 0;
    String path = "";

    PriorityQueue<Vertex> heap = new PriorityQueue<Vertex>(graph.vertices.length, new
        VertexComparator());
     Vertex vertex = new Vertex(src, 0);
     heap.add(vertex);

     while(!heap.isEmpty()) {
       vertex = heap.remove();
       int vertexIndex = graph.indexMap.get(vertex.label);

       if(graph.visited[vertexIndex] == 0) {
         graph.visited[vertexIndex] = 1;
         cost = cost + graph.vertices[vertexIndex];
         path = path + " " + vertex.label;

         for(int i=0; i < graph.vertices.length; i++) {
           if(graph.adjMatrix[vertexIndex][i] != 0 && graph.visited[i] == 0) {
             Vertex neighbour = new Vertex(graph.vertices[i], graph.adjMatrix[vertexIndex][i]);
             heap.add(neighbour);
           }
         }
       }
     }
    System.out.println("Cost: " + cost);
    System.out.println("Path: " + path);
  }

  private Graph createGraph(int cost[][]) {
    int n = cost.length;
    int counter = 0;
    int vertices[] = new int[n];
    for(int i=0; i < n; i++) vertices[i] = counter++;

    Graph graph = new Graph(vertices, false);

    for(int i=0; i < n; i++) {
      for(int j=0; j < n; j++) {
        if(cost[i][j] != 0) {
          graph.setEdge(i, j, cost[i][j]);
        }
      }
    }
    return graph;
  }

  private class Vertex {
    int label;
    int cost;
    Vertex(int label, int cost) {
      this.cost = cost;
      this.label = label;
    }
  }

  private class VertexComparator implements Comparator<Vertex> {
    public int compare(Vertex o1, Vertex o2) {
      if(o1.cost < o2.cost) return -1;
      return 1;
    }
  }

  private class Graph {
    public int[] vertices; //set of vertices labels
    public int[][] adjMatrix; //informs if an edge is present
    public int[] visited; //informs if a node has already been visited
    public Map<Integer, Integer> indexMap; //gives us the index for a vertx
    private boolean isUnDirected; //check if a graph is un-directed


    public Graph(int[] vertices, boolean isUnDirected) {
      indexMap = new HashMap<Integer, Integer>();
      int size = vertices.length;
      this.vertices = vertices;
      this.adjMatrix = new int[size][size];
      this.visited = new int[size];
      for(int i=0; i < size; i++) {
        indexMap.put(vertices[i], i);
      }
      this.isUnDirected = isUnDirected;
    }

    public void setEdge(int x, int y, int weight) {
      if(indexMap.get(x) != null && indexMap.get(y) != null) {
        int xIndex = indexMap.get(x);
        int yIndex = indexMap.get(y);
        adjMatrix[xIndex][yIndex] = weight;
        if(isUnDirected) {
          adjMatrix[yIndex][xIndex] = weight;
        }
      }
    }
  }

  public static void main(String[] args) {
    Problem019 object = new Problem019();
    object.util(new int[][] {
        {0, 1, 2, 3, 4},
        {1, 0, 5, 0, 7},
        {2, 5, 0, 6, 0},
        {3, 0, 6, 0, 0},
        {4, 7, 0, 0, 0}
    });
  }

}
