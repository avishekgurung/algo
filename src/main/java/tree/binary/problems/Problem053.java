package tree.binary.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem053 {

  public static int modify(Node node) {
    if(node == null) return 0;
    int left = modify(node.left);
    int right = modify(node.right);
    int data = node.data;
    node.data = data + left;
    return left + data + right;
  }

  public static void main(String[] args) {
    Node node = BinaryTree.createTree(new int[]{1,2,3,4,5,0,6});
    BinaryTree.display(node);
    modify(node);
    System.out.println();
    BinaryTree.display(node);
  }

}
