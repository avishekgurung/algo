package tree.problems;

import tree.util.BinaryTree;
import tree.util.Node;

public class Problem016 {

  public static boolean checkPath(Node root, int sum) {
    if(root == null) return false;
    sum = sum - root.data;
    if(root.left == null && root.right == null) {
      return sum == 0 ? true : false;
    }
    boolean left = checkPath(root.left, sum);
    boolean right = checkPath(root.right, sum);
    return left || right;
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    System.out.println();

    System.out.println("Path:6 Exists:" + checkPath(root, 6));
    System.out.println("Path:7 Exists:" + checkPath(root, 7));
    System.out.println("Path:8 Exists:" + checkPath(root, 8));
    System.out.println("Path:9 Exists:" + checkPath(root, 9));
    System.out.println("Path:10 Exists:" + checkPath(root, 10));
  }

}
