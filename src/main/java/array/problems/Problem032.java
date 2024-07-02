package array.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem032 {

  public static void fill(int index, int arr[]) {
    if(arr[index] == index) {
      return;
    }
    if(arr[index] == -1) {
      return;
    }
    int element = arr[index];
    int temp = arr[element];
    arr[element] = element;
    arr[index] = temp;
    fill(index, arr);
  }

  public static void rearrange(int arr[]) {
    System.out.println(Arrays.toString(arr));
    for(int i=0; i < arr.length; i++) {
      fill(i, arr);
    }
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }

  public static void main(String[] args) {
    rearrange(new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1});
    rearrange(new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
        11, 10, 9, 5, 13, 16, 2, 14, 17, 4});
    rearrange1(new int[]{-1, -1, 6, 1, 9, 3, 2, -1, 4, -1});
    rearrange1(new int[]{19, 7, 0, 3, 18, 15, 12, 6, 1, 8,
            11, 10, 9, 5, 13, 16, 2, 14, 17, 4});
  }

  /**
   * A simple solution with O(n) time and space complexity
   */

  private static void rearrange1(int arr[]) {
    System.out.println(Arrays.toString(arr));
    Set<Integer> set = new HashSet<>();
    for(int i=0; i < arr.length; i++) set.add(arr[i]);

    for(int i=0; i < arr.length; i++) {
      if(set.contains(i)) {
        arr[i] = i;
      }
      else {
        arr[i] = -1;
      }
    }
    System.out.println(Arrays.toString(arr));
    System.out.println();
  }
}
