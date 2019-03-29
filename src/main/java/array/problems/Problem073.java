package array.problems;

import java.util.Arrays;

public class Problem073 {

  /**
   * The worst complexity is O(m*n) when all elements of arr is greater than all elements of brr.
   * Else it will lesser.
   *
   * The approach is to use insertion sort kind of technique where we pick element from one
   * array and insert into another array.
   *
   * Lets take arrays
   *  a = [1, 5, 9, 10, 15, 20]
   *  b = [2, 3, 8, 13]
   *
   *  We will pick last element of b and insert into correct position in a. Now while searching
   *  for a correct position we ll keep shifting elements to the right in a. So when correct
   *  position is found, the element is inserted into that position. And also, since the
   *  elements of a are shifted towards right, so the last element is out of place. We place
   *  this last element of a into the position of the element of b.
   *
   *  Lets take e = 13.
   *  We search for an element which is just higher than 13, which is 10 in our case.
   *  We start this search from the last element of array a.
   *  When we find 10, we insert 13 in position of 10. Since we are shifting elements while
   *  searching so 20 will be out of place. We will now insert 20 in place of 13.
   *
   *  Doing so will sort both the arrays simultaneously.
   *
   *  Focus on the logic and not on the code.
   *
   *
   */
  public static void mergeSortedArrays(int arr[], int brr[]) {
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(brr));

    int len_a = arr.length;
    int len_b = brr.length;

    for(int i=len_b-1; i >=0; i--) {
      int key = brr[i];

      int last = arr[len_a - 1];
      int j = len_a - 1;
      while(j >=0 && key < arr[j]) {
        arr[j] = arr[j - 1];
        j--;
      }

      if(j != len_a - 1 && last > key) {
        brr[i] = last;
        arr[j + 1] = key;
      }
    }


    Arrays.sort(brr);
    System.out.println();
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(brr));
    System.out.println("-------------------");

  }

  public static void main(String[] args) {
    mergeSortedArrays(new int[]{1, 5, 9, 10, 15, 20}, new int[]{2, 3, 8, 13});
  }

}
