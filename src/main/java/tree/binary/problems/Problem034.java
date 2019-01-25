package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem034 {

  public static void printBottomUp(Node node) {
    Queue<Node> queue = new LinkedList<Node>();
    Stack<Node> stack = new Stack<Node>();
    Queue<Node> aux = new LinkedList<Node>();
    aux.add(node);
    queue.add(node.right);
    queue.add(node.left);
    queue.add(null);
    while(!queue.isEmpty()) {
      if(queue.peek() == null) {
       queue.remove();
       while(!aux.isEmpty()) stack.push(aux.remove());
       if(queue.isEmpty()) {
         break;
       }
       queue.add(null);
      }
      else {
        Node x = queue.remove();
        Node y = queue.remove();
        aux.add(x);
        aux.add(y);
        System.out.println(x.data + " " + y.data);
        if (x.left != null)
          queue.add(x.left);
        if (y.right != null)
          queue.add(y.right);
        if (x.right != null)
          queue.add(x.right);
        if (y.left != null)
          queue.add(y.left);
      }
    }
    while(!stack.isEmpty()) {
      System.out.print(stack.pop().data + " ");
    }
  }

  public static void main(String[] args) {
    Node node = BinaryTree.createTree(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
    //Node node = BinaryTree.createTree(new int[]{1,2,3,4,5,6,7});
    BinaryTree.display(node);
    System.out.println();
    printBottomUp(node);
  }
}

/**
 * Have to think and use brains. :P
 */
