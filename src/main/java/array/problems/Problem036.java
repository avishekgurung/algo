package array.problems;

import java.util.Arrays;

public class Problem036 {

  public static void rearrangePositiveAndNegative(int arr[]) {
    System.out.println(Arrays.toString(arr));
    //segregate positive and negative to each side
    int negativeIndex = 0;
    int pointer = 1;
    while(pointer != arr.length) {
      if(arr[pointer] < 0) {
        int temp = arr[pointer];
        arr[pointer] = arr[negativeIndex];
        arr[negativeIndex] = temp;
        negativeIndex++;
      }
      pointer++;
    }

    int positiveIndex = negativeIndex + 1; //When negative index has just finished

    //simply swap the elements
    for(int i=0; i < arr.length && positiveIndex < arr.length; i = i + 2) {
      int temp = arr[i];
      arr[i] = arr[positiveIndex];
      arr[positiveIndex] = temp;
      positiveIndex++;
    }
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  public static void main(String[] args) {
    rearrangePositiveAndNegative(new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9});
    rearrangePositiveAndNegative(new int[]{1,-2,2,3,1,-4,5});
    rearrangePositiveAndNegative(new int[]{-1,-3,3,-2,-5,-6,-9,9});
  }

}

/**
 * Another simple approach that would be short and efficient would be:
 * Iterate an array:
 *  if i is odd and element is negative
 *    continue
 *  else
 *    arr[i] = next Negative Element
 *
 * if i is even and element is positive
 *    continue
 * else
 *    arr[i] = next Positive Element
 *
 * The next negative or positive element always be searched from i+1.
 */
