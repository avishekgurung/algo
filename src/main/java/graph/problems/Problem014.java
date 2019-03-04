package graph.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import graph.utils.Graph;
import graph.utils.GraphInt;

public class Problem014 {

  public static void shortestPathUtil(int n1, int n2) {
    int[]  primes = get4DigitPrimeNumbers();
    GraphInt graph = new GraphInt(primes, true);
    for(int i=0; i < primes.length; i++) {
      for(int j=i+1; j < primes.length; j++) {
        if(compare(primes[i],primes[j])) {
          graph.setEdge(primes[i], primes[j]);
        }
      }
    }

    shortestPath(graph, n1, n2);

  }

  private static void shortestPath(GraphInt graph, int n1, int n2) {

    Queue<Integer> queue = new LinkedList<Integer>();
    queue.add(n1);
    int distance[] = new int[graph.vertices.length];
    String path[] = new String[graph.vertices.length];
    for(int i=0; i < graph.vertices.length; i++) distance[i] = -1;
    int ind = graph.indexMap.get(n1);
    distance[ind] = 0;
    path[ind] = n1+"";

    boolean exitFlag = false;

    while(!queue.isEmpty()) {
      int vertex = queue.remove();
      int vertexIndex = graph.indexMap.get(vertex);

      for(int i=0; i < graph.vertices.length; i++) {
        if(graph.adjMatrix[vertexIndex][i] == 1 && distance[i] == -1) {
          distance[i] = distance[vertexIndex] + 1;
          path[i] = path[vertexIndex] + " -> " + graph.vertices[i];
          queue.add(graph.vertices[i]);
          if(i == n2) {
            exitFlag = true;
            break;
          }
        }
      }

      if(exitFlag) {
        break;
      }
    }

    int p2Index = graph.indexMap.get(n2);
    System.out.println("Distance: " + distance[p2Index]);
    System.out.println("Path: " + path[p2Index]);

  }

  private static boolean compare(int p1, int p2) {
    String prime1 = p1+"";
    String prime2 = p2+"";

    int diff = 0;
    for(int i=0; i < 4; i++) {
      if(prime1.charAt(i) != prime2.charAt(i)) diff++;
    }
    return diff == 1;
  }

  private static int[] get4DigitPrimeNumbers() {
    List<Integer> primes = new ArrayList<Integer>();
    int n = 10000;
    int marker[] = new int[n];


    for(int divider=2; divider < n && marker[divider] == 0; divider++) {
      for(int number=2; number < n; number++) {
        if(number%divider == 0 && number >= divider*divider) {
          marker[number] = 1;
        }
      }
    }

    for(int i=2; i < n; i++) {
      if(marker[i] == 0) {
        primes.add(i);
      }
    }

    int size = 0;
    for(int ele : primes) {
      if(ele > 1000) size++;
    }

    int primeArr[] = new int[size];
    int c=0;
    for(int prime : primes) {
      if(prime > 1000) {
        primeArr[c] = prime;
        c++;
      }
    }
    return primeArr;
  }


  public static void main(String[] args) {
    //System.out.println(Arrays.toString(get4DigitPrimeNumbers()));
    shortestPathUtil(1033,8179);
  }

}
