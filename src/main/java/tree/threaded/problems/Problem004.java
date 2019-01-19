package tree.threaded.problems;

import tree.threaded.utils.Node;
import tree.threaded.utils.ThreadedTree;

public class Problem004 {

  public static Node getPreorderSuccessor(Node node) {
    if(node.leftTag == 1) return node.left;
    while(node.rightTag == 0) node = node.right;
    return node.right;
  }

  public static void main(String[] args) {
    Node node = ThreadedTree.getTree();
    node = node.left;

    System.out.println(node.data + " " + getPreorderSuccessor(node).data);

    Node two = node.left;
    System.out.println(two.data + " " + getPreorderSuccessor(two).data);

    Node one = two.left;
    System.out.println(one.data + " " + getPreorderSuccessor(one).data);

    Node three = two.right;
    System.out.println(three.data + " " + getPreorderSuccessor(three).data);
  }

}
