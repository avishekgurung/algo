package sorting.impl;

import java.util.Arrays;

public class InsertionSort {

  /**
   * Most efficient of all the O(n2) algos.
   * O(n2) for worst case when the list is reversed.
   * O(n) for best case when the list is already sorted.
   * @param arr
   */
  public static void insertionSort(int arr[]) {
    for(int i=1; i < arr.length; i++) {
      int key = arr[i];
      int j = i;
      while(j > 0 && key < arr[j-1]) {
        arr[j] = arr[j-1];
        j--;
      }
      arr[j] = key;
    }
  }

  public static void main(String[] args) {
    int arr[] = new int[]{4,2,8,9,5,1,6,3,7};
    insertionSort(arr);
    System.out.println(Arrays.toString(arr));
  }
}
