package linkedlist.problems;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem008 {

  public static Node mergeSort(Node head) {
    if(head == null || head.next == null) return head;
    Node mid = getMid(head);
    Node midNext = mid.next;
    mid.next = null;
    Node left = mergeSort(head);
    Node right = mergeSort(midNext);
    Node sortedList = merge(left, right);
    return sortedList;
  }

  private static Node merge(Node left, Node right) {
    if(left == null) return right;
    if(right == null) return left;
    Node result = null;
    if(left.data <= right.data) {
      result = left;
      result.next = merge(left.next, right);
    }
    else {
      result = right;
      result.next = merge(left, right.next);
    }
    return result;
  }

  private static Node getMid(Node node) {
    Node slow = node;
    Node fast = node.next;
    while(fast != null) {
      fast = fast.next;
      if(fast == null) break;
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }

  public static void main(String[] args) {
    Node head = LinkedListUtil.customBulkInsert(new int[]{9,2,5,1,0,3,2,5,7,2,3,8});
    LinkedListUtil.display(head);
    head = mergeSort(head);
    LinkedListUtil.display(head);
  }

}
