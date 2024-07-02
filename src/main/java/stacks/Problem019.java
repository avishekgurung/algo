package stacks;

import java.util.Arrays;
import java.util.Stack;

public class Problem019 {

  public static void nextGreaterElement(int arr[]) {
    Stack<Integer> stack = new Stack<Integer>();
    for(int i=0; i < arr.length; i++) {
      while(!stack.isEmpty() && stack.peek() < arr[i]) {
        System.out.println(stack.pop() + " -> " + arr[i]);
      }
      stack.push(arr[i]);
    }
    while(!stack.isEmpty()) {
      System.out.println(stack.pop() + " -> -1");
    }
  }

  public static void main(String[] args) {
    int arr[] = new int[]{4,5,2,25};
    System.out.println(Arrays.toString(arr));
    nextGreaterElement(arr);

    System.out.println();
    arr = new int[]{4,5,2,35,25};
    System.out.println(Arrays.toString(arr));
    nextGreaterElement(arr);
  }

}
