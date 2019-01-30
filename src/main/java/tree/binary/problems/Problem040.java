package tree.binary.problems;

import java.util.Arrays;

public class Problem040 {

  private static int index = 0;
  public static int getHeight(int arr[]) {
    if(index >= arr.length) return 0;
    if(arr[index++] == 0) return 0;
    int left = getHeight(arr);
    int right = getHeight(arr);
    return Math.max(left, right) + 1;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,0,1,0,0};
    System.out.println("Height of " + Arrays.toString(arr) + " is " + getHeight(arr));

    index = 0;
    arr = new int[]{1,0,1,1,0,0,0};
    System.out.println("Height of " + Arrays.toString(arr) + " is " + getHeight(arr));
  }

}
