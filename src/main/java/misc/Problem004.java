package misc;

public class Problem004 {

  /**
   * Complexity = 2^n
   */
  public static void subsetSum(int arr[], int left, int right, int sum) {
    if(left > right) {
      System.out.println(sum);
      return;
    }

    System.out.println(left + " : " + right);

    subsetSum(arr, left + 1, right, sum + arr[left]);

    subsetSum(arr, left + 1, right, sum);
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,2,3};
    subsetSum(arr, 0, arr.length - 1, 0);
  }

}

