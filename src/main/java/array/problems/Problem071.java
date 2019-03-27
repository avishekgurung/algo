package array.problems;

import java.util.Arrays;

/**
 * This problem is divided into two parts.
 * Lets take [10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60] as an example.
 *
 * 1. Find the subarray which is unsorted
 *    a. Traverse from left to right and find an element which is higher than the next element.
 *    Let its index be s. (Elements are always lower than the next element in sorted array). So
 *    we are finding an element which is defying the law of sorting.
 *
 *    b. Traverse from right to left and find an element which is lower than the next element. Let
 *    e be its index.
 *
 *    In the above array, 30 and 31 so s and e are 3 and 7.
 *
 * 2. Expand the above subarray to find the min subarray
 *    1. Between s and e find the max and min elements. (which are 25 and 40 respectively).
 *    2. Traverse from  start to s-1 and find a first element which is greater than the min
 *    element. If found then change s to its index.
 *    3. Traverse from e + 1 to end and find the last element which is greater than max. If found
 *      then change e to its index.
 *
 *  The index s and e is the required subarray.
 */
public class Problem071 {

  public static void minimumUnsortedSubArray(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int start = 0, end = arr.length - 1;
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    //calculate start
    for(int i=0; i < arr.length - 1; i++) {
      if(arr[i] > arr[i+1]) {
        start = i;
        break;
      }
    }

    //calculate end
    for(int i=arr.length - 1; i >0; i--) {
      if(arr[i] < arr[i-1]) {
        end = i;
        break;
      }
    }

    //find the max and min
    for(int i=start; i <=end; i++) {
      max = Math.max(arr[i], max);
      min = Math.min(arr[i], min);
    }

    //Expand start
    for(int i=0; i <= start - 1; i++) {
      if(arr[i] > min) {
        start = i;
        break;
      }
    }

    //Expand end. We will traverse from end and get the first value. Rather than traversing
    //from end and getting the last value.
    for(int i=arr.length-1; i>=end + 1; i--) {
      if(arr[i] < max) {
        end = i;
        break;
      }
    }

    System.out.println("The minimum subarray which can be sorted to sort an array as a whole "
        + "is from " + start + " to " + end + "\n");

  }

  public static void main(String[] args) {
    minimumUnsortedSubArray(new int[]{10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60});
    minimumUnsortedSubArray(new int[]{0, 1, 15, 25, 6, 7, 30, 40, 50});
  }

}
