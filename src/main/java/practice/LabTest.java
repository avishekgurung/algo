package practice;

import java.util.Arrays;

public class LabTest {

  static int maxGameByWinner(int N)
  {
    int[] dp = new int[N];

    // for 0 games, 1 player is needed
    // for 1 game, 2 players are required
    dp[0] = 1;
    dp[1] = 2;

    // loop until i-th Fibonacci number is
    // less than or equal to N
    int i = 2;
    do {
      dp[i] = dp[i - 1] + dp[i - 2];
    } while (dp[i++] <= N);

    // result is (i - 2) because i will be
    // incremented one extra in while loop
    // and we want the last value which is
    // smaller than N, so one more decrement
    return (i - 2);
  }

  public static int test(int n) {
    if(n == 0) return 1;
    if(n == 1) return 2;

    return test(n-1) + test(n-2);

  }

  // Driver code to test above methods
  public static void main(String args[])
  {
    int N = 6;
    System.out.println(maxGameByWinner(N));
    System.out.println(test(N));

  }

}
