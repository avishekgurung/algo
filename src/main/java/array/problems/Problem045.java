package array.problems;

import java.util.Arrays;

/**
 * The logic is pretty simple.
 * Whenever we find a position where the element is wrongly placed, eg, negative elements placed
 * at even position or positive elements placed at odd position, then we will replace these
 * elements by another element which is also placed in wrong manner.
 *
 * Eg. If we find a negative element at even position, say 0,2,4, etc. Then we will search for a
 * positive element that is placed at odd position like 3,5, etc. If we find this wrong positive
 * element then we will swap them. But if we do not find such positive element then this means
 * that the array cannot be further re-arranged so we just quit.
 *
 * And search of wrong positive or negative element is through an entire array for every element.
 * We search wrong element from the last position. Hence the complexity will be O(n).
 */

public class Problem045 {

  public static void rearrangePositiveAndNegativeElements(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int posPointer = -1;
    int negPointer = -1;

    //Move the pointer to first positive and first negative index.
    for(int i=0; i < arr.length; i++) {
      if(arr[i] < 0 && negPointer == -1) negPointer = i;
      if(arr[i] >= 0 && posPointer == -1) posPointer = i;
    }

    int pointer = 0;

    while(pointer != arr.length) {

      if(pointer % 2 == 0 && arr[pointer] < 0) {
        posPointer = nextPositivePointerAtWrongLocation(pointer, arr);
        if(posPointer == -1) break; //as we cannot re-arrange further
        swap(arr, posPointer, pointer);
      }

      if(pointer % 2 == 1 && arr[pointer] >= 0){
        negPointer = nextNegativePointerAtWrongLocation(negPointer, arr);
        if(negPointer == -1) break; //as we cannot re-arrange further
        swap(arr, negPointer, pointer);
      }
      pointer++;
    }
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  private static void swap(int arr[], int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  private static int nextPositivePointerAtWrongLocation(int positivePointer, int arr[]) {
    while(positivePointer != arr.length) {
      if(arr[positivePointer] >= 0 && positivePointer % 2 == 1) {
        return positivePointer;
      }
      positivePointer++;
    }
    return -1;
  }

  public static int nextNegativePointerAtWrongLocation(int negativePointer, int arr[]) {
    while(negativePointer != arr.length) {
      if(arr[negativePointer] < 0 && negativePointer % 2 == 0) {
        return negativePointer;
      }
      negativePointer++;
    }
    return -1;
  }


  public static void main(String[] args) {
    rearrangePositiveAndNegativeElements(new int[]{1, -3, 5, 6, -3, 6, 7, -4, 9, 10});
    rearrangePositiveAndNegativeElements(new int[]{-1, 3, -5, 6, 3, 6, -7, -4, -9, 10});
  }
}
