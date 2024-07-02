package tree.binarysearch.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem016 {

  /**
   * This is a very naive approach that takes O(n) for both normal and BST. Since, we are given BST, we need to find
   * an optimised approach.
   *
   * One approach would be for a given node, if the data of that node is less than the k1 and k2 then do not traverse
   * the left subtree. Likewise, if the data of the node is more then k1 and k2 then do not traverse right subtree.
   * This will optimise our time.
   *
   * @param node
   * @param k1
   * @param k2
   */
  public static void print(Node node, int k1, int k2) {
    if(node == null) return;
    print(node.left, k1, k2);
    if(k1 < node.data && node.data < k2) {
      System.out.println(node.data);
    }
    print(node.right, k1, k2);
  }

  public static void main(String[] args) {
    Node root = BinarySearchTree.getTree();
    BinarySearchTree.display(root);
    System.out.println();
    print(root, 2,6);
  }

}
