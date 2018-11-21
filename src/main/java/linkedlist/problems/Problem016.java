package linkedlist.problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import linkedlist.util.LinkedList.LinkedListUtil;
import linkedlist.util.LinkedList.Node;

public class Problem016 {

  public static Node unionWithExtraSpace(Node x, Node y) {
    Node pointer = x;
    Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
    while(pointer.next != null) {
      map.put(pointer.data, true);
      pointer = pointer.next;
    }

    map.put(pointer.data, true);
    Node prev = y;
    Node yPointer = y.next;


    while(yPointer != null) {
      if(map.get(yPointer.data) != null) {
        Node next = yPointer.next;
        prev.next = next;
        yPointer = next;
      }
      else {
        prev = yPointer;
        yPointer = yPointer.next;
      }
    }

    if(map.get(y.data) != null) {
      y = y.next;
    }
    pointer.next = y;
    return x;
  }

  public static Node intersectionWithExtraSpace(Node head1, Node head2) {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    Node pointer1 = head1;
    while (pointer1.next != null) {
      map.put(pointer1.data, pointer1.data);
      pointer1 = pointer1.next;
    }
    map.put(pointer1.data, pointer1.data);

    Node prev = head2;
    Node pointer2 = head2.next;

    while(pointer2 != null) {
      if(map.get(pointer2.data) == null) {
        prev.next = pointer2.next;
      }
      else {
        prev = pointer2;
      }
      pointer2 = pointer2.next;
    }
    if(map.get(head2.data) == null) {
      head2 = head2.next;
    }
    return head2;
  }


  public static Node unionWithoutExtraSpace(Node head1, Node head2) {
    Node pointer = head1;
    while (pointer.next != null) pointer = pointer.next;
    pointer.next = head2;
    Node head = sort(head1);

    Node prev = head;
    pointer = head.next;
    while (pointer != null) {
      if(prev.data == pointer.data) {
        prev.next = pointer.next;
      }
      else {
        prev = pointer;
      }
      pointer = pointer.next;
    }
    return head;
  }

  public static Node intersectionWithoutExtraSpace(Node head1, Node head2) {
    Node pointer = head1;
    while (pointer.next != null) pointer = pointer.next;
    pointer.next = head2;
    Node head = sort(head1);

    Node prev = head;
    pointer = head.next;
    head = null;
    Node x = null;
    while (pointer != null) {
      if(prev.data == pointer.data) {
        if(head == null) {
          head = x = prev;
        }
        else if(x.data != prev.data) {
          x.next = prev;
          x = prev;
        }
      }
      prev = pointer;
      pointer = pointer.next;
    }
    x.next = null;
    return head;
  }




  private static Node sort(Node head) {
    if(head == null || head.next == null) return head;
    Node mid = getMid(head);
    Node midNext = mid.next;
    mid.next = null;
    Node left = sort(head);
    Node right = sort(midNext);
    Node result = sortMerge(left, right);
    return result;
  }

  private static Node sortMerge(Node x, Node y) {
    if(x == null) return y;
    if(y == null) return x;
    Node result = null;
    if(x.data < y.data) {
      result = x;
      result.next = sortMerge(x.next, y);
    }
    else {
      result = y;
      result.next = sortMerge(x, y.next);
    }
    return result;
  }

  private static Node getMid(Node head) {
    Node slow = head, fast = head.next;
    while(fast != null) {
      fast = fast.next;
      if(fast == null) break;
      fast = fast.next;
      slow = slow.next;
    }
    return slow;
  }


  public static void main(String[] args) {

    Node head1 = LinkedListUtil.customBulkInsert(new int[]{10,15,4,20});
    Node head2 = LinkedListUtil.customBulkInsert(new int[]{8,4,2,10});
    LinkedListUtil.display(head1);
    LinkedListUtil.display(head2);

    System.out.println("--------------------------------------");
    Node head = unionWithExtraSpace(head1, head2);
    LinkedListUtil.display(head);

    System.out.println("--------------------------------------");

    head1 = LinkedListUtil.customBulkInsert(new int[]{10,15,4,20});
    head2 = LinkedListUtil.customBulkInsert(new int[]{8,4,2,10});
    head = intersectionWithExtraSpace(head1, head2);
    LinkedListUtil.display(head);

    System.out.println("--------------------------------------");

    head1 = LinkedListUtil.customBulkInsert(new int[]{10,15,4,20});
    head2 = LinkedListUtil.customBulkInsert(new int[]{8,4,2,10});
    head = unionWithoutExtraSpace(head1, head2);
    LinkedListUtil.display(head);

    System.out.println("--------------------------------------");

    head1 = LinkedListUtil.customBulkInsert(new int[]{10,15,4,20});
    head2 = LinkedListUtil.customBulkInsert(new int[]{8,4,2,10});
    head = intersectionWithoutExtraSpace(head1, head2);
    LinkedListUtil.display(head);
  }


}
