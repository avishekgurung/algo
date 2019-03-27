package array.problems;

import java.util.Arrays;

/**
 *
 * For any given pair-sum array for a given array say arr,
 *  arr[0] = (pair_sum[0] + pair_sum[1] - pair_sum[n-1])/2;
 *
 *  How?
 *  Lets consider an arr = [a,b,c,d]
 *  pair_sum = [a+b, a+c, a+d, b+c, b+d, c+d]
 *
 *  (pair_sum[0] + pair_sum[1] - pair_sum[n-1])/2 = ((a+b)+(a+c)-(b+c))/2
 *   = (a + b + a + c - b - c) / 2
 *   = 2a/2
 *   = a
 *
 *  here n is the size of array and not the size of pair_sum, which is expected to be
 *  provided.
 *
 *
 */
public class Problem074 {

  public static void constructArrayFromPairSum(int pair[], int n) {
    System.out.println(Arrays.toString(pair));
    int arr[] = new int[n];
    arr[0] = (pair[0] + pair[1] - pair[n-1])/2;
    for(int i=1; i < n; i++) {
      arr[i] = pair[i] - arr[0];
    }
    System.out.println(Arrays.toString(arr) + "\n");
  }

  public static void main(String[] args) {
    constructArrayFromPairSum(new int[]{14, 9, 10, 11, 12, 7}, 4);
  }
}
