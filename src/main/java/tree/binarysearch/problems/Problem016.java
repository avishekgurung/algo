package tree.binarysearch.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem016 {

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
