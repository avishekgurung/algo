package linkedlist.problems;

public class Problem017 {

  private static class Node {
    Node prev;
    Node next;
    int data;

    Node(Node prev, int data, Node next) {
      this.prev = prev;
      this.data = data;
      this.next = next;
    }
  }

  private static Node insert(int arr[]) {
    Node head = null;
    Node prev = null;
    Node pointer = null;
    for(int i=0; i < arr.length; i++) {
      pointer = new Node(prev, arr[i], null);
      if(prev != null) {
        prev.next = pointer;
      }
      prev = pointer;
      if(head == null) head = pointer;
    }
    return head;
  }

  public static void findPair(Node head, int k) {

    Node tail = head;
    while (tail.next != null) tail = tail.next;

    while(head != tail) {
      int sum = head.data + tail.data;
      if(sum == k) {
        System.out.println(head.data +","+ tail.data);
        head = head.next;
      }
      else if(sum < k) {
        head = head.next;
      }
      else {
        tail = tail.prev;
      }
    }
  }

  public static void main(String[] args) {

    /**
     * We will convert a given linked list into Doubly Linked List.
     * We can have a look at XOR list.
     * Then we use this DLL to find the pair.
     * Lets abstract the logic to convert LL to DLL with the help of an array.
     */

    Node head = insert(new int[] {3,6,7,8,9,10,11});
    findPair(head, 17);

  }


}
