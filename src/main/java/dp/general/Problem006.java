package dp.general;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem006 {

  /**
   * First solve the problem by recursion and then add memoization.
   * Also the recursion complexity is 2^N which is NP complete problem which do not have know polynomial time solution.
   * @param args
   */
  public static void main(String[] args) {
    largestDivisiblePairUtil(new int[]{10, 5, 3, 15, 20});

    largestDivisiblePairUtil(new int[]{18, 1, 3, 6, 13, 17});

    largestDivisiblePairUtil(new int[]{3,6,12});

    largestDivisiblePairUtil(new int[]{5,2,3});

  }

  private static void largestDivisiblePairUtil(int arr[]) {
    System.out.println(Arrays.toString(arr));
    Arrays.sort(arr);
    int result = largestDivisiblePair(arr, 0, 0, new HashMap<>());
    result = result + 1;
    /**
     *  One is appended in the result which will mark true for all cases because there can never be 0 answer.
     */
    System.out.println(result);
    System.out.println();
  }
  private static int largestDivisiblePair(int arr[], int index, int prev, Map<String, Integer> lookup) {
    if(index >= arr.length) return 0;
    if(lookup.containsKey(index+":"+prev)) return lookup.get(index+":"+prev);

    int result = 0;
    for(int i=index; i < arr.length; i++) {
      result = Math.max(result, largestDivisiblePair(arr, i+1, arr[index], lookup));
    }
    if(prev != 0 && arr[index] % prev == 0) result++;
    lookup.put(index+":"+prev, result);
    return result;
  }

}
