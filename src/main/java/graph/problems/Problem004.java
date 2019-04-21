package graph.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;


/**
 * Dijktra's shortest path algorithm
 *
 * Quick Walkthrough:
 * We use PriorityQueue or Heap(min).
 * For a given vertex, we check for all its neighbours. We process only the non-visited
 * neighbours. So if the neighbour is not visited, then we calculate the distance.
 * If this distance is less than already calculated distance then we add this neighbour with
 * its new calculated distance in the heap.
 *
 *
 * Explanation
 * This algorithm is a single source shortest path problem for non-negative edges. It is solved
 * using Greedy method. Given a vertex, we find a shortest distance to all the
 * vertices in a graph.
 *
 * Lets consider the graph below.
 *          2
 *    A-------------B
 *    |             |
 *  3 |             | 3
 *    |             |
 *    C-------------D
 *          1
 *  Its a directed graph where A -> B = 2, A -> C = 3, B -> D = 3, C -> D = 1.
 *  Dijktra's algo starts with a source vertex and then starts traversing its
 *  neighbours (which have NOT been visited before) with minimum distance,
 *  until all the nodes are visited. This will be clear with an example. Let A
 *  be the starting vertex. The algo assumes that the initial distance from A
 *  to all the vertices is infinite.
 *
 *  Step 1: We find the unvisited neighbours of A which is B and C. We then
 *  calculate the
 *  distance from A to B and A to C which is 2 and 3. We mark A as visited and
 *  we would never visit A again.
 *
 *  Step 2: Among the two distance calculated, we chose a neighbour with smaller
 *  distance, i.e. B. B has a unvisted neighbour D. So we calculate the
 *  distance from A
 *  to D, which is A to B and B to D. We already know the distance from A to B
 *  (in first step), we now calculate distance from A to D as distance(A,B) +
 *  distance(B,D), which is 5. We now mark B as visited and would never visit B
 *  again.
 *
 *  Step 3: So far we calculated three distances, AB=2, AD=5 and AC=3. Since A
 *  and B are already visited, so which is the next node to process. We process
 *  C because AC < AD. C also has a neighbour unvisted  D for which distance
 *  is already
 *  calculated. But D has not been marked as visited. So we again calculate the
 *  distance from A to D which is AC + CD = 4. The previous distance AD was 5
 *  and now its 4, so we update the distance of AD as 4. We mark C as visited.
 *
 *  Step 4: We only have node D to process now and it does not have any
 *  neighbour. So we just mark it as visited.
 *
 *  Now lets look at some examples using the same graph as above with
 *  different weights to understand better:
 *
 * Example 1.
 *          2
 *    A-------------B
 *    |             |
 *  3 |             | 1
 *    |             |
 *    C-------------D
 *          1
 *
 * Step 1: A selected. AB = 2, AC = 3. A is marked.
 *
 * Step 2: B selected since AB < AC. BD = 1, AD = 3. B is marked.
 *
 * Step 3: AC = 3 and AD = 3, so we can select either B or C. Lets select
 *  C. CD = 1 so AD = 4. Since AD is already calculated as 3 < 4 so AD remains
 *  as 3 and is not updated. C is marked.
 *
 *  Step 4: AD via B = 3 and AD via C = 4. We select D and mark it.
 *
 *
 *  Example 2.
 *          2
 *    A-------------B
 *    |             |
 *  3 |             | 0
 *    |             |
 *    C-------------D
 *          1
 *
 * Step 1: A is selected. AB=2 and AC=3. A is marked.
 *
 * Step 2. AB < AC. We select B. BD = 0. AD = AB + BD = 2. B is marked.
 *
 * Step 3. AC=3 and AD=2. We select D. D has no neighbours so do nothing. D is
 * marked.
 *
 * Step 4. C is selected. AD is NOT calculated since D is already marked as visited. C is marked.
 *
 *  Example 3. (Dijktra's algo working for negative weights)
 *          2
 *    A-------------B
 *    |             |
 *  3 |             | 1
 *    |             |
 *    C-------------D
 *          -1
 *
 * Step 1: A is selected. B,C are un-visited. AC=3 and AB=2. A is marked.
 *
 * Step 2. B is selected. D is not visited. AD=3. B is marked.
 *
 * Step 3. AC=3 and AD=3. We can select C or D. Lets select C. CD=-1 so AD=2.
 * Update AD to 2 from 3. C is marked. (If we had selected D then the algo would
 * give wrong result). C is marked.
 *
 * Step 4. D is selected and marked.
 *
 * Here, the algo could have given wrong or right result. In 3 step, if we had
 * selected D then AD would be 3 and D would be marked as visited. So next time
 * C is selected, AD via C would never be calculated as D is already marked as
 * visited.
 *
 * Example 4. (Dijktra's algo working for negative weights)
 *          2
 *    A-------------B
 *    |             |
 *  3 |             | 0
 *    |             |
 *    C-------------D
 *          -2
 *
 * This would be a case where the Algo would always fail.
 *
 * Step 1: A selected. B and C not visted. So AB and AC are calculated.
 * AB=2,AC=3. A is marked.
 *
 * Step 2. AB < AC so B is selected. B's unvisited neighbour is D. AD=2+0=2.
 * B is marked.
 *
 * Step 3. AD < AC. So D is selected. D has not neighbours. D is marked.
 *
 * Step 4. C is selected. Now C has no neighbours who are not visited before. So
 * C will not calculate the distance AD via C which would have been 3-2=1. AD
 * should have been 1 but now its 2. So in this case Dijktra's algo would fail.
 * So we can conclude that Dijktra's algo is unstable for negative weights.
 *
 *
 * IMPLEMENTATION
 * The implementation is simpler than thought.
 *
 * We assign a distance of infinity to all the vertices except the source
 * vertex.
 *
 * We create a min Priority Queue which would store the vertices based on their
 * distance calculated. The source vertex has distance 0 (distance to itself)
 * and we insert source vertex to queue.
 *
 * while queue is not empty
 *  Remove a vertex from a queue.
 *  mark it as visited.
 *  Find all the neighbours of vertex which are not visited.
 *    Calculate the distance from the source to neighbour via current vertex.
 *    If this distance is lesser than the distance assigned to neighbour then
 *    update the distance and put the neighbour in the queue.
 *
 * COMPLEXITY (Assuming implementation is done by Adj List and not Adj matrix)
 * Considering the below code:
 * V(logV + NlogV) where V is the vertices and N is the number of edges attached
 * to a single vertex.
 *
 * Complexity = VNlogV. But Dijktra's algo states that the time complexity
 * is ElogV. Here E is the total number of edges present in the graph.
 * So our calculation is correct. VN = E.
 * https://stackoverflow.com/questions/26547816/understanding-time-complexity-calculation-for-dijkstra-algorithm
 *
 * If we use adjMatrix, the complexity comes to V^2logV. And with Adj list,
 * its VNlogV.
 *
 * Lets say we have graph of vertices 100. And its a sparse graph with edge
 * 20. Then adjMatrix complexity = 100000log100 and adjList=2000log100 so
 * we see the difference.
 *
 * Referred:
 * https://www.youtube.com/watch?v=XB4MIexjvY0
 * https://www.geeksforgeeks.org/dijkstras-algorithm-for-adjacency-list-representation-greedy-algo-8/
 * https://algorithms.tutorialhorizon.com/dijkstras-shortest-path-algorithm-spt-adjacency-list-and-priority-queue-java-implementation/
 * https://www.sanfoundry.com/java-program-mplement-dijkstras-algorithm-using-priority_queue/
 *
 */
public class Problem004 {

  private class Vertex{
    char label;
    int distance;

    Vertex(char label, int distance) {
      this.label = label;
      this.distance = distance;
    }

  }

  private class VertexComparator implements Comparator<Vertex> {
    public int compare(Vertex o1, Vertex o2) {
      if(o1.distance < o2.distance) return -1;
      if(o1.distance > o2.distance) return 1;
      else return -1;
    }
  }

  private class Neighbour {
    char label;
    int weight;

    Neighbour(char label, int weight) {
      this.label = label;
      this.weight = weight;
    }
  }

  private class Graph {

    private char[] vertices;

    private LinkedList<Neighbour>[] adjList;

    private Map<Character, Integer> indexMap = new HashMap<Character, Integer>();
    private Set<Character> visited = new HashSet<Character>();
    private int size;

    Graph(char[] vertices) {
      this.size = vertices.length;
      this.vertices = vertices;

      adjList = new LinkedList[size];

      for(int i=0; i < size; i++) {
        adjList[i] = new LinkedList<Neighbour>();
      }

      for(int i=0; i < size; i++) {
        indexMap.put(this.vertices[i], i);
      }
    }


    public void setEdge(char src, char dest, int weight) {
      int srcIndex = indexMap.get(src);
      Neighbour neighbour = new Neighbour(dest, weight);
      LinkedList<Neighbour> neighbours = adjList[srcIndex];
      neighbours.add(neighbour);
      adjList[srcIndex] = neighbours;

      //For non directed graph
      /*int destIndex = indexMap.get(dest);
      LinkedList<Neighbour> neighbours1 = adjList.get(destIndex);
      Neighbour neighbour1 = new Neighbour(src, weight);
      neighbours1.add(neighbour1);
      adjList.add(destIndex, neighbours1);*/
    }


    public void shortestPath(char source) {

      String path[] = new String[size];
      int distance[] = new int[size];

      PriorityQueue<Vertex> minHeap =  new PriorityQueue<Vertex>(size,new
          VertexComparator());

      for(int i=0 ; i < size; i++) {
        distance[i] = Integer.MAX_VALUE;
      }

      int vertexIndex = indexMap.get(source);
      distance[vertexIndex] = 0;
      path[vertexIndex] = source + "";

      Vertex vertex = new Vertex(source, 0);
      minHeap.add(vertex);

      while(!minHeap.isEmpty()) {
        vertex = minHeap.remove();
        visited.add(vertex.label);
        evaluateNeighbours(vertex, distance, path, minHeap);
      }

      for(int i=0 ; i < size; i++) {
        System.out.println(distance[i] + " : " + path[i]);
      }
    }

    private void evaluateNeighbours(Vertex vertex, int[] distance, String[]
        path, PriorityQueue<Vertex> minHeap) {
      int vertexIndex = indexMap.get(vertex.label);
      LinkedList<Neighbour> neighbours = adjList[vertexIndex];

      for(Neighbour neighbour : neighbours) {
        if(!visited.contains(neighbour.label)) {
          int newDistance = distance[vertexIndex] + neighbour.weight;
          int neighbourIndex = indexMap.get(neighbour.label);
          if(newDistance < distance[neighbourIndex]) {
            distance[neighbourIndex] = newDistance;
            path[neighbourIndex] = path[vertexIndex] + " -> " + neighbour.label;
            Vertex neighbourVertex = new Vertex(neighbour.label, newDistance);
            minHeap.add(neighbourVertex);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    new Problem004().util();
  }

  public void util() {
    char vertices[] = new char[]{'A','B','C','D','E'};
    Graph graph = new Graph(vertices);

    graph.setEdge('A', 'B', 4);
    graph.setEdge('A', 'C', 1);
    graph.setEdge('C', 'B', 2);
    graph.setEdge('B', 'E', 4);
    graph.setEdge('C', 'D', 4);
    graph.setEdge('D', 'E', 2);

    graph.shortestPath('A');

    System.out.println("----------------");
    vertices = new char[]{'A','B','C','D'};
    graph = new Graph(vertices);
    graph.setEdge('A', 'B', 2);
    graph.setEdge('A', 'C', 3);
    graph.setEdge('C', 'D', 1);
    graph.setEdge('B', 'D', 3);
    graph.shortestPath('A');

    System.out.println("----------------");
    vertices = new char[]{'A','B','C','D'};
    graph = new Graph(vertices);
    graph.setEdge('A', 'B', 2);
    graph.setEdge('A', 'C', 3);
    graph.setEdge('C', 'D', -10);
    graph.setEdge('B', 'D', 0);
    graph.shortestPath('A');


    System.out.println("----------------");
    vertices = new char[]{'A','B','C','D'};
    graph = new Graph(vertices);
    graph.setEdge('A', 'B', 5);
    graph.setEdge('B', 'C', 5);
    graph.setEdge('D', 'C', 2);
    graph.setEdge('D', 'A', 9);
    graph.shortestPath('D');

/*
    System.out.println("----------------");
    vertices = new char[]{'A','B','C','D'};
    graph = new Graph(vertices);
    graph.setEdge('A', 'B', 3);
    graph.setEdge('A', 'C', 5);
    graph.setEdge('C', 'D', 2);
    graph.setEdge('D', 'B', -10);
    graph.shortestPath('A');
*/

  }

}
