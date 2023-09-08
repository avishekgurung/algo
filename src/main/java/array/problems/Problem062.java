package array.problems;

import java.util.Arrays;

/**
 * Naive Approach:
 * run the loop for k times and find the kth smallest element.
 * Iterate the loop and print all the elements less than for equal to k.
 * Complexity = O(nk).
 *
 * We follow a concept of insertion sort here.
 * we will divide the array into two parts (conceptually), first k elements and the n-k elements.
 * Eg, arr[] = {5,7,4,2,6,1,9} and k = 3
 * [5,7,4] and [2,6,1,9].
 * We iterate through the second array [2,6,1,9] and for every iteration, we will find the largest
 * element in 1st array and its position.
 * If this largest element is greater than the current element of 2nd array then, we shift
 * all the elements of 1st array to its left and keep this largest element as the last element of
 * 1st array and then we will replace this largest element by the current element of 2nd index.
 *
 * Eg,
 * iterating for 2
 * [5,7,4][2,6,1,9],
 * here 7 is the largest.
 * 7 is bigger than 2
 * keep shifting elements of first array towards left, [5,4,7] [2,6,1,9]
 * Replace the last element of 1st array by 2, [5,4,2][2,6,1,9]
 *
 * Now start the procedure for second element of second array which is '6'.
 *
 * This process also takes n*k time complexity. For n-k times, we are running a inner loop of k times. (n-k)k ~ nk
 *
 */
public class Problem062 {

  public static void kSmallestElementsWithOrderRetained(int arr[], int k) {

    System.out.println(Arrays.toString(arr) + " k=" + k);

    for(int i=k; i < arr.length; i++) {

      int max = arr[0];
      int pos = 0;
      for(int j=1; j < k; j++) {
        if(max < arr[j]) {
          max = arr[j];
          pos = j;
        }
      }

      if(max > arr[i]) {
        while(pos < k) {
          arr[pos] = arr[pos + 1];
          pos++;
        }
        arr[k-1] = arr[i];
      }
    }

    for(int i=0; i < k; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println("\n");
  }

  public static void main(String[] args) {
    kSmallestElementsWithOrderRetained(new int[]{5,7,4,2,6,1,9}, 3);
    kSmallestElementsWithOrderRetained(new int[]{5,7,4,2,6,1,9}, 4);
  }

}
