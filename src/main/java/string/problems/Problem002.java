package string.problems;

/**
 * The best implementation is by using suffix trees that will take O(m+n).
 * Here the soln is O(m*n)
 */
public class Problem002 {

  public static void longestCommonSubstring(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();
    int arr[][] = new int[n+1][m+1];
    int max = 0;
    int x = 0, y = 0;

    for(int i=1; i < n + 1; i++) {
      for(int j=1; j < m + 1; j++) {
        if(s1.charAt(i-1) == s2.charAt(j-1)) {
          arr[i][j] = arr[i-1][j-1] + 1;

          if(arr[i][j] > max) {
            max = arr[i][j];
            x = i;
            y = j;
          }
        }
      }
    }

    int rightIndex = x - 1;
    int leftIndex = 0;

    while(arr[x][y] != 1) {
      x--;
      y--;
    }
    leftIndex = x - 1;
    System.out.println("The string is '" + s1.substring(leftIndex, rightIndex + 1)
        + "' of size " + max);
  }

  public static void main(String[] args) {
    longestCommonSubstring("avishek", "avinash");
    longestCommonSubstring("ababcd", "aabcad");
    longestCommonSubstring("abcd", "abcd");
    longestCommonSubstring("marradar", "radar");
  }

}
