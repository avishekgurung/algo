package array.problems;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * My approach.
 * Given an array = [3,4,1,5,2]
 * Create another sorted array for this which is 1,2,3,4,5.
 * So we have two arrays now
 *  [3,4,1,5,2]
 *  [1,2,3,4,5]
 *
 *  Compare each element at ith index,
 *  if they are same then do nothing,
 *  else swap them,
 *  Eg, at i=0, 3 != 1, so we swap 3 with 1 in 1st array.
 *  [1,4,3,5,2]
 *  [1,2,3,4,5]
 *
 *  Now the the second index, i=1. 4 != 2 so we swap 4 with 2.
 *  [1,2,3,5,4]
 *  [1,2,3,4,5]
 *  at i = 2, 3 == 3 so no need to swap.
 *
 *  at i= 3, again swap, which gives us
 *  [1,2,3,4,5] which is sorted as well.
 *
 * Time complexity = O(logn) for sorting the array and space  = O(n)
 *
 * This might not solve all the edge cases.
 */
public class Problem069 {

  public static void minimumNumberOfSwapsToSortArray(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int[] sorted = arr.clone();
    Arrays.sort(sorted);
    int minSwap = 0;

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i=0; i < arr.length; i++) map.put(arr[i], i);

    for(int i=0; i < arr.length; i++) {
      if(arr[i] == sorted[i]) continue;
      swap(arr, i, map.get(sorted[i]));
      minSwap++;
    }

    System.out.println("The minimum swap required is " + minSwap + "\n");
  }

  private static void swap(int arr[], int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    minimumNumberOfSwapsToSortArray(new int[]{1,2,3,4,5});
    minimumNumberOfSwapsToSortArray(new int[]{4, 3, 2, 1});
    minimumNumberOfSwapsToSortArray(new int[]{1, 5, 4, 3, 2});
    minimumNumberOfSwapsToSortArray(new int[]{6, 5, 2, 7, 4, 1, 3});
  }

}


