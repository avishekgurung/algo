package array.problems;

import java.util.Arrays;

public class Problem056 {
  /**
   * We will not create a new target array from the given array. But we will do the reverse. For
   * a given array, we will try to find out how many operations are required to reduce all the
   * elements of a given array to zero.
   *
   * Remember the problem is to find the minimum number of steps and not to achieve a target array.
   *
   * Given an array, we will use the operations in operations in reverse manner.
   *
   * We will check for every element and if the element is odd, we do the decrement of that element.
   * We then divide all the elements by 2. We keep doing these operations until we have all the
   * elements as 0.
   */

  public static void minStepsToConvertToZeroArray(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int minOperations = 0;
    boolean opFlag = true;
    int len = arr.length;

    while(true) {
      int zeroCount = 0;
      if(opFlag) {
        for(int i=0; i < len; i++) {
          if(arr[i] % 2 == 1) {
            arr[i] = arr[i] - 1;
            minOperations++;
          }
          if(arr[i] == 0) {
            zeroCount++;
          }
        }
        if(zeroCount == arr.length) break;
      }
      else {
        for(int i=0; i < arr.length; i++) {
          arr[i] = arr[i] / 2;
        }
        minOperations++;
      }
      opFlag = !opFlag;
    }
    System.out.println(Arrays.toString(arr));
    System.out.println("Min Operations required = " + minOperations + "\n");
  }

  public static void main(String[] args) {
    minStepsToConvertToZeroArray(new int[]{2,3});
    minStepsToConvertToZeroArray(new int[]{2,1});
    minStepsToConvertToZeroArray(new int[]{16,16,16});
  }
}
