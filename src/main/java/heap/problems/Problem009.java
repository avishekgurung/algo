package heap.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem009 {

  public static int getMinCost(int ropes[]) {
    int cost = 0;
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    for(int i=0; i < ropes.length; i++) {
      minHeap.add(ropes[i]);
    }

    while(!minHeap.isEmpty()) {
      int x = minHeap.remove();
      if(minHeap.isEmpty()) break;
      int y = minHeap.remove();
      cost = cost + x + y;
      minHeap.add(x + y);
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
