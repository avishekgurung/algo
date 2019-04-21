package array.problems;

import java.util.Arrays;

public class Problem038 {

  /**
   * Sort the array and swap the element and its next element. Thats all.
   *
   *  The Efficient method:
   *  This is a array wave form problem which can be solved in O(n)
   *  The approach is simple. It expects elements in the following format:
   *      arr[i] must be less than arr[i-1] and arr[i+1].
   *  start with i=1
   *    check if arr[i] < arr[i-1] ? No => swap
   *    check if arr[i] < arr[i+1] ? No => swap
   *  The resulting array will be in the form of a wave where the element at odd position will
   *  always be smaller than its sides. It does not need sorting as well.
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
