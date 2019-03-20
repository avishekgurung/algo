package array.problems;

import java.util.Arrays;

public class Problem048 {

  public static void largestThreeElements(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE, third = Integer.MIN_VALUE;

    for(int i=0; i < arr.length; i++) {
      int element = arr[i];

      if(element > first) {
        third = second;
        second = first;
        first = element;
      }
      else if(element > second) {
        third = second;
        second = element;
      }
      else if(element > third) {
        third = element;
      }
    }

    System.out.println("Largest three elements: " + first + " " + second + " " + third + "\n");
  }

  public static void main(String[] args) {
    largestThreeElements(new int[]{10, 4, 3, 50, 23, 90});
  }

}

