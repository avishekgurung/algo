package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class ReverseLinkedList {

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
    Node res = reverse(head.next, head);
    head.next = prev;
    return res;
  }

}
