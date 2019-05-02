package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem007 {

  public static Node rotate(Node head, int k) {
    Node x = head;
    Node y = null;
    for(int i=1; i <=k; i++) {
      y = x;
      x = x.next;
      if(x == null) return head;
    }
    while(x.next != null) {
      x = x.next;
    }
    x.next = head;
    head = y.next;
    y.next = null;
    return head;
  }

  /**
   * Fixing in single iteration and lesser pointers.
   * We transform LL to Circular LL and unlink the kth Node.
   * @param head
   * @param k
   * @return
   */
  public static Node rotateSmart(Node head, int k) {
    Node tail = head;
    Node kNode = null;
    while(tail.next != null) {
      if(k == 1) kNode = tail;
      tail = tail.next;
      k--;
    }
    if(k >= 1) return head;
    tail.next = head;
    head = kNode.next;
    kNode.next = null;
    return head;
  }

  public static void main(String[] args) {
    Node head = LinkedListUtil.customBulkInsert(new int[]{1,2,3,4,5,6});
    head = rotate(head, 4);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[]{1,2,3,4,5,6});
    head = rotate(head, 1);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[]{1,2,3,4,5,6});
    head = rotate(head, 6);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[]{1,2});
    head = rotate(head, 1);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[]{1,2,3,4,5,6});
    head = rotateSmart(head, 4);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[]{1,2,3,4,5,6});
    head = rotateSmart(head, 1);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[]{1,2,3,4,5,6});
    head = rotateSmart(head, 6);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[]{1,2});
    head = rotateSmart(head, 1);
    LinkedListUtil.display(head);
  }

}
/**
 * One way to solve this problem would be to solve it like array rotation. Dividing the array into
 * two halves, reverse it, join it and again reverse.
 */
