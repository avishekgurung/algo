package array.problems;

import java.util.Arrays;

public class Problem025 {

  /**
   *  Takes O(n)
   */
  public static int rotationCount(int arr[]) {
    int count = 0;
    for(int i=0; i < arr.length - 1; i++) {
      count++;
      if(arr[i] > arr[i+1]) {
        return count;
      }
    }
    return 0;
  }

  /**
   *  Takes O(logn)
   */

  public static int rotationCountOptimized(int arr[]) {
    int i = 0, j = arr.length - 1;
    int pivot = arr.length - 1;
    if(arr[0] < arr[arr.length - 1]) {
      pivot = arr.length - 1;
    }
    else {
      while(i <= j) {
        int mid = (i + j)/2;
        if(arr[mid] > arr[mid + 1]) {
          pivot = mid;
          break;
        }
        if(arr[0] < arr[mid]) {
          i = mid + 1;
        }
        else {
          j = mid - 1;
        }
      }
    }
    return (pivot + 1) % arr.length;
  }

  public static void util(int arr[]) {
    System.out.println(Arrays.toString(arr));
    System.out.println("Rotation " + rotationCountOptimized(arr));
    System.out.println();
  }

  public static void main(String[] args) {
    util(new int[]{4,1,2,3});
    util(new int[]{3,4,1,2});
    util(new int[]{2,3,4,1});
    util(new int[]{1,2,3,4});
  }

}
