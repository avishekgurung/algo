package array.problems;

import java.util.Arrays;

public class Problem026 {
  /**
   * To rotate an element k times, we need to perform same right rotation n-k times.
   * Or we can also use the reverse logic as shown below.
   */

  public static void rotateAntiClockWise(int arr[], int k) {
    System.out.println("Rotating " + k + " times");
    System.out.println(Arrays.toString(arr));
    int len = arr.length;

    k = k % len; //if k is very high value.
    reverse(arr, 0, len-1);
    reverse(arr, 0, len - k - 1);
    reverse(arr, k+1, len-1);
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
    rotateAntiClockWise(new int[]{1,2,3,4,5}, 2);
    rotateAntiClockWise(new int[]{1, 3, 5, 7, 9}, 3);
  }
}
