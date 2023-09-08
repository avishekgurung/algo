package array.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem001 {

  /**
   * Time O(n)
   * Space O(n)
   * @param arr
   */
  public static void solnBruteForce(int arr[]) {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    int winningCandidate = -1;
    int winningVotes = Integer.MIN_VALUE;

    for (int i=0; i < arr.length; i++) {
      int candidate = arr[i];
      if(map.get(candidate) != null) {
        map.put(candidate, map.get(candidate) + 1);
      }
      else {
        map.put(candidate, 1);
      }

      int votes = map.get(candidate);
      if(votes > winningVotes) {
        winningVotes = votes;
        winningCandidate = candidate;
      }
    }

    System.out.println("Candidate " + winningCandidate + " wins by " + winningVotes + " votes");
  }


  /**
   * Time O(n)
   * Space O(1)
   * Assumption: All the elements of an array are less than arr length
   * @param arr
   */
  public static void solnWithArrayIndex(int arr[]) {

    int len = arr.length;
    for(int i=0; i < arr.length; i++) {
      int index = arr[i] % len;
      arr[index] = arr[index] + len;
    }

    int winningCandidate = -1;
    int winningVotes = 0;
    int maxElement = Integer.MIN_VALUE;

    for(int i=0; i < arr.length; i++) { //since we know that the array is largely filled only from 1 to 5, so we can iterate only from 1 to 5 for better efficiency
      if(arr[i] > maxElement) {
        winningCandidate = i;
        winningVotes = arr[i] / len;
        maxElement = arr[i];
      }
    }
    System.out.println("Candidate " + winningCandidate + " wins by " + winningVotes + " votes");
  }


  public static void main(String[] args) {
    int sample1[] = {4,1,1,2,4,5,3,2,3,4,5,1,2,1,2,3,4,5,4,4,3,3,2,2,1,3,1,3,5,4,2,3};
    int sample2[] = {4,1,1,2,1};
    solnBruteForce(sample1);
    solnBruteForce(sample2);

    solnWithArrayIndex(sample1);
    solnWithArrayIndex(sample2);
  }

}
