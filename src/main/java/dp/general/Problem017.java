package dp.general;

/**
 * We have to first sort the pairs based on their low element.
 * Then we use Longest Increasing Subsequence concept where we compare the high of prev elements
 * with low of the current element.
 */
public class Problem017 {

  private static class Pair {
    int low;
    int high;

    Pair(int low, int high) {
      this.low = low;
      this.high = high;
    }
  }

  public static void longestChain(Pair[] pairs) {
    int n = pairs.length;
    int dp[] = new int[n];
    for (int i = 0; i < n; i++) dp[i] = 1;

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        Pair jthPair = pairs[j];
        Pair ithPair = pairs[i];

        if (jthPair.high < ithPair.low) {
          dp[i] = Math.max(dp[j] + 1, dp[i]);
        }
      }
    }

    int largestIndex = 0;
    for (int i = 0; i < n; i++) {
      largestIndex = dp[largestIndex] < dp[i] ? i : largestIndex;
    }

    System.out.println("The longest chain is of size " + dp[largestIndex]);

    //Find the pair in the longest chains.
    Pair pair = pairs[largestIndex];
    int i = largestIndex;
    System.out.println(pair.low + ", " + pair.high);
    while (i >= 0) {
      if(pair.low > pairs[i].high) {
        pair = pairs[i];
        System.out.println(pair.low + ", " + pair.high);
      }
      i--;
    }


  }

  public static void main(String[] args) {
    longestChain(new Pair[]{
        new Pair(5,24),
        new Pair(39,60),
        new Pair(15,28),
        new Pair(27,40),
        new Pair(50,90),
    });
  }

}
