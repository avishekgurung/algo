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

    rearrangeDistinct1(new int[]{1,3,0,2});
    rearrangeDistinct1(new int[]{2, 0, 1, 4, 5, 3});
  }

}
