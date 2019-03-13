package sorting.impl;

import java.util.Arrays;

public class BinarySearch {

  public static boolean search(int arr[], int element) {
    arr = sort(arr);
    int left = 0;
    int right = arr.length - 1;

    while(left <= right) {
      int mid = (left + right)/2;
      if(element == arr[mid]) {
        return true;
      }
      else if(element < arr[mid]) {
        right = mid - 1;
      }
      else {
        left = mid + 1;
      }
    }
    return false;
  }

  private static int[] sort(int arr[]) {
    for(int i=1;i < arr.length; i++) {
      int key = arr[i];
      int j = i;
      while(j > 0 && key < arr[j-1]) {
        int temp = arr[j];
        arr[j] = arr[j-1];
        arr[j-1] = temp;
        j--;
      }
      arr[j] = key;
    }
    return arr;
  }

  public static void main(String[] args) {
    int arr[] = new int[] {8,2,4,1,7,3,9,6,5};
    System.out.println(Arrays.toString(arr));

    int element = 1;
    System.out.println("Search " +element + " " + search(arr, element));

    element = 2;
    System.out.println("Search " + element + " " + search(arr, element));

    element = 3;
    System.out.println("Search " + element + " " + search(arr, element));

    element = 4;
    System.out.println("Search " + element + " " + search(arr, element));

    element = 5;
    System.out.println("Search " + element + " " + search(arr, element));

    element = 6;
    System.out.println("Search " + element + " " + search(arr, element));

    element = 7;
    System.out.println("Search " + element + " " + search(arr, element));

    element = 8;
    System.out.println("Search " + element + " " + search(arr, element));

    element = 9;
    System.out.println("Search " + element + " " + search(arr, element));

    element = 10;
    System.out.println("Search " + element + " " + search(arr, element));
  }

}
