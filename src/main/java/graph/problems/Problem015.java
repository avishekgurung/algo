package graph.problems;

import java.util.LinkedList;
import java.util.Queue;

import graph.utils.GraphInt;

public class Problem015 {

  /**
   * If the centre is (2,3) and R = 2, then one easy way to create a circle would,
   * Find two coordinates by adding and subtracting R, ie (0,1) and (4,5). Now all the points that lies between
   * these two coordinates will be touched by the circle.
   */
  private static int[][] labelMatrix(int arr[][], int[][] circles, int radius) {
    int size = arr.length;
    for(int i=0; i < circles.length; i++) {
      int circle[] = circles[i];
      int x_crd = circle[0];
      int y_crd = circle[1];
      arr[x_crd][y_crd] = 1; //creating a wall at the center.

      int r = radius;
      int x = x_crd;
      int y = y_crd;

      //creating a wall on all left cells
      while(r != 0) {
        y = y - 1;
        if(y >=0) arr[x][y] = 1;
        r--;
      }

      //creating a wall on all right cells
      r = radius;
      x = x_crd;
      y = y_crd;
      while(r != 0) {
        y = y + 1;
        if(y < size) arr[x][y] = 1;
        r--;
      }

      //creating wall on all top cells
      r = radius;
      x = x_crd;
      y = y_crd;
      while(r != 0) {
        x = x - 1;
        if(x >= 0) arr[x][y] = 1;
        r--;
      }

      //creating a wall on all bottom cells
      r = radius;
      x = x_crd;
      y = y_crd;
      while(r != 0) {
        x = x + 1;
        if(x < size) arr[x][y] = 1;
        r--;
      }

      //we need to consider diagonal walls too.
    }
    return arr;
  }


  private static GraphInt createGraph(int arr[][]) {
    int size = arr.length;
    int vertices[] = new int[size * size];
    int counter = 0;

    for(int i=0; i < size * size; i++) vertices[i] = counter++;

    GraphInt graph = new GraphInt(vertices, true);
    counter = 0;

    for(int i=0; i < size; i++) {
      for(int j=0; j < size; j++) {
        if(arr[i][j] == 0) {
          //connecting to left cell
          if(j-1 >= 0 && arr[i][j-1] != 1) {
            graph.adjMatrix[counter][counter-1] = 1;
          }
          //connecting to right cell
          if(j+1 < size && arr[i][j+1] != 1) {
            graph.setEdge(counter, counter+1);
          }
          //connecting to top cell
          if(i-1 >= 0 && arr[i-1][j] != 1) {
            graph.adjMatrix[counter][counter - size] = 1;
          }
          //connecting to bottom cell
          if(i+1 < size && arr[i+1][j] != 1) {
            graph.adjMatrix[counter][counter+size] = 1;
          }
        }
        counter++;
      }
    }
    return graph;
  }

  private static void shortestPath(GraphInt graph) {
    int src = graph.vertices[0];
    int dest = graph.vertices[graph.vertices.length-1];
    int size = graph.vertices.length;

    int distance[] = new int[size];
    String path[] = new String[size];

    for(int i=0; i < size; i++) distance[i] = -1;
    int srcIndex = graph.indexMap.get(src);
    distance[srcIndex] = 0;
    path[srcIndex] = src + "";

    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(src);

    while(!queue.isEmpty()) {
      src = queue.remove();
      srcIndex = graph.indexMap.get(src);

      for(int i=0; i < size; i++) {
        if(graph.adjMatrix[srcIndex][i] == 1 && distance[i] == -1) {
          distance[i] =  distance[srcIndex] + 1;
          path[i] = path[srcIndex] + " -> " + graph.vertices[i];
          queue.add(graph.vertices[i]);
        }
      }
    }

    int destIndex = graph.indexMap.get(dest);
    System.out.println("Distance: " + distance[destIndex]);
    System.out.println("Path: " + path[destIndex]);
  }

  public static void util(int m, int n, int numberOfCircles, int radius, int circles[][]) {
    int arr[][] = new int[m][n];
    arr = labelMatrix(arr, circles, radius);
    GraphInt graph = createGraph(arr);
    shortestPath(graph);
  }

  public static void main(String[] args) {
    util(5, 5, 2, 1, new int[][]{{0,2},{2,2}});
    System.out.println("----------------------");
    util(5, 5,2, 1, new int[][]{{1,1},{2,3}});

  }

  /**
   * A simple approach for filling the cells with walls can be used as follows:
   *
   * A radius is of 2 and the centre is 4,5
   * Maintain two lists l1 and l2.
   * Fill l1 with 2,3,4,5,6
   * Fill l2 with 3,4,5,6,7
   *
   * Iterate and fill the cells with 2,3 | 2,4 and so on.
   *
   */

}
