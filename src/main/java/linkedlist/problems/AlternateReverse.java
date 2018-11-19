package linkedlist.problems;


import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class AlternateReverse {

  public static void main(String[] args) {

    Node head = LinkedListUtil.customBulkInsert(new int[] {1,2,3,4,5,6,7,8,9});
    head = altReverse(head);
    LinkedListUtil.display(head);

  }

  private static Node altReverse(Node head) {
    Node pointer = head;
    if(head.next == null) {
      return null;
    }
    Node newHead = pointer.next;
    while(pointer != null) {
      Node x = pointer.next;
      if(x == null) break;
      Node y = x.next;
      x.next = pointer;
      if(y == null || y.next == null) {
        pointer.next = y;
        break;
      }
      pointer.next = y.next;
      pointer = y;
    }
    return newHead;
  }
}
