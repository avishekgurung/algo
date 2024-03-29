package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem007 {

  private static void reversePrint(Node node) {
    Stack<Node> stack = new Stack<Node>();
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(node);

    while(!queue.isEmpty()) {
      node = queue.remove();
      stack.push(node);
      if(node.right != null) queue.add(node.right);
      if(node.left != null) queue.add(node.left);
    }
    System.out.println();
    while(!stack.isEmpty()) {
      System.out.print(stack.pop().data + " ");
    }
    System.out.println();

  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    reversePrint(root);

    System.out.println();
    root = BinaryTree.createTree(new int[] {6,5,2,3,8,7,4,3,7,1});
    BinaryTree.display(root);
    reversePrint(root);

    System.out.println();
    root = BinaryTree.createTree(new int[] {6});
    BinaryTree.display(root);
    reversePrint(root);
  }

  /**
   * Without using extra space, we can follow an approach of performing level order traversal without using extra space.
   *
   * We will find the height of the tree. And we will print the nodes at height h, h-1, h-2, ... 1
   *
   */
}
