package array.problems;

import java.util.Arrays;

public class Problem033 {

  /**
   * O(nlogn) time and O(n) space.
   */
  public static void rearrangeOddAndEven(int arr[]) {
    sort(arr);
    System.out.println(Arrays.toString(arr));
    int len = arr.length;
    int aux[] = new int[len];

    boolean even_flag = len % 2 == 0;
    int j = arr.length-1;
    int k = 1;
    if(even_flag) {
      j = arr.length - 2;
    }

    int i=0;
    while(j >= 0) {
      aux[j] = arr[i];
      i++;
      j = j - 2;
    }

    while(k < len) {
      aux[k] = arr[i];
      i++;
      k = k + 2;
    }

    System.out.println(Arrays.toString(aux));
    System.out.println();
  }

  //performing bubble sort but should be used other sorting in real situation.
  public static void sort(int arr[]) {
    for(int i=0; i < arr.length - 1; i++){
      for(int j=i+1; j < arr.length; j++) {
        if(arr[i] > arr[j]) {
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
    }
  }

  public static void main(String[] args) {
    rearrangeOddAndEven(new int[]{1, 2, 3, 4, 5, 6, 7});
    rearrangeOddAndEven(new int[]{1, 2, 1, 4, 5, 6, 8, 8});
  }
}

/**
 * The out follows the pattern
 * 4  3   2   1
 *   5  6   7
 *-----------------
 *4 5 3 6 2 7 1
 */
