package linkedlist.problems;

import java.util.Stack;

public class Problem011 {
  private class Node {
    int data;
    Problem011.Node next;
    Problem011.Node rand;

    Node(int data, Problem011.Node next, Problem011.Node rand) {
      this.data = data;
      this.next = next;
      this.rand = rand;
    }
  }

  private Problem011.Node getLinkedList() {
    Problem011.Node four = new Problem011.Node(4,null, null);
    Problem011.Node two = new Problem011.Node(2,null, null);
    Problem011.Node five = new Problem011.Node(5,null, null);
    Problem011.Node twnFive = new Problem011.Node(25,null, null);

    four.next = five;
    five.next = two;
    two.next = twnFive;
    return four;
  }

  private void display(Problem011.Node node) {
    while(node != null) {
      System.out.print(node.data);
      if(node.next != null) System.out.print(" -> " + node.next.data);
      else System.out.print(" : N");
      if(node.rand != null) System.out.print(" : " + node.rand.data);
      else System.out.print(" : N");
      System.out.println();
      node = node.next;
    }
  }

  private Problem011.Node arrange(Problem011.Node head) {
    Stack<Node> stack = new Stack<Node>();
    stack.push(head);
    Node pointer = head.next;
    while(pointer != null) {
      while(!stack.empty() && stack.peek().data < pointer.data) {
        stack.pop().rand = pointer;
      }
      stack.push(pointer);
      pointer = pointer.next;
    }
    return head;
  }


  public static void main(String[] args) {
    Problem011 obj = new Problem011();
    Problem011.Node head = obj.getLinkedList();
    obj.display(head);
    System.out.println("---------------");
    head = obj.arrange(head);
    obj.display(head);

  }

}
