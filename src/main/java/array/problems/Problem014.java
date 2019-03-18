package array.problems;

import java.util.Arrays;

public class Problem014 {

  public static void subArrayWithSum0(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int currentSum = arr[0];
    int start = 0;

    for(int i=1; i < arr.length; i++) {
      currentSum = currentSum + arr[i];
      if(currentSum == 0) {
        System.out.println("The subarray from index " + start + " to " + i + " has sum equal to "
            + "0");
        return;
      }

      if(arr[i] < 0 && currentSum > 0) {
        while(currentSum > 0) {
          currentSum = currentSum - arr[start];
          start++;
          if(currentSum == 0) {
            System.out.println("The subarray from index " + start + " to " + i + " has sum equal to "
                + "0");
            return;
          }
        }
      }
    }
    System.out.println("No subarray with sum 0");
  }

  public static void main(String[] args) {
    subArrayWithSum0(new int[]{1,2,-4,1});
    System.out.println();

    subArrayWithSum0(new int[]{1,2,-3,1});
    System.out.println();

    subArrayWithSum0(new int[]{1,2,-2,1});
    System.out.println();

    subArrayWithSum0(new int[]{1,2,-1,1});
    System.out.println();

    subArrayWithSum0(new int[]{10,2,-3,11});
    System.out.println();
  }

}
