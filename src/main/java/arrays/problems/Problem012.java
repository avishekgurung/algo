package arrays.problems;

public class Problem012 {

  public static void rowWithMax1s(int arr[][]) {
    int maxOnes = 0;
    int rowWithMaxOnes = 0;

    int i=0, j=0;

    while(i < arr.length && j < arr.length) {
      if(arr[i][j] == 1) {
        maxOnes++;
        rowWithMaxOnes = i;
        j++;
      }
      else if(arr[i][j] == 0) {
        i++;
      }
    }
    System.out.println("Row " + (rowWithMaxOnes) + " has maximum 1s with value " + maxOnes);

  }

  public static void rowWithMax0s(int arr[][]) {
    int maxZeroes = 0;
    int rowWithMaxZeroes = 0;

    int i=0, j=arr[0].length-1;

    while(i < arr.length && j >= 0) {
      if(arr[i][j] == 0) {
        maxZeroes++;
        rowWithMaxZeroes = i;
        j--;
      }
      else if(arr[i][j] == 1) {
        i++;
      }
    }
    System.out.println("Row " + (rowWithMaxZeroes) + " has maximum 0s with value " + maxZeroes);

  }

  public static void main(String[] args) {
    int arr[][] = new int[][] {
        {1,1,0,0,0},
        {1,1,1,1,0},
        {1,0,0,0,0},
        {1,1,1,0,0}
    };
    rowWithMax1s(arr);
    rowWithMax0s(arr);
  }

}
