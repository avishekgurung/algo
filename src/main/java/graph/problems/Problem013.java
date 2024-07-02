package graph.problems;

import java.util.*;

/**
 * This problem cannot be solved by using Depth First which we usually use for solving the 2D problems like
 * no of islands, largest island, total paths from source to destination etc.
 *
 * This is a simple shortest path algorithm, just that we would need a little tweaking for implementation.
 */
public class Problem013 {

  class Node {
    int i;
    int j;

    Node(int i, int j) {
      this.i = i;
      this.j = j;
    }
    public String key() {
      return i+":"+j;
    }
  }
  private void shortestPath(int arr[][], Node source, Node target) {
    Set<String> visited = new HashSet<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(source);
    Map<String, Integer> distance = new HashMap<>();
    Map<String, String> path = new HashMap<>();
    distance.put(source.key(), 0);
    path.put(source.key(), source.key());

    while(!queue.isEmpty()) {
      Node node = queue.remove();
      if(!visited.contains(node.key())) {
        visited.add(node.key());
        int i = node.i;
        int j = node.j;

        List<Node> neighbors = new ArrayList<>();
        if(i-1 >=0 && arr[i-1][j] != 0) neighbors.add(new Node(i-1, j));
        if(i+1 < arr.length && arr[i+1][j] != 0) neighbors.add(new Node(i+1, j));
        if(j-1 >=0 && arr[i][j-1] != 0) neighbors.add(new Node(i, j-1));
        if(j+1 < arr[0].length && arr[i][j+1] != 0) neighbors.add(new Node(i, j+1));

        for(Node neighbor : neighbors) {
          //Neighbor is seen for the first time. We need to compute distance and add neighbor for processing.
          if(!visited.contains(neighbor.key())) {
            int oldDistance = distance.containsKey(neighbor.key()) ? distance.get(neighbor.key()) : Integer.MAX_VALUE;
            int newDistance = distance.get(node.key()) + 1;
            if(newDistance < oldDistance) {
              distance.put(neighbor.key(), newDistance);
              path.put(neighbor.key(), path.get(node.key()) + " -> " + neighbor.key());
              queue.add(neighbor);
            }
          }
        }
      }
    }

    System.out.println("Shortest distance is: " + distance.get(target.key()));
    System.out.println("Path: " + path.get(target.key()));
  }


  public static void main(String[] args) {
  new Problem013().driver();
  }

  public void driver() {
    int[][] matrix = new int[][]
      {{ 3 , 3 , 1 , 0 },
      { 3 , 0 , 3 , 3 },
      { 2 , 3 , 0 , 3 },
      { 0 , 3 , 3 , 3 }};

    Node source = new Node(0,2);
    Node target = new Node(2,0);
    shortestPath(matrix, source, target);

  }

}



