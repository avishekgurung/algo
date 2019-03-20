package array.problems;

import java.util.Arrays;

public class Problem044 {

  public static void rearrangeDistinct(int arr[]) {
    System.out.println(Arrays.toString(arr));

    int i = arr[0];
    int val = 0;

    while( i != 0 ) {
      int element = arr[i];
      arr[i] =  val;
      val = i;
      i = element;

    }

    arr[0] = val;

    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  public static void main(String[] args) {
    rearrangeDistinct(new int[]{1,3,0,2});
  }

}
