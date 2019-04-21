package array.problems;

import java.util.Arrays;

/**
 * Soln. Count the elements less than or equal to k, say cnt. Take two variables and make a window
 * of size cnt and iterate. In every window, count the elements that are larger then k. The min
 * of this count is the answer.
 */
public class Problem037 {

  public static void minSwap(int arr[], int k) {
    System.out.println(Arrays.toString(arr));
    int len = arr.length;
    int cnt = 0;

    for(int i=0; i < len; i++) {
      if(arr[i] <= k)cnt++;
    }

    int i = 0;
    int j = cnt - 1;
    int valuesGreaterThanK = 0;
    int minOfValuesGreaterThanK = 0;

    for(int m=0; m <=j; m++){
      if(arr[m] > k) {
        valuesGreaterThanK++;
      }
    }

    minOfValuesGreaterThanK = valuesGreaterThanK;

    while(j < len - 1) {
      int elementRemoved = arr[i];
      int elementAdded = arr[j+1];
      if(elementAdded != elementRemoved) {
        if(elementRemoved > k) valuesGreaterThanK--;
        if(elementAdded > k) valuesGreaterThanK++;
        minOfValuesGreaterThanK = Math.min(valuesGreaterThanK, minOfValuesGreaterThanK);
      }
      i++;
      j++;
    }

    System.out.println("Min number of swaps required is " + minOfValuesGreaterThanK + "\n");
  }

  public static void main(String[] args) {
    minSwap(new int[]{2,1,5,6,3}, 3);
    minSwap(new int[]{2,1,5,6,3}, 2);
    minSwap(new int[]{5,6,3,7,5,2,9,10,1}, 3);
    minSwap(new int[]{5,6,3,7,5,2,9,10,}, 3);
    minSwap(new int[]{5,6,3,7,5,2,9,1,1}, 3);
  }

}
