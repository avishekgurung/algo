package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem014 {

  public static int levelWithMaxSum(Node root) {
    int maxSum = 0;
    int sum = 0;
    int level = 0;
    int maxLevel = 0;
    Queue<Node> queue =  new LinkedList<Node>();
    queue.add(root);
    queue.add(null);

    while(!queue.isEmpty()) {
      root = queue.remove();
      if(root == null) {
        level++;
        if(sum > maxSum) {
          maxSum = sum;
          maxLevel = level;
        }
        sum = 0;
        if(queue.isEmpty()) break;
        queue.add(null);
      }
      else {
        sum = sum + root.data;
        if(root.left != null) queue.add(root.left);
        if(root.right != null) queue.add(root.right);
      }
    }

    System.out.println("Max sum: " +  maxSum + " @ level " + maxLevel);
    return maxSum;
  }

  public static void main(String[] args) {
    Node root = BinaryTree.getTree();
    BinaryTree.display(root);
    levelWithMaxSum(root);

    System.out.println();
    root = BinaryTree.createTree(new int[] {4,10,20,3,4,5,6,7});
    BinaryTree.display(root);
    levelWithMaxSum(root);

    System.out.println();
    root = BinaryTree.createTree(new int[] {4,10,20,3,4,5,6,70});
    BinaryTree.display(root);
    levelWithMaxSum(root);
  }


}
