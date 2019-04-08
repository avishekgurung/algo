package dp.general;

import java.util.Arrays;

public class Problem012 {

  public static void maxProductIncSubSeq(int arr[]) {
    int n = arr.length;
    int dp[] = new int[n];
    for(int i=0; i < n; i++) dp[i] = 1;
    dp[0] = arr[0];

    for(int i=1; i < n; i++) {
      for(int j=0; j < i; j++) {
        if(arr[j] < arr[i]) {
          dp[i] = Math.max(dp[j] * arr[i], dp[i]);
        }
      }
    }

    int largest = 0;
    for(int i=0; i < n; i++) largest = Math.max(largest, dp[i]);
    System.out.println(Arrays.toString(arr));
    System.out.println(largest);
    System.out.println();
  }

  public static void main(String[] args) {
    maxProductIncSubSeq(new int[]{3, 100, 4, 5, 150, 6});
    maxProductIncSubSeq(new int[]{10, 22, 9, 33, 21, 50, 41, 60});
  }

}
