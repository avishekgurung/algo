package array.problems;

import java.util.Arrays;

/**
 * this is normal subarray problem which can be solved in a normal way.
 * Just take the example of below examples to fix the edge cases.
 */
public class Problem055 {

  public static void smallestSubArraySum(int arr[], int k) {
    System.out.println(Arrays.toString(arr));
    int sum = 0, start = 0, end = 0;
    int minStart = 0, minEnd = 0, minSubArraySize = Integer.MAX_VALUE;

    for(int i=0; i < arr.length; i++) {
      sum = sum + arr[i];
      if(sum > k) {
        end = i;
        while(sum > k) {
          sum = sum - arr[start];
          start++;
        }
        //The below two lines are performed to satisfy the condition where sum > k
        start--;
        sum = sum + arr[start];

        int subArraySize = end - start + 1;
        if(subArraySize < minSubArraySize) {
          minSubArraySize = subArraySize;
          minStart = start;
          minEnd = end;
        }
      }
    }

    System.out.print("K = " + k + ", min subarray size = "+ minSubArraySize+", Arrays = [ ");
    for(int i=minStart; i <= minEnd; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.print("]\n\n");
  }


  /***
   * Another simpler solution with similar logic
   */

  private static void smallestSubArrayWithGreaterSum(int arr[], int k) {
    int sum = 0;
    int start = 0;
    int minArrSize = arr.length + 1;
    int end = 0;
    int reqStart = 0;
    int reqEnd = 0;

    for(int i=0; i < arr.length; i++) {
      sum = sum + arr[i];
      if(sum > k) {
        while(sum - arr[start] > k) {
          sum = sum - arr[start];
          start++;
        }
        end = i;
        if(end - start < minArrSize) {
          minArrSize = end - start;
          reqStart = start;
          reqEnd = end;
        }
      }
    }

    System.out.println(Arrays.toString(arr));
    for(int i=reqStart; i <= reqEnd; i++) {
      System.out.print(arr[i]+ " ");
    }
  }

  public static void main(String[] args) {
    smallestSubArraySum(new int[]{1,1,1,1,1,1}, 5);
    smallestSubArraySum(new int[]{1,1,1,1,1,2}, 5);
    smallestSubArraySum(new int[]{1,1,1,1,1,2,2}, 5);
    smallestSubArraySum(new int[]{1,1,1,1,1,2,2,4}, 5);
    smallestSubArraySum(new int[]{1,1,1,1,1,2,6}, 5);
    smallestSubArraySum(new int[]{1, 4, 45, 6, 0, 19}, 51);
    smallestSubArraySum(new int[]{1, 10, 5, 2, 7}, 9);
  }

}
