package practice;

import java.util.*;

public class LabTest {
  public static void printSmall(int arr[], int n, int k)
  {
    int count_1 = 0, count_2 = 0;
    // For each arr[i] find whether
    // it is a part of n-smallest
    // with insertion sort concept
    for (int i = k; i < n; ++i) {
      // Find largest from top n-element
      int max_var = arr[k - 1];
      int pos = k - 1;
      for (int j = k - 2; j >= 0; j--) {
        count_1++;
        if (arr[j] > max_var) {
          max_var = arr[j];
          pos = j;

        }
      }

      // If largest is greater than arr[i]
      // shift all element one place left
      if (max_var > arr[i]) {
        int j = pos;
        count_2++;
        while (j < k - 1) {
          arr[j] = arr[j + 1];
          j++;

        }
        // make arr[k-1] = arr[i]
        arr[k - 1] = arr[i];
      }
    }
    // print result
    for (int i = 0; i < k; i++)
      System.out.print(arr[i] + " ");
    System.out.println("\ncount 1: " + count_1);
    System.out.println("count 2: " + count_2);
  }

  // Driver function
  public static void main(String argc[])
  {
    int[] arr = {1,2,3};
    int c = arr[0];
    for(int i=1; i < arr.length; i++) {
      c = c ^ arr[i];
    }
    System.out.println(c);
  }

}
