package tree.problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.util.BinaryTree;
import tree.util.Node;

public class Problem008 {

  public static int height(Node root) {
    if(root == null) return 0;
    if(root.left == null && root.right == null) return 0;
    int left = height(root.left);
    int right = height(root.right);
    return Math.max(left, right) + 1;
  }

  /**
   * There are different conventions we follow with height of a tree. If a tree with one node
   * is supposed to be a height 1 then we can follow the below approach. But if we consider a
   * tree with one node to be height 0 (which I feel is true because the number of nodes in level
   * is also give by 2^0) then we can use the above approach.
   * @param root
   * @return
   */
  public static int heightAnother(Node root) {
    if(root == null) return 0;
    int left = heightAnother(root.left);
    int right = heightAnother(root.right);
    return Math.max(left, right) + 1;
  }

  public static int heightByIteration(Node root) {
    Queue<Node> queue = new LinkedList<Node>();
    int height = -1; //As per our above convenience, we can keep 0 or -1
    queue.add(root);
    queue.add(null);

    while(!queue.isEmpty()) {
      root = queue.remove();
      if(root == null) {
        height++;
        if(queue.isEmpty()) break;
        queue.add(null);
      }
      else {
        if(root.left != null) queue.add(root.left);
        if(root.right != null) queue.add(root.right);
      }
    }
    return height;
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    System.out.println("Height: " + heightByIteration(root));

    System.out.println();
    root = BinaryTree.createTree(new int[]{1,2,3});
    BinaryTree.display(root);
    System.out.println("Height: " + heightByIteration(root));

    System.out.println();
    root = BinaryTree.createTree(new int[]{1});
    BinaryTree.display(root);
    System.out.println("Height: " + heightByIteration(root));

  }

}
