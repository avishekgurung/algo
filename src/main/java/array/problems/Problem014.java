package array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * We keep calculating the current sum and store them in a map.
 * If the current sum is 0 then the sub array is from 0 to current index
 * If the current sum has already been seen before then there is a subarray.
 *
 * Explanation. Consider an example -1,2,-1,-1.
 * We calculate current sum and store them in a map as -1,1,0,-1
 * Now when we encounter second -1, we can say that subarray from first encountered -1's index
 * till current index makes the total sum to 0. Consider the above case when we encounter -1 second
 * time. This means the sum of all the elements come to -1. And the map already has -1 which means
 * removing -1 from the total sum (which is also -1) will result in 0.
 *
 */
public class Problem014 {

  /**
   * This method is efficient but it does not hold some cases where there are many subarrays with
   * sum as 0. Eg, -4,2,-1,-1,2,-1,1 has many subarrays but it does not show all. So the more
   * efficient one is below.
   * @param arr
   */
  public static void subArrayWithSum0(int arr[]) {
    System.out.println(Arrays.toString(arr));
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int currentSum = 0;
    for(int i=0; i < arr.length; i++) {
      currentSum = currentSum + arr[i];

      if(arr[i] == 0) {
        System.out.println("Subarray " + i + " to " + i);
      }
      if(currentSum == 0) {
        System.out.println("Subarray 0 " + " to " + i);
      }

      if(map.get(currentSum) != null) {
        int index = map.get(currentSum);
        System.out.println("Subarray " + (index + 1) + " to " + i);
      }
      map.put(currentSum, i);
    }
  }

  public static void subArrayWithSumZeroEfficient(int arr[]) {
    System.out.println(Arrays.toString(arr));
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    int currentSum = 0;
    for(int i=0; i < arr.length; i++) {
      currentSum = currentSum + arr[i];

      if(arr[i] == 0) {
        System.out.println("Subarray " + i + " to " + i);
      }
      if(currentSum == 0) {
        System.out.println("Subarray 0 " + " to " + i);
      }

      if(map.get(currentSum) != null) {
        List<Integer> indices = map.get(currentSum);
        for(Integer index : indices) {
          System.out.println("Subarray " + (index + 1) + " to " + i);
        }
      }
      if(map.get(currentSum) == null) {
        List<Integer> indices = new ArrayList<Integer>();
        indices.add(i);
        map.put(currentSum, indices);
      }
      else {
        List<Integer> indices = map.get(currentSum);
        indices.add(i);
        map.put(currentSum, indices);
      }
    }
  }

  public static void main(String[] args) {
    subArrayWithSum0(new int[]{1,2,-3,1});
    System.out.println();

    subArrayWithSumZeroEfficient(new int[]{-4,2,-1,-1,2,-1,1});
    System.out.println();
  }

}
