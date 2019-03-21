package array.problems;

import java.util.Arrays;

public class Problem013 {

  public static void subArrayWithSumS(int arr[], int sum) {
    int currentSum = arr[0];
    int start = 0;

    for(int i=1; i < arr.length; i++) {
      currentSum = currentSum + arr[i];
      if(currentSum == sum) {
        System.out.println("The subarray from index " + start + " to " + i + " has sum equal to " +
            sum);
        return;
      }
      if(currentSum > sum) {
        while(currentSum > sum) {
          currentSum = currentSum - arr[start];
          start++;
          if(currentSum == sum) {
            System.out.println("The subarray from index " + start + " to " + i + " has sum equal to " +
                sum);
            return;
          }
        }
      }
    }
    System.out.println("No subarray with sum " + sum);
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,2,3,4,4};
    System.out.println(Arrays.toString(arr));
    subArrayWithSumS(arr,7);
    subArrayWithSumS(arr,5);
    subArrayWithSumS(arr,8);
    subArrayWithSumS(arr,11);
    subArrayWithSumS(arr,10);
    subArrayWithSumS(arr,12);
  }

}
