package array.problems;

import java.util.Arrays;

public class Problem059 {
  /**
   * We know that every single element irrespective of it value is defined as palindrome when its
   * in an array.
   * Eg, [1234] is a palindrome since the array element is only one.
   * [123,4,123] is also a palindrome.
   * [1,2,3,4] is not a palindrome. The simplest way to convert it into a palindrome is keep merging
   * the elements into another which will finally result in one element. And for us, single element
   * is a palindrome so it will be a result for us. But in this case, we are expected to find the
   * minimum number of merge.
   *
   * The approach we follow is to traverse array from the beginning and from the end using two
   * pointers. If the elements are same then we increment and decrement the pointers and no merging
   * is required. But if the elements are not same, then we follow the approach
   * arr[i] < arr[j]
   *  merge arr[i] into arr[i+1]
   *  i++
   * arr[j] < arr[i]
   *  merge arr[j] into arr[j-1]
   *  j--
   */

  public static void makeArrayPalindrome(int arr[]) {
    System.out.println(Arrays.toString(arr));
    int i = 0, j = arr.length - 1;
    int mergeOperations = 0;

    while(i <= j) {
      if(arr[i] == arr[j]) {
        i++;
        j--;
      }
      else if(arr[i] < arr[j]) {
        arr[i+1] = arr[i] + arr[i+1];
        i++;
        mergeOperations++;
      }
      else {
        arr[j-1] = arr[j] + arr[j-1];
        j--;
        mergeOperations++;
      }
    }
    System.out.println("Minimum merge operations required is " + mergeOperations+"\n");
  }

  public static void main(String[] args) {
    makeArrayPalindrome(new int[]{15, 4, 15});
    makeArrayPalindrome(new int[]{1, 4, 5, 1});
    makeArrayPalindrome(new int[]{11, 14, 15, 99});
  }

}
