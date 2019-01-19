package tree.avl.utils;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

  public static Node insert(Node node, int data) {
    if(node == null) {
      node = new Node(null, data, null);
      return node;
    }
    else {
      if(data < node.data) node.left = insert(node.left, data);
      else node.right = insert(node.right, data);

      node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
      int diff = getDiff(node);

      if(diff > 1 && data < node.left.data) return rotateLeft(node);
      if(diff < -1 && data > node.right.data) return rotateRight(node);
      if(diff > 1 && data > node.left.data) return rotateLeftAndRight(node);
      if(diff < -1 && data < node.right.data) return rotateRightAndLeft(node);
      return node;
    }
  }

  private static int getDiff(Node node) {
    if(node == null) return 0;
    return getHeight(node.left) - getHeight(node.right);
  }

  public static void display(Node node) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(node);
    queue.add(null);
    while(!queue.isEmpty()) {
      node = queue.remove();
      if(node == null) {
        System.out.println();
        if(queue.isEmpty()) break;
        queue.add(null);
      }
      else {
        System.out.print(node.data + "["+node.height+"] ");
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
      }
    }
  }

  private static Node rotateLeft(Node node) {
    Node w = node.left;
    node.left = w.right;
    w.right = node;
    node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    w.height = Math.max(getHeight(node.left), node.height) + 1;
    return w;
  }

  private static Node rotateRight(Node node) {
    Node x = node.right;
    node.right = x.left;
    x.left = node;
    node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    x.height = Math.max(getHeight(node.right), node.height) + 1;
    return x;
  }

  /**
   * Inserting into Left Child's right subtree
   * @param node
   * @return
   */
  public static Node rotateLeftAndRight(Node node) {
    node.left = rotateRight(node.left);
    return rotateLeft(node);
  }

  /**
   * Inserting into Right Child's Left Subtree
   * @param node
   * @return
   */
  public static Node rotateRightAndLeft(Node node) {
    node.right = rotateLeft(node.right);
    return rotateRight(node);
  }

  private static int getHeight(Node node) {
    if(node == null) return 0;
    return node.height;
  }

  public static Node createCustomTree(int arr[]) {
    Node node = null;
    for(int i=0; i < arr.length; i++) {

      node = insert(node, arr[i]);
    }
    return node;
  }

  public static Node getTree() {
    int arr[] = new int[]{4,2,6,1,3,5,7};
    Node node = createCustomTree(arr);
    return node;
  }

  public static void preOrder(Node node) {
    if(node == null) return;
    preOrder(node.left);
    System.out.print(node.data + " ");
    preOrder(node.right);
  }

  public static void main(String[] args) {
    //Node node = getTree();
    Node node = createCustomTree(new int[]{4,2,6,1,3,5,745});
    display(node);
    preOrder(node);
  }

}
