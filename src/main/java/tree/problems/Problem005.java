package tree.problems;

import tree.util.BinaryTree;
import tree.util.Node;

public class Problem005 {

  private static int getSize(Node node) {
    if(node == null) return 0;
    int left = getSize(node.left);
    int right = getSize(node.right);
    return left + 1 + right;
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    System.out.println("Size: " + getSize(root));

    System.out.println();
    root = BinaryTree.createTree(new int[] {6,5,2,3,8,7,4,3,7,1});
    BinaryTree.display(root);
    System.out.println("Size: " + getSize(root));

    System.out.println();
    root = BinaryTree.createTree(new int[] {6});
    BinaryTree.display(root);
    System.out.println("Size: " + getSize(root));
  }
}
