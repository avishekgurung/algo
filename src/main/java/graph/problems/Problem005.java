package graph.problems;

import java.util.*;

public class Problem005 {
  public static void main(String[] args) throws Exception {
    new Problem005().driver();
  }


  private void driver() {
    //nonWeightedShortestPathUtil();
    //weightedShortestPathUtil();
    negativeWeightedShortestPathUtil();
  }

  /**
   * Non Weighted Shortest Path (E+V)
   */
  private void nonWeightedShortestPathUtil() {
    Map<Character, List<Character>> adjList1 = new HashMap<>();
    adjList1.put('A', Arrays.asList('B', 'C'));
    adjList1.put('B', Arrays.asList('D', 'A'));
    adjList1.put('C', Arrays.asList('D', 'A'));
    adjList1.put('D', Arrays.asList('C', 'B'));
    nonWeightedShortestPath(adjList1, 'A');

    adjList1 = new HashMap<>();
    adjList1.put('A', Arrays.asList('D', 'B', 'C'));
    adjList1.put('B', Arrays.asList('D', 'A'));
    adjList1.put('C', Arrays.asList('D', 'A'));
    adjList1.put('D', Arrays.asList('C', 'B'));
    nonWeightedShortestPath(adjList1, 'A');
  }

  private void nonWeightedShortestPath(Map<Character, List<Character>> adjList, Character vertex) {
    Set<Character> visited = new HashSet<>();
    Map<Character, Integer> distance = new HashMap<>();
    Map<Character, String> path = new HashMap<>();

    path.put(vertex, vertex + "");
    for(Character vrtx : adjList.keySet()) {
      distance.put(vrtx, 0);
    }

    Queue<Character> queue = new LinkedList<>();
    queue.add(vertex);

    while(!queue.isEmpty()) {
      vertex = queue.remove();
      if(!visited.contains(vertex)) {
        visited.add(vertex);
        for(Character neighbor : adjList.get(vertex)) {
          int newDistance = distance.get(vertex) + 1;
          int oldDistance = distance.get(neighbor);
          if(!visited.contains(neighbor)) {
            if(oldDistance == 0 || newDistance < oldDistance) {
              distance.put(neighbor, newDistance);
              path.put(neighbor, path.get(vertex) + " -> " + neighbor);
              queue.add(neighbor);
            }
          }
        }
      }
    }

    for(Character vrtx : adjList.keySet()) {
      System.out.println(path.get(vrtx) + " : " + distance.get(vrtx));
    }
    System.out.println("----------------------------");
  }


  class Node {
    Character label;
    int weight;

    Node(Character label, int weight) {
      this.label = label;
      this.weight = weight;
    }
  }

  class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
      return o1.weight < o2.weight ? -1 : 1;
    }
  }
  private void weightedShortestPathUtil() {
    Map<Character, List<Node>> adjList = new HashMap<>();
    adjList.put('A', Arrays.asList(new Node('B', 1), new Node('C', 2)));
    adjList.put('B', Arrays.asList(new Node('A', 1), new Node('D', 3)));
    adjList.put('C', Arrays.asList(new Node('A', 2), new Node('D', 1)));
    adjList.put('D', Arrays.asList(new Node('C', 1), new Node('B', 3)));
    weightedShortestPath(adjList, new Node('A', 0));


    adjList = new HashMap<>();
    adjList.put('A', Arrays.asList(new Node('D', 1), new Node('B', 1), new Node('C', 2)));
    adjList.put('B', Arrays.asList(new Node('A', 1), new Node('D', 3)));
    adjList.put('C', Arrays.asList(new Node('A', 2), new Node('D', 1)));
    adjList.put('D', Arrays.asList(new Node('C', 1), new Node('B', 3)));
    weightedShortestPath(adjList, new Node('A', 0));


    adjList = new HashMap<>();
    adjList.put('A', Arrays.asList(new Node('B', 2), new Node('C', 3)));
    adjList.put('B', Arrays.asList(new Node('A', 2), new Node('D', 0)));
    adjList.put('C', Arrays.asList(new Node('A', 2), new Node('D', -2)));
    adjList.put('D', Arrays.asList(new Node('C', -2), new Node('B', 0)));
    weightedShortestPath(adjList, new Node('A', 0));
    System.out.println("Algorithm failing for negative weights");
  }

  /**
   * Dijkstra's algorithm (ElogV)
   */
  private void weightedShortestPath(Map<Character, List<Node>> adjList, Node vertex) {
    Set<Character> visited = new HashSet<>();
    Map<Character, Integer> distance = new HashMap<>();
    Map<Character, String> path = new HashMap<>();

    for(Character label : adjList.keySet()) {
      distance.put(label, Integer.MAX_VALUE);
    }
    distance.put(vertex.label, 0);
    path.put(vertex.label, vertex.label + "");

    PriorityQueue<Node> heap = new PriorityQueue<>(new NodeComparator());
    heap.add(vertex);

    while(!heap.isEmpty()) {
      vertex = heap.remove();
      if(!visited.contains(vertex.label)) {
        visited.add(vertex.label);
        for(Node neighbor : adjList.get(vertex.label)) {
          if(!visited.contains(neighbor.label)) {
            int oldDistance = distance.get(neighbor.label);
            int newDistance = distance.get(vertex.label) + neighbor.weight;
            if(oldDistance == Integer.MAX_VALUE || newDistance < oldDistance) {
              distance.put(neighbor.label, newDistance);
              path.put(neighbor.label, path.get(vertex.label) + " -> " + neighbor.label);
              heap.add(neighbor);
            }
          }
        }
      }
    }

    for(Character label : adjList.keySet()) {
      System.out.println(distance.get(label) + " : " + path.get(label));
    }
    System.out.println("----------------------------");
  }

  private void negativeWeightedShortestPathUtil() {
    Map<Character, List<Node>> adjList = new HashMap<>();
    adjList.put('A', Arrays.asList(new Node('B', 1), new Node('C', 2)));
    adjList.put('B', Arrays.asList(new Node('A', 1), new Node('D', 3)));
    adjList.put('C', Arrays.asList(new Node('A', 2), new Node('D', 1)));
    adjList.put('D', Arrays.asList(new Node('C', 1), new Node('B', 3)));
    negativeWeightedShortestPath(adjList, new Node('A', 0));

    adjList = new HashMap<>();
    adjList.put('A', Arrays.asList(new Node('B', 2), new Node('C', 3)));
    adjList.put('B', Arrays.asList(new Node('A', 2), new Node('D', 0)));
    adjList.put('C', Arrays.asList(new Node('A', 3), new Node('D', -2)));
    adjList.put('D', Arrays.asList(new Node('C', -2), new Node('B', 0)));
    negativeWeightedShortestPath(adjList, new Node('A', 0));
  }

  /**
   * Bellman Ford (EV)
   */
  private void negativeWeightedShortestPath(Map<Character, List<Node>> adjList, Node vertex) {
    Set<Character> visited = new HashSet<>();
    Map<Character, Integer> distance = new HashMap<>();
    Map<Character, String> path = new HashMap<>();

    for(Character label : adjList.keySet()) {
      distance.put(label, Integer.MAX_VALUE);
    }
    distance.put(vertex.label, 0);
    path.put(vertex.label, vertex.label + "");

    Queue<Node> queue = new LinkedList<>();
    queue.add(vertex);

    while(!queue.isEmpty()) {
      vertex = queue.remove();
      if(!visited.contains(vertex.label)) {
        visited.add(vertex.label);
        for(Node neighbor : adjList.get(vertex.label)) {
          if(!visited.contains(neighbor.label)) {
            int oldDistance = distance.get(neighbor.label);
            int newDistance = distance.get(vertex.label) + neighbor.weight;
            if(oldDistance == Integer.MAX_VALUE || newDistance < oldDistance) {
              distance.put(neighbor.label, newDistance);
              path.put(neighbor.label, path.get(vertex.label) + " -> " + neighbor.label);
              queue.add(neighbor);
            }
          }
        }
      }
    }

    for(Character label : adjList.keySet()) {
      System.out.println(distance.get(label) + " : " + path.get(label));
    }
    System.out.println("----------------------------");
  }
}

/**
 *
 * All the three algo are the same, just some minor differences. We will always calculate the distance/path of the
 * neighbors and not that of the current processing node.
 *
 * 1. Process only non visited nodes.
 * 2. For every node, calculate the distance / path of its neighbors if
 *      1. The neighbor is not visited.
 *      2. The new distance (calculated) is less than the old distance.
 *      3. Add the neighbor in the queue/heap.
 *
 * We do this same process for all the three algorithms. For Dijkstra's, we use min-heap instead of queue. For
 * non weighted, we use queue but the nodes do not have weights. For Bellman-Ford, we also queue but the nodes are 
 * weighted.
 *
 * For Prim's algo, do the same as that of Dijktra's but just start with the edge that has the lowest weight. We do not
 * need to manipulate output as well. Because, the way we are displaying output clearly signifies the edges that is
 * needed to create a minimal spanning tree.
 *
 * Shortest path non weighted : E+V
 * Dikjstra : ElogV
 * Bellman Ford : EV
 * Prim: Elogv
 *
 */
