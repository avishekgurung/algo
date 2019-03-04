package graph.problems;

import java.util.Map;

import graph.utils.Graph;

/**
 * View theory from: https://www.youtube.com/watch?v=jFZsDDB0-vo&t=336s
 * https://www.geeksforgeeks.org/articulation-points-or-cut-vertices-in-a-graph/
 */
public class Problem011 {

  private static int count = 0;

  public static void getArticulationPoints(Graph graph) {
    int size = graph.vertices.length;
    int[] visited = new int[size];
    int[] discoveryTime = new int[size];
    int[] low = new int[size];
    char[] articulationPoint = new char[size];
    char[] parent = new char[size];

    for(int i=0; i < size; i++) {
      articulationPoint[i] = '*';
      parent[i] = '*';
    }

    for(int i=0; i < size; i++) {
      if(visited[i] == 0) {
        calculateArticulationPoint(graph, graph.vertices[i], visited, discoveryTime, low, articulationPoint , parent);
      }
    }

    for(int i=0; i < size; i++) {
      if(articulationPoint[i] != '*') {
        System.out.println(articulationPoint[i]);
      }
    }

  }


  public static void calculateArticulationPoint(Graph graph, char vertex, int[] visited,
      int[] discoveryTime, int[] low, char[] articulationPoint, char[] parent) {

    int vertexIndex = graph.indexMap.get(vertex);
    visited[vertexIndex] = 1;

    int children = 0;
    discoveryTime[vertexIndex] = ++count;
    low[vertexIndex] = ++count;

    for(int i=0; i < graph.vertices.length; i++) {
      if(graph.adjMatrix[vertexIndex][i] !=0) {
        if(visited[i] == 0) {
          children++;
          parent[i] = vertex;
          calculateArticulationPoint(graph, graph.vertices[i], visited, discoveryTime ,low , articulationPoint , parent );
          low[vertexIndex] = Math.min(low[vertexIndex], low[i]);
          if(parent[vertexIndex] == '*' && children > 1) {
            articulationPoint[vertexIndex] = vertex;
          }

          if(parent[vertexIndex] != '*' && low[i] >= discoveryTime[vertexIndex]) {
            articulationPoint[vertexIndex] = vertex;
          }
        }
        if(visited[i] == 1 && parent[i] != vertex) {
          low[vertexIndex] = Math.min(low[vertexIndex], discoveryTime[i]);
        }
      }
    }
  }

  public static void main(String[] args) {
    char vertices[] = new char[]{'A','B','C','D','E','F'};
    Graph graph = new Graph(vertices, true);
    graph.setEdge('A', 'B');
    graph.setEdge('A', 'C');
    graph.setEdge('B', 'D');
    graph.setEdge('D', 'C');
    graph.setEdge('D', 'E');
    graph.setEdge('D', 'F');
    graph.setEdge('E', 'F');

    getArticulationPoints(graph);

  }
}
/***
 * Time complexity = O(V+E)
 *
 * Max number of cut-vertices a graph can have is n-1.
 * a - b - c -d - e where AP are b,c and d.
 *
 */

