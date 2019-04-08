package dp.general;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem014 {
  public static List<Character> lcs(String s1, String s2) {
    s1 = '\0' + s1;
    s2 = '\0' + s2;
    int mem[][] = new int[s1.length()][s2.length()];

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
    Collections.reverse(lcs);
    return lcs;
  }

  public static void shortestCommonSuperSequence(String s1, String s2) {
    List<Character> lcs = lcs(s1, s2);

    System.out.println("The size of the shortest common subsequence is " + (s1.length() +
        s2.length() - lcs.size()));

    //Find the shortestCommonSuperSequence.
    /**
     * There can be many super sequence. This method is the simplest.
     * Take both the strings and the lcs.
     * for ele in lcs:
     *  find all the elements before ele in first string and add to output string
     *  find all the elements before ele in second string and add to output string
     *  add ele to output string.
     */

    String output = "";
    int i=0, j=0;
    for(Character ele : lcs) {
      while(s1.charAt(i) != ele) {
        output = output + s1.charAt(i);
        i++;
      }

      while(s2.charAt(j) != ele) {
        output = output + s2.charAt(j);
        j++;
      }

      output = output + ele;
      i++;
      j++;
    }

    //adding the remaining ones
    while(i != s1.length()) {
      output = output + s1.charAt(i);
      i++;
    }

    while(j != s2.length()) {
      output = output + s2.charAt(j);
      j++;
    }

    System.out.println("The super sequence is " + output);
  }


  public static void main(String[] args) {
    shortestCommonSuperSequence("longest", "stoney");
  }
}
