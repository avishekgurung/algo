package dp.classical;

import java.util.HashSet;
import java.util.Set;

/**
 * Ref: https://www.youtube.com/watch?v=s6FhG--P7z0&t=481s
 */
public class Problem07 {

  public static void subsetSum(int elements[], int s) {
    int sum[] = new int[s + 1];
    for(int i=0; i < sum.length; i++) sum[i] = i;

    boolean dp[][] = new boolean[elements.length][s + 1];

    for(int i=0; i < elements.length; i++) {
      dp[i][0] = true;
    }

    for(int j=1; j < sum.length; j++) {
      if(sum[j] == elements[0]) {
        dp[0][j] = true;
      }
      else {
        dp[0][j] = false;
      }
    }

    //creating DP table
    for(int i=1; i < elements.length; i++) {
      for(int j=1; j < sum.length; j++) {
        if(elements[i] > sum[j]) { //keep the value same as the above row
          dp[i][j] = dp[i-1][j];
        }
        else {
          if(elements[i] == sum[j] || dp[i-1][j]) {
            dp[i][j] = true;
          }
          else {
            dp[i][j] = dp[i-1][j-elements[i]];
          }
        }
      }
    }

    //finding subset
    Set<Integer> subset = new HashSet<Integer>();
    int i = dp.length - 1;
    int j = dp[0].length - 1;

    while(i !=0 && j != 0) {
      if(dp[i][j]) {
        i--;
      }
      else {
        int element = elements[i+1];
        j = j - element;
        subset.add(element);
      }
    }

    if(dp[elements.length-1][sum.length - 1]) {
      System.out.println("The sum " + s + " CAN be formed from the subset");
      System.out.println("The subset is " + subset);
    }
    else {
      System.out.println("The sum " + s + " CANNOT be formed from the subset");
    }
    System.out.println("");

  }

  //We might have to sort the array first.
  public static void main(String[] args) {
    subsetSum(new int[]{2, 3, 7, 8, 10}, 11);
  }

}
