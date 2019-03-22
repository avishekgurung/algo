package array.problems;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * This is not a NGE (Next Greater Element) problem although it looks like one. We will calculate
 * the maximum sum by considering the smallest element found so far. We will take the difference
 * between the current element and the smallest element found so far.
 *
 * Have a look at maxDiffSimple first to understand the logic then we can go ahead with the
 * maxDiff which also calculates the indices.
 *
 * It gets little trickier when we want to find indices but its solvable.
 */

public class Problem041 {

  public static void maxDiffSimple(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int minElementFoundSoFar = arr[0];
    int maxDiff = 0;

    for(int i=1; i < arr.length; i++) {
      maxDiff = Math.max(maxDiff, arr[i] - minElementFoundSoFar);
      minElementFoundSoFar = Math.min(minElementFoundSoFar, arr[i]);
    }

    System.out.println("Max diff is " + maxDiff + "\n");
  }

  public static void maxDiff(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int minElementFoundSoFar = arr[0];
    int maxSum = 0;
    int start = 0;
    int end = 0;
    int maxStart = 0;


    for(int i=1; i < arr.length; i++) {
      int diff = arr[i] - minElementFoundSoFar;
      if(diff > maxSum) {
        maxSum = diff;
        end = i;
        maxStart = start;
      }

      if(minElementFoundSoFar > arr[i]) {
        minElementFoundSoFar = arr[i];
        start = i;
      }
    }
    System.out.println("Max diff is " + maxSum + " ("+arr[maxStart]+" and "+ arr[end]+")\n");
  }


  public static void main(String[] args) {
    maxDiffSimple(new int[]{7,9,8,12,20});
    maxDiffSimple(new int[]{2,3,10,6,4,8,1});
    maxDiffSimple(new int[]{7,9,5,6,3,2});

    System.out.println("----------------");

    maxDiff(new int[]{7,9,8,12,20});
    maxDiff(new int[]{2,3,10,6,4,8,1});
    maxDiff(new int[]{7,9,5,6,3,2});
  }

}
