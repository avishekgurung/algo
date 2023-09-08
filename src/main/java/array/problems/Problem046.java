package array.problems;

import java.util.Arrays;

public class Problem046 {

  public static void multiplePairs(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int prev = arr[0];
    arr[0] = arr[0] * arr[1];

    for(int i=1; i < arr.length - 1; i++) {
      int current = arr[i];
      arr[i] = prev * arr[i+1];
      prev = current;
    }

    arr[arr.length - 1] = arr[arr.length - 1] * prev;
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  public static void main(String[] args) {
    multiplePairs(new int[]{2, 3, 4, 5, 6});
  }
}
