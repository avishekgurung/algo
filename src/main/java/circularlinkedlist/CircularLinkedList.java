package circularlinkedlist;

public class CircularLinkedList {


  public static Node insert(Node head, int data) {
    if(head == null) {
      head = new Node(data, null);
      head.next = head;
    }
    else {
      Node pointer = head;
      while(pointer.next != head) {
        pointer = pointer.next;
      }
      pointer.next = new Node(data, head);
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

  public static void display(Node node) {
    Node pointer =  node;
    do {
      System.out.print(node.data + " -> ");
      node = node.next;
    }
    while(node != pointer);
    System.out.println();
  }

}
