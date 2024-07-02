package dp.classical;

import java.util.*;

/**
 * Ref: https://www.youtube.com/watch?v=CE2b_-XfVDk&t=147s
 */
public class Problem03 {

/*  private static int lis(int arr[], int index, Map<Integer, Integer> lookup) {
    if(index >= arr.length) return 0;
    if(index > 0 && arr[index-1] > arr[index]) return 0;
    if(lookup.containsKey(index)) return lookup.get(index);
    int result = Integer.MIN_VALUE;

    for(int i=index; i < arr.length; i++) {
      result = Math.max(result, lis(arr, i + 1, lookup));
    }
    lookup.put(index, result + 1);
    return result + 1;
  }*/

  private static int lis(int arr[], int index, Integer prev) {
    if(index >= arr.length) {
      return 0;
    }
    int current = arr[index];
    /*if(prev >= arr[index]) {
      return 0;
    }*/
    int result = 0;
    for(int i=index; i < arr.length; i++) {
      result = Math.max(result, lis(arr, i+1, arr[index]));
    }
    if(prev != null && prev < arr[index]) result++;
    //result = result + 1;
    return result;
  }


  private static int maxResult = 0;
  private static void lis1(int arr[], int index, Integer prev, int result, Map<String, Integer> map) {
    if(index >= arr.length) return;
    if(prev != null && prev >= arr[index]) {
      result = 0;
    }
    if(map.containsKey(index)) return;
    maxResult = Math.max(maxResult, result);

    for(int i=index; i < arr.length; i++) {
      lis1(arr, i+1, arr[index], result + 1, map);
    }
  }

  private static int test(int[] arr, int index, Integer prev, int carry) {
    if(index >= arr.length) return carry;
    int result = carry;
    if(prev != null && prev > arr[index]) {
      result = 0;
    }

    for(int i=index; i < arr.length; i++) {
      result = Math.max(result, test(arr, i+1, arr[index], carry+1));
    }

    return Math.max(carry, result) + 1;
  }


  public static void main(String[] args) {
    //System.out.println(lis(new int[]{4,3,6,4,8,6,7}, 0, new HashMap<>()));;
    //System.out.println(lis(new int[]{6,7,1,3}, 0, new HashMap<>()));
    //System.out.println(lis(new int[]{20,100,10,12,5,13}, 0, new HashMap<>()));
    //System.out.println(lis(new int[]{6,7,1,2}, 0, new HashMap<>()));;
    //System.out.println(lis(new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80}, 0, new HashMap<>()));;
    //System.out.println(lis(new int[]{4,5,1,2}, 0, null));

    lis1(new int[]{7,7,7,7,7,7,7}, 0, null, 0, new HashMap<>());
    //lis1(new int[]{20,100,10,12,5,13}, 0, null, 0);
    System.out.println(maxResult+1);

    //System.out.println(test(new int[]{20,100,10,12,5,13}, 0, null, 0));

  }

}
