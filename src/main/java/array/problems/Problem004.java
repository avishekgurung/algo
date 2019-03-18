package array.problems;

import java.util.Arrays;

public class Problem004 {

  public static void findPairClosestToZero(int arr[]) {
    Arrays.sort(arr);
    String pair = "";
    int minDiff = Integer.MAX_VALUE;
    int i=0, j=  arr.length-1;

    while(i < j) {
      int left = arr[i];
      int right = arr[j];
      int diff;
      if(left < 0 && right < 0) {
        diff = right + left;
      }

      else if(left > 0 && right > 0) {
        diff = right - left;
      }
      else {
        diff = left + right;
      }

      if(Math.abs(diff) < minDiff) {
        minDiff = Math.abs(diff);
        pair = arr[i] + " : " + arr[j];
      }

      if(diff < 0) {
        i++;
      }
      else {
        j--;
      }
    }

    System.out.println("Pair closest to 0: " + pair);
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,60,-10,70,-80,85};
    System.out.println(Arrays.toString(arr));
    findPairClosestToZero(arr);

    System.out.println();
    arr = new int[]{1,3,4,5,6,7};
    System.out.println(Arrays.toString(arr));
    findPairClosestToZero(arr);

    System.out.println();
    arr = new int[]{-1,-2,-3,-4,-5,-6,-7};
    System.out.println(Arrays.toString(arr));
    findPairClosestToZero(arr);
  }

}
