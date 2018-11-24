package linkedlist.problems;

import java.util.ArrayList;
import java.util.List;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem023 {
  private static int carry = 0;


  private static Node sum(Node head1, Node head2) {
    List<Node> nodes = addZerosPrefix(head1, head2);
    head1 = nodes.get(0);
    head2 = nodes.get(1);
    Node head = sumHelper(head1, head2);
    if(carry != 0) {
      Node node = new Node(carry, head);
      head = node;
    }
    return head;
  }

  private static Node sumHelper(Node head1, Node head2) {
    if(head1 == null || head2 == null)return null;
    Node result = sumHelper(head1.next, head2.next);
    int sum = head1.data + head2.data + carry;
    int data = sum % 10;
    carry = sum / 10;
    Node node = new Node(data, result);
    return node;
  }

  private static List<Node> addZerosPrefix(Node head1, Node head2) {
    int l1 = length(head1);
    int l2 = length(head2);
    int diff = Math.abs(l1 - l2);
    Node zeroHead = new Node(0, null);
    Node pointer = zeroHead;
    diff--;
    while(diff > 0) {
      Node node = new Node(0, null);
      pointer.next = node;
      pointer = node;
      diff--;
    }
    if(l1 < l2) {
      pointer.next = head1;
      head1 = zeroHead;
    }
    else if (l2 < l1){
      pointer.next = head2;
      head2 = zeroHead;
    }

    List<Node> result = new ArrayList<Node>();
    result.add(head1);
    result.add(head2);
    return result;
  }


  private static int length(Node head) {
    int length = 0;
    while(head != null) {
      length++;
      head = head.next;
    }
    return length;
  }

  public static void main(String[] args) {

    Node head1 = LinkedListUtil.customBulkInsert(new int[]{9,9});
    Node head2 = LinkedListUtil.customBulkInsert(new int[]{9,9});
    Node result = sum(head1,head2);
    LinkedListUtil.display(head1);
    LinkedListUtil.display(head2);
    System.out.println("------------------------");
    LinkedListUtil.display(result);
    System.out.println("\n\n");

    head1 = LinkedListUtil.customBulkInsert(new int[]{6,6,8,7,9});
    head2 = LinkedListUtil.customBulkInsert(new int[]{5,9,2});
    result = sum(head1,head2);
    LinkedListUtil.display(head1);
    LinkedListUtil.display(head2);
    System.out.println("------------------------");
    LinkedListUtil.display(result);
    System.out.println("\n\n");

    head1 = LinkedListUtil.customBulkInsert(new int[]{6,9,0,2,4,5,1});
    head2 = LinkedListUtil.customBulkInsert(new int[]{9,9,9,2});
    result = sum(head1,head2);
    LinkedListUtil.display(head1);
    LinkedListUtil.display(head2);
    System.out.println("------------------------");
    LinkedListUtil.display(result);
    System.out.println("\n\n");

    head1 = LinkedListUtil.customBulkInsert(new int[]{9,9});
    head2 = LinkedListUtil.customBulkInsert(new int[]{9,9,9,9});
    result = sum(head1,head2);
    LinkedListUtil.display(head1);
    LinkedListUtil.display(head2);
    System.out.println("------------------------");
    LinkedListUtil.display(result);
    System.out.println("\n\n");
  }
}

/**
 * WOA: Never jump to this solution directly. First give straight forward solutions like
 *  1. Traverse every single list, concatenate the numbers as string. Parse the result to integer.
 *  Do this for both the LL. Then add them. Their sum can then be used to create a new linked list.
 *
 *  2. The same solution but rather than using string, we can simply create a number which LL is
 *  representing:
 *  int sum = 0;
 *  Node pointer = head1;
 *  while(pointer != null){
 *    sum = sum * 10 + pointer.data;
 *    pointer = pointer.next;
 *  }
 *  This sum is the number that LL represents.
 *
 *  Finally when we jump to the above conclusions.
 */
