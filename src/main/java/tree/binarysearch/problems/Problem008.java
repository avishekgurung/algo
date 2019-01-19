package tree.binarysearch.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem008 {

  private static Node prev = null;

  public static boolean isBST(Node root) {
    if(root == null) return true;
    boolean left = isBST(root.left);
    if(prev != null) {
      if(prev.data > root.data) return false;
    }
    prev = root;
    boolean right = isBST(root.right);
    return left && right;
  }

  public static void main(String[] args) {

    Node root = BinaryTree.createTree(new int[]{4,2,6,1,3,5,7});
    BinaryTree.display(root);
    System.out.println("Valid BST: " + isBST(root));

    System.out.println();
    root = BinaryTree.createTree(new int[]{4,2,6,1,3,5,2});
    BinaryTree.display(root);
    System.out.println("Valid BST: " + isBST(root));
  }
}
