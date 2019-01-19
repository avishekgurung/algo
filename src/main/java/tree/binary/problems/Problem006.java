package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem006 {

  public static void delete(Node root) {
    if(root == null) return;
    delete(root.left);
    delete(root.right);
    root.left = null;
    root.right = null;
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    delete(root);
    System.out.println("Tree after deletion");
    BinaryTree.display(root);

    System.out.println();
    root = BinaryTree.createTree(new int[]{1,2,3,4});
    BinaryTree.display(root);
    delete(root);
    System.out.println("Tree after deletion");
    BinaryTree.display(root);

    System.out.println();
    root = BinaryTree.createTree(new int[]{1});
    BinaryTree.display(root);
    delete(root);
    System.out.println("Tree after deletion");
    BinaryTree.display(root);
  }

}
