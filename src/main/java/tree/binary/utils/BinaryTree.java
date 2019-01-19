package tree.binary.utils;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

  private static Node insert (Node root, int data) {
    if(root == null) {
      root = new Node(null, data, null);
    }
    else {
      Node pointer = root;
      Queue<Node> q = new LinkedList<Node>();
      q.add(pointer);
      while(!q.isEmpty()) {
        pointer = q.remove();
        if(pointer.left == null) {
          pointer.left = new Node(null, data, null);
          return root;
        }
        else {
          q.add(pointer.left);
        }

        if(pointer.right == null) {
          pointer.right = new Node(null, data, null);
          return root;
        }
        else {
          q.add(pointer.right);
        }
      }
    }
    return root;
  }

  public static void display(Node root) {
    Queue<Node> q = new LinkedList<Node>();
    q.add(root);
    q.add(null);

    while(!q.isEmpty()) {
      root = q.remove();

      if(root == null) {
        System.out.println();
        if(q.isEmpty()) {
          break;
        }
        q.add(null);
      }
      else {
        System.out.print(root.data + "\t");
        if(root.left != null) {
          q.add(root.left);
        }
        if(root.right != null) {
          q.add(root.right);
        }
      }
    }
  }

  public static Node createTree(int arr[]) {
    Node root = null;
    for(int i=0; i < arr.length; i++) {
      root = insert(root, arr[i]);
    }
    return root;
  }

  public static Node getTree() {
    int arr[] = new int[]{1,2,3,4,5,6,7};
    Node root = createTree(arr);
    return root;
  }

  public static void main(String[] args) {
    Node root = createTree(new int[] {1,2,3,4,5});
    display(root);

    root = getTree();
    display(root);
  }
}
