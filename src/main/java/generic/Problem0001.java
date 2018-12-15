package generic;

import java.util.Stack;

public class Problem0001 {

  public static void main(String[] args) {
    int arr[] = {4,5,3,7,8,5,1,2};

    Stack<Integer> stack = new Stack<Integer>();
    stack.push(arr[0]);

    for(int i=1; i < arr.length; i++) {

      while(!stack.empty() && stack.peek() < arr[i]) {
        System.out.println(stack.pop() + " -> " + arr[i]);
      }
      stack.push(arr[i]);
    }
  }
}
