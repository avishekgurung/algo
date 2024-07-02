package array.problems;

import java.util.Arrays;

public class Problem027 {
  /**
   * We find a pivot and the next element to pivot is the smallest element.
   */
  public static void minElement(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int pivot = getPivot(arr, 0, arr.length-1);
    System.out.println("The smallest element is " + arr[(pivot+1)%arr.length]);
    //Dividing by length handles the case when the array is not rotated.
    System.out.println();
  }

  /**
   * This function will return a pivot if an array is sorted and rotated. If an array is just
   * sorted then it returns the last element of an array.
   */
  public static int getPivot(int arr[], int left, int right) {
    if(arr[left] < arr[right]) return right; //array is not rotated.
    while(left <= right) {
      int mid = (left + right) / 2;
      if(arr[mid] > arr[mid + 1]) return mid;
      if(arr[mid] > arr[left]) left = mid;
      else right = mid;
    }
    return -1;
  }

  public static void main(String[] args) {
    minElement(new int[]{5,6,1,2,3,4});
    minElement(new int[]{6,1,2,3,4,5});
    minElement(new int[]{2,3,4,5,6,1});
    minElement(new int[]{1,2,3,4,5,6});
    minElement(new int[]{7,8,1,2,3,4});
  }


}
