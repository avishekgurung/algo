package misc.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * The naive approach would take n^4. So we will optimize it to use n^2
 */
public class Problem008 {

  public static void sumOfPairs(int arr[]) {
    System.out.println(Arrays.toString(arr));
    Map<Integer, String> map = new HashMap<Integer, String>();

    for(int i=0; i < arr.length - 1; i++) {
      for(int j=i+1; j < arr.length; j++) {
        int sum = arr[i] + arr[j];
        if(map.containsKey(sum)) {
          System.out.println(arr[i] + " + " + arr[j] + " = " + map.get(sum) + "\n");
          return;
        }
        map.put(sum, arr[i] + " + " + arr[j]);
      }
    }
    System.out.println("No pairs found\n");
  }

  public static void main(String[] args) {
    sumOfPairs(new int[]{3, 4, 7, 1, 2, 9, 8});
    sumOfPairs(new int[]{3, 4, 7, 1, 12, 9});
    sumOfPairs(new int[]{65, 30, 7, 90, 1, 9, 8});
    sumOfPairs(new int[]{1, 2, 3, 4, 100, 200, 300, 400});
  }
}
