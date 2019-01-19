package dll.util;

public class DoublyLinkedList {

  private static Node insert(Node node, int data) {
    if(node == null) {
      node = new Node(null, data, null);
    }
    else {
      Node pointer = node;
      while(pointer.next != null) {
        pointer = pointer.next;
      }
      pointer.next = new Node(pointer, data, null);
    }
    return node;
  }

  public static void display(Node node) {
    while(node != null) {
      System.out.print(node.data + " -> ");
      node = node.next;
    }
    System.out.println();
  }

  public static Node createCustomTree(int arr[]) {
    Node node = null;
    for(int i=0; i < arr.length; i++) {
      node = insert(node, arr[i]);
    }
    return node;
  }

  public static Node getTree() {
    int arr[] = new int[]{1,2,3,4,5,6,7};
    Node node = createCustomTree(arr);
    return node;
  }

}
