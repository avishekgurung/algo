package array.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem077 {

  public static void maxSumArray(int arr[], int brr[]) {
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(brr));
    Set<Integer> set = new HashSet<Integer>();
    for(int ele : brr)set.add(ele); //add all elements to set

    for(int i=0; i < arr.length; i++) {
      if(set.contains(arr[i])) {
        arr[i] = -32767;
      }
    }

    kadaneAlgo(arr);
  }

  public static void kadaneAlgo(int arr[]) {
    int start = 0, end = 0;
    int maxSum = arr[0];
    int maxStart = 0;
    int maxEnd = 0;
    int currentSumTillHere = arr[0];

    for(int i=1; i < arr.length; i++) {
      if(arr[i] > currentSumTillHere + arr[i]) {
        currentSumTillHere = arr[i];
        start = i;
        end = i;
      }
      else {
        currentSumTillHere = currentSumTillHere + arr[i];
        end = i;
      }

      if(maxSum < currentSumTillHere) {
        maxSum = currentSumTillHere;
        maxStart = start;
        maxEnd = end;
      }
    }
    System.out.println("The max sum is " + maxSum + " from '" + maxStart + "' to '" + maxEnd+"' \n");
  }

  public static void main(String[] args) {
    maxSumArray(new int[]{1, 7, -10, 6, 2}, new int[]{5, 6, 7, 1});
    maxSumArray(new int[]{3, 4, 5, -4, 6}, new int[]{1, 8, 5});
  }

}
