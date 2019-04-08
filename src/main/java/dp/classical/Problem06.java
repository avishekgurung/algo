package dp.classical;

import java.util.ArrayList;
import java.util.List;

public class Problem06 {

  public static int longestPath(int arr[][], int mem[][], int i, int j) {
    int n = arr.length;
    if(i < 0 || i >= n || j < 0 || j >= n) return 0;
    if(mem[i][j] != -1) {
      return mem[i][j];
    }

    if(i < n-1 && arr[i][j] + 1 == arr[i+1][j]) {
      mem[i][j] = longestPath(arr, mem, i+1, j) + 1;
    }
    else if(i > 0 && arr[i][j] + 1 == arr[i-1][j]) {
      mem[i][j] = longestPath(arr, mem, i-1, j) + 1;
    }
    else if(j < n-1 && arr[i][j] + 1 == arr[i][j+1]) {
      mem[i][j] = longestPath(arr, mem , i, j+1) + 1;
    }
    else if(j > 0 && arr[i][j] + 1 == arr[i][j-1]) {
      mem[i][j] = longestPath(arr, mem, i, j-1) + 1;
    }
    else {
      mem[i][j] = 1; //For elements that does not have path in any four directions.
    }
    return mem[i][j];
    /**
     * Check the edge condition. The else if block should be replaced by if.
     * See problem 11 of General DP of Max Snake sequence.
     */
  }


  public static void longestPathUtil(int arr[][]) {
    int m = arr.length, n = arr[0].length;
    int mem[][] = new int[m][n];

    for(int i=0; i < m; i++) {
      for(int j=0; j < n; j++) {
        mem[i][j] = -1;
      }
    }


    for(int i=0; i < m; i++) {
      for(int j=0; j < n; j++) {
        longestPath(arr, mem, i, j);
        //result can be evaluated here as well.
      }
    }
    evaluateResult(arr, mem);
  }

  public static void evaluateResult(int arr[][], int mem[][]) {
    int maxPath = Integer.MIN_VALUE;
    int x=0, y=0;
    int m = arr.length;
    int n = arr[0].length;

    for(int i=0; i < arr.length; i++) {
      for(int j=0; j < arr[0].length; j++) {
        if(mem[i][j] > maxPath) {
          maxPath = mem[i][j];
          x = i;
          y = j;
        }
      }
    }

    List<Integer> elements = new ArrayList<Integer>();
    while(true) {
      elements.add(arr[x][y]);
      if(x < n-1 && arr[x][y] + 1 == arr[x+1][y]) {
        x= x + 1;
      }
      else if(x > 0 && arr[x][y] + 1 == arr[x-1][y]) {
        x = x - 1;
      }
      else if(y < n-1 && arr[x][y] + 1 == arr[x][y+1]) {
        y = y + 1;
      }
      else if(y > 0 && arr[x][y] + 1 == arr[x][y-1]) {
        y = y - 1;
      }
      else break;
    }

    System.out.println("The longest path in a matix is " + maxPath);
    System.out.println("The path is " + elements);
    System.out.println();
  }


  public static void main(String[] args) {
    int arr[][] = {
        {1, 2, 9},
        {5, 3, 8},
        {4, 6, 7}
    };
    longestPathUtil(arr);

    arr = new int[][] {
        {2, 3},
        {1, 4}
    };
    longestPathUtil(arr);

    arr = new int[][] {
        {23, 24},
        {22, 20}
    };
    longestPathUtil(arr);
  }

}
