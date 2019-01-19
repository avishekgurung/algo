package tree.binarysearch.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem002 {

  public static boolean search(Node node, int element) {
    if(node == null) return false;
    if(node.data == element) return true;
    if(element < node.data) {
      return search(node.left, element);
    }
    else {
      return search(node.right, element);
    }
  }

  public static void main(String[] args) {
    Node root = BinarySearchTree.getTree();
    BinarySearchTree.display(root);

    System.out.println();
    int element = 4;
    System.out.println("Search " + element + ": " + search(root, element));

    element = 3;
    System.out.println("Search " + element + ": " + search(root, element));

    element = 5;
    System.out.println("Search " + element + ": " + search(root, element));

    element = 0;
    System.out.println("Search " + element + ": " + search(root, element));
  }

}
