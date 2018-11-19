package sorting;

import java.util.Arrays;

/**
 * Write the basic skeleton and create a dummy array and trace it. This will make the algo correct
 * and also will give a good impression (since you have not mugged up).
 */

public class MergeSort {

  private void merge(int arr[], int left, int mid, int right) {
    int n1 = mid - left + 1;
    int n2 = right - mid;

    int leftArr[] = new int[n1];
    int rightArr[] = new int[n2];

    int i=0,j=0,k=left;

    for(i=0; i<n1; i++) {
      leftArr[i] = arr[left+i];
    }

    for(j=0; j < n2; j++) {
      rightArr[j] = arr[mid+j+1];
    }

    i=0;
    j=0;

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

  private void sort(int arr[], int left, int right) {
    if(left < right) {
      int mid = (left + right) / 2;
      sort(arr, left, mid);
      sort(arr, mid+1, right);
      merge(arr, left, mid, right);
    }
  }

  public static void main(String[] args) {

    int arr[] = {9,2,4,1,6,5,7,8,1,2,3,3,6,8,7,7,3,2,4,9,0};
    MergeSort obj = new MergeSort();
    obj.sort(arr, 0, arr.length-1);
    System.out.println(Arrays.toString(arr));
  }



}
