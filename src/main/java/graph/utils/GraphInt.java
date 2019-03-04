package graph.utils;

import java.util.HashMap;
import java.util.Map;

public class GraphInt {

  public int[] vertices; //set of vertices labels
  public int[][] adjMatrix; //informs if an edge is present
  public int[] visited; //informs if a node has already been visited
  public Map<Integer, Integer> indexMap; //gives us the index for a vertx
  private boolean isUnDirected; //check if a graph is un-directed


  public GraphInt(int[] vertices, boolean isUnDirected) {
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


  public void setEdge(int x, int y) {
    if(indexMap.get(x) != null && indexMap.get(y) != null) {
      int xIndex = indexMap.get(x);
      int yIndex = indexMap.get(y);
      adjMatrix[xIndex][yIndex] = 1;
      if(isUnDirected) {
        adjMatrix[yIndex][xIndex] = 1;
      }
    }
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

  public static GraphInt getPredefinedGraph() {
    int vertices[] = new int[]{1,2,3,4,5};
    GraphInt graph = new GraphInt(vertices, true);
    graph.setEdge(1,2 );
    graph.setEdge(1, 3);
    graph.setEdge(2, 4);
    graph.setEdge(3, 5);
    graph.setEdge(4, 6);
    graph.setEdge(5, 6);
    return graph;
  }

  public static void main(String[] args) {
    int vertices[] = new int[]{1,2,3,4};
    GraphInt graph = new GraphInt(vertices, true);
    System.out.println(graph.adjMatrix);
  }

}
