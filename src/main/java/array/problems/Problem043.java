package array.problems;

import java.util.Arrays;
import java.util.Collections;

/**
 * Soln. We take two numbers at a time n1 and n2 and compare them as follows.
 * n1+n2 > n2+n1. Whichever is bigger is considered as a result.
 *
 * BUT first we need to sort and reverse the array so that we can start taking the largest numbers. Else, we will
 * not get correct answers.
 */
public class Problem043 {

  public static void findMaxNumberFromArray(Integer arr[]) {
    System.out.println(Arrays.toString(arr));
    Collections.sort(Arrays.asList(arr));
    Collections.reverse(Arrays.asList(arr));
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
    findMaxNumberFromArray(new Integer[]{54, 546, 548, 60});
    findMaxNumberFromArray(new Integer[]{1, 34, 3, 98, 9, 76, 45, 4});
  }

}
