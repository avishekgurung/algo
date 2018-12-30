package tree.problems.binarytree;

import tree.util.binarytree.BinaryTree;
import tree.util.binarytree.Node;

public class Problem018 {

  public static Node getMirror(Node root) {
    if(root == null) return null;
    getMirror(root.left);
    getMirror(root.right);
    Node temp = root.left;
    root.left = root.right;
    root.right = temp;
    return root;
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    System.out.println();
    root = getMirror(root);
    BinaryTree.display(root);
  }

}
