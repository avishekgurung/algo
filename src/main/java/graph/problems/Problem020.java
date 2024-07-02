package graph.problems;

import java.util.*;

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


  /**
   * The above process needs to create a whole Graph. But we can do it by just using adj Matrix. We will
   * assume that the provided 2D matrix as adjMatrix and solve it as follows.
   */

  class Node {
    int i;
    int j;

    Node(int i, int j) {
      this.i = i;
      this.j = j;
    }

    @Override
    public int hashCode() {
      return (i + " " + j).hashCode();
    }

    @Override
    public String toString() {
      return this.i + ":" + this.j;
    }
  }
  private void driver() {
    int arr[][] = {
            {1, 1, 1, 1, 0, 0},
            {1, 0, 0, 1, 0, 0},
            {1, 0, 1, 1, 0, 0},
            {1, 0, 1, 0, 0, 0},
            {1, 1, 1, 0, 0, 0},
    };

    Set<String> visited = new HashSet<>();
    Map<String, Integer> distance = new HashMap<>();
    Map<String, String> path = new HashMap<>();

    Node origin = new Node(0, 0);

    path.put(origin.toString(), origin.toString());
    distance.put(origin.toString(), 0);

    Queue<Node> queue = new LinkedList<>();
    queue.add(origin);

    Node destination = new Node(2,2);
    boolean foundDest = false;

    while (!queue.isEmpty()) {
      Node node = queue.remove();
      if (!visited.contains(node.toString())) {
        visited.add(node.toString());
        int i = node.i;
        int j = node.j;
        List<Node> neighbors = new ArrayList<>();
        if (j - 1 >= 0 && arr[i][j - 1] == 1)
          neighbors.add(new Node(i, j - 1));
        if (i - 1 >= 0 && arr[i - 1][j] == 1)
          neighbors.add(new Node(i - 1, j));
        if (j + 1 < arr[0].length && arr[i][j + 1] == 1)
          neighbors.add(new Node(i, j + 1));
        if (i + 1 < arr.length && arr[i + 1][j] == 1)
          neighbors.add(new Node(i + 1, j));

        for (Node neighbor : neighbors) {
          if (!visited.contains(neighbor.toString())) {
            int newDistance = distance.get(node.toString()) + 1;
            distance.put(neighbor.toString(), newDistance);
            path.put(neighbor.toString(), path.get(node.toString()) + " -> " + neighbor);
            queue.add(neighbor);
            if (neighbor.toString().equals(destination.toString())) {
              break;
            }
          }
        }
      }
      if(foundDest) break;
    }
    System.out.println(distance.get(destination.toString()) + " : " + path.get(destination.toString()));
  }

}
