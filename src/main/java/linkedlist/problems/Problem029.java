package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem029 {

  public static Node merge(Node x, Node y) {
    Node prev = null;
    Node pointer = null;

    while(x != null || y != null) {
      if(x != null && (y == null || (x.data < y.data))) {
        pointer = x.next;
        x.next = prev;
        prev = x;
        x = pointer;
      }
      else if(y != null && (x == null || (y.data < x.data))){
        pointer = y.next;
        y.next = prev;
        prev = y;
        y = pointer;
      }
    }
    return prev;
  }

  public static void main(String[] args) {
    Node x = LinkedListUtil.customBulkInsert(new int[] {1,4,6,7});
    Node y = LinkedListUtil.customBulkInsert(new int[] {3,9});
    Node res = merge(x, y);
    LinkedListUtil.display(res);
  }

  /**
   * Another approach would be merge the two linked list in usual way in non decreasing order.
   * Reverse the result.
   */
}
