package array.problems;

import java.util.Arrays;

public class Problem009 {

  public static int getFirstOccurrence(int arr[], int ele) {
    int left = 0, right = arr.length - 1;

    while(left <= right) {
      int mid = (left + right) / 2;
      if(ele > arr[mid]) {
        left = mid  + 1;
      }
      else if(ele < arr[mid]) {
        right = mid - 1;
      }
      else {
        if(mid == 0) return 0;
        if(arr[mid - 1] != ele) return mid;
        right = mid - 1;
      }
    }
    return -1;
  }

  public static int getLastOccurrences(int arr[], int left, int right, int element) {
    if(left > right) return -1;
    int mid = (left + right) / 2;
    int result;

    if(element > arr[mid]) {
      result = getLastOccurrences(arr, mid + 1, right, element);
    }
    else if(element < arr[mid]) {
      result = getLastOccurrences(arr, left, mid - 1,element);
    }
    else {
      if(mid == right || arr[mid + 1] != element) return mid;
      result = getLastOccurrences(arr, mid + 1, right, element);
    }
    return result;
  }

  public static void main(String[] args) {
    int arr[] = new int[] {1,1,1,2,2,2,3,3};
    System.out.println(Arrays.toString(arr));
    int ele = 1;
    System.out.println("First occurrence of " + ele + " is " + getFirstOccurrence(arr, ele));
    System.out.println("Last occurrence of " + ele + " is " + getLastOccurrences(arr, 0,
        arr.length-1, ele));

    System.out.println();
    ele = 2;
    System.out.println("First occurrence of " + ele + " is " + getFirstOccurrence(arr, ele));
    System.out.println("Last occurrence of " + ele + " is " + getLastOccurrences(arr, 0,
        arr.length-1, ele));

    System.out.println();
    ele = 3;
    System.out.println("First occurrence of " + ele + " is " + getFirstOccurrence(arr, ele));
    System.out.println("Last occurrence of " + ele + " is " + getLastOccurrences(arr, 0,
        arr.length-1, ele));
  }

}
