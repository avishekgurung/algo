package tree.avl.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem004 {

  public static int isAVL(Node node) {
    if(node == null) return 0;
    int left = isAVL(node.left);
    if(left == -1) return left;
    int right = isAVL(node.right);
    if(right == -1) return right;
    if(Math.abs(left-right) > 1) return -1;
    return Math.max(left, right) + 1;
  }


  public static void main(String[] args) {
    Node node = BinarySearchTree.getTree();
    BinarySearchTree.display(node);
    System.out.println(isAVL(node) == -1 ? false : true);
    System.out.println();
    node = BinarySearchTree.createTree(new int[]{1,2,3});
    BinarySearchTree.display(node);
    System.out.println(isAVL(node) == -1 ? false : true);
  }

}
