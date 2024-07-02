package stacks;


import java.util.Stack;

public class Problem008 {

  private class Queue {

    private Stack<Integer> enqueue;
    private Stack<Integer> dequeue;

    Queue() {
      enqueue = new Stack<Integer>();
      dequeue = new Stack<Integer>();
    }

    public void enqueue(int data) {
      enqueue.push(data);
    }

    public int dequeue() {
      if(dequeue.isEmpty()) {
        moveElements();
      }
      return dequeue.pop();
    }

    public int peek() {
      if(dequeue.isEmpty()) {
        moveElements();
      }
      return dequeue.peek();
    }

    private void moveElements() {
      while(!enqueue.isEmpty()) {
        dequeue.push(enqueue.pop());
      }
    }

    public boolean isEmpty() {
      return enqueue.isEmpty() && dequeue.isEmpty();
    }
  }

  private void utility() {
    Queue queue = new Queue();
    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    queue.enqueue(4);

    while(!queue.isEmpty()) {
      System.out.println(queue.dequeue());
    }
  }

  public static void main(String[] args) {
    new Problem008().utility();
  }

}
