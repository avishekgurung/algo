package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem054 {

  public static void convertTreeToSpiral(Node node) {
    Queue<Node> queue = new LinkedList<Node>();
    Queue<Node> aux = new LinkedList<Node>();
    Stack<Node> stack = new Stack<Node>();
    boolean evenLevel = false;

    queue.add(node);
    queue.add(null);


    while(!queue.isEmpty()) {
      node = queue.remove();
      if(node == null) {
        while(!stack.isEmpty()) {
          aux.add(stack.pop());
        }
        if(queue.isEmpty()) break;
        queue.add(null);
        evenLevel = !evenLevel;
      }
      else {
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);
        node.left = node.right = null;
        if(evenLevel) {
          stack.push(node);
        }
        else {
          aux.add(node);
        }
      }
    }

    queue = new LinkedList<Node>(aux);
    aux.remove();
    while(!aux.isEmpty()) {
      node = queue.remove();
      node.left = aux.remove();
      if(aux.isEmpty()) break;
      node.right = aux.remove();
    }
  }


  public static void modify(Node node) {
    Node prev = null;
    Queue<Node> queue = new LinkedList();
    queue.add(node);
    while (!queue.isEmpty()) {
      node = queue.remove();
      if(node.left != null) queue.add(node.left);
      if(node.right != null) queue.add(node.right);
      if(prev != null) prev.right = node;
      node.left = prev;
      prev = node;
    }
  }

  public static void traverse(Node node) {
    while(node != null) {
      System.out.print(node.data + " ");
      node = node.right;
    }
  }

  public static void main(String[] args) {
    Node node = BinaryTree.createTree(new int[]{1,2,3,4,5,6,7,8,9,10,11,12});
    BinaryTree.display(node);
    convertTreeToSpiral(node);
    System.out.println();
    BinaryTree.display(node);
    modify(node);
    traverse(node);
  }

}

/**
 * We divide the problem into two simple halves. First we create a spiral tree.
 * Then we will convert this spiral tree to DLL.
 */
