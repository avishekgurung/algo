package stacks.problems;

public class Problem014 {

  private class Node {
    String data;
    Node next;
    Node prev;

    Node(Node prev, String data, Node next) {
      this.prev = prev;
      this.data = data;
      this.next = next;
    }
  }

  private class Stack {
    private Node head;
    int count = 0;
    private Node mid;

    public void push(String data) {
      if(head == null) {
        head = new Node(null, data, null);
        mid = head;
      }
      else {
        Node temp = new Node(null, data, null);
        temp.next = head;
        head.prev = temp;
        head = temp;
        if(count % 2 == 0) {
          mid = mid.prev;
        }
        count++;
      }
    }

    public String pop() {
      if(head == null) return null;
      String pop = head.data;
      head = head.next;
      if(count % 2 == 1) {
        mid = mid.next;
      }
      count--;
      return pop;
    }

    public String getMid() {
      return mid.data;
    }

    public void deleteMid() {
      Node next = mid.next;
      Node prev = mid.prev;
      prev.next = next;
      next.prev = prev;
      mid = next;
    }

  }

  public void util() {
    Stack stack = new Stack();
    stack.push("A");
    stack.push("B");
    System.out.println(stack.getMid());
    stack.push("C");
    System.out.println(stack.getMid());
    stack.push("D");
    System.out.println(stack.getMid());
    stack.push("E");
    System.out.println(stack.getMid());
  }

  public static void main(String[] args) {
    new Problem014().util();
  }

}
