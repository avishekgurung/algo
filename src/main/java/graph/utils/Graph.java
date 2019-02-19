package graph.utils;

import java.util.HashMap;
import java.util.Map;

public class Graph {

  public char[] vertices; //set of vertices labels
  public int[][] adjMatrix; //informs if an edge is present
  public int[] visited; //informs if a node has already been visited
  public Map<Character, Integer> indexMap; //gives us the index for a vertx
  private boolean isUnDirected; //check if a graph is un-directed


  public Graph(char[] vertices, boolean isUnDirected) {
    indexMap = new HashMap<Character, Integer>();
    int size = vertices.length;
    this.vertices = vertices;
    this.adjMatrix = new int[size][size];
    this.visited = new int[size];
    for(int i=0; i < size; i++) {
      indexMap.put(vertices[i], i);
    }
    this.isUnDirected = isUnDirected;
  }


  public void setEdge(char x, char y) {
    if(indexMap.get(x) != null && indexMap.get(y) != null) {
      int xIndex = indexMap.get(x);
      int yIndex = indexMap.get(y);
      adjMatrix[xIndex][yIndex] = 1;
      if(isUnDirected) {
        adjMatrix[yIndex][xIndex] = 1;
      }
    }
  }

  public void setEdge(char x, char y, int weight) {
    if(indexMap.get(x) != null && indexMap.get(y) != null) {
      int xIndex = indexMap.get(x);
      int yIndex = indexMap.get(y);
      adjMatrix[xIndex][yIndex] = weight;
      if(isUnDirected) {
        adjMatrix[yIndex][xIndex] = weight;
      }
    }
  }

  public static Graph getPredefinedGraph() {
    char vertices[] = new char[]{'A','B','C','D','E','F','G','H'};
    Graph graph = new Graph(vertices, true);
    graph.setEdge('A', 'B');
    graph.setEdge('B', 'C');
    graph.setEdge('B', 'H');
    graph.setEdge('C', 'D');
    graph.setEdge('C', 'E');
    graph.setEdge('H', 'E');
    graph.setEdge('E', 'G');
    graph.setEdge('E', 'F');
    return graph;
  }

}
