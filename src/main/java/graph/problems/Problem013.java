package graph.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Problem013 {

  private class Graph {
    private int vertices[];
    private int visited[];
    private int adj[][];

    Graph(int[] vertices) {
      int size = vertices.length;
      this.vertices = vertices;
      this.visited = new int[size];
      this.adj = new int[size][size];
    }

    public void setEdge(int x, int y) {
      this.adj[x][y] = 1;
      this.adj[y][x] = 1;
    }
  }

  public void shortestPath(int[][] matrix) {
    int src = 0, dest = 0;
    int counter = 0;
    int size = matrix.length;
    for(int i=0; i < size; i++) {
      for(int j=0; j < size; j++) {
        if(matrix[i][j] == 1) src = counter;
        if(matrix[i][j] == 2) dest = counter;
        counter++;
      }
    }

    Graph graph = createGraph(matrix);
    Queue<Integer> queue = new LinkedList<Integer>();
    int dist[] = new int[size * size];
    String path[] = new String[size * size];
    for(int i=0; i < size * size; i++) dist[i] = -1;
    dist[src] = 0;
    path[src] = src + "";
    queue.add(src);

    while(!queue.isEmpty()) {

      src = queue.remove();

      for(int i=0; i < size * size; i++) {
        if(graph.adj[src][i] == 1 && dist[i] == -1) {
          dist[i] = dist[src] + 1;
          path[i] = path[src] + " --> " + i;
          queue.add(i);
        }
      }
    }

    System.out.println("Shortest distance: " + dist[dest]);
    System.out.println("Path: " + path[dest]);

  }

  private Graph createGraph(int[][] matrix) {
    int size = matrix.length;
    int counter = 0;
    int vertices[] = new int[size * size];
    for(int i=0; i < (size * size); i++) {
      vertices[i] = counter++;
    }
    Graph graph = new Graph(vertices);

    counter = 0;
    for(int i=0; i < size; i++) {
      for(int j=0; j < size; j++) {

        if(matrix[i][j] != 0) {
          if(i + 1 < size && matrix[i+1][j] != 0) {
            graph.adj[counter][counter+size] = 1;
          }

          if(i - 1 > -1 && matrix[i-1][j] != 0) {
            graph.adj[counter][counter - size] = 1;
          }

          if(j+1 < size && matrix[i][j+1] != 0) {
            graph.setEdge(counter, counter+1);
          }

          if(j-1 > -1 && matrix[i][j-1] != 0) {
            graph.adj[counter][counter-1] = 1;
          }
        }
        counter++;
      }
    }
    return graph;
  }


  public static void main(String[] args) {
    int matrix[][] = new int[][]{{0,3,2},{3,3,0},{1,3,0}};
    Problem013 obj = new Problem013();
    obj.shortestPath(matrix);

    System.out.println("--------------------------");
    matrix = new int[][]
        {{ 3 , 3 , 1 , 0 },
        { 3 , 0 , 3 , 3 },
        { 2 , 3 , 0 , 3 },
        { 0 , 3 , 3 , 3 }};
    obj = new Problem013();
    obj.shortestPath(matrix);
  }

}
