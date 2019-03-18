package array.problems;

import java.util.Arrays;

public class Problem030 {
  /**
   * The decent approach could be to use hashmap and find the element whose freq is greater than
   * one. This takes O(n) time and space.
   *
   * We can perform it in O(n) time and constant space by using bitwise XOR.
   *
   * We can also use mathematical eq to peeform in O(n) time and constant space.
   * Let S be the sum of elements in the array. Let a and b the those two elements to find.
   * n(n+1)/2 + a + b = S
   * a + b = S - n(n+1)/2  ----------> eq-1
   *
   * Let P be the product of all numbers in the array.
   * n!*a*b = P
   * a*b = P/n! -----------> eq-2
   *
   * We have to solve them.
   *
   */


  public static void findRepeatingElements(int arr[]) {
    int size = arr.length;
    for(int i=0; i < size; i++) {
      int index = arr[i] % size;
      arr[index] = arr[index] + size;
    }
    System.out.print("Repeating elements: ");
    for(int i=0; i < size; i++) {
      if(arr[i] / size == 2) System.out.print(i + "\t");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int arr[] = new int[]{3,1,2,1,3};
    System.out.println(Arrays.toString(arr));
    findRepeatingElements(arr);

    System.out.println();
    arr = new int[]{1,2,3,4,5,1,2};
    System.out.println(Arrays.toString(arr));
    findRepeatingElements(arr);
  }
  /**
   * Time complexity = O(n)
   * Space complexity = O(1)
   */
}
