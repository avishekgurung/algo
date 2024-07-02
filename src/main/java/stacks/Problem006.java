package stacks;

import java.util.Arrays;
import java.util.Stack;

public class Problem006 {

  private static class MyStack {

    private Stack<Integer> stack = new Stack<Integer>();
    int minElement;

    public Stack<Integer> push(int x) {

      if(stack.isEmpty()) {
        minElement = x;
        stack.push(x);
      }
      else {
        int eleToPush;
        if(x >= minElement) {
          eleToPush = x;
        }
        else {
          eleToPush = 2 * x - minElement;
          minElement = x;
        }
        stack.push(eleToPush);
      }
      return stack;
    }


    public int pop() {
      int y = stack.pop();
      int eleToReturn;
      if(y >= minElement) {
        eleToReturn = y;
      }
      else {
        eleToReturn = minElement;
        minElement = 2 * minElement - y;
      }
      return eleToReturn;
    }

    public boolean isEmpty() {
      return stack.isEmpty();
    }

    public int getMinimum() {
      return minElement;
    }

    public Object[] viewStack() {
      return stack.toArray();
    }
  }

  public static void main(String[] args) {
    MyStack stack = new MyStack();

    int arr[] = {5,3,4,2};
    for(int i=0; i < arr.length; i++) {
      stack.push(arr[i]);
      System.out.println("Pushed:" + arr[i] + " Min:" + stack.getMinimum() + "\tInternal Stack: " +
          Arrays.toString(stack.viewStack()));
    }
    System.out.println();
    while(!stack.isEmpty()){
      int min = stack.getMinimum();
      int popped = stack.pop();
      System.out.println("Popped:" + popped + " Min: " + min+ "\tInternal Stack: " +
          Arrays.toString(stack.viewStack()));
    }
  }
}

/**
 * The logic here is out of the box.
 *
 * Push
 *
 *  Let 'x' be an element to be pushed into the stack.
 *  if stack is empty:
 *    we push x into the stack
 *    we keep x as min element
 *
 *  if stack is not empty:
 *    if x >= minElement:
 *      push x to stack
 *    if x < minElement
 *      minElement = x
 *      push (2*x-minElement) into the stack
 *
 * Pop
 *
 *  Let y be an element popped from the stack
 *  if y >= minElement
 *    we return y as the popped out element
 *  if y < minElement
 *    we return minElement as popped out element
 *    minElement = 2*minElement - y
 *
 */
