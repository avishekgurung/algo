package linkedlist.util.LinkedList;

public class LinkedListUtil {

  private static Node insert(Node head, int data) {
    if(head == null) {
      head = new Node(data, null);
    }
    else {
      Node pointer = head;
      while(pointer.next != null) {
        pointer = pointer.next;
      }
      pointer.next = new Node(data, null);
    }
    return head;
  }

  public static Node customBulkInsert(int[] arr) {
    Node head = null;
    for(int i=0; i < arr.length;i++) {
      head = insert(head, arr[i]);
    }
    return head;
  }

  public static Node getPredefinedList() {
    Node head = customBulkInsert(new int[] {1,2,3,4,5,6});
    return head;
  }

  public static void display(Node head) {
    while(head != null) {
      System.out.print(head.data);
      head = head.next;
      if(head != null) {
        System.out.print(" --> ");
      }
    }
    System.out.println();
  }
}
