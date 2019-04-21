package array.problems;

import java.util.Arrays;

/**
 * This problem could also have many other applications. Verify.
 */
public class Problem054 {

  public static void levelPoleHeight(int arr[], int k) {
    System.out.println(Arrays.toString(arr));
    Arrays.sort(arr);

    int min = arr[0] + k;
    int max = arr[arr.length - 1] - k;

    if(min > max) {
      int temp = min;
      min = max;
      max = temp;
    }

    for(int i=1; i < arr.length - 1; i++) {
      int sub = arr[i] - k;
      int add = arr[i] + k;

      if(sub >= min && add <= max) continue; //Changing this element wont make any difference.

      if(max - sub <= add - min) {
        min = sub;
      }
      else {
        max = add;
      }
    }


    System.out.println("The maximum difference between the heights of min and max poles is " +
        (max - min) + " where k = "+ k + " \n");

  }

  public static void main(String[] args) {
    levelPoleHeight(new int[]{1, 15, 10}, 6);
    levelPoleHeight(new int[]{1, 5, 15, 10}, 3);
    levelPoleHeight(new int[]{4, 6}, 10);
    levelPoleHeight(new int[]{6, 10}, 3);
    levelPoleHeight(new int[]{3, 4, 8}, 2);
    //levelPoleHeight(new int[]{}, );
    //levelPoleHeight(new int[]{}, );
  }

}
