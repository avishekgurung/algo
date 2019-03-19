package array.problems;

import java.util.Arrays;

public class Problem017 {
  /**
   * The logic is same as the one we use for finding the pair in rotated array. Here, we choose
   * the largest element which is pivot and the smallest element which is just after pivot.
   * If the sum is less then we reduce the pivot index else increase the smaller element index.
   * Just to note that once the index goes beyond 0, it has to travel again from the end.
   */

  public static void pairSum(int arr[], int S) {
    System.out.println(Arrays.toString(arr));
    int i = 0, j = 0;
    for(int k=0; k < arr.length-1; k++) {
      if(arr[k] > arr[k+1]) {
        i = k; //largest
        j = k + 1; //smallest
      }
    }

    while(i != j) {
      int sum = arr[i] + arr[j];
      if(sum == S) {
        System.out.println(S + " = " + arr[i]+ " + " + arr[j] + " \n");
        return;
      }

      if(sum > S) {
        i--; //Remember that pivot has to decrease towards left
      }
      else {
        j++; //small element has to increase towards right
      }
      if(j == arr.length) j = 0;
      if(i == -1) i = arr.length-1;
    }
    System.out.println("No pair found for sum " + S);
    System.out.println();
  }

  public static void main(String[] args) {
    int[] arr = new int[]{11, 15, 6, 8, 9, 10};
    pairSum(arr, 16);

    arr = new int[]{11, 15, 26, 38, 9, 10};
    pairSum(arr, 35);

    arr = new int[]{11, 15, 26, 38, 9, 10};
    pairSum(arr, 45);
  }

}
