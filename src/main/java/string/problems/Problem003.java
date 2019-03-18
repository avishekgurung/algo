package string.problems;

/**
 * We reverse the string and find the maximum substring between two strings.
 */
public class Problem003 {
  public static void main(String[] args) {
    maximumPalindrome("marradar", "radar");
  }

  public static void maximumPalindrome(String s1, String s2) {
    String reversedS2 = "";
    for(int i=0; i < s2.length(); i++) {
      reversedS2 = s2.charAt(i)+reversedS2;
    }
    Problem002.longestCommonSubstring(s1, reversedS2);
  }
}
