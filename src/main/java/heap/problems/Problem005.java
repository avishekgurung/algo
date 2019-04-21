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
 * We take first k elements and put it in a max heap. The top element of the heap is
 * the maximum. For every insertion takes logk, so inserting k elements takes klogk.
 *
 * We iterate remaining elements. If the element is smaller than the top element then
 * we remove the top and insert the smaller element.
 * So the loop runs for (n-k) elements. And for every iteration, we remove the element and
 * insert the element. So (n-k) * (logn + logn) = n-k * logk
 *
 * Time Complexity = klogk + (n-k) * log(k) = nlogk (worst case if elements are in
 * descending order).
 *
 * We can make this little faster in processing by using our custom heap where we can skip one
 * heapifying process. So if the element is smaller than the top element, we will replace arr[0]=
 * element and heapify. Normal process would involve, remove arr[0] and heapify. Add element. So
 * we can skip this process of add element which takes us logn.
 *
 */
