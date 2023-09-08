package array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * We keep calculating the current sum and store them in a map.
 * If the current element is 0 then that element is also a subarray.
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

  /**
   * Max subarray with standard implementation. We take a sum and keep storing it in a map with its index.
   * At any point, if we encounter the same index, then it simply means that it had a negative number that
   * made it go down to 0 and again come up to same number.
   */

  private static void subarraysWithSum0(int arr[]) {
    System.out.println(Arrays.toString(arr));

    Map<Integer, List<Integer>> map = new HashMap<>();
    int sum = 0;
    for(int i=0; i < arr.length; i++) {
      sum = sum + arr[i];
      if(map.containsKey(sum)) {
        List<Integer> values = map.get(sum);
        values.add(i);
      }
      else {
        List<Integer> values = new ArrayList<>();
        values.add(i);
        map.put(sum, values);
      }
    }

    for(Integer _sum: map.keySet()) {
      List<Integer> indices = map.get(_sum);


      /**
       * We will have to handle special case for sum = 0.
       * If the key 0 has only one value, then the sum of all the arrays are 0, hence from 0 to arr.len - 1
       * if the key 0 has more than one values, eg 0 : [2,5], then the answers are [0,2],[0,5],[3,5]
       */
      if(_sum == 0 && indices.size() == 1) {
        System.out.println(0 + " : " + (arr.length - 1));
      }
      else if (sum == 0 && indices.size() > 1) {
        for(Integer index: indices) {
          System.out.println("0 : " + index);
        }

        for(int i=0; i < indices.size() - 1; i++) {
          for(int j=i+1; j < indices.size(); j++) {
            System.out.println(indices.get(i) + 1 + " : " + indices.get(j));
          }
        }

      }
      else if (indices.size() > 1) {
        for(int i=0; i < indices.size() - 1; i++) {
          for(int j=i+1; j < indices.size(); j++) {
            System.out.println(indices.get(i) + 1 + " : " + indices.get(j));
          }
        }
      }
    }

  }

  public static void main(String[] args) {
    subArrayWithSum0(new int[]{1,2,-3,1});
    System.out.println();

    subArrayWithSumZeroEfficient(new int[]{-4,2,-1,-1,2,-1,1});
    System.out.println();

    System.out.println();
    subarraysWithSum0(new int[]{-1, 0, -1, 0, 0, 1, 0});
  }

}
