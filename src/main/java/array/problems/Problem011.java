package array.problems;

import java.util.Arrays;

/**
 *
 * Kadane's algo states that maximum sub-array at index i is either the element at index i or the
 * sum of maximum subarray till(i-1) + element at index i.
 *
 * If all the elements are positive then the max subarray is the sum of all the elements.
 */
public class Problem011 {

  public static int maxSubArray(int arr[]) {
    int maxSoFar = arr[0]; //gives us the max sum of a subarray.
    int maxTillHere = arr[0]; //gives us the max sum till index i.

    for(int i=1;i < arr.length-1; i++) {
     maxTillHere = Math.max(maxTillHere + arr[i], arr[i]);
     maxSoFar = Math.max(maxSoFar, maxTillHere);
    }
    return maxSoFar;
  }

  public static void maxSubArrayWithIndex(int arr[]) {
    int maxSoFar = arr[0];
    int maxTillHere = arr[0];
    int start = 0, end = 0;
    int maxStart = 0, maxEnd = 0;

    for(int i=1; i < arr.length; i++) {
      if(arr[i] > arr[i] + maxTillHere) {
        maxTillHere = arr[i];
        start = i;
        end = i;
      }
      else {
        maxTillHere = maxTillHere + arr[i];
        end = i;
      }

      if(maxTillHere > maxSoFar) {
        maxSoFar = maxTillHere;
        maxStart = start;
        maxEnd = end;
      }
    }

    System.out.println("The maximum sum of a subarray is " + maxSoFar + " from index " + maxStart +
        " "
        + "till " + maxEnd);
  }

  public static void util(int arr[]) {
    System.out.println(Arrays.toString(arr));
    System.out.println("Max sum of a subarray  is " + maxSubArray(arr));
    maxSubArrayWithIndex(arr);
    System.out.println("");
  }

  public static void main(String[] args) {
    util(new int[]{1,-3,2,1,-1});
    util(new int[]{-2,-3,4,-1,-2,1,5,-3});

  }

}
