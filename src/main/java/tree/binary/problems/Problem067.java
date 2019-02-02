package tree.binary.problems;

import tree.binarysearch.util.BinarySearchTree;
import tree.binarysearch.util.Node;

public class Problem067 {

  public static Node merge(Node x, Node y) {
    if(x == null && y == null) return null;
    if(x == null) return y;
    if(y == null) return x;

    int data = x.data + y.data;
    Node node = new Node(null, data, null);
    node.left = merge(x.left, y.left);
    node.right = merge(x.right, y.right);
    return node;
  }


  public static void main(String[] args) {
    Node x = BinarySearchTree.createTree(new int[]{4,3,1,5});
    Node y = BinarySearchTree.createTree(new int[]{3,1,2,5,4,6});
    BinarySearchTree.display(x);
    System.out.println();
    BinarySearchTree.display(y);
    System.out.println();
    Node node = merge(x, y);
    BinarySearchTree.display(node);
  }
}
