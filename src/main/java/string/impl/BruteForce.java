package string.impl;

public class BruteForce {

  public static int patternSearch(String text, String pattern) {
    int n = text.length(), m = pattern.length();

    for(int i=0; i < n - m; i++) {
      int count = 0;
      for(int j = 0; j < m; j++) {
        if(text.charAt(i + j) != pattern.charAt(j)) break;
        count++;
      }
      if(count == m) return i;
    }
    return -1;
  }

  public static void patternSearchUtil(String text, String pattern) {
    System.out.println("Text: " + text);
    System.out.println("Pattern: " + pattern);
    System.out.println("Search: " + patternSearch(text, pattern));
    System.out.println();
  }

  public static void main(String[] args) {
    patternSearchUtil("abcabaabcde","abcd" );
    patternSearchUtil("avishek", "vis");
  }

}
