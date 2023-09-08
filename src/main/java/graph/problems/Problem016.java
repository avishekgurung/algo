package graph.problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import graph.utils.GraphInt;

public class Problem016 {

  public static void maxRegionUtil(int arr[][]) {
    GraphInt graph = createGraph(arr);
    Set<Integer> unprocessedVertices = getVertices(arr);
    maxRegion(graph,unprocessedVertices);
  }

  private static void maxRegion(GraphInt graph, Set<Integer> unprocessedVertices) {
    int maxNodeCount = 0;
    Set<Integer> maxNodes = new HashSet<Integer>();

    while(!unprocessedVertices.isEmpty()) {
      Iterator<Integer> iterator = unprocessedVertices.iterator();
      int src = iterator.next();
      Set<Integer> nodes = new HashSet<Integer>();
      int node_count = bfs(graph, src, unprocessedVertices, nodes);
      if(node_count > maxNodeCount) {
        maxNodeCount = node_count;
        maxNodes = nodes;
      }
    }

    System.out.println("Region size: " + maxNodeCount);
    System.out.println("Region area: " + maxNodes);
  }

  //We can use bfs or dfs anything we want.
  private static int bfs(GraphInt graph, int vertex, Set<Integer> unprocessedVertices,
      Set<Integer> nodes) {
    int nodeCount = 0;

    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(vertex);

    while(!queue.isEmpty()) {
      vertex = queue.remove();
      int vertexIndex = graph.indexMap.get(vertex);
      if(graph.visited[vertexIndex] == 0) {
        graph.visited[vertexIndex] = 1;

        nodeCount++;
        nodes.add(vertex);
        unprocessedVertices.remove(vertex);

        for(int i=0; i < graph.vertices.length; i++) {
          if(graph.adjMatrix[vertexIndex][i] == 1 && graph.visited[i] == 0) {
            queue.add(graph.vertices[i]);
          }
        }
      }
    }

    return nodeCount;
  }

  private static Set<Integer> getVertices(int arr[][]) {
    Set<Integer> validVertices = new HashSet<Integer>();
    int counter = 0;
    for(int i=0; i < arr.length; i++) {
      for(int j=0; j < arr[0].length; j++) {
        if(arr[i][j] == 1) {
          validVertices.add(counter);
        }
        counter++;
      }
    }
    return validVertices;
  }

  private static GraphInt createGraph(int arr[][]) {
    int m = arr.length;
    int n = arr[0].length;
    int size = m * n;
    int vertices[] = new int[size];
    int counter = 0;
    for(int i=0; i < size; i++)vertices[i] = counter++;

    GraphInt graph = new GraphInt(vertices, true);

    //Lets set up edges for graph
    counter = 0;
    for(int i=0; i < m; i++) {
      for(int j=0; j < n; j++) {
        if(arr[i][j] == 1) {
          //check top cell
          if(i-1 >= 0 && arr[i-1][j] == 1) {
            graph.setEdge(counter-n, counter);
          }
          //check bottom cell
          if(i+1 < m && arr[i+1][j] == 1) {
            graph.setEdge(counter+n, counter);
          }
          //check left cell
          if(j-1 >=0 && arr[i][j-1] == 1) {
            graph.setEdge(counter-1, counter);
          }
          //check right cell
          if(j+1 < n && arr[i][j+1] == 1) {
            graph.setEdge(counter, counter+1);
          }
          //check left top
          if(i-1 >=0 && j-1>=0 && arr[i-1][j-1] == 1) {
            graph.setEdge(counter-(n+1), counter);
          }
          //check left bottom
          if(i+1 < m && j-1>=0 && arr[i+1][j-1] == 1) {
            graph.setEdge(counter+(n-1), counter);
          }
          //check right top
          if(i-1 >=0 && j+1 < n && arr[i-1][j+1] == 1){
            graph.setEdge(counter-(n-1), counter);
          }
          //check right bottom
          if(i+1 < m && j+1 < n && arr[i+1][j+1] == 1) {
            graph.setEdge(counter+(n+1), counter);
          }
        }
        counter++;
      }
    }
    return graph;
  }


  public static void main(String[] args) {
    maxRegionUtil(new int[][]{{0,0,1,1,0},{1,0,1,1,0},{0,1,0,0,0},{0,0,0,0,1}});
  }

}

/**
 *  The solution is simple.
 *
 *  1. Create a graph where every cell will be a vertex of a graph. For simplicity, we name all
 *  vertex from 0 to (m*n-1). The vertex whose cell value is 1 should connect to left cell, right
 *  cell, top cell, bottom cell, left top, left bottom, right top and right bottom PROVIDED if
 *  their values are 1.
 *
 *  2. No we keep all the vertices which we want to process in a set. So that we do not
 *  re-process same vertices. We pick one vertex from the set and do its BFS. Once the node
 *  is visited we remove from this set. Once the BFS is complete, all the nodes belonging to
 *  one region are removed. Now we need to process node of another region, so for that we
 *  pick next node from this set.
 *
 *  3. To find a region, we just do bfs or dfs and find the node count.
 *
 *
 *  We can simply solve this by simple recursion.
 */
