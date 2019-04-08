package dp.general;

public class Problem003 {

  static int dp[][];

  public static int mining(int arr[][], int i, int j) {
    if(i < 0 || i >= arr.length) return 0;
    if(j == arr[0].length - 1) return arr[i][j];
    if(dp[i][j] != 0) return dp[i][j];

    int rightTopNeighbour = mining(arr, i - 1, j + 1);
    int rightNeighbour = mining(arr, i, j + 1);
    int rightBottomNeighbour = mining(arr, i + 1, j + 1);
    int neighbourWithMaxValue = Math.max(Math.max(rightTopNeighbour, rightNeighbour),
        rightBottomNeighbour);

    dp[i][j] = arr[i][j] + neighbourWithMaxValue;

    return dp[i][j];
  }

  public static void miningUtil(int arr[][]) {
    dp = new int[arr.length][arr.length];

    int maxGoldCollected = Integer.MIN_VALUE;
    for(int i=0; i < arr.length; i++) {
      int goldCollected = mining(arr, i, 0);
      maxGoldCollected = Math.max(goldCollected, maxGoldCollected);
    }

    System.out.println("Max gold collected is  " + maxGoldCollected);
  }

  public static void main(String[] args) {
    int arr[][] = new int[][]{
        {1, 3, 3},
        {2, 1, 4},
        {0, 6, 4}
    };
    miningUtil(arr);

    arr = new int[][]{
        {1, 3, 1, 5},
        {2, 2, 4, 1},
        {5, 0, 2, 3},
        {0, 6, 1, 2}
    };
    miningUtil(arr);

    arr = new int[][]{
        {10, 33, 13, 15},
        {22, 21, 04, 1},
        {5, 0, 2, 3},
        {0, 6, 14, 2}
    };
    miningUtil(arr);

  }

}
