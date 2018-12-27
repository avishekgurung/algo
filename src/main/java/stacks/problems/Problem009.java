package stacks.problems;

import java.util.LinkedList;
import java.util.Queue;

public class Problem009 {

  private class Stack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;
    private int count;

    Stack() {
      queue1 = new LinkedList<Integer>();
      queue2 = new LinkedList<Integer>();
      count = 0;
    }

    public boolean push(int data) {
      count++;
      return !queue1.isEmpty() == true?queue1.add(data):queue2.add(data);
    }

    public int pop() {
      int pop;
      if(!queue1.isEmpty()) {
        for(int i=1; i < count; i++) {
          queue2.add(queue1.remove());
        }
        pop = queue1.remove();
      }
      else {
        for(int i=1; i < count; i++) {
          queue1.add(queue2.remove());
        }
        pop = queue2.remove();
      }
      count--;
      return pop;
    }

    public boolean isEmpty() {
      return queue1.isEmpty() && queue2.isEmpty();
    }
  }

  public void utility() {

    Stack stack = new Stack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    stack.push(5);

    while(!stack.isEmpty()) {
      System.out.println(stack.pop());
    }

  }

  public static void main(String[] args) {
    new Problem009().utility();
  }
}
