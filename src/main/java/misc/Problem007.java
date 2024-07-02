package misc;

import java.util.Arrays;

public class Problem007 {

  public static void maxProduct(int arr[]) {
    System.out.println(Arrays.toString(arr));

    int first = Integer.MIN_VALUE;
    int second = Integer.MAX_VALUE;
    int firstOriginal = 0;
    int secondOriginal = 0;

    for(int i=0; i < arr.length; i++) {
      int absVal = Math.abs(arr[i]);
      if(absVal > first) {
        second = first;
        first = absVal;

        secondOriginal = firstOriginal;
        firstOriginal = arr[i];
      }
      else if(absVal > second) {
        second = absVal;
        secondOriginal = arr[i];
      }
    }
    System.out.println("The max product is " + firstOriginal + " x " + secondOriginal + " = " +
        Math.abs(first * second));
  }

  public static void main(String[] args) {
    maxProduct(new int[]{1, 4, 3, 6, 7, 0});
    maxProduct(new int[]{-1, -3, -4, 2, 0, -5});
  }

}
