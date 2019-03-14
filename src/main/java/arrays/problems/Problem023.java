package arrays.problems;

import java.util.Arrays;

public class Problem023 {

  public static int getLonelyElement(int arr[]) {
    int lonely = arr[0];
    for(int i=1; i < arr.length; i++) {
      lonely = lonely ^ arr[i];
    }
    return lonely;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{3,5,1,6,2,2,1,3,5};
    System.out.println(Arrays.toString(arr));
    System.out.println("Lonely: " + getLonelyElement(arr));
  }

}
