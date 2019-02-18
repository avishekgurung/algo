package heap.problems;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * The first solution that might come to our mind is, I will maintain a sorted
 * array. Whenever new integer comes, I will insert that element in a sorted
 * array. Lets check the time complexity. For every new element, we are sorting
 * the array. Since the array is already sorted so if we use insertion sort
 * then the time complexity will be O(n). So for the next n elements in the
 * stream we will have O(n2).
 *
 * We will use two heap. All the elements from the mid to left will be stored
 * in max heap and all the elements from mid to right will be stored in min
 * heap. The top of these max and min heap will be an adjacent middle elements
 * which will be used to calculate median. Inserting into heap is only logn.
 * So for next n elements that comes from streams, it will be O(nlogn).
 *
 * Try with heap diagram to understand better.
 *
 */
public class Problem015 {

  private static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>
      (11, Collections.reverseOrder());
  private static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>
      (11);
  private static float median = 0;



  public static void calculateMedian(int element) {

    int leftElementsSize = maxHeap.size();
    int rightElementsSize = minHeap.size();

    if(leftElementsSize == rightElementsSize) {

      if(element < median) {
        maxHeap.add(element);
        median = maxHeap.peek();
      }
      else {
        minHeap.add(element);
        median = minHeap.peek();
      }
    }

    else if(leftElementsSize > rightElementsSize) {

      if(element < median) {
        int maxHeapRoot = maxHeap.remove();
        minHeap.add(maxHeapRoot);
        maxHeap.add(element);
      }
      else {
        minHeap.add(element);
      }
      median = (minHeap.peek() + maxHeap.peek()) / 2;
    }

    else {
      if(element < median) {
        maxHeap.add(element);
      }
      else {
        int minHeapRoot = minHeap.remove();
        maxHeap.add(minHeapRoot);
        minHeap.add(element);
      }
      median = (float)(minHeap.peek() + maxHeap.peek()) / 2;
    }
  }

  public static void main(String[] args) throws Exception{

    int arr[] = new int[]{8,3,1,5,9,6,4,2,7};

    for(int i=0; i < arr.length; i++) {
      calculateMedian(arr[i]);
      System.out.println("Adding: " + arr[i]);
      System.out.println("Median: " + median);
      System.out.println("--------");
      Thread.sleep(2000);
    }

  }

}
