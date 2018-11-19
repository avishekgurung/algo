package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class MergeSortedLinkedList {

  public static void main(String[] args) {

    Node x = LinkedListUtil.customBulkInsert(new int[]{1,6});
    Node y = LinkedListUtil.customBulkInsert(new int[] {2,4});
    //Node res = mergeByIteration(x, y);
    //LinkedListUtil.display(res);
    Node res1 = mergeByRecursion(x, y);
    LinkedListUtil.display(res1);

  }

  public static Node mergeByRecursion(Node x, Node y) {
    if(x == null && y == null) return null;
    if(x == null) return y;
    if(y == null) return x;
    Node result = null;
    if(x.data <= y.data) {
      result = x;
      result.next = mergeByRecursion(x.next, y);
    }
    else {
      result = y;
      result.next = mergeByRecursion(x, y.next);
    }
    return result;
  }

  public static Node mergeByIteration(Node x, Node y){
    Node prev = null;
    Node head = null;
    if(x == null && y== null) return null;
    if(x == null) return y;
    if(y == null) return x;
    while(x != null && y != null) {
      Node pointer = null;
      if(x.data <= y.data) {
        pointer = x;
        x = x.next;
      }
      else {
        pointer = y;
        y = y.next;
      }
      if(prev != null) {
        prev.next = pointer;
      }
      prev = pointer;
      if(head == null) {
        head = pointer;
      }
    }
    if(x == null) {
      prev.next = y;
    }
    if(y == null) {
      prev.next = x;
    }
    return head;
  }

}
