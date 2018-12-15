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

  }
}
