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
   * We can optimize this by using any other sorting. As using heap will require us to use extra
   * space.
   * Here we ll divide array of size n into k+1 halves and sort these k+1 halves.
   * The total look will run for n/k. For each iteration, we sort, which takes klogk.
   * So n/k * klogk = nlogk and constant space.
   *
   */

}
