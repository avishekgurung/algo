package misc.problems;

public class Problem003 {

  public static boolean isSafe(int board[][], int row, int col) {
    int n = board.length;

    //check vertical line
    for(int i=0; i < board.length; i++) {
      if(i == row) continue;
      if(board[i][col] == 1) return false;
    }

    //check horizontal line
    for(int j=0; j < n; j++) {
      if(j == col) continue;
      if(board[row][j] == 1) return false;
    }

    //check north east
    for(int i=row-1, j=col+1; i >=0  && j < n; i--, j++) {
      if(board[i][j] == 1) return false;
    }

    //check south east
    for(int i=row+1, j=col+1; i < n && j < n; i++, j++) {
      if(board[i][j] == 1) return false;
    }

    //check north west
    for(int i=row-1, j=col-1; i >=0 && j >=0; i--,j--) {
      if(board[i][j] == 1) return false;
    }

    //check south west
    for(int i=row+1, j=col-1; i<n && j >=0; i++,j--) {
      if(board[i][j] == 1) return false;
    }

    return true;
  }

  public static boolean nQueen(int board[][], int row) {
    if(row == board.length) return true;

    for(int j=0; j < board.length; j++) {
      if(isSafe(board, row, j)) {
        board[row][j] = 1;

        boolean nextPlacement = nQueen(board, row + 1);
        if(nextPlacement) return true;
        board[row][j] = 0;
      }
    }
    return false;
  }

  public static void displayResult(int board[][]) {
    int n = board.length;
    for(int i=0; i < n; i++) {
      for(int j=0; j < n; j++) {
        System.out.print(board[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void util(int board[][]) {
    int n = board.length;
    boolean result = nQueen(board, 0);
    if(result) {
      System.out.println(n + " queens can be placed in following arragement");
      displayResult(board);
    }
    else {
      System.out.println("Not possible to place " + n + " queens in " + n + " X " + n + " board");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    util(new int[3][3]);
    util(new int[4][4]);
    util(new int[2][2]);
    util(new int[5][5]);
    util(new int[8][8]);
    util(new int[16][16]);
  }

}
