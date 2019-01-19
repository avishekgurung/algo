package tree.binarysearch.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem003 {

  public static int getMinElement(Node root) {
    if(root.left == null) return root.data;
    return getMinElement(root.left);
  }

  /**
   * An alternative approach.
   * @param root
   * @return
   */
  public static int getMinByIteration(Node root) {
    while(root.left != null) root = root.left;
    return root.data;
  }

  public static int getMaxElement(Node root) {
    if(root.right == null) return root.data;
    return getMaxElement(root.right);
  }

  public static void main(String[] args) {
    Node root = BinarySearchTree.getTree();
    BinarySearchTree.display(root);

    System.out.println("Max: " + getMaxElement(root));
    System.out.println("Min: " + getMinElement(root));
    System.out.println("Min: " + getMinByIteration(root));

  }

}
