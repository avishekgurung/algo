package array.problems;

import java.util.Stack;

public class Problem041 {

  public static void maxDiff(int arr[]) {
    Stack<Integer> stack = new Stack<Integer>();
    int maxDiff = 0;
    String pair = "";

    for(int i=0; i < arr.length; i++) {
      while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {

      }
    }
  }

}
