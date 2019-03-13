package arrays.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem003 {

  /**
   * O(n) time and space.
   * @param arr
   * @param k
   */
  public static void findPairsForGivenSum(int arr[], int k) {
    Set<Integer> set = new HashSet<Integer>();
    for(int i=0; i < arr.length; i++) {
      int element = arr[i];
      int pair = k - arr[i];
      if(set.contains(pair)) System.out.println(element + " : " + pair);
      set.add(element);
    }
  }

  public static void findPairsForGivenNumberSum1(int arr[], int k) {
    Arrays.sort(arr);
    int i=0, j=arr.length-1;

    while(i < j) {
      int sum = arr[i] + arr[j];
      if(sum < k) i++;
      else if(sum > k) j--;
      else {
        System.out.println(arr[i] + " : " + arr[j]);
        i++;
      }
    }
  }

  public static void main(String[] args) {
    int arr[] = new int[]{3,1,5,6,7,8,2,3,4};
    System.out.println(Arrays.toString(arr));
    findPairsForGivenSum(arr, 6);
    System.out.println();
    findPairsForGivenNumberSum1(arr, 6);

  }

}
