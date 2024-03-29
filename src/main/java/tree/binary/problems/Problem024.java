package tree.binary.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem024 {

  public static void getVerticalSum(Node root, int distance, Map<Integer, Integer> map) {
    if(root == null) return;

    getVerticalSum(root.left, distance - 1, map);

    int data = root.data;
    if(map.get(distance) != null) {
      data = data + map.get(distance);
    }
    map.put(distance, data);
    getVerticalSum(root.right, distance + 1, map);
  }

  public static void printVerticalSum(Map<Integer, Integer> map) {
    Set<Integer> keys = map.keySet();
    int lowestKey = 0;
    for(Integer key : keys) {
      if(key < lowestKey) lowestKey = key;
    }

    lowestKey = Math.abs(lowestKey);
    for(Integer key : keys) {
      System.out.println("Column:" + (lowestKey + key) + " Sum: " + map.get(key));
    }


  }

  public static void main(String[] args) {

    Node root = BinaryTree.createTree(new int[]{1,2,3,4,5,6,7});
    BinaryTree.display(root);
    System.out.println();

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    getVerticalSum(root, 0, map);
    printVerticalSum(map);
  }
  /**
   * We perform an inorder search. We increase the distance for right subtree and decrease the distance
   * for left subtree by one.
   */
}

