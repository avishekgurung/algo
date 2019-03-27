package array.problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem064 {

  /**
   * find max subarray by using Kadane's algo and store them in a heap.
   *
   * Time = nlogn
   * Space = n
   *
   */
  public void kMaxSubArray(int arr[], int k) {
    PriorityQueue<Node> heap = new PriorityQueue<Node>(arr.length, new NodeComparator());

    int sumTillHere = arr[0];
    int maxSum = arr[0];
    int start = 0, end = 0;
    int maxStart = 0, maxEnd = 0;

    heap.add(new Node(maxSum, maxStart, maxEnd));

    for(int i=1; i < arr.length; i++) {

      sumTillHere = sumTillHere + arr[i];

      if(arr[i] > sumTillHere) {
        sumTillHere = arr[i];
        start = i;
        end = i;
      }
      else {
        end = i;
      }

      heap.add(new Node(sumTillHere, start, end));
    }

    while(k != 0) {
      Node node = heap.remove();
      System.out.println("Sum : " + node.sum + " from [" + node.leftIndex + "," + node.rightIndex
          + "]");
      k--;
    }
  }

  private class Node {
    int sum; int leftIndex; int rightIndex;
    Node(int sum, int leftIndex, int rightIndex) {
      this.sum = sum;
      this.leftIndex = leftIndex;
      this.rightIndex = rightIndex;
    }
  }

  private class NodeComparator implements Comparator<Node>{
    public int compare(Node o1, Node o2) {
      return o1.sum < o2.sum ? 1 : -1;
    }
  }

  /**
   * For k times, we perform Kadane's algo to find the max sub array.
   * Every time we find a max subarray, we print and then we replace the elements of these
   * subarray by minimum elements. Probably by Integer.MIN_VALUE but since int works in circle.
   * So when some element is subtracted from Integer.MIN_VALUE then it becomes a large positive
   * number. So we keep -23767.
   *
   * Hence we print max subarray for k times without using any heap.
   *
   * Time = nk
   * Space = O(1)
   *
   */
  public static void kMaxSubArrayForNonOverlappingSubArrays(int arr[], int k) {
    for(int j=0; j < k; j++) {

      int sumTillHere = arr[0];
      int maxSum = arr[0];
      int start = 0, end = 0;
      int maxStart = 0, maxEnd = 0;

      for(int i=1; i < arr.length; i++) {
        sumTillHere = sumTillHere + arr[i];
        if(arr[i] > sumTillHere) {
          sumTillHere = arr[i];
          start = i;
          end = i;
        }
        else {
          end = i;
        }
        if(maxSum < sumTillHere) {
          maxSum = sumTillHere;
          maxStart = start;
          maxEnd = end;
        }
      }

      System.out.println("The max sum is " + maxSum + " from [" + maxStart + "," + maxEnd + "]");
      for(int i=maxStart; i <= maxEnd; i++) {
        arr[i] = -32767;
      }
    }

  }

  public static void main(String[] args) {
    Problem064 instance = new Problem064();
    instance.kMaxSubArray(new int[]{4, -8, 9, -4, 1, -8, -1, 6}, 4);

    //kMaxSubArrayForNonOverlappingSubArrays(new int[]{4, 1, 1, -1, -3, -5, 6, 2, -6, -2}, 3);

  }

}
