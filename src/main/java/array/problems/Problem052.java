package array.problems;

import java.util.Arrays;

public class Problem052 {

  public static void smallestMissingNumber(int arr[], int n, int m) {
    System.out.println(Arrays.toString(arr));
    int smallest = -1;
    for(int i=0; i < m; i++) {
      if(i == arr.length) { //edge case
        smallest = i;
        break;
      }
      if(i != arr[i]) {
        smallest = i;
        break;
      }
    }
    System.out.println("N:" + n + "\tM:" + m +"\tSmallest:" + smallest + "\n");
  }

  public static void main(String[] args) {
    smallestMissingNumber(new int[]{0, 1, 2, 6, 9}, 5, 10);
    smallestMissingNumber(new int[]{4, 5, 10, 11}, 4, 12);
  }

}
