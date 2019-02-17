package heap.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem012 {

  public static void smallestDerangement(int k) {
    int output[] = new int[k];
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);

    for(int i=0; i < k; i++) {
      minHeap.add(i);
    }

    for(int i=0; i < k; i++) {
      int root = minHeap.remove();

      if(root != i) {
        output[i] = root;
      }
      else {
        int temp;
        if(minHeap.isEmpty()) { //condition when the last element to be filled
          //and the top of heap is the same. We swap with the prev element
          temp = output[i-1];
          output[i-1] = root;
          output[i] = temp;
          break;
        }
        temp = minHeap.remove();
        minHeap.add(root);
        output[i] = temp;
      }
    }

    System.out.println(Arrays.toString(output));
    Arrays.sort(output);
    System.out.println(Arrays.toString(output));
    System.out.println();
  }

  public static void main(String[] args) {
    int k = 2;
    smallestDerangement(k);

    k = 3;
    smallestDerangement(k);

    k = 4;
    smallestDerangement(k);

    k = 5;
    smallestDerangement(k);

    k = 6;
    smallestDerangement(k);

    k = 7;
    smallestDerangement(k);
  }
  /**
   * Try similar problem for largest derangement.
   */
}

