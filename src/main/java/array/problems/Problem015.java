package array.problems;

import java.util.Arrays;

public class Problem015 {

  public static int getMissingElement(int arr[]) {
    int n = arr.length + 1;
    int totalSum = (n*(n+1))/2;
    int arraySum = 0;
    for(int i=0; i < arr.length; i++) arraySum = arraySum + arr[i];
    return totalSum - arraySum;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,2,4,6,3,7,8};
    System.out.println(Arrays.toString(arr));
    System.out.println("Missing element: " + getMissingElement(arr));
  }
}
