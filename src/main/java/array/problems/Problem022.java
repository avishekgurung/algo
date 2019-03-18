package array.problems;

import java.util.Arrays;

public class Problem022 {

  public static int getNumberOfOccurrences(int arr[], int element) {
    int firstOccurrence = Problem009.getFirstOccurrence(arr, element);
    int lastOccurrence = Problem009.getLastOccurrences(arr, 0, arr.length-1, element);
    return lastOccurrence - firstOccurrence + 1;
  }

  public static void main(String[] args) {
    int arr[] = new int[] {1,1,1,2,2,2,3,3};
    System.out.println(Arrays.toString(arr));
    int ele = 1;
    System.out.println("Number of occurrence of " + ele + " is " + getNumberOfOccurrences(arr, ele));

    ele = 2;
    System.out.println("Number of occurrence of " + ele + " is " + getNumberOfOccurrences(arr, ele));

    ele = 3;
    System.out.println("Number of occurrence of " + ele + " is " + getNumberOfOccurrences(arr, ele));
  }

}

