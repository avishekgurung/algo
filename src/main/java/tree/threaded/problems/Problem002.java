package tree.threaded.problems;

import tree.threaded.utils.Node;
import tree.threaded.utils.ThreadedTree;

public class Problem002 {

  public static Node getInorderSuccessor(Node node) {
    if(node.rightTag == 0) return node.right;
    Node pointer = node.right;
    while(pointer.left != node) {
      pointer = pointer.left;
    }
    return pointer;
  }

  public static void main(String[] args) {
    Node node = ThreadedTree.getTree();
    node = node.left;
    System.out.println(node.data + " successor " + getInorderSuccessor(node).data);

    node = node.right;
    System.out.println(node.data + " successor " + getInorderSuccessor(node).data);

    Node one = node.left;
    System.out.println(one.data + " successor " + getInorderSuccessor(one).data);

    Node two = node.right;
    System.out.println(two.data + " successor " + getInorderSuccessor(two).data);
  }

  /**
   *  If a node has rightTag = 0 then it means that its right pointer is pointing to its successor.
   *
   *  If not, we find the right subtree. The left most node of this right subtree will
   *  be a successor for a given node.
   *
   */
}
