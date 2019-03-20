package array.problems;

import java.util.Arrays;

/**
 * Soln. We take two numbers at a time n1 and n2 and compare them as follows.
 * n1+n2 > n2+n1. Whichever is bigger is considered as a result.
 */
public class Problem043 {

  public static void findMaxNumberFromArray(int arr[]) {
    System.out.println(Arrays.toString(arr));
    String result = arr[0]+"";

    for(int i=1; i < arr.length; i++) {
      result = compare(result, arr[i]+"");
    }

    System.out.println("Max number is " + result + "\n");
  }

  public static String compare(String n1, String n2) {
    String result1 = n1 + n2;
    String result2 = n2 + n1;

    return Long.parseLong(result1) > Long.parseLong(result2) ?
        result1 : result2;
  }

  public static void main(String[] args) {
    findMaxNumberFromArray(new int[]{54, 546, 548, 60});
    findMaxNumberFromArray(new int[]{1, 34, 3, 98, 9, 76, 45, 4});
  }

}
