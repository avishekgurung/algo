package array.problems;

import java.util.Arrays;

public class Problem020 {
  /**
   * The solution can be achieved using different methods but in order to find the solution in
   * O(n) time and constant space we use bitwise xor.
   * Understand bitwise operations and programming first.
   */

  public static int getOddElement(int arr[]) {
    int element = arr[0];
    for(int i=1; i < arr.length; i++) {
      element = element ^ arr[i];
    }
    return element;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,2,3,2,3,1,3};
    System.out.println(Arrays.toString(arr));
    System.out.println(getOddElement(arr));
  }
}
