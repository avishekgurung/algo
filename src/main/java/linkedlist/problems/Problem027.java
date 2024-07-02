package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem027 {

  public static void main(String[] args) {

    Node head = LinkedListUtil.getPredefinedList();
    LinkedListUtil.display(head);
    head = reverse(head, null);
    LinkedListUtil.display(head);

  }

  public static Node reverse(Node head, Node prev) {
    if(head == null) {
      return prev;
    }

    Node next = head.next;
    head.next = prev;
    return reverse(next, head);
  }

}
