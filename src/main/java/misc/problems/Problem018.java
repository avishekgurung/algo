package misc.problems;

public class Problem018 {

  /**
   *
   * @param arr is the arr.
   * @param i is the index.
   * @param value is the added or subtracted.
   * @param k is the number to find.
   * @return
   */
  public static boolean fun(int arr[], int i, int value, int k) {
    if(i >= arr.length) return false;
    int add = 0;
    int sub = 0;
    if(i == 0) {
      add = sub = arr[i];
    }
    else {
      add = value + arr[i];
      sub = value - arr[i];
    }
    if(i == arr.length - 1 && (add == k || sub == k)) { //last element
      return true;
    }

    boolean addResult = fun(arr, i+1, add, k);
    boolean subResult = fun(arr, i + 1, sub, k);
    return addResult || subResult;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,1,1};
    System.out.println(fun(arr, 0, 0, -1));
    System.out.println(fun(arr, 0, 0, 1));
    System.out.println(fun(arr, 0, 0, 2));
    System.out.println(fun(arr, 0, 0, 3));
  }
  /**
   *  Consider this program like a binary tree. Let the give array be 1,2,3
   *
   *                     1
   *               |            |
   *              +2           -2
   *           |      |      |    |
   *          +3     -3     +3   -3
   *
   *  Take a root node value and pass it across the two children. Add and Sub the value with
   *  each children. Continue until we reach the leave which are elements with i == arr.length-1
   *  Now compare the value with k.
   *
   */
}
