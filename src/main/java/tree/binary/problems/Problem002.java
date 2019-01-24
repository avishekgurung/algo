package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem002 {

  public static void breadthFirstTraversal(Node root) {
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
        System.out.print(root.data + " ");
        if(root.left != null) queue.add(root.left);
        if(root.right != null) queue.add(root.right);
      }
    }
    System.out.println();
  }

  public static void levelOrderByRecursion(Node node) {
    int height = getHeight(node);
    for(int i=0; i < height; i++) {
      printLevel(node, i);
      System.out.println();
    }
  }

  private static void printLevel(Node node, int height) {
    if(height == 0) {
      System.out.print(node.data + " ");
      return;
    }
    printLevel(node.left, height - 1);
    printLevel(node.right, height - 1);
  }

  private static int getHeight(Node node) {
    if(node == null) return 0;
    return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
  }


  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    System.out.println();
    breadthFirstTraversal(root);
    System.out.println();
    levelOrderByRecursion(root);
  }

}
