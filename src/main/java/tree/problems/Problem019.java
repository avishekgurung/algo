package tree.problems;

import java.util.HashMap;
import java.util.Map;

import tree.util.BinaryTree;
import tree.util.Node;

public class Problem019 {
  private static int preIndex = 0;
  private static Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

  public static Node createTree(int[] preorder, int left, int right) {

    int data = preorder[preIndex];
    preIndex++;
    Node node = new Node(null, data, null);
    if(left >= right) return node;
    int inorderIndex = indexMap.get(data);
    node.left = createTree(preorder, left, inorderIndex-1);
    node.right = createTree(preorder, inorderIndex+1, right);
    return node;
  }

  public static void setIndexMap(int[] inorder) {
    for(int i=0; i < inorder.length; i++) {
      indexMap.put(inorder[i], i);
    }
  }

  public static void main(String[] args) {

    int[] preorder = new int[]{1,2,4,5,3,6,7};
    int[] inorder = new int[]{4,2,5,1,6,3,7};
    setIndexMap(inorder);
    Node root = createTree(preorder, 0, preorder.length-1);
    BinaryTree.display(root);
  }
}

/***
 * The logic is:
 *
 * take first element of preorder, which will basically a root node.
 * This element will lie in the middle in the inorder list. All the elements to its
 * left are left-subtree and all the elements to its right are right subtree.
 *
 * So we just need to keep finding left and right subtree.
 *
 */
