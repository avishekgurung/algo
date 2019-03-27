package array.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * We will store the differences in an array and also store them in a
 * Map<Integer,List<Integer>></Integer>, so that the order is also maintained. We then sort the
 * array and store the values.
 *
 * Another simple approach to these kind of problems where the order is to be maintained,
 * we can use a Node with element, diff, and order (index). Create an array of them and sort them.
 * Such that if the differences are same then we would consider the index.
 */
public class Problem065 {

  public static void absoluteDifferenceSorting(int arr[], int k) {
    System.out.println(Arrays.toString(arr));
    SortedSet<Integer> set = new TreeSet<Integer>();
    int output[] = new int[arr.length];
    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    for(int i=0; i < arr.length; i++) {
      int diff = Math.abs(k - arr[i]);
      set.add(diff);

      List<Integer> list = map.get(diff);
      if(list == null) {
        list = new ArrayList<Integer>();
      }
      list.add(arr[i]);
      map.put(diff, list);
    }


    int j = 0;
    for(Integer key : set) {
      List<Integer> list = map.get(key);
      for(Integer ele : list) {
        output[j++] = ele;
      }
    }
    System.out.println(Arrays.toString(output));
    System.out.println();
  }

  public static void main(String[] args) {
    absoluteDifferenceSorting(new int[]{10, 5, 3, 9, 2}, 7);
    absoluteDifferenceSorting(new int[]{1, 2, 3, 4, 5}, 6);
  }

}
