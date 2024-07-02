package array.problems;

import java.util.Arrays;

public class Problem036 {

  /**
   * This problem cannot be solved by rearranging -ve and +ve at the beginning and at end and placing one after the
   * other. The below solution does not work.
   * @param arr
   */
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

  /**
   * There are two approaches to the problem. One with O(n) time and space and the other one is O(n2) time with
   * constant space.
   */

  private static void withSpace(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int[] negatives = new int[arr.length];
    int[] positives = new int[arr.length];

    int n=0;
    int p=0;
    for(int i=0; i < arr.length; i++) {
      if(arr[i] < 0) {
        negatives[n] = arr[i];
        n++;
      } else {
        positives[p] = arr[i];
        p++;
      }
    }

    int ni = 0;
    int pi = 0;
    int i = 0;
    while(ni < n && pi < p) {
      if(i%2 == 0) {
        arr[i] = positives[pi];
        pi++;
      } else {
        arr[i] = negatives[ni];
        ni++;
      }
      i++;
    }

    while(ni < n) {
      arr[i] = negatives[ni];
      ni++;
      i++;
    }

    while(pi < p) {
      arr[i] = positives[pi];
      pi++;
      i++;
    }
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  private static void withoutSpace(int arr[]) {
    System.out.println(Arrays.toString(arr));
    for(int i=0; i < arr.length; i++) {
      if(i%2 == 0 && arr[i] < 0) {
        int s = getNextWrongPositiveElement(i+1, arr);
        if(s != -1) swap(s, i, arr);
      }
      if(i%2 == 1 && arr[i] > -1) {
        int s = getNextWrongNegativeElement(i+1, arr);
        if(s != -1) swap(s, i, arr);
      }
    }
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  private static void swap(int i, int j, int[] arr) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  private static int getNextWrongPositiveElement(int i, int arr[]) {
    while(i < arr.length) {
      if(i % 2 == 1 && arr[i] > -1) {
        return i;
      }
      i++;
    }
    return -1;
  }

  private static int getNextWrongNegativeElement(int i, int arr[]) {
    while(i < arr.length) {
      if(i % 2 == 0 && arr[i] < 0) {
        return i;
      }
      i++;
    }
    return -1;
  }


  public static void main(String[] args) {
    /*rearrangePositiveAndNegative(new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9});
    rearrangePositiveAndNegative(new int[]{1,-2,2,3,1,-4,5});
    rearrangePositiveAndNegative(new int[]{-1,-3,3,-2,-5,-6,-9,9});
    rearrangePositiveAndNegative(new int[]{-3,2,-1,4});*/
    withoutSpace(new int[]{-1, 2, -3, 4, 5, 6, -7, 8, 9});
    withoutSpace(new int[]{-3,2,-1,4});
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
