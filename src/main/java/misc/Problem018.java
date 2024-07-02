package misc;

public class Problem018 {

  /**
   *
   * @param arr is the arr.
   * @param i is the index.
   * @param value is the added or subtracted.
   * @param k is the number to find.
   * @return
   */
  public static boolean fun(int arr[], int i, int value, int k) {
    if(i >= arr.length) return false;
    int add = 0;
    int sub = 0;
    if(i == 0) {
      add = sub = arr[i];
    }
    else {
      add = value + arr[i];
      sub = value - arr[i];
    }
    if(i == arr.length - 1 && (add == k || sub == k)) { //last element
      return true;
    }

    boolean addResult = fun(arr, i+1, add, k);
    boolean subResult = fun(arr, i + 1, sub, k);
    return addResult || subResult;
  }


    private static boolean utility(int arr[], int k, int ind) {
      if (ind == arr.length - 1) {
        if (arr[ind] == k || arr[ind] == -k) {
          return true;
        }
        return false;
      }
      else {
        Boolean result = (utility(arr, k - arr[ind], ind + 1));
        if (ind > 0 && !result) {
          return (utility(arr, k + arr[ind], ind + 1));
        }
        return result;
      }
    }

  public static void main(String[] args) {
    int arr[] = new int[]{1,1,1};
    /*System.out.println(fun(arr, 0, 0, -1));
    System.out.println(fun(arr, 0, 0, 1));
    System.out.println(fun(arr, 0, 0, 2));
    System.out.println(fun(arr, 0, 0, 3));*/

    arr = new int[]{1,2,3};

    System.out.println(utility(arr, 2, 0));

  }
  /**
   *  Consider this program like a binary tree. Let the give array be 1,2,3
   *
   *                     1
   *               |            |
   *              +2           -2
   *           |      |      |    |
   *          +3     -3     +3   -3
   *
   *  Take a root node value and pass it across the two children. Add and Sub the value with
   *  each children. Continue until we reach the leave which are elements with i == arr.length-1
   *  Now compare the value with k.
   *
   */

  /**
   *
   * #include<bits/stdc++.h>
   * using namespace std;
   *

  int solve(int id, int remK, vector<int> &arr, vector<vector<int>> &dp, int sum) {
   *if (id == (int) arr.size() - 1) {
   *return (remK == sum);
   *}
   *int &ans = dp[id][remK];
   *if (ans != -1)
   *return ans;
   *ans = solve(id + 1, remK - arr[id + 1], arr, dp, sum); // adding next
   *ans |= solve(id + 1, remK + arr[id + 1], arr, dp, sum); // sub next
   *return ans;
   *}
   *
           *

  bool isK(vector<int> arr, int k) {
   *int sum = 0;
   *for (int i : arr)
   *sum += i;
   *if (k > sum or k <-sum)
   *return false;
   *vector<vector<int>> dp (arr.size(), vector < int>(2 * sum + 1, -1));
   *return solve(0, sum + k - arr[0], arr, dp, sum);
   *}
   *
           *

  int main() {
   *vector<int> a = {1, 2, 3};
   *int k = -4;
   *
   *cout << isK(a, k);
   *}
   *
   *
   *
   * int dp[4][7]={0};
   * bool isKpossible(int arr[],int k,int n,int curr_sum=0)
   * {
   *     if(dp[n][curr_sum]!=0) return dp[n][curr_sum]==1?false:true;
   *     if(n==1)
   *     {
   *         if(curr_sum+arr[n-1]==k || curr_sum-arr[n-1]==k)
   *         {
   *             dp[n][curr_sum]=2;
   *             return true;
   *         }
   *         else
   *         {
   *             dp[n][curr_sum]=1;
   *             return false;
   *         }
   *     }
   *     bool ret_val=isKpossible(arr,k,n-1,curr_sum+arr[n-1]) || isKpossible(arr,k,n-1,curr_sum-arr[n-1]);
   *     dp[n][curr_sum]=(ret_val?2:1);
   *     return ret_val;
   * }
   *
   * int main()
   * {
   *     int arr[3]={1,1,1};
   *     cout<<isKpossible(arr,2,3,0);
   *     return 0;
   * }
   *
   */
}
