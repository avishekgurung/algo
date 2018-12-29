package tree.problems;

import tree.util.BinaryTree;
import tree.util.Node;

public class Problem003 {

  private static int getMax(Node node) {
    if(node == null) return 0;
    int left = getMax(node.left);
    int right = getMax(node.right);
    return Math.max(Math.max(left, right), node.data);
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    System.out.println("Max: " + getMax(root));

    System.out.println();
    root = BinaryTree.createTree(new int[] {6,5,2,3,8,7,4,3,7,1});
    BinaryTree.display(root);
    System.out.println("Max: " + getMax(root));

    System.out.println();
    root = BinaryTree.createTree(new int[] {6});
    BinaryTree.display(root);
    System.out.println("Max: " + getMax(root));
  }
}

/**
 * The solution can also be obtained by using iteration. We can perform any of the three depth first
 * traversal or can use breadth first traversal.
 */
