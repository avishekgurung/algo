package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem042 {

  public static Node createTree(int arr[]) {
    Node head = new Node(null, arr[0], null);
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(head);

    int i=1;
    while(i < arr.length) {
      Node node = queue.remove();
      node.left = new Node(null, arr[i], null);
      queue.add(node.left);
      i++;
      if(i >= arr.length) break;
      node.right = new Node(null, arr[i], null);
      queue.add(node.right);
      i++;
    }
    return head;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1,2,3,4,5,6,7};
    Node root = createTree(arr);
    BinaryTree.display(root);
  }
}
