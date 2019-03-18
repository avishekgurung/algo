package array.problems;

import java.util.Arrays;

public class Problem019 {

  /**
   * One simple solution is to count the number of 0s and 1s and replace them in an array.
   * Its the easiest and requires two iteration.
   * @param arr
   */

  public static void sort(int arr[]) {
    int i=0;
    int j = arr.length - 1;
    int pointer = 1;

    while( pointer < arr.length ) {
      if(arr[pointer] == 0) {
        int temp = arr[pointer];
        arr[pointer] = arr[i];
        arr[i] = temp;
        i++;
        if(i == pointer) pointer++;
      }
      else if(arr[pointer] == 2) {
        int temp = arr[pointer];
        arr[pointer] = arr[j];
        arr[j] = temp;
        j--;
        if(j == pointer) {
          pointer++;
        }
      }
      else {
        pointer++;
      }
    }
  }

  public static void util(int arr[]) {
    System.out.println(Arrays.toString(arr));
    sort(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,2,0,2,1,0};
    util(arr);

    arr = new int[]{0,0,0,1,2,1};
    util(arr);

    arr = new int[]{2,2,0,0,1,1};
    util(arr);
  }

}
