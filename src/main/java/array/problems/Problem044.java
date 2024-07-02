package array.problems;

import java.util.Arrays;

public class Problem044 {

  /**
   * This method will not work for test cases.
   * @param arr
   */
  public static void rearrangeDistinct(int arr[]) {
    System.out.println(Arrays.toString(arr));

    int i = arr[0];
    int val = 0;

    while( i != 0 ) {
      int element = arr[i];
      arr[i] =  val;
      val = i;
      i = element;

    }

    arr[0] = val;

    System.out.println(Arrays.toString(arr));
    System.out.println();
  }


  /**
   * We cannot keep changing the element because we will have to note what element we are changing. So this problem
   * needs a recursive way to fix it. Everytime, we traverse an element, we mark it by adding the length of an array.
   * So any element can be identified by modular division of array length. Once we mark an array, we will take the
   * element of the index and pass again to the function as index. We do this until all the elements are traversed.
   *
   * The complexity is O(n), because our first for loop will not be executed for the elements that has already been
   * traversed.
   * @param arr
   */
  public static void rearrangeDistinct1(int arr[]) {
    System.out.println(Arrays.toString(arr));

    for(int i=0; i < arr.length; i++) {
      swap1(arr, i);
    }

    for(int i=0; i < arr.length; i++) {
      arr[i] = arr[i] % arr.length;
    }
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  private static void swap1(int arr[], int index) {
    if(arr[index] >= arr.length) return;
    int element = arr[index] % arr.length;
    arr[index] = arr[index] + arr.length;
    swap1(arr, element);
    arr[element] = index + arr.length;
  }

  public static void main(String[] args) {

    int arr[] = {1,3,0,2};
    arr = new int[]{3,2,1,0};
    maxIndexReached = 0;
    System.out.println(Arrays.toString(arr));
    while(maxIndexReached < arr.length-1) {
      swap(arr, maxIndexReached, maxIndexReached);
      maxIndexReached++;
    }
    System.out.println(Arrays.toString(arr));

    System.out.println();

    arr = new int[]{2, 0, 1, 4, 5, 3};
    maxIndexReached = 0;
    System.out.println(Arrays.toString(arr));
    while(maxIndexReached < arr.length-1) {
      swap(arr, maxIndexReached, maxIndexReached);
      maxIndexReached++;
    }
    System.out.println(Arrays.toString(arr));

  }

  /**
   * A very simple and alternate approach.
   * 1. If we can use aux array, we can just create aux array and just do the swap.
   * 2. If we cannot use extra space, then we need to do the following approach.
   * This problem requires us to change the element of an array but at the same time, we also need to remember what was
   * the previous element before swapping. So recursion is a good usecase for remembering.
   *
   * We will just replace as arr[element] = index but we will do the recursion so that we remember the element.
   * There can be cases where the recursion can end and cannot be used for remaining elements. Hence, for that we
   * maintain a tracker. Eg, the logic will work only for half array incase of 1 0 3 2
   *
   */

  private static int maxIndexReached = 0;

  private static void swap(int arr[], int startingIndex , int index) {
    if(index >= arr.length) return;
    int element = arr[index];
    if(startingIndex == element) {
      arr[element] = index;
      return;
    }
    swap(arr, startingIndex, element);
    arr[element] = index;
    maxIndexReached = Math.max(maxIndexReached, index);
  }

}
