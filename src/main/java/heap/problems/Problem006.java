package heap.problems;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem006 {

  public static void sort(int arr[], int k) {

    int count = 0;
    PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
    int aux[] = new int[arr.length];
    int j = 0;

    for (int i = 0; i < arr.length; i++) {
      if (count == k + 1) {
        count = 0;
        while (!heap.isEmpty()) {
          aux[j++] = heap.remove();
        }
      }

      heap.add(arr[i]);

      count++;
    }

    if (!heap.isEmpty()) {
      while (!heap.isEmpty()) {
        aux[j++] = heap.remove();
      }
    }

    System.out.println(Arrays.toString(aux));
  }

  public static void main(String[] args) {
    int arr[] = new int[] {6, 5, 3, 2, 8, 10, 9};
    int k = 3;
    sort(arr, k);
  }

  /**
   *
   * If we analyse this problem closely then we solve this in a complexity better
   * then O(nlogn).
   *
   * If we divide the array into k + 1 subarrays then all the elements even after
   * sorting will also lie in the same subarray.
   * Eg. 6, 5, 3, 2, 8, 10, 9 with k = 3.
   *    [6,5,3,2] and [8,10,9]
   *    Here the elements after sorting will also lie in the same sub-array
   *    [2,3,5,6] and [8,9,10].
   *
   * So we will sort subarray that will take klogk and merge the result.
   *
   *
   *Therefore, Sorting takes klogk.
   * Sorting does not happen in every step but happens only when the count is k.
   *
   * Every element is inserted in heap so nlogk.
   * Removing element from heap happens after every k elements, so removing from heap takes
   * place n/k times.
   *
   * Time Complexity = n * (logk + logk) = nlogk
   *
   * Space complexity = n
   *
   */

}
