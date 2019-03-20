package array.problems;

import java.util.Arrays;

public class Problem046 {

  public static void multiplePairs(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int prev = 0;

    for(int i=0; i < arr.length; i++) {
      int product;

      if(i == 0) {
        product = arr[i] * arr[i+1];
      }
      else if(i == arr.length - 1) {
        product = prev * arr[i];
      }
      else {
        product = prev * arr[i+1];
      }
      prev = arr[i];
      arr[i] = product;
    }
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  public static void main(String[] args) {
    multiplePairs(new int[]{2, 3, 4, 5, 6});
  }
}
