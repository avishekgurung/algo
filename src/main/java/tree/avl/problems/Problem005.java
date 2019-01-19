package tree.avl.problems;

import tree.avl.utils.AvlTree;
import tree.avl.utils.Node;

public class Problem005 {
  private static int count = 1;

  public static Node createAVLTree(int height) {
    if(height < 0) return null;
    Node node = new Node(null, 0, null);
    node.left = createAVLTree(height - 1);
    node.data = count++;
    node.right = createAVLTree(height - 2);
    node.height = height;
    return node;
  }

  public static void main(String[] args) {
    Node node = createAVLTree(3);
    AvlTree.display(node);
  }

}
