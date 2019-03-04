package graph.problems;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import graph.utils.Graph;

public class Problem018 {

  public static void sortAlienAlphabets(String dict[]) {
    Graph graph = createGraph(dict);
    topologicalSort(graph);
  }

  private static void topologicalSort(Graph graph) {
    int size = graph.vertices.length;
    int[] inDegree = new int[size];

    //calculate indegree
    for(int i=0; i < size; i++) {
      for(int j=0; j < size; j++) {
        if(graph.adjMatrix[i][j] == 1) {
          inDegree[j] = inDegree[j] + 1;
        }
      }
    }

    Queue<Character> queue = new LinkedList<Character>();
    for(int i=0; i < size; i++) {
      if(inDegree[i] == 0) queue.add(graph.vertices[i]);
    }

    while(!queue.isEmpty()) {
      char vertex = queue.remove();
      int vertexIndex = graph.indexMap.get(vertex);
      System.out.print(vertex + " -> ");

      for(int i=0; i < size; i++) {
        if(graph.adjMatrix[vertexIndex][i] == 1) {
          inDegree[i] = inDegree[i] - 1;
          if(inDegree[i] == 0) {
            queue.add(graph.vertices[i]);
          }
        }
      }
    }
    System.out.println();
  }

  /**
   * Creating a graph.
   * We compare every adjacent word and whenever there is a mismatch in characters, we define
   * the edge.
   * @param arr
   * @return
   */
  private static Graph createGraph(String arr[]) {
    char[] vertices = getVertices(arr);
    Graph graph = new Graph(vertices, false);

    for(int i=0; i < arr.length-1; i++) {
      String word1 = arr[i];
      String word2 = arr[i+1];

      int j=0;
      while(word1.charAt(j) == word2.charAt(j)) {
        j++;
      }
      if(j < word1.length() && j < word2.length()) { //cases: aab and aabc
        graph.setEdge(word1.charAt(j), word2.charAt(j));
      }
    }
    return graph;
  }

  /**
   * Fetching the vertices for a graph from the array.
   * If n is the number of words and e is the number of alphabets in each words, then
   * complexity = ne
   * @param arr
   * @return
   */
  private static char[] getVertices(String arr[]) {
    Set<Character> set = new HashSet<Character>();
    for(String word : arr) {
      for(int i=0; i < word.length(); i++) {
        set.add(word.charAt(i));
      }
    }

    char vertices[] = new char[set.size()];
    int i=0;
    Iterator<Character> iterator = set.iterator();
    while(iterator.hasNext()) {
      vertices[i++] = iterator.next();
    }
    return vertices;
  }

  public static void main(String[] args) {
    sortAlienAlphabets(new String[]{"baa", "abcd", "abca", "cab", "cad"});
    sortAlienAlphabets(new String[]{"caa", "aaa", "aab"});
  }

}
