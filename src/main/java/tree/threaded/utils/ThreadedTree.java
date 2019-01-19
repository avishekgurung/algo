package tree.threaded.utils;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class ThreadedTree {

  private static Node prev = null;
  private static Node dummy = new Node(null, Integer.MIN_VALUE, null);

  public static void display(Node node) {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(node.left);
    queue.add(null);

    while(!queue.isEmpty()) {
      node = queue.remove();
      if(node == null) {
        System.out.println();
        if(queue.isEmpty()) break;
        queue.add(null);
      }
      else {
        System.out.print(node.data + " ");
        if(node.leftTag == 1) {
          queue.add(node.left);
        }
        if(node.rightTag == 1) {
          queue.add(node.right);
        }
      }
    }
  }

  public static Node createTree(int arr[]) {
    Node root = null;
    for(int i=0 ; i < arr.length; i++) {
      root = binarySearchInsertion(root, arr[i]);
    }
    root = createFullyThreadedTreeFromBinaryTree(root);
    return root;
  }

  public static Node getTree() {
    return createTree(new int[]{4,2,1,3,6,5,7});
  }

  private static Node createFullyThreadedTreeFromBinaryTree(Node root) {
    Node node = root;
    Node dummy = new Node(null, 0, null);
    Node prev = null;
    Stack<Node> stack = new Stack<Node>();

    while(true) {
      while(node != null) {
        stack.push(node);
        node = node.left;
      }

      if(stack.isEmpty()) break;
      node = stack.pop();

      if(prev == null) {
        node.left = dummy;
        node.leftTag = 0;
      }
      else {
        if(prev.right == null) {
          prev.right = node;
          prev.rightTag = 0;
        }
        if(node.left == null) {
          node.left = prev;
          node.leftTag = 0;
        }
      }
      prev = node;
      node = node.right;
    }

    prev.right = dummy;
    prev.rightTag = 0;

    dummy.left = root;
    dummy.leftTag = 1;
    dummy.right = dummy;
    dummy.rightTag = 1;
    return dummy;
  }


  public static Node binarySearchInsertion(Node node, int data) {
    if(node == null) {
      node = new Node(null, data, null);
      return node;
    }
    else {
      Node pointer = node;
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
    }
    return node;
  }

  public static void main(String[] args) {
    Node root = createTree(new int[]{4,2,1,3,6,5,7});
    display(root);
  }
}
