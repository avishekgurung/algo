package tree.binary.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import tree.binary.utils.BinaryTree;
import tree.binary.utils.Node;

public class Problem037 {

  public static void diagonalStore(Node node, int d, Map<Integer, List<Node>> map) {
    if(node == null) return;

    List<Node> list = map.get(d);
    if(list == null) list = new ArrayList<Node>();
    list.add(node);
    map.put(d, list);

    diagonalStore(node.left, d + 1, map);
    diagonalStore(node.right, d, map);
  }

  private static void display(Map<Integer, List<Node>> map) {
    System.out.println();
    Set<Integer> keys = map.keySet();
    for(Integer key : keys) {
      List<Node> list = map.get(key);
      for(Node node : list) {
        System.out.print(node.data + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    Node node = BinaryTree.createTree(new int[]{1,2,3,4,5,6,7});
    BinaryTree.display(node);
    Map<Integer, List<Node>> map = new HashMap<Integer, List<Node>>();
    diagonalStore(node, 0, map);
    display(map);
  }
}

/**
 *
 * The logic here is similar to the problem of finding the vertical sum. In vertical
 * sum we increment the distance by 1 to right and by -1 to left. But here, we increment
 * the distance by 1 to left and keep the distance as same to the right. Doing so
 * we can get a pattern to calculate diagonal. Create a tree as shown in the above
 * geekforgeek example and mark nodes with distance. We can get a clear picture.
 * Also, we store the nodes in the list that falls in the same diagonal and later
 * print them all.
 *
 */
