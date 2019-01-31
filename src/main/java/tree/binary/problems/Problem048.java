package tree.binary.problems;

import java.util.LinkedList;
import java.util.Queue;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem048 {

  public static Node createTree(int arr[]) {
    Queue<Node> queue = new LinkedList<Node>();
    Node root = null;
    for(int i=0; i < arr.length; i++) {
      if(arr[i] == -1) {
        root = new Node(null, i, null);
        break;
      }
    }

    queue.add(root);
    while(!queue.isEmpty()) {
      Node node = queue.remove();
      int[] indices = getIndices(arr, node.data);
      if(indices[0] != -1) {
        node.left = new Node(null, indices[0], null);
        queue.add(node.left);
      }
      if(indices[1] != -1) {
        node.right = new Node(null, indices[1], null);
        queue.add(node.right);
      }
    }

    return root;
  }

  private static int[] getIndices(int[] arr, int ele) {
    int indices[] = new int[2];
    indices[0] = indices[1] = -1;

    int i = 0;
    for(int j=0; j < arr.length; j++) {
      if(arr[j] == ele) {
        indices[i] = j;
        i++;
      }
    }
    return indices;
  }

  public static void main(String[] args) {
    int arr[] = new int[]{1, 5, 5, 2, 2, -1, 3};
    Node node = createTree(arr);
    BinaryTree.display(node);
    System.out.println();

    arr = new int[]{-1, 0, 0, 1, 1, 3, 5};
    node = createTree(arr);
    BinaryTree.display(node);
  }

}
