package sorting.impl;

import java.util.Arrays;

public class BubbleSort {
  /**
   * Time complexity is O(n2) for all cases.
   * @param arr
   */
  public static void bubbleSort(int arr[]) {
    for(int i=0; i < arr.length-1;i++) {
      for(int j=i+1; j < arr.length; j++) {
        if(arr[i] > arr[j]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = new int[]{4,2,8,9,5,1,6,3,7};
    System.out.println(Arrays.toString(arr));
    bubbleSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
