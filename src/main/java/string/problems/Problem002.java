package string.problems;

/**
 * The best implementation is by using suffix trees that will take O(m+n).
 * Here the soln is O(m*n)
 */
public class Problem002 {

  public static void longestCommonSubstring(String s1, String s2) {
    s1 = '\0' + s1;
    s2 = '\0' + s2;
    int n = s1.length();
    int m = s2.length();
    int dp[][] = new int[n][m];

    int x = 0, y=0;
    int max = 0;

    for(int i=1;i < n; i++) {
      for(int j=1; j < m; j++) {
        if(s1.charAt((i)) == s2.charAt(j)) {
          dp[i][j] = dp[i-1][j-1] + 1;

          if(max < dp[i][j]) {
            max = dp[i][j];
            x = i;
            y = j;
          }
        }
      }
    }

    System.out.println("The length of longest common substring is " + max);
    String substring = "";
    while(dp[x][y] != 0) {
      substring = s1.charAt(x) + substring;
      x--;
      y--;
    }
    System.out.println("The substring is " + substring);
  }

  public static void main(String[] args) {
    longestCommonSubstring("avishek", "avinash");
    longestCommonSubstring("ababcd", "aabcad");
    longestCommonSubstring("abcd", "abcd");
    longestCommonSubstring("marradar", "radar");
  }

}
