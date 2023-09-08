package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem004 {

  public static Node deleteNodesGreaterOnRight(Node node) {
    if(node == null || node.next == null) return node;
    boolean deleteFirstNode = node.data < node.next.data ? true : false;
    Node prev = node;
    Node pointer = node;

    while(pointer.next != null) {
      if(pointer.data < pointer.next.data)
        prev.next = pointer.next;
      else
        prev = pointer;
      pointer = pointer.next;
    }

    if(deleteFirstNode) {
      node = node.next;
    }
    return node;
  }

  public static void main(String[] args) {
    Node head = LinkedListUtil.customBulkInsert(new int[] {12,15,10,11,5,6,2,3});
    head = deleteNodesGreaterOnRight(head);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[] {1,2,3,4,5,6});
    head = deleteNodesGreaterOnRight(head);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[] {6,5,4,3,2,1});
    head = deleteNodesGreaterOnRight(head);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[] {1,2});
    head = deleteNodesGreaterOnRight(head);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[] {2,1});
    head = deleteNodesGreaterOnRight(head);
    LinkedListUtil.display(head);

    head = LinkedListUtil.customBulkInsert(new int[] {1});
    head = deleteNodesGreaterOnRight(head);
    LinkedListUtil.display(head);
    
    head = deleteNodesGreaterOnRight(null);
    LinkedListUtil.display(head);


    /**
     * This approach would not work for the scenario below. The expected output is 15 -> 13 but we get another
     * output. So the correct solution is to reverse the metrics and proceed.
     */
    head = LinkedListUtil.customBulkInsert(new int[] {12,11,13,15,10,9,8,13});
    head = deleteNodesGreaterOnRight(head);
    LinkedListUtil.display(head);

  }
  /**
   * Another simpler approach would be.
   * Reverse the node.
   * Delete the next node if its lesser than the current one.
   * Reverse the node again.
   * Here, we do not have to handle the 'deleteFirstNode' condition as above.
   */

  public static Node reverse(Node node, Node prev) {
    if(node == null) return prev;
    Node next = node.next;
    node.next = prev;
    return reverse(next, node);
  }

  public static Node removeElementsGreaterToRight(Node head) {
    head = reverse(head, null);
    Node pointer = head.next;
    Node prev = head;

    while(pointer != null) {
      if(pointer.data < prev.data) {
        Node nextPointer = pointer.next;
        prev.next = nextPointer;
        pointer = nextPointer;
      }
      else {
        prev = pointer;
        pointer = pointer.next;
      }
    }

    head = reverse(head, null);
    return head;
  }
}
