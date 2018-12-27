package stacks.problems;

import java.util.Arrays;
import java.util.Stack;

public class Problem007 {

  public static void reverse(Stack<Integer> stack) {
    if(stack.isEmpty()) return;
    int x = stack.pop();
    reverse(stack);
    helper(stack, x);
  }

  private static void helper(Stack<Integer> stack, int x) {
    if(stack.isEmpty()) {
      stack.push(x);
      return;
    }

    int y = stack.pop();
    helper(stack, x);
    stack.push(y);
  }

  public static void main(String[] args) {

    Stack<Integer> stack = new Stack<Integer>();
    int arr[] = {1,2,3,4,5,6};
    for(int i=0; i<arr.length; i++) stack.push(arr[i]);
    System.out.println(Arrays.toString(stack.toArray()));

    reverse(stack);
    System.out.println(Arrays.toString(stack.toArray()));

  }

}
