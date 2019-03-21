package array.problems;

import java.util.Arrays;

public class Problem007 {

  /**
   * Sol 1. For every element, search throughout the array. O(n2)
   * Sol 2. Sort and find. O(nlogn)
   * Sol 3. Use hash map. O(n) for both time and space.
   * Sol 4. If elements are in range 0 to n-1 then use bucket sort approach. O(n) time and O(1) sp.
   * This approach allows us to get even the first duplicate element if present any. But if its
   * only about finding whether any duplicate element exists then the other soln is simpler.
   *
   * We can also approach this method by making an element negative and using the absolute value
   * as index.
   *
   * @param arr
   * @return
   */
  public static int hasDuplicate(int arr[]) {
    int n = arr.length;
    for(int i=0; i < n; i++) {
      int index = arr[i] % n;
      int element = arr[index];
      if(element/n >= 1) { //This condition can also be if(element >= n)
        return index;
      }
      arr[index] = arr[index] + n;
    }
    System.out.println("No duplicate elements");
    return -1;
  }

  /**
   * Find the duplicated by negating the value
   * @param arr
   * @return
   */
  public static int hasDuplicate1(int arr[]) {
    for(int i=0; i < arr.length; i++) {
      int element = Math.abs(arr[i]);
      if(arr[element] < 0) return element;
      arr[element] = -arr[element];
    }
    return -1;
  }

  /**
   * Since all the elements are in the range 0 to n-1 for an array of size n. If no duplicate
   * elements are present then these elements will be from 0 to n-1 but not in an order. We can
   * calculate their sum with the formulae n(n-1)/2 and compare with original sum.
   * @param arr
   * @return
   */
  public static boolean hasDuplicateSimpler(int arr[]) {
    int n = arr.length - 1;
    int expectedSum = (n*(n+1))/2;
    int observedSum = 0;
    for(int i=0; i < arr.length; i++) {
      observedSum = observedSum + arr[i];
    }
    return expectedSum != observedSum;
  }


  public static void main(String[] args) {
    int arr[] = new int[]{3,2,1,4,1};
    System.out.println(Arrays.toString(arr));
    System.out.println(hasDuplicateSimpler(arr));
    arr = new int[]{3,2,1,4,1};
    System.out.println("Has duplicate: " + hasDuplicate(arr));
    arr = new int[]{3,2,1,4,1};
    System.out.println("Has duplicate: " + hasDuplicate1(arr));

    System.out.println();
    arr = new int[]{4,1,2,3,0};
    System.out.println(Arrays.toString(arr));
    System.out.println(hasDuplicateSimpler(arr));
    arr = new int[]{4,1,2,3,0};
    System.out.println("Has duplicate: " + hasDuplicate(arr));
    arr = new int[]{4,1,2,3,0};
    System.out.println("Has duplicate: " + hasDuplicate1(arr));


    System.out.println();
    arr = new int[]{5,1,3,3,3,1};
    System.out.println(Arrays.toString(arr));
    System.out.println(hasDuplicateSimpler(arr));
    arr = new int[]{5,1,3,3,3,1};
    System.out.println("Has duplicate: " + hasDuplicate(arr));
    arr = new int[]{5,1,3,3,3,1};
    System.out.println("Has duplicate: " + hasDuplicate1(arr));
  }

}
