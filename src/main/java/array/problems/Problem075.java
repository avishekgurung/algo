package array.problems;

import java.util.Arrays;

/**
 * We can easily search an element in O(n) but this problem is find an efficient way to search.
 *
 * Say we have an array where every element differs by 1. Then to search any element, we can
 * consider the first element.  Eg,
 *
 * arr = [8,7,6,5,4,3]. In this array, to reach any element (say 3) from 8 we can subtract that
 * element from 8. This is the best case scenario. But if the array is jumbled (but still has a
 * diff of
 * 1 between the elements),like [8,7,6,8,7,6,5,4,3,4], still we would take minimum(8-element) steps
 * to reach the element. So rather than going one step at a time, we will directly jump to 8-element
 * step and search. If not found, we will again do the same.
 *
 * Likewise, if the elements differ by k, let k be 3.
 * arr = [1,4,7,10,13]. To reach any element, the min steps required would be (element - 1)/3. So
 * we will directly jump to this element and if not found we will repeat the steps again.
 *
 * Time = O(n/k)
 */
public class Problem075 {

  public static void searchElementWithKSteps(int arr[], int k, int element) {
    System.out.println(Arrays.toString(arr));
    System.out.println("k = " + k + ", element = " + element);
    int i = 0;

    while( i < arr.length ) {
      if(arr[i] == element) break;
      i = i + Math.max(1,Math.abs(arr[i] - element)/k);
    }
    if(i == arr.length) System.out.println("Element not found");
    else System.out.println("Element found at " + i + "\n");
  }

  public static void main(String[] args) {
    searchElementWithKSteps(new int[]{8, 7, 6, 7, 6, 5, 4, 3, 2, 3, 4, 3}, 1, 3);
    //searchElementWithKSteps(new int[]{2, 4, 5, 7, 7, 6}, 2, 6);
    searchElementWithKSteps(new int[]{20, 40, 50, 70, 70, 60}, 20, 60);
  }

}
