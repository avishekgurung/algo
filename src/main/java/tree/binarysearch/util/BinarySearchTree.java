package tree.binarysearch.util;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {

  private static Node insertIteration(Node root, int data) {
    if(root == null) {
      root = new Node(null, data, null);
      return root;
    }
    else {
      Node pointer = root;
      while(true) {
        if(data < pointer.data) {
          if(pointer.left == null) {
            pointer.left = new Node(null, data, null);
            break;
          }
          else {
            pointer = pointer.left;
          }
        }
        else {
          if(pointer.right == null) {
            pointer.right = new Node(null, data, null);
            break;
          }
          else {
            pointer = pointer.right;
          }
        }
      }
      return root;
    }
  }

  private static Node insertRecursion(Node root, int data) {
    if(root == null) return new Node(null, data, null);
    if(data < root.data) {
      root.left = insertRecursion(root.left, data);
    }
    else {
      root.right = insertRecursion(root.right, data);
    }
    return root;
  }

  public static void display(Node root) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    queue.add(null);

    while(!queue.isEmpty()) {
      root = queue.remove();
      if(root == null) {
        System.out.println();
        if(queue.isEmpty()) break;
        queue.add(null);
      }
      else {
        System.out.print(root.data + "\t");
        if(root.left != null) queue.add(root.left);
        if(root.right != null) queue.add(root.right);
      }
    }
  }

  public static Node createTree(int arr[]) {
    Node root = null;
    for(int i=0; i < arr.length; i++) {
      root = insertRecursion(root, arr[i]);
    }
    return root;
  }

  public static Node getTree() {
    return createTree(new int[] {4,2,1,3,6,5,7});
  }

  public static void main(String[] args) {
    Node root = getTree();
    display(root);
  }

}
