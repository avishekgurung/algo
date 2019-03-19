package array.problems;

import java.util.Arrays;

public class Problem016 {

  /**
   * Complexity = O(n*d)
   * @param arr
   * @param d
   */
  public static void rotate(int arr[], int d) {
    System.out.println(Arrays.toString(arr));
    while(d != 0) {
      int first = arr[0];
      for(int i=1; i < arr.length; i++) {
        arr[i-1] = arr[i];
      }
      arr[arr.length-1] = first;
      d--;
    }
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  /**
   * There is a reversal algorithm that can rotate the array in O(n).
   * Let n be the size of an array and d be the number of rotations.
   * We divide the array into two halves n-d and d. Let the arrays n-d be called A and d be called
   * B. Now we reverse A and then reverse B.
   * Finally, we reverse the whole array.
   * The resultant output is the rotated array.
   *
   */

  public static void rotateByReversal(int arr[], int d) {
    System.out.println(Arrays.toString(arr));
    System.out.println("d = " + d);
    int n = arr.length;
    reverse(arr, 0, d-1);
    reverse(arr, d, n-1);
    reverse(arr, 0, n-1);
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  public static void reverse(int arr[], int left, int right) {
    while(left <= right) {
      int temp = arr[left];
      arr[left] = arr[right];
      arr[right] = temp;
      left++;
      right--;
    }
  }


  public static void main(String[] args) {
    int arr[] = new int[]{1,2,3,4,5,6,7};
    rotate(arr, 2);

    arr = new int[]{1,2,3,4,5,6,7};
    rotate(arr, 4);

    arr = new int[]{1,2,3,4,5,6,7};
    rotate(arr, 7);

    arr = new int[]{1,2,3,4,5,6,7};
    rotateByReversal(arr, 2);

    arr = new int[]{1,2,3,4,5,6,7};
    rotateByReversal(arr, 4);

    arr = new int[]{1,2,3,4,5,6,7};
    rotateByReversal(arr, 7);
  }

}
