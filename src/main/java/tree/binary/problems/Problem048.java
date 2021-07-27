package tree.binary.problems;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
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


  /**
   *
   * @param arr
   * @return
   * A simplified solution takes O(n) time and space.
   */
  private static Node createTreeSimplified(int arr[]) {
    Map<Integer, Node> map = new HashMap<Integer, Node>();
    for(int i=0; i < arr.length; i++) {
      map.put(i, new Node(null, i, null));
    }

    Node root = null;

    for(int i=0; i < arr.length; i++) {
      if(arr[i] == -1) {
        root = map.get(i);
      }
      else {
        Node parent = map.get(arr[i]);
        Node child = map.get(i);
        if(parent.left == null) parent.left = child;
        else parent.right = child;
      }
    }
    return root;
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


  /**
   * The time complexity of the above solution is O(n2) as we are iterating while process every
   * queue element. It can be made O(n) by using a map<Integer, List<Integer>></Integer>. Eg,
   * 5 -> [1,2]
   * 2 -> [3,4]
   *
   *
   * Another approach to look into above solution is by using topological sorting.
   */

}
