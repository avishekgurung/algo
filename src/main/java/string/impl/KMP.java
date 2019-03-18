package string.impl;

/**
 * Knuth Morris and Pratt algo has the best time complexity for searching a pattern
 * in a text. Let m be the pattern length and n be the text length.
 *
 * Space complexity = O(m)
 * Time complexity = O(m+n)
 */
public class KMP {

  public static int[] createPrefixTable(String pattern) {
    int m = pattern.length();
    int prefixTable[] = new int[m];
    int i=1,j=0;

    while(i < m) {
      if(pattern.charAt(i) == pattern.charAt(j)) {
        prefixTable[i] = prefixTable[j] + 1;
        i++;
        j++;
      }
      else if(j > 0) {
        j = prefixTable[j-1];
      }
      else {
        prefixTable[i] = 0;
        i++;
      }
    }
    return prefixTable;
  }

  public static int patternSearch(String text, String pattern) {
    int[] prefixTable = createPrefixTable(pattern);
    int m = pattern.length();
    int n = text.length();
    int i=0, j=0;
    while(i < n) {
      if(text.charAt(i) == pattern.charAt(j)) {
        if(j == m - 1) {
          return i - j;
        }
        i++;
        j++;
      }
      else if(j > 0) {
        j = prefixTable[j-1];
      }
      else {
        i++;
      }
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
