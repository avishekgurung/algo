package array.problems;

import java.util.Arrays;

/**
 * The naive solution is to sort the array and swap the alternate element which takes
 * O(nlogn). But this can be done in O(n) as well.
 *
 * The desired array is of the form where the elements in the even index should always be greater
 * than its previous and next elements (which are elements of odd index actually).
 *
 * Or elements in the odd index should always be lesser than its prev and next element.
 *
 * We follow this approach until this condition is satisfied. We take only the even elements and
 * keep swapping with its neighbours until the even element is larger than its neighbour.
 *
 *
 */
public class Problem066 {

  public static void waveFormSort(int arr[]) {
    System.out.println(Arrays.toString(arr));
    for(int i=0; i < arr.length; i+=2) {

      if(i == 0) {
        if(arr[i] < arr[i + 1]) {
          swap(arr, i, i+1);
        }
      }
      else {
        if(arr[i] < arr[i + 1]) {
          swap(arr, i, i+1);
        }
        if(arr[i] < arr[i - 1]) {
          swap(arr, i, i-1);
        }
      }
    }

    System.out.println(Arrays.toString(arr) + "\n");
  }

  private static void swap(int arr[], int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public static void main(String[] args) {
    waveFormSort(new int[]{10, 5, 6, 3, 2, 20, 100, 80});
    waveFormSort(new int[]{3, 6, 5, 10, 7, 20});
  }

}
