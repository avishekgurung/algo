package misc.problems;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

/**
 * First thing to remember is that this problem is not about finding the distance between the
 * longest leaves.
 *
 * Longest path is as usual calculated as the sum of current node, left and right data.
 * But the path should not include both the child. So we include either the left, right or node.
 *
 */

public class Problem015 {

  public static int maxPathBetweenTwoLeaves(Node node, int res[]) {
    if(node == null) return 0;
    int left = maxPathBetweenTwoLeaves(node.left, res);
    int right = maxPathBetweenTwoLeaves(node.right, res);

    int leftSum = node.data + left;
    int rightSum = node.data + right;

    int totalSum = left + right + node.data;
    res[0] = Math.max(totalSum, res[0]);

    int returnVal;
    if(leftSum > rightSum) {
      returnVal = leftSum;
      if(node.data > leftSum) {
        returnVal = node.data;
      }
    }
    else {
      returnVal = rightSum;
    }
    return returnVal;
  }


  public static void main(String[] args) {
    //Refer to the tree shown in the example in GFG.
    Node root = new Node(null, -15, null);
    root.left = new Node(null,5,null);
    root.right = new Node(null,6,null);
    root.left.left = new Node(null,-8,null);
    root.left.right = new Node(null,1,null);
    root.left.left.left = new Node(null,2,null);
    root.left.left.right = new Node(null,6,null);
    root.right.left = new Node(null,3,null);
    root.right.right = new Node(null,9,null);
    root.right.right.right = new Node(null,0,null);
    root.right.right.right.left = new Node(null,4,null);
    root.right.right.right.right = new Node(null,-1,null);
    root.right.right.right.right.left = new Node(null,10,null);
    BinaryTree.display(root);

    int res[] = new int[1];
    maxPathBetweenTwoLeaves(root, res);
    System.out.println("Max path: " + res[0]);
  }

}
