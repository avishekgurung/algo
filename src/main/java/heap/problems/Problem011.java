package heap.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Problem011 {

  public static int getKthSmallest(int arr[], int start, int end, int k) {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k,
        Collections.reverseOrder());
    for(int i=start; i < start + k; i++) {
      maxHeap.add(arr[i]);
    }

    for(int i=start+k; i <= end; i++) {

      if(arr[i] < maxHeap.peek()) {
        maxHeap.remove();
        maxHeap.add(arr[i]);
      }
    }
    return maxHeap.remove();
  }

  public static void main(String[] args) {

    int arr[] = {3, 2, 5, 1, 8, 9};
    System.out.println(Arrays.toString(arr));

    int start = 1, end = 4, k = 2;
    System.out.println(getKthSmallest(arr,start ,end ,k ));

    start = 0; end = 5; k = 4;
    System.out.println(getKthSmallest(arr,start ,end ,k ));
  }

}
/**
 *
 * These kind of problems can always be done by using sorting and it would
 * take O(nlogn). But we have to find a way to do it little better than this time.
 *
 * Time Complexities:
 *
 * First loop runs for k times and for every step we insert an element in a heap.
 * The time complexity is O(klogk).
 *
 * The second loop runs for n-k times. In every step it checks the root of max
 * heap. If all the elements are smaller than root then its a worst case. In this
 * case we have to remove the root and add the element. Removing a root from heap
 * involves removing the 0th element of an array(inside heap) and then replacing
 * arr[0] by last element and percolating down. Once it is removed, we add a new
 * element where we again have to place the element in a proper position.
 *
 * So inorder to avoid all these steps, for better complexity, we can use our
 * own custom heap. The process of removal and insertion can be done at one go.
 * We replace the top element arr[0] by the element to be inserted. Then we will
 * heapify or percolate down. So this step will take logk. So the second loop
 * will take (n-k)logk
 *
 * Total Complexity = klogk + (n-k)logk
 *                  = (k + n - k)logk
 *                  = nlogk
 *
 *
 */
