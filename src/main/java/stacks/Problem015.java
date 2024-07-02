package stacks;

import java.util.LinkedList;
import java.util.Queue;

public class Problem015 {

  private class Stack {
    Queue<Integer> queue = new LinkedList<Integer>();
    int size = 0;

    public void push(int data) {
      if(queue.isEmpty()) {
        queue.add(data);
      }
      else {
        queue.add(data);
        for(int i=1;i<=size;i++){
          queue.add(queue.remove());
        }
      }
      size++;
    }

    public int pop() {
      return queue.remove();
    }

    public boolean isEmpty() {
      return queue.isEmpty();
    }
  }

  public void util() {
    int arr[] = new int[] {1,2,3,4,5};
    Stack stack = new Stack();
    for(int i=0; i<arr.length; i++) {
      stack.push(arr[i]);
    }

    while (!stack.isEmpty()) {
      System.out.println(stack.pop());
    }
  }

  public static void main(String[] args) {
    new Problem015().util();
  }

}

/**
 * the another solution would be to reverse the queue, remove the element and return it as pop() and again reverse the queue.
 */