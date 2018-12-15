package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem009 {

  public static Node arrange(Node head) {
    Node mid = getMid(head);
    Node midNext = mid.next;
    mid.next = null;
    Node y = reverse(midNext);
    Node x = head;

    //This merge can also be done by using recursion as shown below which is shorter.
    while (x != null && y != null) {
      Node nextX = x.next;
      Node nextY = y.next;
      x.next = y;
      y.next = nextX;
      x = nextX;
      y = nextY;
    }
    return head;
  }

  /**
   * Merging two linked list
   * @param x
   * @param y
   * @return
   */
  private static Node merge(Node x, Node y) {
    if(x == null) return y;
    if(y == null) return x;
    x.next = merge(y, x.next);
    return x;
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
