package misc;

public class Problem016 {

  public static void islandCheck(int arr[][], int i, int j) {
    int n = arr.length;
    int m = arr[0].length;

    if(i >= arr.length || j >= arr[0].length || i < 0 || j < 0) return;

    arr[i][j] = 2;

    //top
    if(i > 0 && arr[i-1][j] == 1) {
      islandCheck(arr, i-1, j);
    }

    //bottom
    if(i < n-1 && arr[i+1][j] == 1) {
      islandCheck(arr, i+1, j);
    }

    //left
    if(j > 0 && arr[i][j-1] == 1) {
      islandCheck(arr, i, j-1);
    }

    //right
    if(j < m-1 && arr[i][j+1] == 1) {
      islandCheck(arr, i, j + 1);
    }

    //top left
    if(i > 0 && j > 0 && arr[i-1][j-1] == 1) {
      islandCheck(arr, i-1, j-1);
    }

    //top right
    if(i > 0 && j < m-1 && arr[i-1][j+1] == 1) {
      islandCheck(arr, i-1, j+1);
    }

    //bottom left
    if(i < n-1 && j > 0 && arr[i+1][j-1] == 1) {
      islandCheck(arr, i+1, j-1);
    }

    //bottom right
    if(i < n-1 && j < m - 1 && arr[i+1][j+1] == 1) {
      islandCheck(arr, i+1, j+1);
    }
  }

  public static void util(int arr[][]) {
    for(int i=0; i < arr.length; i++) {
      for(int j=0; j < arr[0].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }

    int count = 0;

    for(int i=0; i < arr.length; i++) {
      for(int j=0; j < arr[0].length; j++) {
        if(arr[i][j] == 1) {
          islandCheck(arr, i, j);
          count++;
        }
      }
    }
    System.out.println("\nThe total number of islands are " + count);
  }

  public static void main(String[] args) {
    util(new int[][]{
        {1, 1, 0, 0, 0},
        {0, 1, 0, 0, 1},
        {1, 0, 0, 1, 1},
        {0, 0, 0, 0, 0},
        {1, 0, 1, 0, 1}
    });
  }

}
