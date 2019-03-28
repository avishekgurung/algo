package array.problems;

/**
 * There are many simple solution but here we choose one element calculate its prefix and suffix.
 * Then we will keep going to the right decreasing suffix and increasing prefix.
 */
public class Problem078 {

  public static void equilibrium(int arr[]) {

    int prefix = arr[0];
    int suffix = 0;

    int index = 0;
    int maxSum = 0;

    for(int i=2; i < arr.length;i++) suffix = suffix + arr[i];

    int i = 1;
    for(i=1; i < arr.length - 1; i++) {
      if(suffix == prefix) {
        if(maxSum < prefix) {
          maxSum = prefix;
          index = i;
        }
      }
      prefix = prefix + arr[i];
      suffix = suffix - arr[i + 1];
    }

    System.out.println("The maximum sum is " + maxSum + " and equilibrium is at " + index);

  }

  public static void main(String[] args) {
    equilibrium(new int[]{-1, 2, 3, 0, 3, 2, -1});
    equilibrium(new int[]{-2, 5, 3, 1, 2, 6, -4, 2});
    equilibrium(new int[]{-2, 5, 3, 1, 2, 6, -4, 2});
  }
}
