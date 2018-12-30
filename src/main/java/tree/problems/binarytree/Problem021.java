package tree.problems.binarytree;

import tree.util.binarytree.BinaryTree;
import tree.util.binarytree.Node;

public class Problem021 {

  public static boolean printAncestor(Node root, int element) {
    if(root == null) return false;
    if(root.data == element) return true;
    boolean left = printAncestor(root.left, element);
    boolean right = printAncestor(root.right, element);
    if(left || right) {
      System.out.print(root.data + " --> ");
    }
    return left || right;
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);

    System.out.print("Ancestor of 7: ");
    printAncestor(root, 7);
    System.out.println();

    System.out.print("Ancestor of 4: ");
    printAncestor(root, 4);
    System.out.println();

    System.out.print("Ancestor of 3: ");
    printAncestor(root, 3);
    System.out.println();

    System.out.print("Ancestor of 1: ");
    printAncestor(root, 1);
    System.out.println();
  }
}


/**
 * If they ask us to print in the order of the ancestor then store them in a stack.
 */
