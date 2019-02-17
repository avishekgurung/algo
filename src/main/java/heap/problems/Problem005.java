package heap.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

public class Problem005 {

  public static int findKthSmallestElement(int arr[], int k) {
    PriorityQueue<Integer> heap =
        new PriorityQueue<Integer>(arr.length, Collections.reverseOrder());
    for (int i = 0; i < k; i++) {
      heap.add(arr[i]);
    }

    for (int i = k; i < arr.length; i++) {
      if (arr[i] < heap.peek()) {
        heap.remove();
        heap.add(arr[i]);
      }
    }

    return heap.remove();
  }

  public static void main(String args[]) {
    int arr[] = new int[] {4, 2, 7, 1, 5, 3, 6};
    System.out.println(Arrays.toString(arr));
    int k = 3;
    System.out.println(k + " smallest: " + findKthSmallestElement(arr, k));
    k = 6;
    System.out.println(k + " smallest: " + findKthSmallestElement(arr, k));
  }

}

/**
 *
 * There is reason for using heap in this problem.
 * The most standard way to solve this problem would be to sort the array and find
 * the kth smallest number. This would take O(nlogn).
 *
 * If there are possibilities to use other sort algo like Bucket Sort etc then, we
 * can bring our complexity to O(n).
 *
 * But in general, if we use heap, we can reduce the time complexity.
 *
 * We take first k elements and put it in a max heap. The heap creation takes O(k).
 * The top element of the heap is the maximum.
 *
 * We iterate remaining elements. If the element is smaller than the top element then
 * we remove the top and insert the smaller element.
 * Removing the top element is constant. Now in the array inside heap, we have to put
 * the new element and heapify(percolateDown) it. Now this cannot be done in
 * pre-defined heap as above, we have to create our own heap.
 * Time Complexity = n + (n-k) * log(k) = nlogk
 *
 * Normal heap removal process involves removing the 0th element, replacing this
 * 0th element by last element and percolate down. So it takes O(logn). Here, we want
 * to skip the second step of percolate down but want to percolate down the new element.
 *
 */
