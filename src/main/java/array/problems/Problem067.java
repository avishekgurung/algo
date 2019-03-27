package array.problems;

import java.util.Arrays;

/**
 * if current element is less than or equal to next element then do nothing.
 *
 * If current element is greater than the next element
 *  check if it can be swapped. If not, then return false.
 *  else swap the elements.
 *  Once swapped, check if the element is lesser than its previous element.
 *  If yes then move the pointer to previous element.
 */
public class Problem067 {

  public static boolean canArrayBeSorted(int arr[], int brr[]) {
    int i=0;

    while(i < arr.length - 1) {
      if(arr[i] <= arr[i+1]) {
        i++;
      }
      else {
        if(brr[i] == 1) {
          swap(arr, i, i+1);
          if(i >0 && arr[i-1] > arr[i]) {
            i--;
          }
        }
        else {
          return false;
        }
      }
    }
    return true;
  }


  private static void swap(int arr[], int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }

  public static void util(int arr[], int brr[]) {
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(brr));
    boolean sorted = canArrayBeSorted(arr, brr);
    System.out.println("The array can be sorted? " + sorted + "\n");
  }

  public static void main(String[] args) {
    util(new int[]{1, 2, 5, 3, 4, 6}, new int[]{0, 1, 1, 1, 0});
    util(new int[]{2, 3, 1, 4, 5, 6}, new int[]{0, 1, 1, 1, 1});
    util(new int[]{2, 3, 1, 4, 5, 6}, new int[]{1, 1, 1, 1, 1});
  }
}
