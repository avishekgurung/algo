package graph.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Problem020 {

  public void shortestPathUtil(int arr[][], int dest) {
    Graph graph = createGraph(arr);
    shortestPathBellmanFord(graph, 0, dest);
  }

  private void shortestPathBellmanFord(Graph graph, int src, int dest) {
    int size = graph.vertices.length;
    String path[] = new String[size];
    int dist[] = new int[size];

    for(int i=0; i < size; i++) dist[i] = Integer.MAX_VALUE;
    int srcIndex = graph.indexMap.get(src);
    dist[srcIndex] = 0;
    path[srcIndex] = src + "";

    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(src);

    while(!queue.isEmpty()) {
      src = queue.remove();
      srcIndex = graph.indexMap.get(src);

      for(int i=0; i < size; i++) {
        if(graph.adjMatrix[srcIndex][i] != 0) {
          int newDistance = dist[srcIndex] + graph.adjMatrix[srcIndex][i];
          if(dist[i] == Integer.MAX_VALUE) {
            dist[i] = newDistance;
            path[i] = path[srcIndex] + " --> " + graph.vertices[i];
            queue.add(graph.vertices[i]);
          }
          else if(dist[i] > newDistance) {
            dist[i] = newDistance;
            path[i] = path[srcIndex] + " --> " + graph.vertices[i];
          }
        }
      }
    }

    int destIndex = graph.indexMap.get(dest);
    System.out.println("Distance: " + dist[destIndex]);
    System.out.println("Path: " + path[destIndex]);
  }

  private Graph createGraph(int arr[][]) {
    int counter = 0;
    int size = arr.length;
    int vertices[] = new int[size * size];
    for(int i=0; i < size*size; i++) vertices[i] = counter++;

    Graph graph = new Graph(vertices, true);

    counter = 0;
    for(int i=0; i < size; i++) {
      for(int j=0; j < size; j++) {
        //top
        if(i-1 >= 0) {
          graph.setEdge(counter-size, counter, arr[i][j]);
        }
        //bottom
        if(i+1 < size) {
          graph.setEdge(counter+size, counter, arr[i][j]);
        }
        //left
        if(j-1 >= 0) {
          graph.setEdge(counter-1, counter, arr[i][j]);
        }
        //right
        if(j+1 < size) {
          graph.setEdge(counter+1,counter, arr[i][j]);
        }
        counter++;
      }
    }
    return graph;
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
    Problem020 object = new Problem020();
    int arr[][] = new int[][]{
        {1,2,3},
        {4,8,2},
        {1,5,3}
    };
    object.shortestPathUtil(arr, 8);
  }

}
