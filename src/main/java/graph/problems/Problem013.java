package graph.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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


  /**
   * Used this simple trick of recursion.
   */
  private int shortPathIn2DMatrix(int arr[][], Set<String> visited, int i, int j) {
    /**
     * Return any largest value if the condition is not sufficing since we want to find the minimal value.
     * Do not use Integer.MAX_VALUE since it will become negative on adding any value to to.
     *
     * In order to avoid traversing the same path again, we use set to check the visited nodes. We create a key to store
     * in that set.
     *
     */
    if(i >= arr.length || i < 0 || j >= arr.length || j < 0) return (arr.length * 2);
    if(arr[i][j] == 0) return (arr.length * 2);

    String key = i + " : " + j;
    if(visited.contains(key)) return (arr.length * 2);

    if(arr[i][j] == 2) return 0;

    visited.add(key);

    int leftResult = shortPathIn2DMatrix(arr, visited, i-1, j);
    int rightResult = shortPathIn2DMatrix(arr, visited, i+1, j);
    int topResult = shortPathIn2DMatrix(arr, visited, i, j + 1);
    int bottomResult = shortPathIn2DMatrix(arr, visited, i, j - 1);
    visited.remove(key);
    return Math.min(Math.min(Math.min(leftResult, rightResult), topResult), bottomResult) + 1;
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

/**
 * Another simple way is to use DP and solve it (recursion). No too much code on
 * creating a graph.
 */



