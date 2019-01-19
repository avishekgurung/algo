package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem011 {

  public static int getLeaves(Node root) {
    if(root == null) return 0;
    if(root.left == null && root.right == null) return 1;
    int left = getLeaves(root.left);
    int right = getLeaves(root.right);
    return left + right;
  }

  public static int getFullNodes(Node root) {
    if(root == null) return 0;
    int left = getFullNodes(root.left);
    int right = getFullNodes(root.right);
    int sum = left + right;
    if(root.left != null && root.right != null) sum = sum + 1;
    return sum;
  }

  public static int getFullNodes1(Node root) {
    if(root.left == null || root.right == null) return 0;
    int left = getFullNodes(root.left);
    int right = getFullNodes(root.right);
    return left + 1 + right;
  }
  public static int getHalfNodes(Node root) {
    if(root == null) return 0;
    int left = getHalfNodes(root.left);
    int right = getHalfNodes(root.right);
    int sum  = left + right;
    if((root.left == null && root.right!= null) ||
        root.right == null && root.left != null) {
      sum =  sum + 1;
    }
    return sum;
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    System.out.println("Leaves: " + getLeaves(root));
    System.out.println("Full Nodes: " + getFullNodes1(root));
    System.out.println("Half Nodes: " + getHalfNodes(root));

    System.out.println();
    root = BinaryTree.createTree(new int[]{1,2,3,4,5,6});
    BinaryTree.display(root);
    System.out.println("Leaves: " + getLeaves(root));
    System.out.println("Full Nodes: " + getFullNodes1(root));
    System.out.println("Half Nodes: " + getHalfNodes(root));
  }

}

/**
 * The solutions can be achieved easily by iteration as well.
 *
 * The traversal should always be postorder. Else if the traversal is like pre-order and if
 * the node condition (like halfnode, etc) comes true then the remaining nodes will not be
 * processed.
 *
 */
