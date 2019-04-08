package dp.classical;

public class Problem04 {

  public static void editDistance(String s1, String s2) {
    s1 = '\0' + s1;
    s2 = '\0' + s2;
    int m = s1.length();
    int n = s2.length();
    int mem[][] = new int[m][n];

    for(int i=0; i < n; i++) {
      mem[0][i] = i;
    }

    for(int i=0; i < m; i++) {
      mem[i][0] = i;
    }

    for(int i=1; i < m; i++) {
      for(int j=1; j < n; j++) {
        if(s1.charAt(i) == s2.charAt(j)) {
          mem[i][j] = mem[i-1][j-1];
        }
        else {
          mem[i][j] = 1 + Math.min(mem[i-1][j-1], Math.min(mem[i-1][j],mem[i][j-1]));
        }
      }
    }

    System.out.println("The minimum number of insertions to convert " + s1 + " to " + s2 + " is "
        + mem[m-1][n-1]);

    /**Computing the result values.
     * Check from where we are getting the current result.
     * If the element of two strings are same then go diagonal and no change has to be done.
     * If the current position has come from above then we need to insert.
     * If the current position has come from diagonal then we need to replace.
     * If the current position has come from front then we need to remove.
     */

    int i = m-1;
    int j = n-1;
    while(i >=0 && j >= 0) {
      if(s1.charAt(i) == s2.charAt(j)) {
        i--;
        j--;
      }
      else {
        if(j > i) {
          if(mem[i][j-1] < mem[i][j]) { //go up
            System.out.println(s2.charAt(j) + " has to be inserted");
            j--;
          }
        }
        else {
          if(mem[i-1][j-1] < mem[i][j]) {
            System.out.println(s1.charAt(i) + " has to be replaced by " + s2.charAt(j));
            i--;
            j--;
          }
          else if(mem[i-1][j] < mem[i][j]) {
            System.out.println(s1.charAt(i) + " has to be removed");
            i--;
          }
        }
      }
    }
    System.out.println("");
  }

  public static void main(String[] args) {
    editDistance("abcdef", "azced");
    editDistance("ab", "amn");
  }

}
