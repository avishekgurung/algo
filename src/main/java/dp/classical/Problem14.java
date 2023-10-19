package dp.classical;

import java.util.Arrays;
import java.util.HashMap;

public class Problem14 {

  public static int maxCut(int n) {
    if(n == 0 || n == 1)return 0;

    int maxVal = 0;

    for(int i=1; i < n; i++) {
      int val = Math.max(i * (n-i), maxCut(n - i) * i);
      maxVal = Math.max(maxVal, val);
    }

    return maxVal;
  }


  /**
   * This is again similar to any other DP problem. Just that we need to tweak it a bit to solve it.
   * A rope of length n is given. I have to cut them in any number of parts so that their product is maximum.
   * But when we cut the rope then sum of the smaller ropes should always be equal to the initial length of the rope
   * and the rope has to be cut atleast once.
   *
   * So we will create an array and store it with 1 to n-1 values. This will represent the denominations in which a
   * rope can be cut. Now we will use each element of an array to check that their sum equals to N. This is necessary
   * because we want to use every dimensions that sums up to N. Once we identify a subset that equals N, we try to find
   * the largest product.
   *
   * It is very similar to usual subset problems.
   */
  private int recur(int index, int sum, int product, int target, int arr[]) {
    if(sum == target) return product;
    if(sum > target) return Integer.MIN_VALUE + 12345;

    int result = Integer.MIN_VALUE + 12345;

    for(int i=index; i < arr.length; i++) {
      result = Math.max(result, recur(i, sum + arr[i], product * arr[i], target, arr));
    }
    exCountRecur++;
    return result;
  }

  static int exCountRecur = 0;
  static int exCountDp = 0;

  /**
   * We had the DP solution running too :)
   */
  private int recurDp(int index, int sum, int product, int target, int arr[], HashMap<String, Integer> dp) {
    if(sum == target) return product;
    if(sum > target) return Integer.MIN_VALUE + 12345;
    String key = index+":"+sum+":"+product;
    if(dp.containsKey(key)) return dp.get(key);

    int result = Integer.MIN_VALUE + 12345;

    for(int i=index; i < arr.length; i++) {
      result = Math.max(result, recurDp(i, sum + arr[i], product * arr[i], target, arr, dp));
    }

    exCountDp++;
    dp.put(key, result);
    return result;
  }


  private void util(int n) {
    int arr[] = new int[n-1];
    for(int i=0; i < arr.length; i++) {
      arr[i] = i + 1;
    }

    exCountRecur = 0;
    exCountDp = 0;

    System.out.println("Rope length: " +n);
    System.out.println("Rope cuts: " + Arrays.toString(arr));
    System.out.println("Max rope cut: " + recur(0, 0, 1, n, arr));
    System.out.println("Max rope cut (DP): " + recurDp(0, 0, 1, n, arr, new HashMap<>()));
    System.out.println("Execution count in Recur: " + exCountRecur);
    System.out.println("Execution count in DP: " + exCountDp);
    System.out.println("\n");

  }

  public static void main(String[] args) {
    Problem14 object = new Problem14();
    int n;

    n=3;
    object.util(n);

    n=4;
    object.util(n);

    n=5;
    object.util(n);

    n=10;
    object.util(n);

    n=30;
    object.util(n);

    //int res = maxCut(10);
    //System.out.println(res);
  }
}
