package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem033 {
  /**
   * The naive approach is to perform a level order traversal. For each level create an
   * array of size 2^level. And rather than print just store the elements in an array.
   * And then print the elements from alternate ends. This method takes more memory.
   *
   * The efficient approach is to process two nodes at a time. While pushing the children
   * push the 1st node's left and 2nd node's right. And then push, 1st node's right and
   * second node's left.
   *
   * We are expecting the tree to be perfect, meaning a full binary tree.
   */

  public static void print(Node node) {
    Queue<Node> queue = new LinkedList<Node>();
    System.out.print(node.data + " ");
    queue.add(node.left);
    queue.add(node.right);
    while(!queue.isEmpty()) {
      Node x = queue.remove();
      Node y = queue.remove();
      System.out.print(x.data + " ");
      System.out.print(y.data + " ");
      if(x.left != null) queue.add(x.left);
      if(y.right != null) queue.add(y.right);
      if(x.right != null) queue.add(x.right);
      if(y.left != null) queue.add(y.left);
    }
  }

  public static void main(String[] args) {
    Node node = BinaryTree.createTree(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
    BinaryTree.display(node);
    System.out.println();
    print(node);
  }
}
