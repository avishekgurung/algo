package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem009 {

  public static Node arrange(Node head) {
    Node mid = getMid(head);
    Node pointer = head;
    while (pointer.next != mid) {
      pointer = pointer.next;
    }
    pointer.next = null;
    Node y = reverse(mid);
    Node x = head;

    boolean flag = true;
    pointer = head;
    while(x != null && y != null) {
      if(flag) {
        Node temp = x.next;
        pointer.next = y;
        x = temp;
      }
      else {
        Node temp = y.next;
        pointer.next = x;
        y = temp;
      }
      pointer = pointer.next;
      flag = !flag;
    }
    return head;
  }

  private static Node reverse(Node node) {
    Node prev = null;
    while(node != null) {
      Node next = node.next;
      node.next = prev;
      prev = node;
      node = next;
    }
    return prev;
  }


  private static Node getMid(Node head) {
    Node slow = head;
    Node fast = head;
    while(fast != null) {
      fast = fast.next;
      if(fast == null) break;
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    Node head = LinkedListUtil.getPredefinedList();
    LinkedListUtil.display(head);
    head = arrange(head);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[] {1,2,3,4,5});
    LinkedListUtil.display(head);
    head = arrange(head);
    LinkedListUtil.display(head);
  }
}
