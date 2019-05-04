package dp.general;

public class Problem018 {

  private static class Node {
    int cost;
    int path;

    Node(int cost, int path) {
      this.cost = cost;
      this.path = path;
    }
  }

  public static Node maxAverage(int arr[][], int i, int j) {
    if(i >= arr.length || j >= arr.length || i < 0 || j < 0) return new Node(0,0);

    Node rightDirection = maxAverage(arr, i, j+ 1);
    Node downDirection = maxAverage(arr, i + 1, j);

    float rightAverage = 0;
    float downAverage = 0;

    if(rightDirection.path != 0) {
      rightAverage = (float)(rightDirection.cost / rightDirection.path);
    }

    if(downDirection.path != 0) {
      downAverage = (float)(downDirection.cost / downDirection.path);
    }

    int cost = 0;
    int path = 0;
    if(rightAverage > downAverage) {
      path = rightDirection.path + 1;
      cost = rightDirection.cost + arr[i][j];
    }
    else {
      path = downDirection.path + 1;
      cost = downDirection.cost + arr[i][j];
    }
    return new Node(cost, path);
  }

  public static void util(int arr[][]) {
    for(int i=0; i < arr.length; i++) {
      for(int j=0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

    Node node = maxAverage(arr, 0, 0);
    System.out.println("The maximum average is " + ((float)node.cost / node.path));
    System.out.println();
  }

  public static float maxAvg(int arr[][], int i, int j, int path, int sum) {
    int n = arr.length;
    if(i < 0 || j < 0 || i >= n || j >= n) return 0;
    if(i == n-1 && j== n-1) {
      return (float)sum / path;
    }
    float down = 0;
    float right = 0;
    if(j < n) right = maxAvg(arr, i, j+1, path+1, sum+arr[i][j]);
    if(i < n) down = maxAvg(arr, i+1, j, path+1, sum + arr[i][j]);
    return Math.max(right, down);
  }

  public static void maxAvgUtil(int arr[][]) {
    System.out.println(maxAvg(arr, 0, 0, 0, 0));
  }

  public static void main(String[] args) {
    maxAvgUtil(new int[][]{
        {1, 2},
        {4, 5}
    });
    maxAvgUtil(new int[][]{
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    });
  }

}
