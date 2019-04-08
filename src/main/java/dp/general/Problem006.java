package dp.general;

import java.util.Arrays;

public class Problem006 {

  /**
   * The logic is simple. If we sort the array, we can fix this problem in O(n2).
   * We can use dp table for optimization as shown below.
   *
   * The worse case would be when all the numbers are prime, where the time complexity will be O(n2)
   */
  public static void largestDivisibleSubset(int arr[]) {
    Arrays.sort(arr);

    int dp[] = new int[arr.length];

    for(int i=1; i < arr.length; i++) {
      int item = arr[i];
      for(int j = i-1; j >=0; j--) {
        if(item % arr[j] == 0) {
          dp[i] = dp[j] + 1;
          break;
        }
      }
    }

    //manipulating result of dp table
    int index = 0;
    int largest = Integer.MIN_VALUE;
    for(int i = arr.length - 1; i >= 0; i--) {
      if(dp[i] > largest) {
        largest = dp[i];
        index = i;
      }
    }

    System.out.println("The size of the subset is " + (largest + 1) +" and the subset is ");

    int largestItem = arr[index];
    while(index >= 0) {
      if(largestItem % arr[index] == 0) {
        System.out.print(arr[index] + " ");
        largestItem = arr[index];
      }
      index--;
    }

    System.out.println("\n");
  }

  public static void main(String[] args) {
    largestDivisibleSubset(new int[]{10, 5, 3, 15, 20});
    largestDivisibleSubset(new int[]{18, 1, 3, 6, 13, 17});
  }
}
