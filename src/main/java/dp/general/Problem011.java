package dp.general;

public class Problem011 {

  public static int maxSeqLength(int arr[][], int i, int j) {
    if(i < 0 || j < 0 || i >= arr.length || j >= arr.length) {
      return 0;
    }
    int rightLength = 0;
    int bottomLength = 0;

    if(j < arr.length - 1 && (arr[i][j] + 1 == arr[i][j+1] || arr[i][j] - 1 == arr[i][j+1])) {
      rightLength = maxSeqLength(arr, i, j + 1);
    }
    if(i < arr.length - 1 && (arr[i][j] + 1 == arr[i + 1][j] || arr[i][j] - 1 == arr[i + 1][j])) {
      bottomLength = maxSeqLength(arr, i + 1, j);
    }
    return Math.max(rightLength, bottomLength) + 1;
  }

  public static void maxSeqLengthUtil(int arr[][]) {
    printArray(arr);
    int maxLength = 0;
    for(int i=0; i < arr.length; i++) {
      for(int j=0; j < arr.length; j++) {
        maxLength = Math.max(maxLength, maxSeqLength(arr, i, j));
      }
    }
    System.out.println("The maximum length is " + maxLength + "\n");
  }

  public static void printArray(int arr[][]) {
    for(int i=0; i < arr.length; i++) {
      for(int j=0; j < arr[i].length; j++) {
        System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int arr[][] = new int[][]{
        {9,10},
        {8,7}
    };
    maxSeqLengthUtil(arr);

    arr = new int[][]{
        {1,3},
        {5,9}
    };
    maxSeqLengthUtil(arr);


    arr = new int[][]{
        {9, 6, 5, 2},
        {8, 7, 6, 5},
        {7, 3, 1, 6},
        {1, 1, 1, 7}
    };
    maxSeqLengthUtil(arr);
  }

}
