package stacks;

import java.util.Arrays;
import java.util.Stack;

public class Problem013 {

  public static Stack<Integer> sort(Stack<Integer> stack) {
    Stack<Integer> aux = new Stack<Integer>();
    while(!stack.isEmpty()) {
      int ele = stack.pop();
      while(!aux.isEmpty() && aux.peek() < ele) {
        stack.push(aux.pop());
      }
      aux.push(ele);
    }
    return aux;
  }

  public static void sortByRecursion(Stack<Integer> stack) {
    if(stack.isEmpty()) return;
    int x = stack.pop();
    sortByRecursion(stack);
    helper(stack, x);
  }

  public static void helper(Stack<Integer> stack, int x) {
    if(stack.isEmpty()) {
      stack.push(x);
      return;
    }
    if(x > stack.peek()) {
      int y = stack.pop();
      helper(stack, x);
      stack.push(y);
    }
    else {
      stack.push(x);
    }
  }

  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(3);
    stack.push(5);
    stack.push(1);
    stack.push(4);
    stack.push(2);
    System.out.println(Arrays.toString(stack.toArray()));
    Stack<Integer> res = sort(stack);
    System.out.println(Arrays.toString(res.toArray()));

    System.out.println();
    stack = new Stack<Integer>();
    stack.push(3);
    stack.push(5);
    stack.push(1);
    stack.push(4);
    stack.push(2);
    System.out.println(Arrays.toString(stack.toArray()));
    sortByRecursion(stack);
    System.out.println(Arrays.toString(stack.toArray()));
  }

}
