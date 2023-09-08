package array.problems;

import java.util.Arrays;

/**
 * Start i from 0 and j from i+1.
 * For every iteration in j find the rightmost index k where arr[i] + arr[j] > arr[k]
 * k will start from i + 2
 * The triangle for every iteration is k - j.
 *
 * The complexity is O(n2) because the inner loop for j runs n times since k is initialised before
 * the inner loop and we always use previous value of k.
 *
 *
 */
public class Problem072 {

  public static void totalNumberOfTriangles(int arr[]) {
    System.out.println(Arrays.toString(arr));
    Arrays.sort(arr);
    int totalTriangles = 0;
    for(int i=0;i < arr.length - 2; i++) {
      int k = i + 2;
      for(int j=i+1; j < arr.length - 1; j++) {
        while(k < arr.length && arr[i] + arr[j] > arr[k]) {
          k++;
        }
        if(k - j > 0 ) {
          int triangles = k -j - 1;
          totalTriangles = totalTriangles + triangles;
        }
      }
    }
    System.out.println("Total number of traingles is " + totalTriangles + "\n");
  }


  /**
   * Another very simple approach would be. Sort the array. Run two loops and for each iteration check if
   * the two elements are greater than the third.
   */

  private static void maxTriangles(int arr[]) {
    int maxTraingles = 0;
    Arrays.sort(arr);
    for(int i=0; i < arr.length - 2; i++) {
      for(int j=i+1; j < arr.length - 1; j++) {
        if(arr[i] + arr[j] > arr[j+1]) {
          maxTraingles++;
        }
      }
    }
    System.out.println(maxTraingles);
  }

  public static void main(String[] args) {
    totalNumberOfTriangles(new int[]{4, 6, 3, 7});
    totalNumberOfTriangles(new int[]{10, 21, 22, 100, 101, 200, 300});
  }

}
