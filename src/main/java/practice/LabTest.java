package practice;

import java.util.Arrays;

public class LabTest {

  public static int getPivot(int arr[], int left, int right) {
    if(arr[left] < arr[right]) return -1;
    while(left <= right) {
      int mid = (left + right) / 2;
      if(arr[mid] > arr[mid + 1]) return arr[mid];
      if(arr[left] < arr[mid]) left = mid;
      else right = mid;
    }
    return  -1;
  }

  public static boolean binarySearch(int arr[],int element) {
    int left = 0;
    int right = arr.length - 1;
    while(left <= right) {
      int mid = (left + right) / 2;
      if(arr[mid] == element) return true;
      if(arr[mid] > element) right = mid - 1;
      else left = mid + 1;
    }
    return false;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,2,3,4,5};
    System.out.println(binarySearch(arr, 1));
    System.out.println(binarySearch(arr, 2));
    System.out.println(binarySearch(arr, 3));
    System.out.println(binarySearch(arr, 4));
    System.out.println(binarySearch(arr, 5));
    System.out.println(binarySearch(arr, 6));
  }

}
