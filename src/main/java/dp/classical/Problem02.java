package dp.classical;

import java.util.ArrayList;
import java.util.List;

/**
 * Ref: https://www.youtube.com/watch?v=sSno9rV8Rhg&t=1113s
 */
public class Problem02 {

  private static String s1;
  private static String s2;
  private static int mem[][];


  /**
   *  A simple recursion approach that takes exponential time complexity.
   */
  public static int longestCommonSubSequence(int i, int j) {
    if(i == s1.length() || j == s2.length()) return 0;
    if(s1.charAt(i) == s2.charAt(j)) {
      return 1 + longestCommonSubSequence(i+1, j+1);
    }
    else {
      return Math.max(longestCommonSubSequence(i+1, j),
          longestCommonSubSequence(i, j+1));
    }
  }

  /**
   * This is DP solution using memoization. This is top down approach where we
   * start storing the results of smallest sub-problems.
   * Being a top-down approach it gives us the optimal solution i.e the max length but it does
   * not give us the value of optimal solution i.e. the maximum subsequence
   */
  public static int topDown(int i, int j) {
    if(i == s1.length() || j == s2.length()) {
      mem[i][j] = 0;
      return 0;
    }

    if(mem[i][j] != 0) return mem[i][j];
    int res;

    if(s1.charAt(i) == s2.charAt(j)) {
      res = 1 + topDown(i + 1, j + 1);
    }
    else {
      res = Math.max(topDown(i+1, j), topDown(i,  j + 1));
    }
    mem[i][j] = res;
    return res;
  }


  public static void bottomUp() {
    s1 = '\0' + s1;
    s2 = '\0' + s2;
    mem = new int[s1.length()][s2.length()];

    //Filling the memoization matrix
    for(int i=1; i < s1.length(); i++) {
      for(int j=1; j < s2.length(); j++) {
        if(s1.charAt(i) == s2.charAt(j)) {
          mem[i][j] = 1 + mem[i-1][j-1];
        }
        else {
          mem[i][j] = Math.max(mem[i-1][j], mem[i][j-1]);
        }
      }
    }

    //Computing the longest subseqence
    int i = s1.length() - 1;
    int j = s2.length() - 1;
    int max = mem[i][j];
    List<Character> lcs = new ArrayList<Character>();

    while(i != 0 && j != 0) {
      if(mem[i][j] == mem[i-1][j]) {
        i--;
      }
      else {
        lcs.add(s1.charAt(i));
        i--;
        j--;
      }
    }
    System.out.println("The length of longest common substring of " + s1 + " and  " + s2 + " "
        + "is " + max + " and the substring is " + lcs);
  }



  public static void main(String[] args) {
    s1 = "longest";
    s2 = "stone";
    mem = new int[s1.length() + 1][s2.length() + 1];

    System.out.println("The length of longest common substring of " + s1 + " and  " + s2 + " "
        + "is " + longestCommonSubSequence(0, 0));

    System.out.println("The length of longest common substring of " + s1 + " and  " + s2 + " "
        + "is " + topDown(0, 0));

    bottomUp();
  }
}
