package sorting.impl;

import java.util.Arrays;

public class SelectionSort {

  /**
   * Time complexity is O(n2) for all cases.
   * @param arr
   */
  public static void selectionSort(int arr[]) {
    for(int i=0; i < arr.length-1; i++) {
      int min = i;
      for(int j=i+1; j < arr.length; j++) {
        if(arr[min] > arr[j]) {
          min = j;
        }
      }
      int temp = arr[i];
      arr[i] = arr[min];
      arr[min] = temp;
    }
  }

  public static void main(String[] args) {
    int arr[] = new int[]{4,2,8,9,5,1,6,3,7};
    selectionSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
