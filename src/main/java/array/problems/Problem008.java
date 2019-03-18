package array.problems;

import java.util.Arrays;

public class Problem008 {

  //if an element is greater than the next element then its a pivot element.
  public static int searchPivot(int arr[], int left, int right) {
    if(arr[left] < arr[right]) return right;

    int mid = (left + right) / 2;
    int element = arr[mid];
    if(element > arr[mid + 1]) return mid;

    int pivot;
    if(arr[left] < arr[mid]) { //pivot is towards right
      pivot = searchPivot(arr, mid + 1, right);
    }
    else { //pivot towards right
      pivot = searchPivot(arr, left, mid-1);
    }
    return pivot;
  }

  //binary search.
  public static int searchElement(int arr[], int left, int right, int element) {
    while(left <= right) {
      int mid = (left + right) / 2;
      if(arr[mid] == element) return mid;
      if(element > arr[mid]) {
        left = mid  + 1;
      }
      else {
        right = mid - 1;
      }
    }
    return -1;
  }


  public static void searchUtil(int arr[], int element) {
    System.out.println(Arrays.toString(arr));
    int pivot = searchPivot(arr, 0, arr.length-1);
    int index;
    if(element > arr[0]) {
      index = searchElement(arr, 0, pivot, element);
    }
    else {
      index = searchElement(arr, pivot + 1 , arr.length-1, element );
    }
    System.out.println(index);
    System.out.println();
  }

  public static void main(String[] args) {
    int arr[] = new int[]{3,4,5,6,7,8,9,1,2};
    searchUtil(arr, 5);

    arr = new int[]{8,9,1,2,3,4,5,6,7};
    searchUtil(arr, 5);

    arr = new int[]{1,2,3,4,5,6,7,8,9};
    searchUtil(arr, 5);
  }

}
