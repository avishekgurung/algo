package heap.problems;

import java.util.Arrays;
import java.util.Collections;

public class Problem013 {

  /**
   * This does not work.
   * @param a
   * @param b
   * @param k
   */
  private static void kMaxSumCombinations(Integer a[], Integer b[], Integer k) {
    System.out.println(Arrays.toString(a));
    System.out.println(Arrays.toString(b));
    Arrays.sort(a, Collections.<Integer>reverseOrder());
    Arrays.sort(b, Collections.<Integer>reverseOrder());

    Integer i = 0, j = 0;

    while(k != 0) {
      System.out.println(a[i] + " + " + b[j] + " = " + (a[i] + b[j]));
      if(i + 1 >= a.length || j + 1 >= a.length) break;
      Integer sum1 = a[i] + b[j+1];
      Integer sum2 = a[i+1] + b[j];
      if(sum1 > sum2)j++;
      else i++;
      k--;
    }
    System.out.println();
  }


  public static void main(String[] args) {
    Integer a[] = new Integer[]{3,2};
    Integer b[] = new Integer[]{1,4};
    Integer k = 2;
    kMaxSumCombinations(a,b,k);

    k = 10;
    kMaxSumCombinations(a,b,k);

    a = new Integer[]{1,4,5,2};
    b = new Integer[]{3,0,9,7};
    k = 2;
    kMaxSumCombinations(a,b,k);

    a = new Integer[]{1,4,5,2};
    b = new Integer[]{3,0,9,7};
    k = 3;
    kMaxSumCombinations(a,b,k);

  }

}

/**
 * The solution should be using a node
 *
 * Node {
 *   int sum;
 *   int i;
 *   int j;
 * }
 *
 * Find the sum a[i]+b[j], create a node and store in the max heap.
 *
 *
 */
