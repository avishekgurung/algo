package array.problems;

import java.util.Arrays;

public class Problem028 {

  /**
   * This is simple can be of efficient use.
   */
  public static void printLeftRotation(int arr[], int d) {
    System.out.println("\nRotated " + d + " times");
    int n = arr.length;
    for(int i=0; i < arr.length; i++) {
      System.out.print(arr[(i+d)%n] + " ");
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,2,3,4,5,6};
    System.out.println(Arrays.toString(arr));
    printLeftRotation(arr, 2);
    printLeftRotation(arr, 1);
    printLeftRotation(arr, 6);
  }

}
