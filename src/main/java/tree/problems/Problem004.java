package tree.problems;

import tree.util.BinaryTree;
import tree.util.Node;

public class Problem004 {

  private static boolean search(Node node, int element) {
    if(node == null) return false;
    if(node.data == element) return true;
    boolean left = search(node.left, element);
    boolean right = search(node.right, element);
    return left || right;
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    System.out.println("Result: " + search(root, 5));

    System.out.println();
    root = BinaryTree.createTree(new int[] {6,5,2,3,8,7,4,3,7,1});
    BinaryTree.display(root);
    System.out.println("Result: " + search(root, 4));

    System.out.println();
    root = BinaryTree.createTree(new int[] {6});
    BinaryTree.display(root);
    System.out.println("Result: " + search(root, 5));
  }
}
