package stacks;

import java.util.Stack;

public class Problem005 {

  private static class MyStack {

    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> aux = new Stack<Integer>();

    public Stack<Integer> push(int ele) {
      stack.push(ele);
      if(aux.isEmpty()) {
        aux.push(ele);
      }
      else {
        if(aux.peek() >= ele) {
          aux.push(ele);
        }
      }
      return stack;
    }

    public int pop() {
      int popped = stack.pop();
      if(popped == aux.peek()) {
        aux.pop();
      }
      return popped;
    }

    public int getMinimum() {
      return aux.peek();
    }

    public boolean isEmpty() {
      return stack.isEmpty();
    }

  }

  public static void main(String[] args) {
    MyStack stack = new MyStack();

    int arr[] = {3,5,2,1,1,-1};
    for(int i=0; i < arr.length; i++) {
      stack.push(arr[i]);
      System.out.println("Pushed:" + arr[i] + " Min: " + stack.getMinimum());
    }
    System.out.println();
    while(!stack.isEmpty()){
      int min = stack.getMinimum();
      int popped = stack.pop();
      System.out.println("Popped:" + popped + " Min: " + min);
    }

  }

}
