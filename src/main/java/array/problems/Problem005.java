package array.problems;

import java.util.Arrays;

public class Problem005 {
  /**
   * a. Take two pointers which will point to the end of the largest elements of two arrays.
   *    Take a pointer which will point to the last element of m+n array.
   *    Compare the elements and start adding at the end of the m+n array.
   *
   * b. Count from 1 to n and replace all the elements from 1 to n.
   *    OR Replace every element by its index + 1.
   *    This soln will not hold true if the elements are repeated.
   *
   */


  /**
   * Time: O(m+n)
   * Space: O(1)
   *
   */
  public static void merge(int arr[], int n, int brr[], int m) {

    int i = n-1;
    int j = m-1;
    int index = brr.length - 1;

    while ( i >= 0 && j >= 0) {
      if(arr[i] > brr[j]) {
        brr[index] = arr[i];
        i--;
      }
      else {
        brr[index] = brr[j];
        j--;
      }
      index--;
    }

    while(j >=0) {
      brr[index] = brr[j];
      j--;
      index--;
    }

    while(i >=0) {
      brr[index] = arr[i];
      i--;
      index--;
    }

    System.out.println(Arrays.toString(brr));

  }

  public static void main(String[] args) {
    merge(new int[]{1, 5, 10}, 3, new int[]{3, 4, 9, 20, 0, 0, 0}, 4);
  }

}
