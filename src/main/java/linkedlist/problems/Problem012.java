package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem012 {

  public static Node sort(Node head) {
    Node odd = head;
    Node even = head.next;
    Node pointer = even.next;
    Node oddHead = odd;
    Node evenHead = even;
    boolean flag = true;

    /**
     * A smarter logic to separate the linked list into odd and even nodes can be referred
     * from Problem006 (cloning a LL with random pointer)
     */
    while(pointer != null) {
      if(flag) {
        odd.next = pointer;
        odd = pointer;
      }
      else {
        even.next = pointer;
        even = pointer;
      }
      pointer = pointer.next;
      flag = !flag;
    }
    odd.next = null;
    even.next = null;
    evenHead = reverse(null, evenHead);
    head = merge(oddHead, evenHead);
    return head;
  }

  private static Node merge(Node x, Node y) {
    if(x == null) return y;
    if(y == null) return x;
    Node result = null;
    if(x.data < y.data) {
      result = x;
      result.next = merge(x.next, y);
    }
    else {
      result = y;
      result.next = merge(x, y.next);
    }
    return result;
  }

  private static Node reverse(Node prev, Node pointer) {
    if(pointer == null) return prev;
    Node next = pointer.next;
    pointer.next = prev;
    return reverse(pointer, next);
  }

  public static void main(String[] args) {
    Node head = LinkedListUtil.customBulkInsert(new int[]{10,40,53,30,67,12,89});
    LinkedListUtil.display(head);
    head = sort(head);
    LinkedListUtil.display(head);
  }

}
