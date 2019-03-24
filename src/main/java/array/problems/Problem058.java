package array.problems;

import java.util.Arrays;

public class Problem058 {

  /**
   * It follows the simple pattern explained below in the program.
   */
  public static void smallestPositiveInteger(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int spi = 1; //smallest positive integer
    for(int i=0; i < arr.length && spi >= arr[i]; i++) {
      spi = spi + arr[i];
    }
    System.out.println("Smallest positive integer is " + spi + "\n");
  }

  public static void main(String[] args) {
    smallestPositiveInteger(new int[]{1, 3, 6, 10, 11, 15});
    smallestPositiveInteger(new int[]{1, 1, 1, 1});
    smallestPositiveInteger(new int[]{1, 1, 3, 4});
    smallestPositiveInteger(new int[]{1, 2, 5, 10, 20, 40});
    smallestPositiveInteger(new int[]{1, 2, 3, 4, 5, 6});
  }

}
