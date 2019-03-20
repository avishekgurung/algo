package array.problems;

import java.util.Arrays;

public class Problem053 {

  public static void maxSumWithNoElementAdjacent(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int prevMaxSum = arr[0];
    int currMaxSum = 0;
    int maxSum = 0;

    for (int i = 1; i < arr.length; i++) {
      currMaxSum += arr[i];
      maxSum = Math.max(prevMaxSum, currMaxSum);
      currMaxSum = prevMaxSum;
      prevMaxSum = maxSum;
    }
    System.out.println("Max sum: " + maxSum + "\n");
  }

  public static void main(String[] args) {
    maxSumWithNoElementAdjacent(new int[]{1, 2, 3, 4, 5});
    maxSumWithNoElementAdjacent(new int[]{5, 5, 10, 100, 10, 5});
    maxSumWithNoElementAdjacent(new int[]{1, 2, 3});
    maxSumWithNoElementAdjacent(new int[]{1, 20, 3});
    maxSumWithNoElementAdjacent(new int[]{8,6,30,5,10,100});
  }

}
