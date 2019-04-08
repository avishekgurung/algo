package dp.general;

import java.util.HashSet;
import java.util.Set;

public class Problem015 {
  /**
   * for a given set, it checks if the subset has this sum.
   */
  public static boolean subsetSum(int elements[], int s) {
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
          if(dp[i-1][j]) {
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

    return dp[elements.length-1][sum.length - 1];
  }

  public static void partitionProblem(int arr[]) {
    int sum = 0;
    for(int i=0; i < arr.length; i++) sum = sum + arr[i];

    //If sum is odd.
    if(sum % 2 == 1) {
      System.out.println("There cannot be two subsets with equal sum");
      return;
    }


    sum = sum / 2;

    boolean res = subsetSum(arr, sum);
    if(res) {
      System.out.println("Possible");
    }
    else {
      System.out.println("Impossible");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    partitionProblem(new int[]{1,5,11,5});
    partitionProblem(new int[]{1,5,11,6});
    partitionProblem(new int[]{1,5,11,7});
    //partitionProblem(new int[]{1,5,11,9});
  }
}
