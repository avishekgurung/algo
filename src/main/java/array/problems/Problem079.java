package array.problems;

import java.util.Arrays;

/**
 * This problem can be solved in O(n) by Moore's voting algorithm. It can be solved by other ways
 * as well but it the efficient one is this.
 *
 * Moore's voting algo has two parts:
 *
 * 1. Get the majority element.
 *  This process involves finding a candidate for majority element. But it might not necessarily
 *  be a majority element. If the majority element is present then this step will get the majority
 *  element for sure. But there can be cases where majority element might not be present.
 *
 * 2. Verify the majority element.
 *  The candidate is then verified to see if its a majority element.
 *
 */

public class Problem079 {

  public static int getCandidate(int arr[]) {
    //We consider that first element is a majority element.
    int majorityIndex = 0;
    int count = 1;

    for(int i=1; i < arr.length; i++) {
      if(arr[i] == arr[majorityIndex]) {
        count++;
      }

      if(arr[i] != arr[majorityIndex]) {
        count--;
        if(count == 0) {
          majorityIndex = arr[i];
          count = 1;
        }

        if(count != 0) {
          count--;
        }
      }

    }
    return arr[majorityIndex];
  }

  public static boolean verifyMajorityElement(int arr[], int major) {
    int count = 0;
    for(int i=0; i < arr.length; i++) {
      if(arr[i] == major) count++;
    }
    return count > arr.length/2;
  }

  public static void findMajorityElement(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int candidate = getCandidate(arr);
    boolean isMajority = verifyMajorityElement(arr, candidate);
    if(isMajority) {
      System.out.println("The majority candidate is " + candidate);
    }
    else {
      System.out.println("There is not majority candidate");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    findMajorityElement(new int[]{ 2, 2, 3, 5, 2, 2, 6});
    findMajorityElement(new int[]{ 2, 2, 3, 5, 2, 6});
  }

}
