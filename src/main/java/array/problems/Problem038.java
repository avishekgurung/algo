package array.problems;

import java.util.Arrays;

public class Problem038 {

  /**
   * Sort the array and swap the element and its next element. Thats all.
   *
   *  This is a array wave form problem which can be solved in O(n)
   *
   *
   * @param arr
   */
  public static void rearrangeOddAndEven(int arr[]) {
    System.out.println(Arrays.toString(arr));
    Arrays.sort(arr);
    for(int i=0; i < arr.length-1; i+=2) {
      int temp = arr[i];
      arr[i] = arr[i+1];
      arr[i+1] = temp;
    }
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  public static void main(String[] args) {
    rearrangeOddAndEven(new int[]{1,2,3,4,5,6,7});
  }

}
