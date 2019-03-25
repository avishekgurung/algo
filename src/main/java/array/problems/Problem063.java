package array.problems;

import java.util.Arrays;

/**
 * We will use a Divide and Conquer method to solve this.
 * Let the arr be as [a1,a2,a3,a4,b1,b2,b3,b4]. We will divide the array into half and swap the
 * elements around its center.
 *
 * a1,a2,a3,a4|b1,b2,b3,b4
 * a1,a2,b1,b2|a3,a4,b3,b4
 *
 * Now we will again divide the left and right array
 *
 * a1,a2|b1,b2 => a1,b1,a2,b2
 * a3,a4|b3,b4 => a3,b3,a4,b4
 *
 * The complexity of this algorithm is nlogn. And it works only when array is of size 2n and
 * n = 2^i.
 *
 */
public class Problem063 {

  public static void alternateSwap(int[] arr, int left, int right) {
    if(right - left + 1 == 2) return; //If there are only two elements we will not proceed.

    int mid = (left + right) / 2;
    int y = mid + 1;

    int preMid = (left + mid)/2;
    int x = preMid + 1;

    //lets swap the elements around the center. Trace this carefully with pen/paper to get proper
    //conditions
    while(x <= mid) {
      int temp = arr[x];
      arr[x] = arr[y];
      arr[y] = temp;
      x++;
      y++;
    }

    alternateSwap(arr, left, mid);
    alternateSwap(arr, mid+1, right);
  }

  public static void util(int arr[]) {
    System.out.println(Arrays.toString(arr));
    alternateSwap(arr, 0, arr.length - 1);
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  public static void main(String[] args) {
    util(new int[]{1,2,3,4,5,6,7,8});
  }

}
