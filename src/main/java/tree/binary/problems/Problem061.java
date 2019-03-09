package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

/**
 * One simple approach I have thought is do a level order traversal. After completion of
 * every level (say after 1) move a pointer depth wise by twice the level and check if the pointer
 * reaches null. If it does then its the middle level and we can print them.
 *
 * But this case be considered invalid as we are keeping track of level.
 * Another way to use fast and slow pointer as we do in linked list.
 */
public class Problem061 {

  public static void printMiddleLevel(Node x, Node y) {
    if(x == null || y == null) return;

    if(y.left == null && y.right == null) {
      System.out.print(x.data + " ");
      return;
    }

    /**
     * Handling the case when the levels are even
     */
    if(y.left != null && y.left.left == null && y.right != null && y.right.right == null) {
      System.out.print(x.data + " ");
      return;
    }

    printMiddleLevel(x.left, y.left.left);
    printMiddleLevel(x.right, y.right.right);

  }


  public static void main(String[] args) {
    Node node = BinaryTree.getTree();
    BinaryTree.display(node);
    System.out.print("Middle level: ");
    printMiddleLevel(node, node);
    System.out.println("\n");

    node = BinaryTree.createTree(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15});
    BinaryTree.display(node);
    System.out.print("Middle level: ");
    printMiddleLevel(node, node);
    System.out.println("\n");

    node = BinaryTree.createTree(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
        21,22,23,24,25,26,27,28,29,30,31});
    BinaryTree.display(node);
    System.out.print("Middle level: ");
    printMiddleLevel(node, node);
    System.out.println("\n");
  }

}
