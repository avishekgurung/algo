package array.problems;

import java.util.Arrays;

public class Problem025 {

  public static int rotationCount(int arr[]) {
    int count = 0;
    for(int i=0; i < arr.length - 1; i++) {
      count++;
      if(arr[i] > arr[i+1]) {
        return count;
      }
    }
    return 0;
  }

  public static void util(int arr[]) {
    System.out.println(Arrays.toString(arr));
    System.out.println("Rotation " + rotationCount(arr));
    System.out.println();
  }

  public static void main(String[] args) {
    util(new int[]{4,1,2,3});
    util(new int[]{3,4,1,2});
    util(new int[]{2,3,4,1});
    util(new int[]{1,2,3,4});
  }

}
