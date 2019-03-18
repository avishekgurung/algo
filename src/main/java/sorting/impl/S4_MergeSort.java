package sorting.impl;

import java.util.Arrays;

public class S4_MergeSort {

  /**
   * 1. Uses divide and conquer.
   * 2. Used to sort linked list.
   * 3. Time Complexity = O(nlogn). Refer to master theorem for finding the complexity.
   * 4. Space Complexity = O(n).
   * 5. For sorting of large files or parallel processing we use merge sort.
   * @param arr
   * @param left
   * @param right
   */
  public static void mergeSort(int arr[], int left, int right) {
    if(left < right) {
      int mid = (left + right) /2;
      mergeSort(arr, left, mid);
      mergeSort(arr, mid+1, right);
      merge(arr, left, mid, right);
    }
  }

  public static void merge(int arr[], int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;
    int leftArr[] = new int[n1];
    int rightArr[] = new int[n2];

    for(int i=0; i < n1; i++) leftArr[i] = arr[left + i];
    for(int i=0; i < n2; i++) rightArr[i] = arr[mid + 1 + i];

    int i=0, j=0, k=left;
    while(i < n1 && j < n2) {
      if(leftArr[i] <= rightArr[j]) {
        arr[k] = leftArr[i];
        i++;
      }
      else {
        arr[k] = rightArr[j];
        j++;
      }
      k++;
    }

    while(i < n1) {
      arr[k] = leftArr[i];
      i++;
      k++;
    }

    while(j < n2) {
      arr[k] = rightArr[j];
      j++;
      k++;
    }
  }

  public static void main(String[] args) {
    int arr[] = new int[]{4,2,8,9,5,1,6,3,7};
    mergeSort(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));
  }
}
