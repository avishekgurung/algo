package heap.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem009 {

  public static int getMinCost(int ropes[]) {
    int cost = 0;
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    for(int i=0; i < ropes.length; i++) {
      heap.add(ropes[i]);
    }

    while(!heap.isEmpty()) {
      int x = heap.remove();
      if(heap.isEmpty()) break;
      int y = heap.remove();
      cost = cost + x + y;
      heap.add(x + y);
    }
    return cost;
  }

  public static void main(String[] args) {
    int ropes[] = new int[]{4,3,2,6};
    System.out.print(Arrays.toString(ropes));
    System.out.println("\tMin cost: " + getMinCost(ropes));

    ropes = new int[]{1,2,3,4,5};
    System.out.print(Arrays.toString(ropes));
    System.out.println("\tMin cost: " + getMinCost(ropes));
  }

}
