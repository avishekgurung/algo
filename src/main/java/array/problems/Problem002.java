package array.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem002 {

  public static int firstRepeatingElement(int arr[]) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    for(int i=0; i < arr.length; i++) {
      if(map.get(arr[i]) == null) {
        map.put(arr[i], 1);
      }
      else {
        map.put(arr[i], map.get(arr[i]) + 1);
      }
    }

    for(int i=0; i < arr.length; i++) {
      if(map.get(arr[i]) >= 2) return arr[i];
    }
    return -1;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{3,2,1,2,2,3};
    System.out.println(Arrays.toString(arr));
    System.out.println("First repeating element " + firstRepeatingElement(arr));

    System.out.println();
    arr = new int[]{3,2,1,4,5};
    System.out.println(Arrays.toString(arr));
    System.out.println("First repeating element " + firstRepeatingElement(arr));

    System.out.println();
    arr = new int[]{3,4,1,4,5};
    System.out.println(Arrays.toString(arr));
    System.out.println("First repeating element " + firstRepeatingElement(arr));
  }
}
